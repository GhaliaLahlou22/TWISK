package twisk.monde;

public class Activite extends Etape {
    /*
    Les variables
     */
    private int temps;
    private int ecartTemps;
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
    @Override
    public String toString() {
        return "Nom: "+nom+ "Le temps : "+temps+ "L'écart temps :"+ecartTemps;
    }

}
