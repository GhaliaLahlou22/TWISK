package twisk.vues;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.GuichetIG;
import twisk.mondeIG.MondeIG;

import java.sql.Array;
import java.util.ArrayList;

public class VueGuichetIG extends VueEtapeIG implements Observateur {
    /**
     * constructeur de VueActiviteIG
     * @param monde
     * @param etape
     */
    public VueGuichetIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
        //list =new ArrayList<>(10);
        HBox box =new HBox();
        for(int i = 0; i < 6; i++){
            HBox box1 =new HBox();
            box1.setPadding(new Insets(15,15,15,15));
            box1.setStyle("-fx-border-color: blue; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px; -fx-background-color: #9f9f9f");
            //box.setPrefSize((float) this.etig.getlargeur()/ 4, (float) this.etig.gethauteur()/4);
            box.getChildren().addAll(box1);
        }
        this.getChildren().addAll(box);
    }


    /**
     * La fonction reagir
     */
    @Override
    public void reagir() {

    }
}
