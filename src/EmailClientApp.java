import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EmailClientApp {
    public static void start() throws IOException, ClassNotFoundException {
        DeSerialize.deSerialize(null);
        BufferedReader reader_ = null;
        try {
            FileReader reader = new FileReader("clientList.txt");
            reader_ = new BufferedReader(reader);
            String line;
            while ((line = reader_.readLine()) != null) {
                RecipientCreator rc = new RecipientCreator();
                IRecipient recipient = rc.createRecipient(line.trim());
                recipient.sendWish();
                Email_Client.recipientList.add(recipient.getEmail());
            }
        }catch ( FileNotFoundException ex ){
            return;
        }catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try{
                if(reader_ != null)
                    reader_.close();
            } catch (IOException ex) {
            }
        }}

}
