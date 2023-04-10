// Affine Cipher
// Mehrad Hajati
// 19/09/2021
// This class turns plaintext into ciphertext and vice versa using the Affine Cipher.

import java.util.Scanner;

public class AffineCipher{

    // Constants
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz" ;
    private static final int ALPHABET_LENGTH = 26;

    // Mod Inverse Method for Decryption
    static int modInverse(int a, int m){
        for (int x = 1; x < m; x++){
            if (((a%m) * (x%m)) % m == 1){
                return x;
            }
        }
        return 1;
    }

    //Encryption Method, the first integer "a" has to be coprime with ALPHABET_LENGTH so that decryption will work
    public static String encrypt(String msg, int a, int b){
        msg = msg.toLowerCase();
        String cipherText = "";
        int length = msg.length();
        for(int i = 0; i < length; i++){
            char letter = msg.charAt(i);
            for(int j = 0; j < ALPHABET_LENGTH; j++){
                if(letter == ALPHABET.charAt(j)){
                    cipherText += ALPHABET.charAt(((j*a) + b) % ALPHABET_LENGTH);
                    break;
                }
            }
        }
        return cipherText.toUpperCase();
    }


    //Decryption Method, the first integer "a" has to be coprime with ALPHABET_LENGTH so that decryption will work
    public static String decrypt(String cipherText, int a, int b){
        cipherText = cipherText.toLowerCase();
        String plainText = "";
        int euclid = modInverse(a, ALPHABET_LENGTH);
        int length = cipherText.length();
        for(int i = 0; i < length; i++){
            char letter = cipherText.charAt(i);
            for(int j = 0; j < ALPHABET_LENGTH; j++){
                if(letter == ALPHABET.charAt(j)){
                    int noMod = (j-b) * euclid;
                    if( noMod < 0){
                        plainText += ALPHABET.charAt(ALPHABET_LENGTH - (Math.abs(noMod) % ALPHABET_LENGTH));
                    }
                    else{
                        plainText += ALPHABET.charAt(noMod % ALPHABET_LENGTH);
                    }
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
            System.out.println("Please enter your two integer keys with a space seperating them: (Remember your first key has to be a coprime with 26)");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Your CipherText is: " + encrypt(plainText, a, b));
        }

        //Decryption part
        if(answer.equals("decrypt")){
            System.out.println("Please enter the ciphertext you would like to decrypt:");
            sc.nextLine();
            String cipherText = sc.nextLine();
            System.out.println("Please enter your two integer keys with a space seperating them:");
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Your plaintext is: " + decrypt(cipherText, a, b));
        }
        sc.close();
    }
}