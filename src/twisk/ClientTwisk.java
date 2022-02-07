package twisk;

import twisk.monde.Activite;
import twisk.monde.Etape;
import twisk.monde.Guichet;
import twisk.monde.Monde;
import twisk.simulation.Simulation;

<<<<<<< HEAD
import javax.imageio.plugins.tiff.ExifParentTIFFTagSet;

=======
>>>>>>> main
public class ClientTwisk {
    public static void main(String[] args){
        System.out.println("************  TWISK  ***********");
        Monde m=new Monde();


        Etape file_tob=new Guichet(("File toboggan:"),3);
        Etape file_balancoire=new Guichet(("File balancoire:"),3);
        Etape toboggan=new Activite("toboggan:",1,2);
        Etape Balancoire =new Activite("Balançoire:",2,8);
        Etape file_wc=new Guichet(("File wc:"),1);
        Etape Plage=new Activite("Plage:");
        Etape Toilette =new Activite("Toilette:");

        m.aCommeEntree(file_tob,file_balancoire);
        m.aCommeSortie(Toilette,Plage,Balancoire);
        m.ajouter(file_tob,file_balancoire,file_wc,toboggan,Balancoire,Plage,Toilette);

        Simulation sim = new Simulation();
        sim.simuler(m);
        System.out.println("************* FIN *************");

    }
}
