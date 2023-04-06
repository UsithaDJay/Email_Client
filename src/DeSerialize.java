import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeSerialize {
    public static void deSerialize(String inDate) throws IOException, ClassNotFoundException {
        try{
            // Make a FileInputStream
            FileInputStream fileStream = new FileInputStream("EmailObjects.ser");
            // Make an ObjectInputStream
            ObjectInputStream os = new ObjectInputStream(fileStream);
            Object obj = os.readObject();
            ArrayList <Email> emailList = (ArrayList<Email>) obj;
            if(inDate == null){
                Email.emailList = emailList;
            }
            else{
                for (Email email : emailList) {
                    if (email.getSentDate().equals(inDate)) {
                        System.out.println(email.getEmail() + " , " + email.getSubject());
                    }
                }
            }
            os.close();
        }catch ( FileNotFoundException ex ){
            return;
        }

    }

}
