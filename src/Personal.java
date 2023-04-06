import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Personal implements IRecipient{
    private String name;
    private String nick_name;
    private String email;
    private String bDay;
    public Personal(String name, String nick_name, String email, String bDay){this.name = name;
        this.nick_name = nick_name;
        this.email = email;
        this.bDay = bDay;
    }
    public String getEmail(){
        return this.email;
    }
    public void sendWish() throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String strDate = formatter.format(date);
        String sentDate = formatter2.format(date);
        String strBday = this.bDay.split("/", 2)[1].trim();
        if(strDate.equals(strBday)){
            String email = this.email;
            String subject = "Happy Birthday!";
            String body = "Hugs and love on your birthday. Usitha\n";
            Email emailToSend = new Email(email, subject, body, sentDate);
            emailToSend.send();
        }
    }

}
