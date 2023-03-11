//

/**
 * Mehrad Hajati
 * This class is meant to be the ModelManager in the MVC structure of the system
 */
public class ModelManager{

    EnigmaMachine controller = null;
    boolean encoding = true; // this instance variable will keep track of whether we are encoding or deconding, if true its we are encoding, false otherwise
    RailFenceCipher railFence = null;
    AffineCipher affine = null;
    AtbashCipher atbash = null;
    VigenereCipher vigenere = null;
    MatrixCipher matrix = null;
    CeasarCipher ceasar = null;


    public ModelManager(EnigmaMachine con){
        this.controller = con;
        // create all the other cipher classes
    }


}