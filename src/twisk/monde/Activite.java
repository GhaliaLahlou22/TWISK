package twisk.monde;

public class Activite extends Etape {
    /*
    Les variables
     */
    protected int temps;
    protected int ecartTemps;

    /*
    Les constructeurs
     */
    public Activite(String nom){
        super(nom);
        this.temps=6;
        this.ecartTemps=3;
    }

    public Activite(String nom , int t , int e){
        super(nom);
        this.temps = t;
        this.ecartTemps= e;
    }
    public boolean estUneActivite(){
        return true;
    }

    public int getTemps() {
        return temps;
    }

    public int getEcartTemps() {
        return ecartTemps;
    }
    @Override
    public boolean estUnGuichet() {
        return false;
    }

    @Override
    public String toString(){
        return this.nom+" : "+nbSuccesseur()+" successeur(s) - "+gest_Succ.toString();
    }

    public String toC() {
        StringBuilder strC = new StringBuilder();
        strC.append("\ndelai("+temps+","+ecartTemps+");\n" +
                "transfert("+this.nom+","+this.gest_Succ.getSuccesseur().getNom()+");\n"+gest_Succ.getSuccesseur().toC());
        return strC.toString();
    }

    @Override
    public String getDefineSema() {
        return null;
    }

    @Override
    public int getnbJetons() {
        return 0;
    }
}
