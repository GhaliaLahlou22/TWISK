package twisk.monde;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape> {

    /*
    Les variables
     */
    protected String nom;
    protected GestionnaireSuccesseurs Gest_Succ;
     /*
     Les constucteurs
      */
    public Etape(String nom){
        this.nom=nom;
        this.Gest_Succ=new GestionnaireSuccesseurs();
    }
    /*
    Les fonctions
     */
    public void ajouterSucceseur(Etape... e){
        Gest_Succ.ajouter(e);

    }
    public abstract boolean estUneActivite();
    public abstract boolean estUnGuichet();
    @Override
    public Iterator<Etape> iterator(){
        return Gest_Succ.iterator();
    }
    public abstract String toString();

    public int nbSuccesseur(){
       return Gest_Succ.nbEtapes();
    }

}
