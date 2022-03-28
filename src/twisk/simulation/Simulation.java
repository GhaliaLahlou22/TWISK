package twisk.simulation;
import twisk.monde.Etape;
import twisk.monde.Monde;
import twisk.outils.KitC;


public class Simulation {

    int[] tab_Clients;
    int[] cher_Clients;
    int[] tabJetonsGuichet ;
    int nbEtapes ;
    int nbGuichets ;
    int nbClients = 6;
    boolean ended = false;
    int etape, numEtapes;
    /*
   Les constructeurs
    */

    public Simulation(){

    }
    /*
    Les fonctions
     */
    public void simuler(Monde monde) throws InterruptedException {
        monde.toC();
        KitC kit = new KitC();
        kit.creerEnvironnement();
        kit.creerFichier(monde.toC());
        kit.compiler();
        kit.construireLaLibrairie();
        System.out.println(" "+monde.toString());
        System.load("/tmp/twisk/libTwisk.so") ;
        int[] tabJetonsGuichet = this.Nbjetons(monde);
        int nbEtapes = monde.nbEtapes();
        int nbGuichets = monde.nbGuichet();

        tab_Clients = start_simulation(nbEtapes, nbGuichets, nbClients, tabJetonsGuichet);
        System.out.println("Les clients: ");
        for (int i = 0; i < nbClients; i++) {
            System.out.print(" "+tab_Clients[i]);
        }
        System.out.println(" \n************************************\n");
        while (!ended) {
            cher_Clients = ou_sont_les_clients(nbEtapes, nbClients);
            for (etape = 0, numEtapes = 0; numEtapes < nbEtapes; ++numEtapes, ++etape) {
                int nbClientsEtapes = cher_Clients[etape];
                System.out.print("\nétapes " + numEtapes + " ("+ monde.getNomEtape(numEtapes)+") " + cher_Clients[etape] + "  clients: ");
                for (int client = 1; client <= nbClientsEtapes; client++) {
                    System.out.printf(" " + cher_Clients[etape + client] + " ");
                }
                etape += nbClients;
                if (numEtapes == 1) {
                    ended = nbClientsEtapes == nbClients;
                }
            }
            Thread.sleep(1000);
        }
        nettoyage();
    }


    public int[] Nbjetons(Monde monde){
        int[] jetons=new int[monde.nbGuichet()];
        int cpt=0;
        for (Etape e:monde){
            if (e.estUnGuichet()){
                jetons[cpt]=e.getnbJetons();
                cpt++;
            }
        }
        return jetons;
    }
    public native int [] start_simulation(int nbEtapes, int nbServices, int nbClients, int []tabJetonsServices);
    public native int [] ou_sont_les_clients(int nbEtapes, int nbClients);
    public native void nettoyage();

    public void setNbClients(int i) {
        this.nbClients= nbClients ;
    }
}
