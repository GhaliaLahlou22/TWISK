package twisk.vues;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import twisk.monde.Monde;
import twisk.mondeIG.MondeIG;
import twisk.simulation.Client;

public class VueClient extends Circle implements Observateur {
    private Client client;

 public VueClient(Client clients) {
     this.client = clients;
     Circle cercle = new Circle();
     cercle.setRadius(4);

     if (client.getNumClient() == 1) {
         this.setFill(Color.RED);
     }
     if (client.getNumClient() == 2) {
         this.setFill(Color.GRAY);
     }
     if (client.getNumClient() == 3) {
         this.setFill(Color.GREEN);
     }
     if (client.getNumClient() == 4) {
         this.setFill(Color.YELLOW);
     }
     if (client.getNumClient() == 5) {
         this.setFill(Color.PURPLE);
     }
     if (client.getNumClient() == 6) {
         this.setFill(Color.BROWN);
     }
     if (client.getNumClient() == 7) {
         this.setFill(Color.BLUE);
     }
     if (client.getNumClient() == 7) {
         this.setFill(Color.BLACK);
     }
 }
    @Override
    public void reagir() {

    }
}