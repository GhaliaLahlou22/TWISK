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
        return "Etape " +getNum()+ " --> "+getNom()+" { Le temps: "+getTemps()+", L'écart temps: "+getEcartTemps()+" ,";
    }

    @Override
    public String toC() {
        StringBuilder strC = new StringBuilder();
        strC.append("delai(").append(getTemps()).append(",").append(getEcartTemps()).append(");\n").append("int nb = (int)((rand()/(float)RAND_MAX)*").append(getGestionnaireSuccesseurs().nbEtapes()).append(");\n").append("switch(nb) {\n");
        for(int i = 0; i < getGestionnaireSuccesseurs().nbEtapes(); ++i) {
            strC.append("case ").append(i).append(": {").append("transfert(").append(getNom().replaceAll("\\s+", "")).append(",").append(getGestionnaireSuccesseurs().getEtapes().get(i).getNom().replaceAll("\\s+", "")).append(");\n").append(getGestionnaireSuccesseurs().getEtapes().get(i).toC()).append("break;\n}\n");
        }
        strC.append("}");
        return strC.toString();
    }


}
