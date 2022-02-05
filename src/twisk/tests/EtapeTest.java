package twisk.tests;

import twisk.monde.*;

import static org.junit.Assert.assertEquals;

public class EtapeTest {

    Etape file_tob;
    Etape file_balancoire;
    Etape file_wc;
    Etape toboggan;
    Etape Balancoir;
    Etape plage;
    Etape toillete;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        file_tob = new Guichet("File tob",3);
        file_balancoire =new Guichet("File bal",2);
        file_wc=new Guichet("File wc",5);
        toboggan =new Activite("tobogan");
        Balancoir=new Activite("Balancoir");
        plage=new Activite("Plage");
        toillete=new Activite("Toillete");
    }

    @org.junit.jupiter.api.Test
    void ajouterSucceseur() {
        file_tob.ajouterSucceseur(toboggan);
        toboggan.ajouterSucceseur(plage);
        file_balancoire.ajouterSucceseur(Balancoir);
        Balancoir.ajouterSucceseur(plage,file_wc);
        file_wc.ajouterSucceseur(toillete);

        assertEquals(1,file_wc.nbSuccesseur());
        assertEquals(1,file_tob.nbSuccesseur());
        assertEquals(1,file_balancoire.nbSuccesseur());
        assertEquals(1,toboggan.nbSuccesseur());
        assertEquals(0,toillete.nbSuccesseur());
        assertEquals(0,plage.nbSuccesseur());
        assertEquals(2,Balancoir.nbSuccesseur());
    }

    @org.junit.jupiter.api.Test
    void estUneActivite() {
        boolean b = file_tob.estUneActivite();
       boolean b1 = toboggan.estUneActivite();

    }

    @org.junit.jupiter.api.Test
    void estUnGuichet() {
       boolean b = file_tob.estUnGuichet();
        boolean b1 = file_tob.estUnGuichet();
        boolean b2 = toboggan.estUnGuichet();

    }


}
