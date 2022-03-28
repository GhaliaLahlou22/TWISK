package twisk.monde;

public class SasEntree extends Activite {
    /**
     * Constructeur de sas entree
     */
    public SasEntree(){
        super("entree");
    }

    /**
     * Fonction qui affiche l'entree
     * @return entree et ses successeurs
     */
    @Override
    public String toString() {
        return this.nom+" : "+nbSuccesseur()+" successeur(s) - "+gest_Succ.toString();
    }

    /**
     * Fonction qui genere le code c
     * @return
     */
    @Override
    public String toC() {
        return "entrer("+this.nom+");\ndelai(4,3);\ntransfert("+this.nom+","+this.gest_Succ.getSuccesseur().getNom()+");\n"+this.gest_Succ.getSuccesseur().toC();
    }
}








