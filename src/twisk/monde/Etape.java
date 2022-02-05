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
