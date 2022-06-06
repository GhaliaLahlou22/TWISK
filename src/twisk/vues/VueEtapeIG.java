package twisk.vues;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import twisk.ecouteurs.*;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Objects;
import java.util.Optional;

public abstract class VueEtapeIG extends VBox implements Observateur {
    protected MondeIG monde;
    protected EtapeIG etig;
    protected Label lb;

    /**
     * Conctructeur vueEtapeIG
     * @param monde
     * @param etape
     */
    public VueEtapeIG(MondeIG monde, EtapeIG etape) {
        this.monde = monde;
        this.etig = etape;
        if (etape.estUneActivite()) {
            this.etig = etape;
            this.setId(etig.getIdentiant());
            lb = new Label(etape.getNom() + " : " + etig.getTemps() + " ± " + etig.getEcartTemps() + " temps");
            lb.setPrefSize(160, 35);
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

        } else {
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
            //this.setPrefSize(12,90);
            this.getChildren().addAll(lb);
            if (this.etig.isSelectionner()) {
                this.setStyle("-fx-border-color: #BABABA;-fx-background-color: #83A697;-fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-background-insets:6; -fx-border-radius:7;-fx-background-radius: 3px, 3px, 2px, 1px");
            }
        }
        entrer_sortie();
    }
    public void entrer_sortie() {
        HBox logo = new HBox();

        if ( this.etig.isEntree()) {
            Label entree = new Label("");
            entree.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/entree.png")))));
            logo.getChildren().add(entree);
        }else {
            if ( this.etig.isSortie() && etig.estUneActivite()) {
                Label sortie = new Label("");
                sortie.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/sortie.png")))));
                sortie.setAlignment(Pos.TOP_RIGHT);
                logo.getChildren().add(sortie);

            }
            if ( this.etig.isSortie() && etig.estUnGuichet()) {
                TextInputDialog n = new TextInputDialog("");
                n.setContentText("Inserer le nouveau nom : ");
                n.setHeaderText("Renommer l'activitée");
                n.setTitle("Impossible");
                Optional<String> affichage = n.showAndWait();
                affichage.ifPresent(nometp -> {monde.renommerlaselection(nometp) ;});
                monde.notifierObservateurs();
            }
        }
        //logo.setAlignment(Pos.TOP_RIGHT);
        logo.setPadding(new Insets(1,1,1,1));
        this.getChildren().add(logo);
    }
    public EtapeIG getEtig(){
        return  etig;
    }
}

