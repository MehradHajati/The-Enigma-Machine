package ca.mta.hacks.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


//@RestController
//@RequestMapping("/api")
/**
 * Represents a Huffman encoder.
 */
public class Huffman {
    public Huffman(){

    }
    //@PostMapping("/data")
    public String encrypt(String string){
        FrequencyCount fcount = new FrequencyCount(string);
        Encoding encoding = encode(fcount);
        String returnValue = "";
        for (int i = 0; i < string.length(); i++){
            returnValue += encoding.getCode(string.charAt(i));
        }
        return returnValue;
    }

    /**
     * Creates a Huffman encoding for the specified FrequencyCount
     * 
     * @param fcount frequency count of characters
     * @return a Huffman encoding using the specified frequency count
     * @throws IllegalArgumentException if argument is {@code null}
     */
    private Encoding encode(FrequencyCount fcount) {
        if(fcount == null){
            throw new IllegalArgumentException();
        }

        //local variables
        int size = fcount.charCount();                  //the number of unique characters
        PriorityQueue heap = new PriorityQueue(size);
        Encoding code = new Encoding(fcount);
        char[] characters = fcount.getCharArray();      //all the unique characters

        //building the heap
        heap = buildingHeap(heap, fcount, characters);

        //building the tree
        while(heap.length() > 1){
            Node first = heap.removeMin();
            Node second = heap.removeMin();              //first two nodes are removed from the heap
            //new node is made with first and second node as its children, and inserted back to the heap
            heap.insert(buildingTreeNode(first, second));
        }
          
        if(heap.length() == 1){
            Node root = heap.removeMin();               //getting the root of the tree and encoding all the characters
            encodingCharacters(root, code, "");
        }
        return code;
    }
    private Node buildingTreeNode(Node first, Node second){
        if (first.getValue() != second.getValue()){
            return new Node(first,second);
            
        }
        //if both nodes have the same fcount
        if (first.isLeaf() && !second.isLeaf()){
            return new Node(first,second);
        }
        if(!first.isLeaf() && second.isLeaf()){
            return new Node(second,first);
        }
        if(first.isLeaf() && second.isLeaf()){     //when both nodes have the same fcount and are leaves
            int ascii_1 = (int) first.getChar();
            int ascii_2 = (int) second.getChar();
            if(ascii_1 > ascii_2){                  //higher ASCII code goes first
                return new Node(first,second);     
            }
            return new Node(second,first);
        }         

        //when both nodes have the same fcount and are non-leaves
        //the node with a lower tree height goes first
        int firstLevel = 0;
        int secondLevel = 0;
        Node temp = first;
        while (temp.getLeftNode() != null){
            temp = temp.getLeftNode();
            firstLevel++;
        }
        temp = second;
        while (temp.getLeftNode() != null){
            temp = temp.getLeftNode();
            secondLevel++;
        }
        if(firstLevel < secondLevel){
            return new Node(first,second);
        }
        return new Node(second,first);      
    }
    private PriorityQueue buildingHeap(PriorityQueue heap, FrequencyCount fcount, char[] characters){
        int size = fcount.charCount();                  //the number of unique characters
        for (int i = 0; i < size; i++){
            char ch = characters[i];
            int value = fcount.getFrequency(ch);
            Node node = new Node(ch, value);            //making a node for each character and adding it to the heap
            heap.insert(node);
        }
        return heap;
    }
    //encoding all characters in the tree and adding them to the code
    private void encodingCharacters(Node node, Encoding code, String string){
        if (node.isLeaf()){
            code.setCode(node.getChar(), string);       //if the node is a leaf, it is added to the map along with its code
            return;
        }
        encodingCharacters(node.getLeftNode(), code, string+"0"); //for each traversal to the left, "0" is added to the code
        encodingCharacters(node.getRightNode(), code, string+"1");//for each traversal to the right, "1" is added to the code
    }


    public static void main(String[] args){
        Huffman huffman = new Huffman();
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to encrypt or decrypt?");
        String answer = sc.next().toLowerCase();
        while (!(answer.equals("encrypt") || (answer.equals("decrypt")))){
            System.out.println("Please try again!");
            System.out.println("Would you like to encrypt or decrypt?");
            answer = sc.next().toLowerCase();
        }
        
        //Encryption part
        if(answer.equals("encrypt")){
            System.out.println("Please enter the message you would like to encrypt:");
            sc.nextLine();
            String plainText = sc.nextLine();
            System.out.println("Your CipherText is: " + huffman.encrypt(plainText));
        }

        //Decryption part
        //if(answer.equals("decrypt")){
            //System.out.println("Please enter the ciphertext you would like to decrypt:");
            //sc.nextLine();
            //String cipherText = sc.nextLine();
            //System.out.println("Please enter your two integer keys with a space seperating them:");
            //int a = sc.nextInt();
            //int b = sc.nextInt();
            //System.out.println("Your plaintext is: " + Decrypt(cipherText, a, b));
        //}
        sc.close();
    }
}
/**
 * Represents an encoding for a FrequencyCount. i.e., a mapping between
 * a character and a string.
 */
class Encoding {
    //instance variables
    private FrequencyCount fCount;
    private HashMap<Character, String> map;

    /**
     * Create a new encoding for this FrequencyCount.
     * Initially, there will be no mappings between chars and strings.
     * 
     * @param fcount frequency count of characters
     * @throws IllegalArgumentException if argument is {@code null}
     */
    public Encoding(FrequencyCount fcount) {
        if(fcount == null){
            throw new IllegalArgumentException();
        }
        fCount = fcount;
        map = new HashMap<Character, String>();
    }

    /**
     * Set the encoding for this char to the specified string.
     * 
     * @param ch a character
     * @param string binary (consisting of only zeros and ones) code string for specified character
     */
    public void setCode(char ch, String string) {
        map.put(ch, string);
    }

    /**
     * Returns the code string for a character
     * 
     * @param ch a character
     * @return code string for the specified character;
     *         or {@code null} if there is no code available
     */
    public String getCode(char ch) {
        if(map.containsKey(ch)){
            return map.get(ch);
        }
        return null;
    }
    
    /**
     * Returns the FrequencyCount that this encoding is for.
     * @return the FrequencyCount that this encoding is for
     */
    public FrequencyCount getFcount() {
        return fCount;
    }
}

/**
 * Represents a node in a tree.
 * Because a Node may have left and right children,
 * it can also represent the root of a tree.
 */
class Node {
    private char ch;
    private int value;
    private Node leftChild, rightChild;

    /**
     * Create a leaf node with the specified char and int.
     * A leaf node has no children.
     * 
     * @param ch specified character
     * @param value specified value
     */
    public Node(char ch, int value) {
        this.ch = ch;
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    /**
     * Create a new Node with the specified Nodes as children.
     * The value of this Node is the sum of the values of its two children
     * Nodes. It has no char value.
     * 
     * @param left left child Node
     * @param right right child Node
     * @throws IllegalArgumentException if either one of the arguments is {@code null}
     */
    public Node(Node left, Node right) {
        if(left == null || right == null){
            throw new IllegalArgumentException();
        }
        leftChild = left;
        rightChild = right;
        this.value = left.getValue() + right.getValue();
    }

    /**
     * Returns the value for this Node
     * @return the value for this Node
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns the left child Node for this Node.
     * 
     * @return the left child Node; or {@code null} if there is no left child
     */
    public Node getLeftNode() {
        return leftChild;
    }

    /**
     * Returns the right child Node for this Node.
     * 
     * @return the right child Node; or {@code null} if there is no right child
     */
    public Node getRightNode() {
        return rightChild;
    }

    /**
     * Return the character for this Node.
     * 
     * @return the character for this Node; or empty char if there is no char
     */
    public char getChar() {
        if(!isLeaf()){
            throw new IllegalStateException("Has no char value");
        }
        return ch;
    }

    /**
     * Determines whether this node is a leaf node
     * 
     * @return {@code true} for a leaf node; {@code false} otherwise.
     */
    public boolean isLeaf() {
        return leftChild == null && rightChild == null;
    }
}
class FrequencyCount {
    private Map<Character, Integer> frequencyMap;
    public FrequencyCount(String string){
        frequencyMap = new HashMap<>();
        for (int i = 0; i < string.length(); i++){
            char c = string.charAt(i);
            addChar(c);
        }
    }
    public void addChar(char c) {
        int frequency = frequencyMap.getOrDefault(c, 0);
        frequencyMap.put(c, frequency + 1);
    }
    public Map<Character, Integer> getFrequencyMap() {
        return frequencyMap;
    }
    public int getFrequency(Character c){
        return frequencyMap.get(c);
    }
    public int charCount(){
        return frequencyMap.keySet().size();
    }
    public char[] getCharArray(){
        char[] charArray = new char[charCount()];
        int i = 0;
        Set<Character> uniqueChar = frequencyMap.keySet();

        for (Character c : uniqueChar){
            charArray[i++] = c;
        }
        return charArray;
    }
}
/*
 * MinHeap-based implementation of a priority queue of Nodes.
 * The priority queue is ordered by the value in each Node.
 */
class PriorityQueue {

    private Node[] heapNodes;
    private int length;

    /** 
     * Create a new Priority Queue of the specified size.
     * A priority queue has a size and a length. The size is
     * the capacity (how many Nodes <emph>can</emph> be in the priority queue).
     * The length is how many Nodes <emph>are</emph> currently in the priority
     * queue. A new priority queue has a length of zero.
     * 
     * @param size maximum capacity of this priority queue
     * @throws IllegalArgumentException if argument is not positive
     */
    public PriorityQueue(int size) {
        if(size<0){
            throw new IllegalArgumentException();
        }

        heapNodes = new Node[size];
        length = 0;
    }

    /**
     * Insert the specified Node into the priority queue
     * 
     * @param n a node to insert
     * @throws IllegalArgumentException if argument is {@code null}
     * @throws IllegalStateException if no more node can be inserted
     */
    public void insert(Node n) {
        if(n == null){
            throw new IllegalArgumentException();
        }
        if(length == heapNodes.length){
            throw new IllegalStateException();
        }
        heapNodes[length] = n;
        heapifyUp(length);
        length++;
    }
    //helper method for insert
    private void heapifyUp(int i){
        if (i > 0){
            int parent = getParent(i);
            if (heapNodes[parent] != null){
                if (heapNodes[i].getValue() < heapNodes[parent].getValue()){    //if the current value is smaller than that of a parent, swap them
                    Node holder = heapNodes[parent];
                    heapNodes[parent] = heapNodes[i];
                    heapNodes[i] = holder;
                    heapifyUp(parent);
                }
            }
            else{
                heapNodes[parent] = heapNodes[i];
                heapNodes[i] = null;
                heapifyUp(parent);
            }
        }
    }

    /**
     * Removes and returns the minimum Node in this priority queue
     * 
     * @return the minimum Node in this priority queue
     * @throws IllegalStateException if this queue is empty
     */
    public Node removeMin() {
        if(length == 0){
            throw new IllegalStateException();
        }
        Node returnNode = heapNodes[0];
        if (length == 1){
            heapNodes[0] = null;
        }
        else{
            heapNodes[0] = heapNodes[length-1];         //move the last element to the front of the queue
            heapNodes[length-1] = null;
            heapifyDown(0);
        }
        length--;
        return returnNode;
    }
    //helper method for removeMin
    private void heapifyDown(int i){
        int smallest = i;
        int left = getLeftChild(i);
        int right = getRightChild(i);
        if (left < length){
            if(heapNodes[left] != null){
                if (heapNodes[left].getValue()<heapNodes[smallest].getValue()){
                    smallest = left;
                }
            }
        }
        if (right < length){
            if(heapNodes[right] != null){
                if (heapNodes[right].getValue()<heapNodes[smallest].getValue()){
                    smallest = right;
                }
            }
        }
        if(smallest != i){
            Node holder = heapNodes[smallest];
            heapNodes[smallest] = heapNodes[i];
            heapNodes[i] = holder;
            heapifyDown(smallest);
        }

    }

    /**
     * Returns the length of (number of Nodes in) the priority queue.
     * @return the length of the priority queue.
     */
    public int length() {
        return length;
    }

    /**
     * Returns the underlying array
     * @return the underlying array
     */
    public Node[] getArray() {
        return heapNodes;
    }
    
    //helper methods
    //returns the index of the parent for the node in position i
    private int getParent(int i){
        return (i-1)/2;
    }
    //Returns the index for the left child of the node in position i
    private int getLeftChild(int i){
        return 2*i+1;
    }
    //Returns the index for the right child of the node in position i
    private int getRightChild(int i){
        return 2*i+2;
    }
    
}