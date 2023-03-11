// Caesar Cipher 2
// Mehrad Hajati
// 2021/05/29 
// This program uses the Caesar Cipher to encrypt and decrypt messages.
// At the end of the encryption a "-1" is added to the end to show the end of the message. 


import java.util.*;

public class CaesarCipher2 {

    // Constants 
    public static final String ALPHABET = " abcdefghijklmnopqrstuvwxyz" ;
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
            String message = sc.next();
            message += sc.nextLine();
            message.toLowerCase();
            int length = message.length();
            String encryptedMessage = "";
            for (int i = 0; i < length; i++){
                char letter = message.charAt(i);
                for (int j = 0; j < 27; j++){
                    if (letter == ALPHABET.charAt(j)){
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
            ArrayList<Integer> codedMessage = new ArrayList<Integer>(); 
            while (number != END_OF_DECRYPTION){
                codedMessage.add(number);
                number = sc.nextInt();
            }
            String message = "";
            int size = codedMessage.size();
            for (int i = 0; i < size; i++){
                char letter = ALPHABET.charAt(codedMessage.get(i) - (key % 27));
                message += letter;
            }
            System.out.println(message);
        }
    }
}
