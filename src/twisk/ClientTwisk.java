package twisk;


import twisk.monde.*;
import twisk.monde.Monde;
import twisk.outils.ClassLoaderPerso;
import twisk.simulation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class  ClientTwisk {
    public static void main(String[] args){

        Monde m=new Monde();
        ClassLoaderPerso ClassLoader  = new ClassLoaderPerso(ClientTwisk.class.getClassLoader());
        try {
            Class<?> simul =  ClassLoader.loadClass("twisk.simulation.simulation");
            Object  objSimulation = simul.getDeclaredConstructor().newInstance();
            Method setNbClients = simul.getDeclaredMethod("setNbClients" , int.class);
            Method sim =simul.getDeclaredMethod("simuler" , twisk.monde.Monde.class);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
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


     /*   Monde monde = new Monde();

        Activite zoo = new Activite("balade au zoo", 3, 1);
        Guichet g = new Guichet("accès au toboggan", 2);
        Activite tob = new ActiviteRestreinte("accès au toboggan", 2, 1);

        Activite wc = new Activite("toilette ", 3, 1);
        Guichet gc = new Guichet(" guichet", 2);
        Activite tobo = new ActiviteRestreinte(" tob ", 2, 1);

        zoo.ajouterSuccesseur(guichet);
        guichet.ajouterSuccesseur(tob);

        monde.ajouter(zoo, tob, tobo , wc , gc, g);

        monde.aCommeEntree(zoo);
        monde.aCommeSortie(tob);

        Simulation simu = new Simulation();
        simu.simuler(monde);*/
    }
}
