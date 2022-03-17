package twisk.simulation;
import twisk.monde.Monde;
import twisk.outils.KitC;


public class Simulation {


    /*
   Les constructeurs
    */

    public Simulation(){

    }
    /*
    Les fonctions
     */
    public void simuler(Monde monde){
        monde.toC();
        KitC kit = new KitC();
        kit.creerEnvironnement();
        kit.creerFichier(monde.toC());
        kit.compiler();
        kit.construireLaLibrairie();
        System.out.println(" "+monde.toString());
    }
}
