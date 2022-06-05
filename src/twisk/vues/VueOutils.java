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
    private  Button AddBouton2;
    private  Button AddBouton3;
    private MondeIG Monde;

    /**
     * Constructeur de VueOutils
     * @param monde
     */
    public VueOutils(MondeIG monde){
        this.Monde =monde;
        Tooltip tool =new Tooltip("Ajouter une activite");
        Tooltip tool1 =new Tooltip("Ajouter un guichet");
        Tooltip tool2 =new Tooltip("Ajouter un bouton de simulation");
        this.AddBouton = new Button("");
        this.AddBouton2 = new Button("");
        this.AddBouton3 = new Button("");
        this.AddBouton.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/activite.png")), 40, 40, true, true)));
        this.AddBouton2.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/guichet.png")), 40, 40, true, true)));
        this.AddBouton3.setGraphic(new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/simulation.png")), 40, 40, true, true)));
        this.AddBouton.setId("boutton en plus");
        this.AddBouton2.setId("boutton en plus");
        this.AddBouton3.setId("boutton en plus");
        this.AddBouton.setTooltip(tool);
        this.AddBouton2.setTooltip(tool1);
        this.AddBouton3.setTooltip(tool1);
        this.AddBouton.setOnAction(new EcouteurBouton(monde,"activite"));
        this.AddBouton2.setOnAction(new EcouteurBouton(monde,"guichet"));
        this.AddBouton3.setOnAction(new EcouteurBouton(monde,"Simulation"));
        this.getChildren().addAll(AddBouton,AddBouton2,AddBouton3);
        this.Monde.ajouterObservateur(this);
    }

    /**
     * Fonction reagir
     */
    @Override
    public void reagir() {

    }
}
