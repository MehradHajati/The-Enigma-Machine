// Vigenere Cipher
// Mehrad Hajati
// 19/09/2021
// This class encrypts plaintext to ciphertext and the other way around using the Vigenere cipher

import java.util.Scanner;

public class VigenereCipher{

    // Constants
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";


    // Method to generate key
    public static String generateKey(String plainText, String key){
        int length = plainText.length();
        int keyLength = key.length();
        if(length <= keyLength){
            return key;
        }
        else{
            for(int i = 0; keyLength < length; i++){
                System.out.println(key);
                key += key.charAt(i % keyLength);
                keyLength++;
            }
            return key;
        }
    }

    public static int[] findPosition(String input){
        int length = input.length();
        int[] array = new int[length]; 
        for(int i = 0; i < length; i++){
            char letter = input.charAt(i);
            for(int j = 0; j < 26; j++){
                if(letter == ALPHABET.charAt(j)){
                    array[i] = j;
                    break;
                }
            }
        }
        return array;
    }

    // Encryption Method
    public static String encrypt(String plainText, String key){
        plainText = plainText.toLowerCase();
        key = key.toLowerCase();
        int length = plainText.length();
        String cipherText = "";
        int[] keyPositions = findPosition(key);
        int[] textPositions = findPosition(plainText);
        for(int i = 0; i < length; i++){
            int letterPosition = keyPositions[i%key.length()] + textPositions[i];
            cipherText += ALPHABET.charAt(letterPosition % 26);
        }
        return cipherText.toUpperCase();
    }


    // Decryption Method
    public static String decrypt(String cipherText, String key){
        cipherText = cipherText.toLowerCase();
        key = key.toLowerCase();
        int length = cipherText.length();
        String plainText = "";
        int[] keyPositions = findPosition(key);
        int[] textPositions = findPosition(cipherText);
        for(int i = 0; i < length; i++){
            int letterPosition = textPositions[i] - keyPositions[i%key.length()];
            if(letterPosition < 0){
                plainText += ALPHABET.charAt(26 - (Math.abs(letterPosition)%26));
            }
            else{
                plainText += ALPHABET.charAt(letterPosition % 26);
            }
        }
        return plainText.toUpperCase();
    }

    // Main Method
    /*public static void main(String [] args){
        
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
            System.out.println("Please enter the message you would like to encrypt with no spaces:");
            String plainText = sc.next();
            System.out.println("Please enter your key:");
            String key = sc.next();
            System.out.println("Your CipherText is: " + encrypt(plainText, key));
        }

        //Decryption part
        if(answer.equals("decrypt")){
            System.out.println("Please enter the ciphertext you would like to decrypt with not spaces:");
            String cipherText = sc.next();
            System.out.println("Please enter your key:");
            String key = sc.next();
            System.out.println("Your plaintext is: " + decrypt(cipherText, key));
        }
        sc.close();
        
    }*/
}