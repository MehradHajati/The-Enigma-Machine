
import java.util.Scanner;
/*
 * The Enigma Machine class is supposed to be the Controller in the MVC strcuture
 */
public class EnigmaMachine{

    // this instance variable will keep track of whether we are encoding or deconding, if true its we are encoding, false otherwise
    boolean encoding = true;


    public EnigmaMachine(){
        
    }

    // Method for changing the mode from encoding to decoding and vice versa
    public void changeMode(){ encoding = !encoding; }

    // Wrapper method for Vigenere Class
    public static String encryptVigenere(String plaintText, String key){ return VigenereCipher.encrypt(plaintText, key); }
    public static String decryptVigenere(String cipherText, String key){ return VigenereCipher.decrypt(cipherText, key); }

    // Wrapper methods for MatrixCipher class
    public static String encryptMatrix(String plaintText, String key){ return MatrixCipher.encrypt(plaintText, key); }
    public static String decryptMatrix(String cipherText, String key){ return MatrixCipher.decrypt(cipherText, key); }

    // Wrapper methods for RailFenceCipher class
    public static String encryptRailFence(String plainText, int key){ return RailFenceCipher.encrypt(plainText, key); }
    public static String decryptRailFence(String cipherText, int key){ return RailFenceCipher.decrypt(cipherText, key); }

    // Wrapper methods for AtbashCipher class
    public static String encryptAtbash(String plainText){ return AtbashCipher.encrypt(plainText); }
    public static String decryptAtbash(String cipherText){ return AtbashCipher.decrypt(cipherText); }

    // Wrapper methods for AffineCipher class, the first integer "a" has to be co prime with 26 so that decryption will work
    public static String encryptAffine(String plainText, int a, int b){ return AffineCipher.encrypt(plainText, a, b); }
    public static String decryptAffine(String cipherText, int a, int b){ return AffineCipher.decrypt(cipherText, a, b); }

    // Wrapper methods for CaesarCipher class
    public static String encryptCaesar(String plainText, int key){ return CaesarCipher.encrypt(plainText, key); }
    public static String decryptCaesar(String cipherText, int key){ return CaesarCipher.decrypt(cipherText, key); }

    public static boolean checkCipherInput(int num){
        if(num > 0 && num < 7){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        int cipher = 0;
        Scanner sc = new Scanner(System.in);
        while(!checkCipherInput(cipher)){
            System.out.println("Choose one of the below cipher by inputting their number:");
            System.out.println("1. Vigenere");
            System.out.println("2. Matrix/Hill");
            System.out.println("3. RailFence");
            System.out.println("4. Atbash");
            System.out.println("5. Affine");
            System.out.println("6. Caesar");
            cipher = sc.nextInt();
        }
        
        System.out.println("Would you like to encrypt or decrypt?");
        String answer = sc.next();
        while (!(answer.equals("encrypt") || (answer.equals("decrypt")))){
            System.out.println("Please try again!");
            System.out.println("Would you like to encrypt or decrypt?");
            answer = sc.next();
        }
       
        switch(cipher){
            case 1:
                if(answer.equals("encrypt")){
                    System.out.println("Please enter your plaintext with no spaces");
                    String pt = sc.next();
                    System.out.println("Please enter your string key with no spaces");
                    String key = sc.next();
                    System.out.println(encryptVigenere(pt, key));
                }
                else{
                    System.out.println("Please enter your ciphertext with no spaces");
                    String ct = sc.next();
                    System.out.println("Please enter your string key with no spaces");
                    String key = sc.next();
                    System.out.println(decryptVigenere(ct, key));
                }
            
            case 2:
                if(answer.equals("encrypt")){
                    System.out.println("Please enter your plaintext with no spaces");
                    String pt = sc.next();
                    System.out.println("Please enter your string key with no spaces");
                    String key = sc.next();
                    System.out.println(encryptMatrix(pt, key));
                }
                else{
                    System.out.println("Please enter your ciphertext with no spaces");
                    String ct = sc.next();
                    System.out.println("Please enter your string key with no spaces");
                    String key = sc.next();
                    System.out.println(decryptMatrix(ct, key));
                }

            case 3:
                if(answer.equals("encrypt")){
                    System.out.println("Please enter your plaintext with no spaces");
                    String pt = sc.next();
                    System.out.println("Please enter your integer key with no spaces");
                    int key = sc.nextInt();
                    System.out.println(encryptRailFence(pt, key));
                }
                else{
                    System.out.println("Please enter your ciphertext with no spaces");
                    String ct = sc.next();
                    System.out.println("Please enter your integer key with no spaces");
                    int key = sc.nextInt();
                    System.out.println(decryptRailFence(ct, key));
                }

            case 4:
                if(answer.equals("encrypt")){
                    System.out.println("Please enter your plaintext with no spaces");
                    String pt = sc.next();
                    System.out.println(encryptAtbash(pt));
                }
                else{
                    System.out.println("Please enter your ciphertext with no spaces");
                    String ct = sc.next();
                    System.out.println(decryptAtbash(ct));
                }

            case 5:
                if(answer.equals("encrypt")){
                    System.out.println("Please enter your plaintext with no spaces");
                    String pt = sc.next();
                    System.out.println("Please enter your two integer key with a space seperating them (the first integer has to be coprime with 26)");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    System.out.println(encryptAffine(pt, a, b));
                }
                else{
                    System.out.println("Please enter your ciphertext with no spaces");
                    String ct = sc.next();
                    System.out.println("Please enter your two integer key with a space seperating them (the first integer has to be coprime with 26)");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    System.out.println(decryptAffine(ct, a, b));
                }
        }


    }
}