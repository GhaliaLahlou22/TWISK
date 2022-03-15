package twisk.monde;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GestionnaireSuccesseurs implements Iterable<Etape>{
    /*
    Les variables
     */
    private ArrayList<Etape> liste_etapes;
    /*
    Les constructeurs
     */
    public GestionnaireSuccesseurs(){
        this.liste_etapes = new ArrayList<Etape>();
    }
    public void ajouter(Etape... etapes){
        liste_etapes.addAll(Arrays.asList(etapes));

    }
    public int nbEtapes(){
      return this.liste_etapes.size();
    }

    @Override
    public Iterator<Etape> iterator() {
      return liste_etapes.iterator();
    }
    @Override
    public String toString(){
      return ""+this.liste_etapes;
    }

    public ArrayList<Etape> getEtapes() {
        return liste_etapes;
    }
}
