package twisk.outils;

public class FabriqueNumero {

    private static final FabriqueNumero instance = new FabriqueNumero();
    private int cptEtape;
    private int cptSemaphore;


    private FabriqueNumero() {
        cptEtape = 0;
        cptSemaphore = 1;

    }
    public static FabriqueNumero getInstance() {
        return instance;
    }

    public int getNumeroEtape() {
        assert (cptEtape >= 0) : " Bug ! , cpt negatif ";
        cptEtape++;
        return cptEtape - 1;
    }
    public void reset() {
        cptEtape = 0;
        cptSemaphore = 1;
    }

    public int getNumeroSemaphore() {
        assert (cptSemaphore > 0) : "Bug ! , cpt inferieur a 1 ";
        cptSemaphore++;
        return cptSemaphore - 1;
    }
}
