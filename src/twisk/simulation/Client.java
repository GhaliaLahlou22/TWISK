package twisk.simulation;

import twisk.monde.Etape;


public class Client {
    private int numeroClient ;
    private int rang ;
    private Etape etape ;

    public Client(int numero){
        this.numeroClient=numero;

    }
    public int getRang() {
        return rang;
    }

    public Etape getEtape() {
        return etape;
    }
    public  void AllerA(Etape etape,int rang){
        this.rang=rang;
        this.etape=etape;

    }
    public  int getNumClient() {
        return numeroClient;
    }
}
