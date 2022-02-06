package twisk;

import twisk.monde.Monde;
import twisk.simulation.Simulation;

public class ClientTwisk {
    public static void main(String[] args){
        System.out.println("************BIENVENUE DANS TWISK***********");
        Monde m=new Monde();
        Simulation sim = new Simulation();
        sim.simuler(m);
        System.out.println("************* FIN *************");

    }
}
