package twisk.vues;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.ecouteurs.EcouteurDragDessin;
import twisk.ecouteurs.EcouteurDrapOver;
import twisk.mondeIG.*;
import twisk.simulation.Client;
import java.util.Iterator;

public class VueMondeIG extends Pane implements Observateur {
    private  MondeIG Monde;
    private  EtapeIG etg;
    private Client client;


    /**
     * Constructeur de MondeIG
     * @param monde
     */
    public VueMondeIG(MondeIG monde) {
        this.Monde = monde;
        this.etg=etg;
        this.client=client;
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
    public void addClientActivite(){
         if(Monde.getSimul() != null) {
       /* for (Client clt : Monde.getClient()) {
            if (Monde.getcorrespondance().get(step).equals(clt.getEtape())) {
                VueClient v = new VueClient(clt);
                h.getChildren().add(v);
            }
        }
        }*/
             double x = 0, y;
             //MondeIG monde = (MondeIG) Monde;
             Iterator<Client> itClients = Monde.iteratorClients();
             if (itClients != null) {
                 while (itClients.hasNext()) {
                     Client client = itClients.next();
                     for (EtapeIG etape : Monde) {
                         //if (!client.getEtape() && !client.getEtape().estUnSasDeSortie()) {
                         if (!client.getEtape().estUneActivite()) {
                             Circle circleClient = new Circle(5.0);
                             circleClient.setFill(Color.RED);
                             getChildren().add(circleClient);
                             //affichage dans le cas où c'est une activité (ou une activité restreinte)
                             if (etape.estUneActivite() || etape.estUneActiviteRestreinte()) {
                                 x = Math.random() * ((etape.getPosX() + etape.getlargeur() - 20) - (etape.getPosX() + 20)) + (etape.getPosX() + 20);
                                 y = Math.random() * ((etape.getPosY() + etape.gethauteur() - 15) - (etape.getPosY() + 50)) + (etape.getPosY() + 50);
                             } else {
                                 y = (etape.getPosY() + etape.gethauteur() - 19);
                                 if (client.getRang() > 10) {
                                     circleClient.setVisible(false);
                                 }
                             }
                             circleClient.setCenterX(x);
                             circleClient.setCenterY(y);
                         }
                     }
                 }
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
             // addClientActivite(((VueActiviteIG) vue).getHbox() , etape);
                addClientActivite();
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

