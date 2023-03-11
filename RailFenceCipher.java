// RailFence Cipher
// Mehrad Hajati
// 19/09/2021
// This class turns plaintext into ciphertext and vice versa using the RailFence Cipher.

import java.util.Scanner;

public class RailFenceCipher{

    public static final int ALPHABET_LENGTH = 26;

    //Encryption Method
    public static String encrypt(String plainText, int key){
        key = modAlphabetLength(key);
        plainText = plainText.toLowerCase();
        String cipherText = "";
        int length = plainText.length();
        char[][] rail = new char[key][length];
        boolean dir_down = true;
        int row = 0;
        for(int i = 0; i < length; i++){
            rail[row][i] = plainText.charAt(i);
            // find the direction using the flag
            if(dir_down){
                row++;
            }
            else{
                row--;
            }
            // check if we at end, if yes reverse flag
            if(row == (key-1) || row == 0){
                dir_down = !dir_down;
            }
        }
        for(int i = 0; i < key; i++){
            for(int j = 0; j < length; j++){
                if(rail[i][j] != 0){
                    cipherText = cipherText + rail[i][j];
                }
            }
        }
        return cipherText.toUpperCase();
    }

    public static int modAlphabetLength(int a){
        while(a < 0){
            a = a + ALPHABET_LENGTH;
        }
        return a % ALPHABET_LENGTH;
    }

    //Decryption Method
    public static String decrypt(String cipherText, int key){
        key = modAlphabetLength(key);
        cipherText = cipherText.toLowerCase();
        int length = cipherText.length();
        char[][] rail = new char[key][length];
        int row = 0;
        boolean dir_down = true;

        // going through the rail matrix and filling the used positiongs with '$'
        for(int i = 0; i < length; i++){
            rail[row][i] = '$';
            // add one to row according to the direction of flow
            if(dir_down){
                row++;
            }
            else{
                row--;
            }
            // check if we at end, if yes reverse flag
            if(row == (key-1) || row == 0){
                dir_down = !dir_down;
            }
        }

        int index = 0;
        // now that we know the position to fill we go through it and fill them
        for(int i = 0; i < key; i++){
            for(int j = 0; j < length; j++){
                if(rail[i][j] == '$'){
                    rail[i][j] = cipherText.charAt(index);
                    index++;
                }
            }
        }

        // now that the matrix is filled we read it row wise
        String plainText = "";
        dir_down = true;
        row = 0; 
        for(int i = 0; i < length; i++){
            plainText = plainText + rail[row][i];
            if(dir_down){
                row++;
            }
            else{
                row--;
            }
            // check if we at end, if yes reverse flag
            if(row == (key-1) || row == 0){
                dir_down = !dir_down;
            }
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
            System.out.println("Please enter your key:");
            int key = sc.nextInt();
            System.out.println("Your CipherText is: " + encrypt(plainText, key));
        }

        //Decryption part
        if(answer.equals("decrypt")){
            System.out.println("Please enter the ciphertext you would like to decrypt:");
            sc.nextLine();
            String cipherText = sc.nextLine();
            System.out.println("Please enter your key:");
            int key = sc.nextInt();
            System.out.println("Your plaintext is: " + decrypt(cipherText, key));
        }
        sc.close();
    }*/
}