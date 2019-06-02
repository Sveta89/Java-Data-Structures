public class BinaryNode {

    private String firstName;
    private String lastName;
    private String eMail;
    private String phoneNumber;
    private BinaryNode left;
    private BinaryNode right;

    //SV: Constructor for a node with firstName, lastName, eMail and phoneNumber
    public BinaryNode (String firstName, String lastName, String eMail, String phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getFirstName(){
        return firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getLastName(){
        return lastName;
    }

    public void setEmail(String eMail){
        this.eMail = eMail;
    }
    public String getEmail(){
        return eMail;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setLeftChild(BinaryNode leftChild){ left = (BinaryNode)leftChild;}
    public BinaryNode getLeftChild() { return left; }

    public void setRightChild(BinaryNode rightChild){
        right = (BinaryNode)rightChild;
    }
    public BinaryNode getRightChild() { return right; }

    public String toString() {
        return firstName + " " + lastName + " " + phoneNumber + " " + eMail;
    }

    public String getName(){ return firstName.toUpperCase() + lastName.toUpperCase(); }

}
