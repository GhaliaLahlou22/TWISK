package twisk.monde;

import twisk.outils.FabriqueNumero;

public class Guichet extends Etape{
    /*
    Les variables
     */
    private int nbjetons;
    private int nbSemaphore ;

    /*
    Les constructeurs
     */
    public Guichet(String nom){
        super(nom);
        nbjetons=2;
        this.nbSemaphore = FabriqueNumero.getInstance().getNumeroSemaphore();
    }

    public Guichet(String nom,int nb){
        super(nom);
        this.nbjetons=nb;
    }
    /*
    Les fonctions
     */
    @Override
    public boolean estUneActivite() {
        return false;
    }

    public boolean estUnGuichet(){
        return true;
    }
    @Override
    public String toString(){
     return this.nom+ " "+nbjetons+ " jetons";
    }
}
