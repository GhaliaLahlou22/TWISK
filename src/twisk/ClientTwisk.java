package twisk;


import twisk.monde.*;
import twisk.monde.Monde;
import twisk.simulation.*;

public class ClientTwisk {
    public static void main(String[] args) throws InterruptedException {
        Monde m=new Monde();
       /* Etape file_tob=new Guichet(("File toboggan:"),3);
        Etape file_balancoire=new Guichet(("File balancoire:"),3);
        Etape toboggan=new Activite("toboggan:",1,2);
        Etape Balancoire =new Activite("Balançoire:",2,8);
        Etape file_wc=new Guichet(("File wc:"),1);
        Etape Plage=new Activite("Plage:");
        Etape Toilette =new Activite("Toilette:");
        file_tob.ajouterSucceseur(file_balancoire);
        file_balancoire.ajouterSucceseur(file_wc);
        file_wc.ajouterSucceseur(toboggan);
        m.aCommeEntree(file_tob,file_balancoire);
        m.aCommeSortie(Toilette,Plage,Balancoire);
        m.ajouter(file_tob,file_balancoire,file_wc,toboggan,Balancoire,Plage,Toilette);
*/
        Guichet guichet = new Guichet("ticket", 2) ;
        Activite act1 = new ActiviteRestreinte("toboggan", 2, 1) ;

        Etape etape1 = new Activite("musee") ;
        Etape etape2 = new Activite("boutique") ;

        etape1.ajouterSucceseur(etape2); ;
        etape2.ajouterSucceseur(guichet) ;
        guichet.ajouterSucceseur(act1);

        m.ajouter(etape1, etape2) ;
        m.ajouter(act1) ;
        m.ajouter(guichet) ;

        m.aCommeEntree(etape1);
        m.aCommeSortie(act1) ;
        Simulation sim = new Simulation();
        sim.simuler(m);

    }
}
