public class Official implements IRecipient{
    private String name;
    private String email;
    private String designation;
    public Official(String name, String email, String designation){
        this.name = name;
        this.email = email;
        this.designation = designation;
    }
    public String getEmail() {
        return this.email;
    }
    public void sendWish(){
    }

}
