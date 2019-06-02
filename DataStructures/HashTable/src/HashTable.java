public class HashTable {
    private LinkedList[] hashTable;
    private static int hashTableSize = 13;

    //SV: Constructor
    public HashTable() {
        hashTable = new LinkedList[hashTableSize];

        for (int i = 0; i < hashTableSize; i++) {

            hashTable[i] = new LinkedList();
        }
    }
    //SV: Gets the hash key for a hash table
    public int getHashKey(String firstName, String lastName){
        int key = (firstName.toUpperCase() + lastName.toUpperCase()).hashCode()% 13;
        if (key < 0)
            key = key + 13;
        return key;
    }
    //SV: Inserts a new entry to the hash table
    public void insertHashTable (String firstName, String lastName, String phoneNumber, String eMail){

        //SV: creates the hash key for a new entry
        int hashKey = getHashKey(firstName, lastName);
        hashTable[hashKey].insert(firstName, lastName, phoneNumber, eMail);
    }

    //SV: Searches for the entry by name

    public Node findHashTable(String firstName, String lastName) {
        int hashKey = getHashKey(firstName, lastName);
        Node theNode = hashTable[hashKey].lookUp(firstName, lastName);
        return theNode;
    }
    //SV: Removes the entry from the hash table if found, otherwise returns null
    public Node removeHashTable (String firstName, String lastName) {

        int hashKey = getHashKey(firstName, lastName);

        Node theNode = hashTable[hashKey].lookUp(firstName, lastName);

        if (theNode != null) {
            hashTable[hashKey].remove(firstName, lastName);
        } else {
            return null;
        }

        return theNode;
    }
    //SV: Displays the hash table
    public void displayHashTable(){

        // Go through every bucket and print the linked list
        for(int i =0; i < hashTableSize; i++) {

            System.out.println("HashTable Index " + i);
            // i  = 1
            hashTable[i].printList();
        }
    }

    public static void main(String[] arg) {

        HashTable testHash = new HashTable();

        System.out.println(" ** Testing Inserting 10 entries \n\n ");


        testHash.insertHashTable("Bob", "Smith", "555-235-1111", "bsmith@somewhere.com");
        testHash.insertHashTable("Jane", "Williams", "555-235-1112", "jw@something.com");
        testHash.insertHashTable("Mohammed", "al-Salam", "555-235-1113", "mas@someplace.com");
        testHash.insertHashTable("Pat", "Jones", "555-235-1114", "pjones@homesweethome.com");
        testHash.insertHashTable("Billy", "Kidd", "555-235-1115", "billy_the_kid@nowhere.com");
        testHash.insertHashTable("H.", "Houdini", "555-235-1116", "houdini@noplace.com");
        testHash.insertHashTable("Jack", "Jones", "555-235-1117", "jjones@hill.com");
        testHash.insertHashTable("Jill", "Jones", "555-235-1118", "jillj@hill.com");
        testHash.insertHashTable("John", "Doe", "555-235-1119", "jdoe@somedomain.com");
        testHash.insertHashTable("Jane", "Doe", "555-235-1120", "jdoe@somedomain.com");

        System.out.println(" --------- Display Table  (Should have 10 entries) -------- \n\n ");
        testHash.displayHashTable();

        System.out.println(" \n\n ** Testing Finding 2 persons \n\n ");
        System.out.println(testHash.findHashTable("Pat", "Jones"));
        System.out.println(testHash.findHashTable("Billy", "Kidd"));

        System.out.println(" \n\n** Testing Removing one \n\n ");
        testHash.removeHashTable("John", "Doe");

        System.out.println(" --------- Display Table  (Should have 9 entries) -------- \n\n ");
        testHash.displayHashTable();

        System.out.println(" \n\n ** Testing Inserting 6 new entries  \n\n ");
        testHash.insertHashTable("Test", "Case", "555-235-1121", "Test_Case@testcase.com");
        testHash.insertHashTable("Nadezhda", "Kanachekhovskaya", "555-235-1122", "dr.nadezhda.kanacheckovskaya@somehospital.moscow.ci.ru");
        testHash.insertHashTable("Jo", "Wu", "555-235-1123", "wu@h.com");
        testHash.insertHashTable("Millard", "Fillmore", "555-235-1124", "millard@theactualwhitehouse.us");
        testHash.insertHashTable("Bob", "vanDyke", "555-235-1125", "vandyke@nodomain.com");
        testHash.insertHashTable("Upside", "Down", "555-235-1126", "upsidedown@rightsideup.com");

        System.out.println(" --------- Display Table ( Should have 15 entries ) -------- \n\n ");
        testHash.displayHashTable();

        System.out.println(" ** Testing Find 2 \n\n ");
        System.out.println(testHash.findHashTable("Jack", "Jones"));
        System.out.println(testHash.findHashTable("Nadezhda", "Kanachekhovskaya"));

        System.out.println(" \n\n ** Testing Remove 1 \n\n ");
        testHash.removeHashTable("Jill", "Jones");
        testHash.removeHashTable("John", "Doe");

        System.out.println(" --------- Display Table (should have 14 entries ) -------- \n\n ");
        testHash.displayHashTable();

        System.out.println(" \n\n ** Testing Find 2 \n\n ");
        System.out.println(testHash.findHashTable("Jill", "Jones"));
        System.out.println(testHash.findHashTable("John", "Doe"));

    }
}
