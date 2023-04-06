import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OfficeFriend implements IRecipient{
    private String name;
    private String email;
    private String designation;
    private String bDay;
    public OfficeFriend(String name, String email, String designation, String bDay){
        this.name = name;
        this.designation = designation;
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
            String body = "Wish you a Happy Birthday. Usitha\n";
            Email emailToSend = new Email(email, subject, body, sentDate);
            emailToSend.send();
        }
    }

}
