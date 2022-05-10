package twisk.ecouteurs;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueEtapeIG;

public class EcouteurSortie implements EventHandler<ActionEvent> {
    private MondeIG monde;

    public EcouteurSortie(MondeIG monde){
        this.monde=monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.monde.AjouterSortie();
        this.monde.notifierObservateurs();
    }
}
