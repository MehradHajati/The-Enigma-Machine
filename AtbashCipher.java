// AtBash Cipher
// Mehrad Hajati
// 18/06/2021
// This class turns plaintext into ciphertext and vice versa using the Atbash Cipher.

import java.util.Scanner;

public class AtbashCipher{

    // Constants
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABETREV = "zyxwvutsrqponmlkjihgfedcba";


    //Encryption Method
    public static String encrypt(String plainText){
        plainText = plainText.toLowerCase();
        String cipherText = "";
        int length = plainText.length();
        for(int i = 0; i < length; i++){
            char letter = plainText.charAt(i);
            cipherText += ALPHABETREV.charAt(ALPHABET.indexOf(letter));
        }
        return cipherText.toUpperCase();
    }


    //Decryption Method
    public static String decrypt(String cipherText){
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        int length = cipherText.length();
        for(int i = 0; i < length; i++){
            char letter = cipherText.charAt(i);
            plainText += ALPHABET.charAt(ALPHABETREV.indexOf(letter));
        }
        return plainText.toUpperCase();
    }



    //Main Method
    /*public static void main(String[] args){

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
            System.out.println("Your CipherText is: " + encrypt(plainText));
        }

        //Decryption part
        if(answer.equals("decrypt")){
            System.out.println("Please enter the ciphertext you would like to decrypt:");
            sc.nextLine();
            String cipherText = sc.nextLine();
            System.out.println("Your plaintext is: " + decrypt(cipherText));
        }
        sc.close();
    }*/
}