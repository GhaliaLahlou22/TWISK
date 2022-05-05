package twisk.exceptions;

public class ExceptionExistArc extends TwiskException {

    public ExceptionExistArc(){
        super("Impossible de crée cet arc ,il existe déjà");
    }
}
