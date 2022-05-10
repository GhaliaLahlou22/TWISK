package twisk.vues;

import javafx.scene.layout.Pane;
import twisk.ecouteurs.EcouteurDragDessin;
import twisk.ecouteurs.EcouteurDrapOver;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

import java.util.Iterator;

public class VueMondeIG extends Pane implements Observateur {
    private final MondeIG Monde;

    /**
     * Constructeur de MondeIG
     * @param monde
     */
    public VueMondeIG(MondeIG monde) {
        this.Monde = monde;
        reagir();
        this.Monde.ajouterObservateur(this);
    }

    /**
     * Fonction reagir de MondeIG
     */
    @Override
    public void reagir() {
        this.getChildren().clear();
     //   for (int cpt = 0; cpt < Monde.getArcig().size(); cpt++) {
        Iterator<ArcIG> arcIGIterator = this.Monde.iteratorarc();
        while (arcIGIterator.hasNext()) { 
            VueArcIG arcig = new VueArcIG(arcIGIterator.next(), Monde);
            this.getChildren().add(arcig);
        }
        for (EtapeIG etape : Monde) {
            VueActiviteIG vue = new VueActiviteIG(Monde, etape);
            VueGuichetIG vueg =new VueGuichetIG(Monde,etape);
          //  setOnAction(new EcouteurDeselection(monde));
            this.getChildren().addAll(vue,vueg);
            for(PointDeControleIG ptc : etape){
                VuePointDeControleIG point=new VuePointDeControleIG(Monde,ptc,etape);
                this.getChildren().add(point);
            }
        }

       /* for (EtapeIG etape : Monde) {
            VueMenu menu = new VueMenu(Monde);
            this.getChildren().add(menu);
        }*/
    }
}

