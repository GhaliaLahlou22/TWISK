package twisk.ecouteurs;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import twisk.mondeIG.MondeIG;
import twisk.vues.VueEtapeIG;

public class EcouteurSelectEtape implements EventHandler<MouseEvent> {

    private MondeIG monde;
    private VueEtapeIG vueetape;


    /**
     * Constructeur de EcouteurSelect
     *
     * @param
     */
    public EcouteurSelectEtape(VueEtapeIG vue, MondeIG m) {
        this.monde = m;
        this.vueetape = vue;
    }

    /**
     * @param mouseevent
     */
    @Override
    public void handle(MouseEvent mouseevent) {
        if (mouseevent.getClickCount() == 1) {
            this.monde.Ajouteretp(this.vueetape.getEtig());
        }
        this.monde.notifierObservateurs();
    }
}