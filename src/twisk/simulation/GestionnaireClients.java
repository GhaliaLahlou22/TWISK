package twisk.simulation;

import twisk.monde.Etape;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class GestionnaireClients  implements Iterable<Client>{
     private ArrayList<Client> clients ;
     int nbClients ;

    public GestionnaireClients(int nbClients){
        clients = new ArrayList<>(nbClients);
    }

    public void setNbClients(int nbClients ){
        this.nbClients = nbClients;

    }
    public ArrayList<Client> getGestclients(){
        return clients;
    }
    public void setClients(int[] tabClients ){
        for(int client : tabClients){
            clients.add(new Client(client));
        }

    }
    public void allerA(int numeroClient  , Etape etape , int rang){
        for(Client client : clients){
          if(client.getNumClient() == numeroClient){
              client.AllerA(etape,rang);
          }
        }

    }

    public void nettoyer(){
        clients.clear();

    }
    public Iterator<Client> iterator(){
        return clients.iterator();
    }
}
