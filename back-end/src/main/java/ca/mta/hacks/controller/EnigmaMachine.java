package ca.mta.hacks.controller;

import ca.mta.hacks.model.*;
import org.springframework.stereotype.Controller;

/*
 * The Enigma Machine class is supposed to be the Controller in the MVC strcuture
 */

@Controller
public class EnigmaMachine {

    // this instance variable will keep track of whether we are encoding or deconding, if true its we are encoding, false otherwise
    boolean encoding = true;


    public EnigmaMachine(){
        
    }

    // Method for changing the mode from encoding to decoding and vice versa
    public void changeMode(){ encoding = !encoding; }

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

    // Wrapper methods for AffineCipher class, the first integer "a" has to be co prime with 26 so that decryption will work
    public String encryptAffine(String plainText, int a, int b){ return AffineCipher.encrypt(plainText, a, b); }
    public String decryptAffine(String cipherText, int a, int b){ return AffineCipher.decrypt(cipherText, a, b); }

    // Wrapper methods for CaesarCipher class
    public String encryptCaesar(String plainText, int key){ return CaesarCipher.encrypt(plainText, key); }
    public String decryptCaesar(String cipherText, int key){ return CaesarCipher.decrypt(cipherText, key); }

    public String encrypt(String encryptType, String message) {
        return null;
    }

    public String decrypt(String encryptType, String message, String key) {
        return null;
    }
}