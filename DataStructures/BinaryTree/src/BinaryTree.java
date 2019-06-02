//SV: Generic implementation of a binary tree
public class BinaryTree {

    private BinaryNode root;

    public void setRoot(BinaryNode root){
        this.root = root;
    }

    public BinaryNode getRoot(){
        return root;
    }

    //SV: Returns the string of the newly inserted BinaryNode, returns "Duplication" otherwise.
    public String insert(String firstName, String lastName, String phoneNumber, String eMail) {
        BinaryNode newNode = new BinaryNode(firstName, lastName, phoneNumber, eMail);
        String result = null;

        if (root == null){
            setRoot(newNode);
            result = root.toString();

        } else {

            int comparison;
            BinaryNode currentNode = root;
            BinaryNode parent;
            boolean found = false;

            while (!found) {

                parent = currentNode;
                comparison = newNode.getName().compareTo(currentNode.getName());

                if (comparison < 0) {
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) {
                        parent.setLeftChild(newNode);
                        result = newNode.toString();
                        found = true;
                    }

                } else if(comparison > 0){
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) {
                        parent.setRightChild(newNode);
                        result = newNode.toString();
                        found = true;
                    }

                } else {
                    result = "Duplication";
                    found = true;

                }
            }
        }
        return result;
    }
    //SV: Returns the string of searching BinaryNode if found, returns "The BinaryNode is not found" otherwise.
    public String lookUp(String firstName, String lastName) {
        BinaryNode currentNode = root;
        int comparison;
        String result = "The BinaryNode is not found";
        boolean found = false;

        while (!found && currentNode != null) {
            comparison = (firstName.toUpperCase() + lastName.toUpperCase()).compareTo(currentNode.getName());
            if (comparison == 0) {
                result = currentNode.toString();
                found = true;
            } else if (comparison < 0) {
                currentNode = currentNode.getLeftChild();
            } else {
                currentNode = currentNode.getRightChild();
            }
        }

        return result;
    }
    //SV: Traverses the BinaryTree inOrder.
    public void inorderTraverse (){
        inorderTraverse(root);
    }
    private void inorderTraverse(BinaryNode node){
        if (node != null){
            inorderTraverse(node.getLeftChild());
            System.out.println(node.toString());
            inorderTraverse(node.getRightChild());
        }
    }
    //SV: Returns the string of removed BinaryNode if found, returns "The BinaryNode is not found" otherwise.
    public String remove(String firstName, String lastName){
        BinaryNode currentNode = root;
        BinaryNode parent = root;
        String result = "The BinaryNode is not found.";

        boolean isItLeftChild = true;

        //SV: Keeps looking for the binary node until it finds it, otherwise returns "The BinaryNode is not found"
        while((firstName.toUpperCase() + lastName).toUpperCase().compareTo(currentNode.getName()) != 0){
            parent = currentNode;
            int comparison = (firstName.toUpperCase() + lastName).toUpperCase().compareTo(currentNode.getName());
            if(comparison < 0){
                isItLeftChild = true;
                currentNode = currentNode.getLeftChild();
            } else {
                isItLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            if(currentNode == null)
                return result;

        }
        //SV: Deletes the binary node if it has no children
        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null){
            if (currentNode == root){
                setRoot(null);

            } else if(isItLeftChild){
                parent.setLeftChild(null);
            }else {
                parent.setRightChild(null);
            }
            result = currentNode.toString() + " " + "BinaryNode has been successfully deleted";
            return result;
        }

        //SV: Deletes the binary node if it has no right child
        else if (currentNode.getRightChild() == null){
            if(currentNode == root)
                setRoot(currentNode.getLeftChild());
            else if(isItLeftChild)
                parent.setLeftChild(currentNode.getLeftChild());
            else parent.setRightChild(currentNode.getLeftChild());
        }

        //SV: Deletes the binary node if it has no left child
        else if(currentNode.getLeftChild() == null){
            if(currentNode == root)
                setRoot(currentNode.getRightChild());

            else if (isItLeftChild)
                parent.setLeftChild(currentNode.getRightChild());
            else
                parent.setRightChild(currentNode.getLeftChild());
        }
        //SV: Deletes the binary node if it has both children and looking for the replacement for that node
        else {
            BinaryNode replacement = getReplacementNode(currentNode);

            if (currentNode == root)
                setRoot(replacement);

            else if (isItLeftChild)
                parent.setLeftChild(replacement);
            else
                parent.setRightChild(replacement);

            replacement.setLeftChild(currentNode.getLeftChild());
        }
        result = currentNode.toString() + " " + "BinaryNode has been successfully deleted";
        return result;

    }

    //SV: Searches and returns a replacement
    public BinaryNode getReplacementNode(BinaryNode replacedNode){
        BinaryNode replacementParent = replacedNode;
        BinaryNode replacement = replacedNode;

        BinaryNode theNode = replacedNode.getRightChild();

        //SV: Searches until there are no more left children
        while (theNode != null){
            replacementParent = replacement;
            replacement = theNode;
            theNode = theNode.getLeftChild();
        }
        if (replacement != replacedNode.getRightChild()){
            replacementParent.setLeftChild(replacement.getRightChild());
            replacement.setRightChild(replacedNode.getRightChild());
        }

        return replacement;

    }

    public static void main(String[] args){

        BinaryTree theTree = new BinaryTree();

        System.out.println(" ** Testing Inserting 10 entries \n\n ");

        theTree.insert("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
        theTree.insert("Jane", "Williams", "555-235-1112", "jw@something.com");
        theTree.insert("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
        theTree.insert("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
        theTree.insert("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
        theTree.insert("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
        theTree.insert("Jack", "Jones", "555-235-1117", "jjones@hill.com");
        theTree.insert("Jill", "Jones", "555-235-1118", "jillj@hill.com");
        theTree.insert("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
        theTree.insert("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");

        System.out.println(" --------- Display Table  (Should have 10 entries) -------- \n\n ");
        theTree.inorderTraverse();

        System.out.println(" \n\n ** Testing Finding 2 persons \n\n ");
        System.out.println(theTree.lookUp("Pat", "Jones"));
        System.out.println(theTree.lookUp("Billy", "Kidd"));

        System.out.println(" \n\n** Testing Removing one \n\n ");
        System.out.println(theTree.remove("John", "Doe"));

        System.out.println(" --------- Display Table  (Should have 9 entries) -------- \n\n ");
        theTree.inorderTraverse();

        System.out.println(" \n\n ** Testing Inserting 6 new entries  \n\n ");
        theTree.insert("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
        theTree.insert("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        theTree.insert("Jo", "Wu", "555-235-1123", "wu@h.com");
        theTree.insert("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
        theTree.insert("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
        theTree.insert("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");

        System.out.println(" --------- Display Table ( Should have 15 entries ) -------- \n\n ");
        theTree.inorderTraverse();

        System.out.println(" \n\n ** Testing Find 2 \n ");
        System.out.println(theTree.lookUp("Jack", "Jones"));
        System.out.println(theTree.lookUp("Nadezhda", "Kanachekhovskaya"));

        System.out.println(" \n\n ** Testing Remove 1 \n\n ");
        System.out.println(theTree.remove("Jill", "Jones"));
        System.out.println(theTree.remove("John", "Doe"));

        System.out.println("\n\n --------- Display Table (should have 14 entries ) -------- \n\n ");
        theTree.inorderTraverse();

        System.out.println(" \n\n ** Testing Find 2 \n\n ");
        System.out.println(theTree.lookUp("Jill", "Jones"));
        System.out.println(theTree.lookUp("John", "Doe"));

    }

}
