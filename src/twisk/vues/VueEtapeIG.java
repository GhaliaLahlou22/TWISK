package twisk.vues;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import twisk.ecouteurs.*;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public abstract class VueEtapeIG extends VBox implements Observateur {
    protected MondeIG monde;
    protected EtapeIG etig;
    protected Label lb;

/*vue etape ajouter chaque ecouteur
    ecouteur*/
    /**
     * Conctructeur vueEtapeIG
     * @param monde
     * @param etape
     */
    public VueEtapeIG(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        if (etape.estUneActivite()) {
            this.etig = etape;
            this.setId(etig.getIdentiant());
            lb = new Label(etape.getNom() + " : " + etig.getTemps() + " ± " + etig.getEcartTemps() + " temps");
            lb.setPrefSize(180, 35);
            lb.setStyle("-fx-alignment:center ;-fx-text-fill: blue");
            this.setStyle("-fx-border-color: #696969;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-insets:6; -fx-border-radius:7;-fx-background-radius: 3px, 3px, 2px, 1px");
            this.setOnMouseClicked(new EcouteurSelectEtape(this, monde));
            this.setOnDragDetected(new EcouteurDragDepart(this));
            this.relocate(etape.getPosX(),etape.getPosY());
            this.setPrefSize(etape.getlargeur(),etape.gethauteur());
            this.getChildren().addAll(lb);
            if (this.etig.isSelectionner()) {
                this.setStyle("-fx-border-color: #BABABA;-fx-background-color: #83A697;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-insets:6; -fx-border-radius:7;-fx-background-radius: 3px, 3px, 2px, 1px");
            }
            if (this.etig.isEntree() && !this.etig.isSortie()) {
                this.setStyle("-fx-border-color: #BABABA;-fx-background-color: #6600cc;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-insets:6; -fx-border-radius:7;-fx-background-radius: 3px, 3px, 2px, 1px");

            } else {
                if (!this.etig.isEntree() && this.etig.isSortie()) {
                    this.setStyle("-fx-border-color: #BABABA;-fx-background-color: green;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-insets:6; -fx-border-radius:7;-fx-background-radius: 3px, 3px, 2px, 1px");
                }
            }
        } else {
            ///////////////////////
            this.etig = etape;
            this.setId(etig.getIdentiant());
            lb = new Label(etape.getNom() + " : "  + etig.getNbjetons() + " jetons");
            lb.setPrefSize(250, 2);
            lb.setStyle("-fx-alignment:center ;-fx-text-fill: blue");
            this.setStyle("-fx-border-color: #696969;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-insets:6; -fx-border-radius:7;-fx-background-radius: 3px, 3px, 2px, 1px");
            this.setOnMouseClicked(new EcouteurSelectEtape(this, monde));
            this.setOnDragDetected(new EcouteurDragDepart(this));
            this.relocate(etape.getPosX(),etape.getPosY());
            this.setPrefSize(etape.getlargeur(),etape.gethauteur());
            this.getChildren().addAll(lb);
            if (this.etig.isSelectionner()) {
                this.setStyle("-fx-border-color: #BABABA;-fx-background-color: #83A697;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-insets:6; -fx-border-radius:7;-fx-background-radius: 3px, 3px, 2px, 1px");
            }
        }
        ///////////////////////
    }
    public EtapeIG getEtig(){
        return  etig;
    }
}

