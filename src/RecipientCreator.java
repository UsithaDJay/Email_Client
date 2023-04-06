public class RecipientCreator {
    public RecipientCreator(){
    }
    public IRecipient createRecipient(String inputLine){
        try{
            String[] typeSplit = inputLine.split(":", 2);
            String[] details = typeSplit[1].split(",");
            if(typeSplit[0].trim().equalsIgnoreCase("personal")){
                String name = details[0].trim();
                String nick_name = details[1].trim();
                String email = details[2].trim();
                String bDay = details[3].trim();
                return new Personal(name, nick_name, email, bDay);
            }
            else if(typeSplit[0].trim().equalsIgnoreCase("office_friend")){
                String name = details[0].trim();
                String email = details[1].trim();
                String designation = details[2].trim();
                String bDay = details[3].trim();
                return new OfficeFriend(name, email, designation, bDay);
            }
            else if(typeSplit[0].trim().equalsIgnoreCase("official")){
                String name = details[0].trim();
                String email = details[1].trim();
                String designation = details[2].trim();
                return new Official(name, email, designation);}
        }catch(Exception ex){
            System.out.println("Invalid Recipient");
        }
        return null;
    }

}
