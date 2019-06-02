public class Node {


    private String firstName;
    private String lastName;
    private String eMail;
    private String phoneNumber;

    private Node next;

    //SV: Constructor
    public Node (String firstName, String lastName, String phoneNumber, String eMail){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.eMail = eMail;
    }


    public String toString() {
        return firstName + " " + lastName + " " + phoneNumber + " " + eMail;
    }

    public String getName(){
        return firstName.toUpperCase() + lastName.toUpperCase();
    }

    void setFirstName (String first) {
        firstName = firstName;
    }

    String getFirstName (){
        return firstName;
    }

    void setLastName (String last) {
        lastName = last;
    }

    String getLastName (){
        return lastName;
    }

    void setPhoneNumber (String number){
        phoneNumber = number;
    }
    String getPhoneNumber(){
        return phoneNumber;
    }

    void setEmail(String mail){
        eMail = mail;
    }
    String getEmail(){
        return eMail;
    }

    void setNextNode (Node nextNode) {
        next = nextNode;
    }

    Node getNextNode() {
        return next;
    }

}
