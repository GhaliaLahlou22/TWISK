package twisk;


import twisk.monde.*;
import twisk.monde.Monde;
import twisk.simulation.*;

public class  ClientTwisk {
    public static void main(String[] args) throws InterruptedException {
        Monde m=new Monde();

        Guichet guichet = new Guichet("ticket", 2) ;
        Activite act1 = new ActiviteRestreinte("toboggan", 2, 1) ;

        Etape etape1 = new Activite("musee") ;
        Etape etape2 = new Activite("boutique") ;

        etape1.ajouterSuccesseur(etape2); ;
        etape2.ajouterSuccesseur(guichet) ;
        guichet.ajouterSuccesseur(act1);

        m.ajouter(etape1, etape2) ;
        m.ajouter(act1) ;
        m.ajouter(guichet) ;

        m.aCommeEntree(etape1);
        m.aCommeSortie(act1) ;
        Simulation sim = new Simulation();
        sim.simuler(m);
        System.out.println("\n************* FIN *************");
    }
}
