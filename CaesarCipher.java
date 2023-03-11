// Caesar Cipher 2
// Mehrad Hajati
// 2021/05/29 
// This program uses the Caesar Cipher to encrypt and decrypt messages.
// At the end of the encryption a "-1" is added to the end to show the end of the message. 


import java.util.*;

public class CaesarCipher {

    // Constants 
    public static final String ALPHABET = " abcdefghijklmnopqrstuvwxyz" ;
    // the string and integer beneath can be any negative number or any number larger than 27 but they must match each other for the program to work

    //Encryption Method
    public static String encrypt(String message, int key){
        String encryptedMessage = "";
        message = message.toLowerCase();
        for (int i = 0; i < message.length(); i++){
            char letter = message.charAt(i);
            for (int j = 0; j < 27; j++){
                if (letter == ALPHABET.charAt(j)){
                    encryptedMessage = encryptedMessage + ALPHABET.charAt(j + (key % 27));
                }
            }
        } 
        return encryptedMessage.toUpperCase();
    }
    //Decryption Method
    public static String decrypt(String letters, int key){
        String message = "";
        for (int i = 0; i < letters.length(); i++){
            char letter = ALPHABET.charAt(ALPHABET.indexOf(letters.charAt(i)) - (key % 27));
            message += letter;
        }
        return message.toUpperCase();
    }

    public static void main(String[] args){

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
            System.out.println("Please type the sequence of letters you would like to decrypt:");
            String letters = sc.next();
            System.out.println(decrypt(letters, key));
        }
        sc.close();
    }
}
