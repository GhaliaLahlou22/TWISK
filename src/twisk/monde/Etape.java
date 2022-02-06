package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape> {

    /*
    Les variables
     */
    protected String nom;
    protected GestionnaireSuccesseurs Gest_Succ;
    protected int numEtape ;
     /*
     Les constucteurs
      */
    public Etape(String nom){
        this.nom=nom;
        this.Gest_Succ=new GestionnaireSuccesseurs();
        this.numEtape = FabriqueNumero.getInstance().getNumeroEtape();
    }
    /*
    Les fonctions
     */
    public void ajouterSucceseur(Etape... e){
        this.Gest_Succ.ajouter(e);

    }
    public abstract boolean estUneActivite();
    public abstract boolean estUnGuichet();
    @Override
    public Iterator<Etape> iterator(){
        return Gest_Succ.iterator();
    }

    public int nbSuccesseur(){
       return Gest_Succ.nbEtapes();
    }
    public abstract String toString();
}
