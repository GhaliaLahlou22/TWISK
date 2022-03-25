package twisk.monde;

import twisk.outils.FabriqueNumero;

import java.util.Iterator;

public abstract class Etape implements Iterable<Etape> {

    /*
    Les variables
     */
    protected String nom;
    protected GestionnaireSuccesseurs gest_Succ;
    protected int numEtape ;
     /*
     Les constucteurs
      */
    public Etape(String nom){
        this.nom=nom;
        this.gest_Succ=new GestionnaireSuccesseurs();
        this.numEtape = FabriqueNumero.getInstance().getNumeroEtape();
    }
    /*
    Les fonctions
     */
    public void ajouterSucceseur(Etape... e){

        this.gest_Succ.ajouter(e);


    }
    public abstract boolean estUneActivite();
    public abstract boolean estUnGuichet();
    public String getNom(){
        return nom;
    }
    public int getNum(){
        return numEtape;
    }
    @Override
    public Iterator<Etape> iterator(){
        return gest_Succ.iterator();
    }

    public int nbSuccesseur(){
       return gest_Succ.nbEtapes();
    }
    public int getnbsucc(){
        return nbSuccesseur();
    }
    public  String toString(){
        return this.nom +"successeur(s): "+getGestionnaireSuccesseurs().toString();
    }


    public abstract String toC();
    public Etape getSuivant() {
        return getGestionnaireSuccesseurs().getEtapes().get(0);
    }

    public GestionnaireSuccesseurs getGestionnaireSuccesseurs() {
        return gest_Succ;

    }
}
