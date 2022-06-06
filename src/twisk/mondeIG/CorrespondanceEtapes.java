package twisk.mondeIG;

import twisk.monde.Etape;

import java.io.Serializable;
import java.util.HashMap;

public class CorrespondanceEtapes implements Serializable {

    private final HashMap<EtapeIG,Etape> correspondance ;

    public CorrespondanceEtapes(){
        correspondance = new HashMap<>(15);
    }

    public void ajouter(EtapeIG etig , Etape et){
        correspondance.put(etig,et);
    }

    public Etape get(EtapeIG e ){
        return correspondance.get(e);
    }

    public HashMap<EtapeIG, Etape> getCorrespondance() {
        return correspondance;
    }
}
