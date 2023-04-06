import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class Email implements Serializable {
    private String email;
    private String subject;
    private String body;
    private String sentDate;
    public static ArrayList <Email> emailList = new ArrayList<>();
    public Email(String email, String subject, String body, String sentDate){
        this.email = email;
        this.subject = subject;
        this.body = body;
        this.sentDate = sentDate;
        emailList.add(this);
    }
    public void send() throws IOException {
        SendEmail.sendEmail(email, subject, body);
        Serialize.serialize();
    }
    public String getEmail() {
        return email;
    }
    public String getSubject() {
        return subject;
    }
    public String getSentDate() {
        return sentDate;
    }

}
