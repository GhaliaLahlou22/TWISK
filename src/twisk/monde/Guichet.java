package twisk.monde;

public class Guichet extends Etape{
    /*
    Les variables
     */
    private int nbjetons;

    /*
    Les constructeurs
     */
    public Guichet(String nom){
        super(nom);
        nbjetons=2;
    }

    @Override
    public boolean estUneActivite() {
        return false;
    }

    public Guichet(String nom,int nb){
        super(nom);
        this.nbjetons=nb;
    }
    /*
    Les fonctions
     */
    public boolean estUnGuichet(){
        return true;
    }
    @Override
    public String toString(){
     return "Le nombre de jetons de"+nom+" est "+nbjetons+ " jetons";
    }
}
