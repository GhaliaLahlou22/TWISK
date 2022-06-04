package twisk.exceptions;

public class MondeException extends TwiskException {
    public MondeException() {
        super("Attention !! votre monde doit avoir au moin une sortie , une entrée et une Activité . ");
    }
}
