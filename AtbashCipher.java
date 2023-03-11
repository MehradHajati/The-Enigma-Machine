// AtBash Cipher
// Mehrad Hajati
// 18/06/2021
// This class turns plaintext into ciphertext and vice versa using the Atbash Cipher.

import java.util.Scanner;

public class AtbashCipher{

    // Constants
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final String ALPHABETREV = "zyxwvutsrqponmlkjihgfedcda";


    //Encryption Method
    public static String Encrypt(String plainText){
        plainText = plainText.toLowerCase();
        String cipherText = "";
        int length = plainText.length();
        for(int i = 0; i < length; i++){
            char letter = plainText.charAt(i);
            for(int j = 0; j < 26; j++){
                if(letter == ALPHABET.charAt(j)){
                    cipherText += ALPHABETREV.charAt(j);
                    // this break statment gets out of the for loop for the alphabet with j
                    break;
                }
            }
        }
        return cipherText.toUpperCase();
    }


    //Decryption Method
    public static String Decrypt(String cipherText){
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        int length = cipherText.length();
        for(int i = 0; i < length; i++){
            char letter = cipherText.charAt(i);
            for(int j = 0; j < 26; j++){
                if(letter == ALPHABETREV.charAt(j)){
                    plainText += ALPHABET.charAt(j);
                    break;
                }
            }
        }
        return plainText.toUpperCase();
    }



    //Main Method
    public static void main(String[] args){

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
            System.out.println("Your CipherText is: " + Encrypt(plainText));
        }

        //Decryption part
        if(answer.equals("decrypt")){
            System.out.println("Please enter the ciphertext you would like to decrypt:");
            sc.nextLine();
            String cipherText = sc.nextLine();
            System.out.println("Your plaintext is: " + Decrypt(cipherText));
        }
        sc.close();
    }
}