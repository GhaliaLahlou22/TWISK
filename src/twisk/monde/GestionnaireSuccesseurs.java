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
        StringBuilder str = new StringBuilder();
        for(Etape step :getEtapes()){
            str.append(step.getNom()+" - ");
        }
        return str.toString();
    }

    public ArrayList<Etape> getEtapes() {
        return liste_etapes;
    }
}
