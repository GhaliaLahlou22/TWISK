package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurDesselectionner implements  EventHandler<ActionEvent> {
    private MondeIG monde;


    /**
     * Constructeur de EcouteurSupprimer
     */
    public EcouteurDesselectionner(MondeIG  monde){
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        monde.SuppSelect();
        monde.notifierObservateurs();
    }
}