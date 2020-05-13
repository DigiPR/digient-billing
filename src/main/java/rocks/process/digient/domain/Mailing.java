package rocks.process.digient.domain;

import org.springframework.core.style.ToStringCreator;

public class Mailing {

    private String mId;
    private String cId;
    private String cName;
    private String email;
    private String emailBody;
    private String emailAttachment;

    public Mailing() {
    }

    public Mailing(String mId, String cId, String cName, String email, String emailBody, String emailAttachment) {
        super();
        this.mId = mId;
        this.cId = cId;
        this.cName = cName;
        this.email = email;
        this.emailBody = emailBody;
        this.emailAttachment = emailAttachment;
    }

    public String getMId() {
        return mId;
    }

    public void setMId(String mId) {
        this.mId = mId;
    }

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public String getEmailAttachment() {
        return emailAttachment;
    }

    public void setEmailAttachment(String emailAttachment) {
        this.emailAttachment = emailAttachment;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this).append("mId", mId).append("cId", cId).append("cName", cName).append("email", email).append("emailBody", emailBody).append("emailAttachment", emailAttachment).toString();
    }

}