
/*
 * The Enigma Machine class is supposed to be the Controller in the MVC strcuture
 */
public class EnigmaMachine{

    ModelManager model = null;


    public EnigmaMachine(){
        model = new ModelManager(this) ;
    }
}