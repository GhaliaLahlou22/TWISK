package twisk.monde;

public class SasSortie extends Activite {
    /*
    Les constructeurs
     */
    public SasSortie(){
        super("sortie");
    }
    @Override
    public String toString() {
        return this.nom+" : "+nbSuccesseur()+" successeur(s)  "+gest_Succ.toString();
    }
    @Override
    public String toC() {
        return "";
    }
}
