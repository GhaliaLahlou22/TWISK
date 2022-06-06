package twisk.vues;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import twisk.ecouteurs.EcouteurDragDessin;
import twisk.ecouteurs.EcouteurDrapOver;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.simulation.Client;

import java.util.Iterator;

public class VueMondeIG extends Pane implements Observateur {
    private  MondeIG Monde;

    /**
     * Constructeur de MondeIG
     * @param monde
     */
    public VueMondeIG(MondeIG monde) {
        this.Monde = monde;
        for (EtapeIG etape : Monde) {
            if (etape.estUneActivite()) {
                VueEtapeIG vue = new VueActiviteIG(Monde, etape);
                this.getChildren().add(vue);
            }
            else {
                VueEtapeIG vue1 = new VueGuichetIG(Monde, etape);
                this.getChildren().add(vue1);
            }
            for(PointDeControleIG ptc : etape){
                VuePointDeControleIG point=new VuePointDeControleIG(Monde,ptc,etape);
                this.getChildren().add(point);
            }
        }
        this.setOnDragDropped(new EcouteurDragDessin(this.Monde,this));
        this.setOnDragOver(new EcouteurDrapOver());
        this.Monde.ajouterObservateur(this);
    }
    public void addClientActivite(HBox h,EtapeIG step ){
        for (Client clt : Monde.getClients()) {
            if (Monde.getcorrespondance().get(step).equals(clt.getEtape())) {
                VueClient v = new VueClient(clt);
                h.getChildren().add(v);
            }
        }

    }

    /**
     * Fonction reagir de MondeIG
     */
    @Override
    public void reagir() {
        this.getChildren().clear();
        Iterator<ArcIG> arcIGIterator = this.Monde.iteratorarc();
        while (arcIGIterator.hasNext()) { 
            VueArcIG arcig = new VueArcIG(arcIGIterator.next(), Monde);
            this.getChildren().add(arcig);
        }
        for (EtapeIG etape : Monde) {
            if (etape.estUneActivite()) {
                VueEtapeIG vue = new VueActiviteIG(Monde, etape);
              addClientActivite(((VueActiviteIG) vue).getHbox() , etape);
                this.getChildren().add(vue);
            }
            else {
                VueEtapeIG vue1 = new VueGuichetIG(Monde, etape);
                this.getChildren().add(vue1);
            }
            for(PointDeControleIG ptc : etape){
                VuePointDeControleIG point=new VuePointDeControleIG(Monde,ptc,etape);
                this.getChildren().add(point);
            }
        }
    }
}

