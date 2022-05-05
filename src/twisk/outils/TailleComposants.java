package twisk.outils;

public class TailleComposants {
    private static TailleComposants instance =new TailleComposants();
    private int hauteur;
    private int largeur;

    /**
     * Constructeur de TailleComposants
     */
    public TailleComposants(){
        this.hauteur = 90;
        this.largeur = 198;
    }

    /**
     * Instance de la TailleComposants
     * @return instance
     */
    public static TailleComposants getInstance(){
        return instance;
    }
    /**
     * Getter de la hauteur
     * @return hauteur
     */
    public int getHauteur(){
        return hauteur;
    }
    /**
     * Getter de la largeur
     * @return largeur
     */
    public int getLargeur(){
        return largeur;
    }

}
