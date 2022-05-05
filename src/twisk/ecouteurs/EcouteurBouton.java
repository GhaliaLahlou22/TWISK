package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurBouton implements EventHandler<ActionEvent> {

    private MondeIG monde;

    /**
     * Ecouteur de Bouton
     * @param monde
     */
    public EcouteurBouton(MondeIG monde){
      this.monde=monde;

    }

    /**
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        monde.ajouter("activite");
        System.out.println("Une activite est ajoutée ");
        monde.notifierObservateurs();
    }
}

