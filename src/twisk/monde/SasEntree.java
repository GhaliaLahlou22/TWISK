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
    @Override
    public String toC() {
        return "entrer("+this.nom+");\ndelai(4,3);\ntransfert("+this.nom+","+this.gest_Succ.getSuccesseur().getNom()+");\n"+this.gest_Succ.getSuccesseur().toC();
    }
}








