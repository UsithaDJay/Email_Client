import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Email_Client {
    static ArrayList <String> recipientList = new ArrayList<>();
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // start email client
        // code to create objects for each recipient in clientList.txt
        EmailClientApp.start();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter option type:\n" +
                            "1 - Adding a new recipient\n" +
                            "2 - Sending an email\n" +
                            "3 - Printing out all the recipients who have birthdays\n" +
                            "4 - Printing out details of all the emails sent\n" +
                    "5 - Printing out the number of recipient objects in the application\n" +
                    "-1 - Exit Email client\n");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    // input format - Official: nimal,nimal@gmail.com,ceo
                    System.out.println(" --input format--\n" +
                                    "Official: nimal,nimal@gmail.com,ceo\n" +
                                    "Office_friend: kamal,kamal@gmail.com,clerk,2000/12/12(birthday) \n" +
                            "Personal: sunil,<nick-name>,sunil@gmail.com,2000/10/10(birthday)");
                    // Use a single input to get all the details of a recipient
                    Scanner sc1 = new Scanner(System.in);
                    String inputLine = sc1.nextLine();
                    String inputLine_ = inputLine.trim();
                    // code to add a new recipient
                    RecipientCreator rc = new RecipientCreator();
                    IRecipient recipient = rc.createRecipient(inputLine_);
                    recipient.sendWish();
                    if(recipientList.contains(recipient.getEmail())){
                        System.out.println("Recipient already added\n");
                    }
                    else{
                        recipientList.add(recipient.getEmail());// store details in clientList.txt file
                        try {
                            FileWriter writer = new FileWriter("clientList.txt", true);
                            BufferedWriter writer_ = new BufferedWriter(writer);
                            writer_.write(inputLine_ + "\n");
                            writer_.close();
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    // input format - email, subject, content
                    System.out.println("input format - email, subject, content");
                    Scanner sc2 = new Scanner(System.in);
                    String emailContent = sc2.nextLine();
                    String emailContent_ = emailContent.trim();
                    // code to send an email
                    String[] content = emailContent_.split(",", 3);
                    String email = content[0].trim();
                    //if recipient added
                    if(recipientList.contains(email)){
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                        Date date = new Date();
                        String sentDate = formatter.format(date);
                        String subject = content[1].trim();
                        String body = content[2];
                        Email emailToSend = new Email(email, subject, body, sentDate);
                        emailToSend.send();
                    }
                    //recipient should be on the list
                    else{
                        System.out.println("Add recipient first. To add select 1 on List\n");
                    }
                    break;
                case 3:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    System.out.println("input format - yyyy/MM/dd (ex: 2018/09/17)");
                    Scanner sc3 = new Scanner(System.in);
                    String bDate = sc3.nextLine();
                    String bDate_ = bDate.trim();
                    // code to print recipients who have birthdays on the given date
                    BirthdayChecker birthdayChecker = new BirthdayChecker(bDate_);ArrayList<String> bdRecipientList = birthdayChecker.getBdRecipientList();
                    for (String s : bdRecipientList) {
                        System.out.println(s);
                    }
                    break;
                case 4:
                    // input format - yyyy/MM/dd (ex: 2018/09/17)
                    System.out.println("input format - yyyy/MM/dd (ex: 2018/09/18)");
                    Scanner sc4 = new Scanner(System.in);
                    String inDate = sc4.nextLine();
                    String inDate_ = inDate.trim();
                    // code to print the details of all the emails sent on the input date
                    DeSerialize.deSerialize(inDate_);
                    break;
                case 5:
                    // code to print the number of recipient objects in the application
                    int count = recipientList.size();
                    System.out.println(count);
                    break;
                case -1:
                    return;
            }
        }
    }

}
