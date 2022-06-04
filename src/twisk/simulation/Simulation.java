package twisk.simulation;
import twisk.monde.Etape;
import twisk.monde.Monde;
import twisk.outils.KitC;


public class Simulation {
    /**
     * Variables
     */
    int[] tab_Clients;
    int[] cher_Clients;
    int[] tabJetonsGuichet ;
    int nbEtapes ;
    int nbGuichets ;
    int nbClients = 6;
    boolean ended = false;
    int etape, numEtapes;
     KitC kit ;
     GestionnaireClients gestClients ;

    /**
     * Constructeurs de Simulation
     */
    public Simulation(){

    }

    /**
     * fonction qui fais la simulation de monde
     * @param monde
     * @throws InterruptedException
     */
    public void simuler(Monde monde) {
        monde.toC();
        kit = new KitC();
        kit.creerEnvironnement();
        kit.creerFichier(monde.toC());
        kit.compiler();
        kit.construireLaLibrairie();
        System.out.println(" "+monde.toString());
        System.load("/tmp/twisk/libTwisk"+kit.getNumlib()+".so") ;
        tabJetonsGuichet = this.Nbjetons(monde);
        nbEtapes = monde.nbEtapes();
        nbGuichets = monde.nbGuichet();
        gestClients = new GestionnaireClients(nbClients);

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
                for (int client = 0; client <= nbClientsEtapes; client++) {
                    System.out.printf(" " + cher_Clients[etape + client] + " ");
                    gestClients.allerA(cher_Clients[getNbClients()] , monde.getEtape(numEtapes), client);
                }
                etape += nbClients;
                if (numEtapes == 1) {
                    ended = nbClientsEtapes == nbClients;
                }
                monde.reset();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

    /**
     * Setter de nombre de cliens
     * @param nbClients
     */
    public void setNbClients(int nbClients) {
        this.nbClients= nbClients ;
    }

    /**
     * Getter de nombre de clients
     * @return
     */
    public int getNbClients() {
        return nbClients;
    }

    /**
     * fonction qui lance la simulation
     * @param nbEtapes
     * @param nbServices
     * @param nbClients
     * @param tabJetonsServices
     * @return
     */
    public native int [] start_simulation(int nbEtapes, int nbServices, int nbClients, int []tabJetonsServices);

    /**
     * fonction qui indique l'amplacement des clients
     * @param nbEtapes
     * @param nbClients
     * @return
     */
    public native int [] ou_sont_les_clients(int nbEtapes, int nbClients);

    /**
     * fonction qui nettoye le monde
     */
    public native void nettoyage();

    /**
     * Getter des jetons de guichet
     * @return
     */
    public int[] getTabJetonsGuichet() {
        return tabJetonsGuichet;
    }

    /**
     * Getter de nombre de guichet
     * @return
     */
    public  int getNbGuichets(){
        return nbGuichets;
    }

    /**
     * Setter de nombre de guichet
     * @param nbg
     */
    public  void setNbGuichets(int nbg){
         this.nbGuichets = nbg;
    }

    /**
     * Getter de la table des clients
     * @return
     */
    public int[] getTab_Clients() {
        return tab_Clients;
    }

    /**
     * Getter de l'amplacement des clients
     * @return
     */
    public int[] getCher_Clients() {
        return cher_Clients;
    }

    /**
     * Setter des jetons
     * @param tabJetonsGuichet
     */


    public void setTabJetonsGuichet(int[] tabJetonsGuichet) {
        this.tabJetonsGuichet = tabJetonsGuichet;
    }
}
