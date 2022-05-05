package twisk.vues;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import twisk.ecouteurs.*;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueMenu extends MenuBar implements Observateur {
    private MondeIG m;
    private EtapeIG etp;
    /**
     * Constructeur de VueMenu
     */
  public VueMenu(MondeIG monde){
   this.m=monde;
   this.etp = etp;
   //Menu de quitter
      Menu Fichier = new Menu("Fichier");
      Menu Edition = new Menu("Edition");
      Menu Monde = new Menu("Monde");
      Menu PARAMETRE = new Menu("Paramètre");

      MenuItem quitter =new MenuItem("Quitter");
      MenuItem supp =new MenuItem("Supprimer");
      MenuItem rename =new MenuItem("Renommer");
      MenuItem entree = new MenuItem("Entrée");
      MenuItem sortie = new MenuItem("Sortie");
      MenuItem effacer = new MenuItem("Effacer");
      MenuItem delai = new MenuItem("Délai");
      MenuItem ecarttemps = new MenuItem("EcartTemps");

      Fichier.getItems().addAll(quitter);
      Edition.getItems().addAll(supp,rename,effacer);
      Monde.getItems().addAll(entree,sortie);
      PARAMETRE.getItems().addAll(delai,ecarttemps);

      this.getMenus().addAll(Fichier,Edition,Monde,PARAMETRE);
      Fichier.setStyle("-fx-text-fill:#370028") ;
      Edition.setStyle("-fx-text-fill:#370028") ;
      quitter.setOnAction(new EcouteurQuitter());
      rename.setOnAction(new EcouteurRenommer(m));
      supp.setOnAction(new EcouteurSupprimer(m));
      effacer.setOnAction(new EcouteurDesselectionner(m));
      entree.setOnAction(new EcouteurEntree(m));
      sortie.setOnAction(new EcouteurSortie(m));
      delai.setOnAction(new EcouteurTemps(m));
      ecarttemps.setOnAction(new EcouteurEcartTemps(m));

      this.m.ajouterObservateur(this);
  }
    /**
     * Fonction reagir
     */
    @Override
    public void reagir() {

    }
}
