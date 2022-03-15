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
    public String toString() {
        return "  " +this.nom+ ", Le temps : "+this.temps+ " ,L'écart temps : "+ecartTemps;
    }

    @Override
    public String toC() {
        StringBuilder str = new StringBuilder();
        str.append("delai(").append(getTemps()).append(",").append(getEcartTemps()).append(");\n");
        for(int i = 0; i < getGestionnaireSuccesseurs().nbEtapes(); ++i) {
           str.append("transfert(").append(getNom().replaceAll("\\s+", "")).append(",").append(getGestionnaireSuccesseurs().getEtapes().get(i).getNom().replaceAll("\\s+", "")).append(");\n").append(getGestionnaireSuccesseurs().getEtapes().get(i).toC()).append("\n}\n");
        }
        str.append("}");
        return str.toString();
    }


}
