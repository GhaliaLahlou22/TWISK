package twisk.monde;


import twisk.outils.FabriqueNumero;
public class Guichet extends Etape {
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
        this.nbjetons=2;
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
    public int getNbjetons(){
        return nbjetons;
    }
    public boolean estUnGuichet(){
        return true;
    }
    @Override
    public String toString(){
     return "Etape "+getNum()+" --> "+getNom()+" { "+getNbjetons()+" jetons ,semaphore "+getSemaphore()+" }";
    }

    @Override
    public String toC() {
        return "P(" + "ids" + "," + getSemaphore() + "); \n" +
                "transfert(" + this.getNom().replaceAll("\\s+", "") + "," + getSuivant().getNom().replaceAll("\\s+", "") + "); \n" +
                "delai(" + getSuivant().getTemps() + "," + getSuivant().getEcartTemps() + ");\n" +
                "V(" + "ids" + "," + getSemaphore() + ");\n" + getSuivant().toC();
    }
    public ActiviteRestreinte getSuivant() {
        return (ActiviteRestreinte) getGestionnaireSuccesseurs().getEtapes().get(0);
    }
    private int getSemaphore() {
        return nbSemaphore;
    }
}
