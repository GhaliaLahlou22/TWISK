package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireEtapes implements Iterable<Etape> {
    /*
    Les variables
     */
    private ArrayList<Etape> Liste_Steps;
    /*
    Les constructeurs
     */
    public GestionnaireEtapes(){
        this.Liste_Steps= new ArrayList<Etape>();
    }
    /*
    Les fonctions
     */

    public void ajouter(Etape... etapes) {
        for (Etape e : etapes) {
            this.Liste_Steps.add(e);
        }
    }
    public int nbEtapes(){
        return Liste_Steps.size();
    }

    @Override
    public Iterator<Etape> iterator() {
        return Liste_Steps.iterator();
    }
    @Override
    public String toString(){
        return ""+this.Liste_Steps;
    }
}
