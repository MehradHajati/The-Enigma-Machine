// Caesar Cipher
// Mehrad Hajati
// 2021/05/18 
// This program uses the Caesar Cipher to encrypt and decrypt messages. 
// At the end of the encryption a "-1" is added to the end to show the end of the message. 


import java.util.*;

public class CaesarCipher {

    // Constants 
    public static final char[] ALPHABET = {' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    // the string and integer beneath can be any negative number or any number larger than 27 but they must match each other for the program to work
    public static final String END_OF_ENCRYPTION = "-1";
    public static final int END_OF_DECRYPTION = -1;


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
            sc.nextLine();
            String message = sc.nextLine();
            message.toLowerCase();
            int length = message.length();
            String encryptedMessage = "";
            for (int i = 0; i < length; i++){
                char letter = message.charAt(i);
                for (int j = 0; j < 27; j++){
                    if (letter == ALPHABET[j]){
                        encryptedMessage = encryptedMessage + (j + (key % 27)) + " ";
                    }
                }

            } 
            encryptedMessage += END_OF_ENCRYPTION;
            System.out.println(encryptedMessage);

        }

        // Decoding Part
        else if(answer.equals("decrypt")){
            System.out.println("Please enter your selected key:");
            int key = sc.nextInt();
            System.out.println("Please type the sequence of numbers you would like to decrypt:");
            int number = sc.nextInt();
            ArrayList<Integer> encryptedMessage = new ArrayList<Integer>(); 
            while (number != END_OF_DECRYPTION){
                encryptedMessage.add(number);
                number = sc.nextInt();
            }
            String message = "";
            int size = encryptedMessage.size();
            for (int i = 0; i < size; i++){
                char letter = ALPHABET[encryptedMessage.get(i) - (key % 27)];
                message += letter;
            }
            System.out.println(message);
        }
    }
}
