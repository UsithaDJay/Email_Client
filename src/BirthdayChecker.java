import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BirthdayChecker {
    private String bDate;
    private ArrayList <String> bdRecipientList = new ArrayList<>();
    public BirthdayChecker(String bDate){
        this.bDate = bDate.split("/", 2)[1].trim();
    }
    public ArrayList<String> getBdRecipientList() {
        BufferedReader reader_ = null;
        try {
            FileReader reader = new FileReader("clientList.txt");
            reader_ = new BufferedReader(reader);
            String line;
            while ((line = reader_.readLine()) != null) {
                String[] typeSplit = line.split(":", 2);
                if(typeSplit[0].trim().equalsIgnoreCase("personal") |
                        typeSplit[0].trim().equalsIgnoreCase("office_friend")){String[] details = typeSplit[1].split(",");
                    String sBDay = details[3].split("/", 2)[1].trim();
                    if(this.bDate.equals(sBDay)){
                        this.bdRecipientList.add(details[0].trim());
                    }
                }
            }
        } catch ( IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try{
                assert reader_ != null;
                reader_.close();
            } catch (IOException ex) {
            }
        }
        return bdRecipientList;
    }

}
