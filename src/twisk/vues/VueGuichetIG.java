package twisk.vues;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.ArrayList;

public class VueGuichetIG extends VueEtapeIG implements Observateur {
    ArrayList<HBox> listeHbox = new ArrayList<HBox>();
    /**
     * constructeur de VueActiviteIG
     * @param monde
     * @param etape
     */
    public VueGuichetIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
        //listeHbox = new ArrayList<HBox>();
        HBox hbox = new HBox();
        hbox.setPrefHeight(37);
        hbox.setPrefWidth(90);
        this.setPadding(new Insets(10,7,7,8));
        hbox.setStyle("-fx-border-color: red; -fx-background-insets: 0 0 -1 0, 0, 1, 2;-fx-alignment:center; -fx-background-radius: 3px, 3px, 2px, 1px; -fx-background-color: #9f9f9f");
        this.relocate(etape.getPosX(),etape.getPosY());
        this.getChildren().addAll(hbox);

    }

    /**
     * La fonction reagir
     */
    @Override
    public void reagir() {

    }
}
