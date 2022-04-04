package twisk.simulation;

import twisk.monde.Etape;
import twisk.monde.Monde;

public class Client {
    int numeroClient ;
    int rang ;
    Etape etape ;

    public Client(int numero){
        this.numeroClient=numero;
    }
    public  void AllerA(Etape etape,int rang){
        this.rang=rang;
        this.etape=etape;

    }
    public int getNumClient() {
        return numeroClient;
    }
}
