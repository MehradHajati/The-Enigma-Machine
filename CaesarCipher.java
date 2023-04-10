// Caesar Cipher 2
// Mehrad Hajati
// 2021/05/29 
// This program uses the Caesar Cipher to encrypt and decrypt messages.


import java.util.*;

public class CaesarCipher {

    // Constants 
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" ;
    public static final int ALPHABET_LENGTH = 26;
    // the string and integer beneath can be any negative number or any number larger than 27 but they must match each other for the program to work

    //Encryption Method
    public static String encrypt(String message, int key){
        key = modAlphabetLength(key);
        String encryptedMessage = "";
        message = message.toLowerCase();
        for (int i = 0; i < message.length(); i++){
            char letter = message.charAt(i);
            int index = modAlphabetLength(ALPHABET.indexOf(letter) + key);
            // To avoid indexOutOfBounds, and also to skip the empty space
            encryptedMessage = encryptedMessage + ALPHABET.charAt(index);
        } 
        return encryptedMessage.toUpperCase();
    }

    //Decryption Method
    public static String decrypt(String letters, int key){
        key = modAlphabetLength(key);
        letters = letters.toLowerCase();
        String message = "";
        for (int i = 0; i < letters.length(); i++){
            int index = modAlphabetLength(ALPHABET.indexOf(letters.charAt(i)) - (key));
            char letter = ALPHABET.charAt(index);
            message += letter;
        }
        return message.toUpperCase();
    }

    public static int modAlphabetLength(int a){
        while(a < 0){
            a = a + ALPHABET_LENGTH;
        }
        return a % ALPHABET_LENGTH;
    }

    /*public static void main(String[] args){
        // Introduction
        Scanner sc = new Scanner(System.in);
        System.out.println("Would you like to encrypt or decrypt?");
        String answer = sc.next();
        while (!(answer.equals("encrypt") || (answer.equals("decrypt")))){
            System.out.println("Please try again!");
            System.out.println("Would you like to encrypt or decrypt?");
            answer = sc.next();
        }
        
        // Encrypting Part
        if (answer.equals("encrypt")){
            System.out.println("Please enter a key consisting of a number:");
            int key = sc.nextInt();
            System.out.println("Please type the message you would like to encrypt:");
            String message = sc.next();
            message += sc.nextLine();
            System.out.println(encrypt(message, key));
        }

        // Decoding Part
        else if(answer.equals("decrypt")){
            System.out.println("Please enter your selected key:");
            int key = sc.nextInt();
            sc.nextLine();
            System.out.println("Please type the sequence of letters you would like to decrypt:");
            String letters = sc.nextLine();
            System.out.println(decrypt(letters, key));
        }
        sc.close();
    }*/
}
