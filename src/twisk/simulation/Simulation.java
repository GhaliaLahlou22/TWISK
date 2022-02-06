package twisk.simulation;

import twisk.monde.Activite;
import twisk.monde.Etape;
import twisk.monde.Guichet;
import twisk.monde.Monde;

import java.util.Scanner;

public class Simulation {
    /*
    Les variables
     */
    private Scanner sc;
    private Monde monde;
    private Etape etapes;
    private Activite activite;
    private Guichet guichet;

    /*
    Les constructeurs
     */
    public Simulation(){
        this.sc =new Scanner(System.in);
    }
    /*
    Les fonctions
     */
    public void simuler(Monde monde){
      this.monde =monde;
      Activite activite=null;
      Guichet guichet=null ;
        Etape etapes = null;
        System.out.println("Les E/S:  "+monde.toString());
       // System.out.println("Les guichets sont : "+guichet.toString());
       // System.out.println("Les activités sont :"+activite.toString());
    }
}
