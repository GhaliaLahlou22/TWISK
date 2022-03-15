package twisk.monde;

import java.util.ArrayList;
import java.util.Iterator;

public class GestionnaireEtapes implements Iterable<Etape> {
    /*
    Les variables
     */
    private ArrayList<Etape> liste_Steps;
    /*
    Les constructeurs
     */
    public GestionnaireEtapes(){
        this.liste_Steps= new ArrayList<Etape>();
    }
    /*
    Les fonctions
     */

    public void ajouter(Etape... etapes) {
        for (Etape e : etapes) {
            this.liste_Steps.add(e);
        }
    }
    public int nbEtapes(){
        return liste_Steps.size();
    }

    @Override
    public Iterator<Etape> iterator() {
        return liste_Steps.iterator();
    }
    public ArrayList<Etape> getEtapes() {
        return liste_Steps;
    }
    @Override
    public String toString(){
        return ""+this.liste_Steps;
    }
}
