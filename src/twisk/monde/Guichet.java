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
     return this.nom+" : "+nbSuccesseur()+" successeur(s) - "+gest_Succ.toString();
    }

    @Override
    public String toC() {
        return "P(" + "ids" + "," + getSemaphore()+ "); \n" +
                "transfert("+this.nom+","+gest_Succ.getSuccesseur().getNom()+");\n"+
                "delai(6,3);\n" +
                "V(ids," + getSemaphore()+ ");\n" + gest_Succ.getSuccesseur().toC();
    }
    public ActiviteRestreinte getSuivant() {
        return (ActiviteRestreinte) getGestionnaireSuccesseurs().getEtapes().get(0);
    }
    public String getSemaphore(){
        return "num_sem_guichet" +nbSemaphore;
    }

    @Override
    public String getDefineSema(){
        return "#define "+getSemaphore() +" "+nbSemaphore;
    }
    public int getnbJetons(){
        return nbjetons;
    }

}
