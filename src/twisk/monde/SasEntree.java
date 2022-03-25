package twisk.monde;

public class SasEntree extends Activite {
    /*
    Les constructeurs
     */
    public SasEntree(){
        super("entree");
    }
    @Override
    public String toString() {
        return this.nom+" : "+nbSuccesseur()+" successeur(s) - "+gest_Succ.toString();
    }
    public String toC() {
        return "";
    }
}








