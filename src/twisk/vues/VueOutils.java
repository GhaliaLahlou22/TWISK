package twisk.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import twisk.ecouteurs.EcouteurBouton;
import twisk.mondeIG.MondeIG;

import java.util.Objects;

public class VueOutils extends TilePane implements Observateur {
    private  Button AddBouton;
    private MondeIG Monde;

    /**
     * Constructeur de VueOutils
     * @param monde
     */
    public VueOutils(MondeIG monde){
        this.Monde =monde;
        Tooltip tool =new Tooltip("Ajouter une activite");
        this.AddBouton = new Button("");
        this.AddBouton.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/Plus.png")), 40, 40, true, true)));
        this.AddBouton.setId("boutton en plus");
        this.AddBouton.setTooltip(tool);
        this.AddBouton.setOnAction(new EcouteurBouton(monde));
        this.getChildren().add(AddBouton);
        this.Monde.ajouterObservateur(this);
    }

    /**
     * Fonction reagir
     */
    @Override
    public void reagir() {

    }
}
