/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.digient.billing.client;

import org.camunda.bpm.client.ExternalTaskClient;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import rocks.process.digient.billing.message.MessageSender;
import rocks.process.digient.domain.Billing;
import rocks.process.digient.domain.Mailing;
import rocks.process.digient.message.Message;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class BillingClient {

    @Autowired
    ExternalTaskClient client;

    @Value("${camunda-rest.tenantid}")
    private String camundaTenantId;

    @Autowired
    private MessageSender messageSender;

    @PostConstruct
    private void subscribeTopics() {

        client.subscribe("IssueInvoice")
                .tenantIdIn(camundaTenantId)
                .handler((ExternalTask externalTask, ExternalTaskService externalTaskService) -> {
                    try {
                        Billing billing = new Billing(UUID.randomUUID().toString(), externalTask.getVariable("cId"), new Date().toString(), "invoice");
                        Mailing mailing = new Mailing(UUID.randomUUID().toString(), externalTask.getVariable("cId"), externalTask.getVariable("cName"), externalTask.getVariable("email"), "Invoice", "invoice");

                        messageSender.sendMDM(new Message<>("billing", billing, externalTask.getBusinessKey()));
                        messageSender.sendMailing(new Message<>("mailing", mailing, externalTask.getBusinessKey()));

                        Map<String, Object> variables = new HashMap<>();
                        variables.put("bId", billing.getBId());
                        variables.put("mId", mailing.getMId());

                        externalTaskService.complete(externalTask, variables);
                    } catch (Exception e) {
                        externalTaskService.handleBpmnError(externalTask, "failed");
                    }
                })
                .open();
    }

}
