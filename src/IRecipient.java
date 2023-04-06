import java.io.IOException;

public interface IRecipient {
    public void sendWish() throws IOException;
    public String getEmail();
}
