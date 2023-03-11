//

/**
 * Mehrad Hajati
 * This class is meant to be the ModelManager in the MVC structure of the system
 */
public class ModelManager{

    EnigmaMachine controller = null;
    boolean encoding = true; // this instance variable will keep track of whether we are encoding or deconding, if true its we are encoding, false otherwise


    public ModelManager(EnigmaMachine con){
        this.controller = con;
        
    }

    // Wrapper method for Vigenere Class
    public String encryptVigenere(String plaintText, String key){ return VigenereCipher.encrypt(plaintText, key); }
    public String decryptVigenere(String cipherText, String key){ return VigenereCipher.decrypt(cipherText, key); }

    // Wrapper methods for MatrixCipher class
    public String encryptMatrix(String plaintText, String key){ return MatrixCipher.encrypt(plaintText, key); }
    public String decryptMatrix(String cipherText, String key){ return MatrixCipher.decrypt(cipherText, key); }

    // Wrapper methods for RailFenceCipher class
    public String encryptRaileFence(String plainText, int key){ return RailFenceCipher.encrypt(plainText, key); }
    public String decryptRailFence(String cipherText, int key){ return RailFenceCipher.decrypt(cipherText, key); }

    // Wrapper methods for AtbashCipher class
    public String encryptAtbash(String plainText){ return AtbashCipher.encrypt(plainText); }
    public String decryptAtbash(String cipherText){ return AtbashCipher.decrypt(cipherText); }
    
    // Wrapper methods for AffineCipher class
    public String encryptAffine(String plainText, int a, int b){ return AffineCipher.encrypt(plainText, a, b); }
    public String decryptAffine(String cipherText, int a, int b){ return AffineCipher.decrypt(cipherText, a, b); }

    // Wrapper methods for CaesarCipher class
    public String encryptCaesar(String plainText, int key){ return CaesarCipher.encrypt(plainText, key); }
    public String decryptCaesar(String cipherText, int key){ return CaesarCipher.decrypt(cipherText, key); }
}