package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape> {

    /**
     * Les variables
     */
    protected String nom;
    protected GestionnaireSuccesseurs gest_Succ;
    protected int numEtape ;

    /**
     *
     * @param nom
     */
    public Etape(String nom){
        this.nom=nom;
        this.gest_Succ=new GestionnaireSuccesseurs();
        this.numEtape = FabriqueNumero.getInstance().getNumeroEtape();
    }

    /**
     * Fonctions qui ajoute les successeurs
     * @param e
     */
    public void ajouterSuccesseur(Etape... e){
        this.gest_Succ.ajouter(e);
    }

    /**
     * Fonction qui vérifie si une etape est une activité ou pas
     * @return
     */
    public abstract boolean estUneActivite();

    /**
     * Fonction qui vérifie une etape est un guichet ou pas
     * @return
     */
    public abstract boolean estUnGuichet();

    /**
     * getter de nom
     * @return
     */
    public String getNom(){
        String name = this.nom;
        name = name.replaceAll(" " , "_");
        name = name.replaceAll("é" , "e");
        name = name.replaceAll("è" , "e");
        name = name.replaceAll("à" , "a");
        name = name.replaceAll("â" , "a");
        name = name.replaceAll("á" ,"a");
        name = name.replaceAll("å","a");
        name = name.replaceAll("ã","a");
        name = name.replaceAll("ø" , "o");
        name = name.replaceAll("æ" , "ae");
        name = name.replaceAll("ç" , "c");
        name = name.replaceAll("î" , "i");
        name = name.replaceAll("ñ" , "n");
        name = name.replaceAll("©" , "c");
        name = name.replaceAll("¶" , "-");
        name = name.replaceAll("ì" , "i");
        name = name.replaceAll("š" , "š");
        name = name.replaceAll("ï" , "i");
        name = name.replaceAll("ý" , "y");
        name = name.replaceAll("â" , "a");
        name = name.replaceAll("Ø" , "o");
        name = name.replaceAll("ê","e");
        name = name.replaceAll("ë","e");
        name = name.replaceAll("é","e");
        name = name.replaceAll("ð","o");
        name = name.replaceAll("ß","B");
        name = name.replaceAll("ù","u");
        name = name.replaceAll("þ","b");
        name = name.replaceAll("$","s");
        name = name.replaceAll("£","e");
        name = name.replaceAll("@","a");
        name = name.replaceAll("§","s");
        name = name.replaceAll("'","-");
        name = name.replaceAll("~","_");
        name = name.replaceAll("&","et");
        name = name.replaceAll("entrees","entree");

        return name;
    }

    /**
     * Getter de numero
     * @return
     */
    public int getNum(){
        return numEtape;
    }

    /**
     * Iterrateur pour parcourir toutes les etapes
     * @return
     */
    @Override
    public Iterator<Etape> iterator(){
        return gest_Succ.iterator();
    }

    public int nbSuccesseur(){
       return gest_Succ.nbEtapes();
    }

    /**
     * Fonction qui affiche le numero /nom de l'etape
     * @return
     */
    public  String toString(){
        return "numero :"+getNum()+getNom();
    }

    /**
     * Fonction qui genere le code c
     * @return
     */
    public abstract String toC();

    /**
     * @return gest_Succ
     */
    public GestionnaireSuccesseurs getGestionnaireSuccesseurs() {
        return gest_Succ;

    }

    /**
     *
     * @return Null
     */
    public String getDefineSema(){
        return  null;
    }
/**
 * Getter de nombre de de jetons
 */
    public abstract int getnbJetons();
}
