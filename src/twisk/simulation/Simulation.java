package twisk.simulation;
import twisk.monde.Monde;


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
        System.out.println(" "+monde.toString());
    }
}
