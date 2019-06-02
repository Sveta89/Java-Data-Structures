public class LinkedList {

    private Node firstNode;

    void setFirstNode (Node firstNode) {
        this.firstNode = firstNode;
    }

    Node getFirstNode (){
        return firstNode;
    }
    //SV: Checks if the Linked List is empty
    public boolean isEmpty(){
        return (firstNode == null);
    }
    //Prints the Linked List if it's not empty
    public void printList(){

        String result = "";
        Node current = getFirstNode();

        if (current == null)
            return;

        result += current.toString() + ", ";
        while(current.getNextNode() != null){
            current = current.getNextNode();
            result += current.toString() + ", ";
        }

        System.out.print("LinkedList: " + result);

    }
    //SV: Inserts a node to Linked List to the beginning of chain
    public void insert(String firstName, String lastName, String phoneNumber, String eMail){

        Node newNode = new Node(firstName, lastName, phoneNumber, eMail);

        if (!isEmpty()) {

            newNode.setNextNode(firstNode);
            setFirstNode(newNode);

        } else {

            setFirstNode(newNode);
        }
    }

    //SV: Checks if the Linked List contains a given entry
    //Otherwise returns "Empty LinkedList"
    public Node lookUp(String firstName, String lastName) {

        Node theNode = getFirstNode();

        if (!isEmpty()){

            while(theNode.getFirstName() != firstName && theNode.getLastName() != lastName) {

                if (theNode.getNextNode() == null) {
                    return null;

                } else {

                    theNode = theNode.getNextNode();
                }
            }

        } else {
            System.out.println("Empty LinkedList");
        }

        return theNode;
    }
    //SV: Checks if Linked List has a given entry and removes it from the chain,
    // Otherwise returns null
    public Node remove(String firstName, String lastName) {

        Node current = getFirstNode();
        Node previous = getFirstNode();

        while (current.getFirstName() != firstName && current.getLastName() != lastName){
            if (current.getNextNode() == null) {
                return null;

            }else{
                previous = current;
                current = current.getNextNode();
            }
        }
        if (current == getFirstNode()) {
            setFirstNode(getFirstNode().getNextNode());

        }else{
            previous.setNextNode(current.getNextNode());
        }
        return current;
    }
}
