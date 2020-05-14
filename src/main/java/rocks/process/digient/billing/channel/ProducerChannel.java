/*
 * Copyright (c) 2020. University of Applied Sciences and Arts Northwestern Switzerland FHNW.
 * All rights reserved.
 */

package rocks.process.digient.billing.channel;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerChannel {
    String MAILING = "output-insurance-mailing";

    @Output(MAILING)
    MessageChannel mailing();

    String MDM = "output-insurance-mdm";

    @Output(MDM)
    MessageChannel mdm();
}
