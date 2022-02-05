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
      this.Gest_Succ.ajouter(e);
    }
    public int nbSuccesseur(){
        return this.Gest_Succ.nbEtapes();
    }
    public boolean estUneActivite(){
        return true;
    }
    public boolean estUnGuichet(){
        return true;
    }
    @Override
    public Iterator<Etape> iterator(){
        return Gest_Succ.iterator();
    }
    public abstract String toString();
}
