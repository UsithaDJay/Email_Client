import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {
    public static void serialize() throws IOException {
// Make a FileOutputStream
        FileOutputStream fileStream = new FileOutputStream("EmailObjects.ser");
// Make a ObjectOutputStream
        ObjectOutputStream os = new ObjectOutputStream(fileStream);
//write the object
        os.writeObject(Email.emailList);os.close();
    }

}
