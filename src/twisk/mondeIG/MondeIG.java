package twisk.mondeIG;

import twisk.exceptions.ExceptionExistArc;
import twisk.exceptions.ExceptionsArcMemeEtape;
import twisk.outils.FabriqueIdentifiant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MondeIG extends SujetObserve implements Iterable<EtapeIG>{

    private HashMap<String, EtapeIG>etapes=new HashMap<>(10) ;
    private ArrayList<EtapeIG> selectedEtape = new ArrayList<>(10);
    private ArrayList<ArcIG> selectedArc = new ArrayList<>(10);
    private FabriqueIdentifiant fabid=FabriqueIdentifiant.getInstance();
    private ArrayList<ArcIG>arclist=new ArrayList<>(10);
    private ArrayList<EtapeIG>listentree=new ArrayList<>(10);
    private ArrayList<EtapeIG>listsortie=new ArrayList<>(10);
    private PointDeControleIG pointselect;

    public int getNbClients() {
        return nbClients;
    }

    private int nbClients = 5;

/**
 * TOOOOOO  DOOOO
 * Les condition des exceptions dons la fonction de ajouter(p1,p2)
 */
    /**
     * Constructeur de MondeIG
     */
    public MondeIG(){

        String identif =fabid.getIdentifiantEtape();
        EtapeIG activ =new ActiviteIG("activite"+identif,identif,60,20);
        etapes.put(identif,activ);
    }

    /**
     * Fonction ajouter qui ajoute les activite au monde
     * @param type
     */
    public  void ajouter(String type){
        if( type.equals("activite")) {
            String identifiant =fabid.getIdentifiantEtape();
            EtapeIG act =new ActiviteIG("activite"+identifiant,identifiant,60,60);
            etapes.put(identifiant,act);
           // this.notifierObservateurs();
        }
            if(type.equals("guichet")){
                String identifiant =fabid.getIdentifiantEtape();
                EtapeIG gui =new GuichetIG("guichet"+identifiant,identifiant,50,100);
                etapes.put(identifiant,gui);
               // this.notifierObservateurs();
        }
        this.notifierObservateurs();
    }

    /**
     * Fonction nbEtape qui rend le numero de l'etape
     * @return
     */
    public int nbEtape(){
        return this.etapes.size();
    }

    /**
     * Fonction ajouter qui permet d’ajouter un arc, créé à partir des deux points de contrôle passés en paramètre
     * @param p1
     * @param p2
     * @throws ExceptionsArcMemeEtape
     */
    public void ajouter(PointDeControleIG p1, PointDeControleIG p2) throws ExceptionsArcMemeEtape,ExceptionExistArc {
        if(p1.getetape() == p2.getetape()) {
            throw new ExceptionsArcMemeEtape();
        }
        //for (ArcIG e : arclist) {
            if (/*p1.getetape().posX==p2.getetape().posY */p1.getetape() == p2.getetape()) {
                throw new ExceptionExistArc();
            }
        //}
        ArcIG monarc = new ArcIG(p1,p2);
        arclist.add(monarc);
    }
    /**
     * Fonction qui permer d'ajouter les arc en deux points de controles
     * @param pt
     * @throws ExceptionsArcMemeEtape ,ExceptionExistArc
     */
    public void formarc(PointDeControleIG pt) throws ExceptionsArcMemeEtape, ExceptionExistArc {
        if (pointselect == null) {
            pointselect = pt;
        } else{
            this.ajouter(pointselect, pt);
            this.notifierObservateurs();
            pointselect  = null;
    }
    }

    /**
     * Iterrateur de etape qui permet de parcourrir toutes les etapes
     * @return
     */
    @Override
    public Iterator<EtapeIG> iterator() {
        return etapes.values().iterator();
    }

    /**
     * Iterrateur de arc qui permet de parcourrir tous les arcs
     * @return
     */
    public Iterator<ArcIG> iteratorarc() {
        return arclist.iterator();
    }
    public  void renommerlaselection(String str){
      selectedEtape.get(0).setNom(str);
    }

   public void Ajouteretp(EtapeIG etp){
       if(!selectedEtape.contains(etp)){
           selectedEtape.add(etp);
           etp.setSelectionner(true);
       }else{
           etp.setSelectionner(false);
           selectedEtape.remove(etp);
       }
   }

    public void AjouterArc(ArcIG arc){
        if(!selectedArc.contains(arc)){
            selectedArc.add(arc);
            arc.setSelectionnerarc(true);
        }else{
            arc.setSelectionnerarc(false);
            selectedArc.remove(arc);
        }
    }

    public void AjouterEntree(){
        for (EtapeIG step : selectedEtape ) {
            if(listentree.contains(step)==true) {
                listentree.remove(step);
            }else{
                step.setEntree(true);
                step.setSelectionner(false);
                this.listentree.add(step);
            }
        }
    }

    /**
     * Fonction qui retourne le temps changer
     * @param delai
     */
    public void Delai(int delai) {
        this.selectedEtape.get(0).setDelai(delai);
    }
    /**
     * Fonction qui retourne l 'escart temps changé
     * @param ecartt
     */
    public void EcartTemps(int ecartt) {
        this.selectedEtape.get(0).setEcartTemps(ecartt);

    }
    /**
     * Fonction qui ajoute La sortie
     */
    public void AjouterSortie(){
        for (EtapeIG step : selectedEtape ) {
            if(listsortie.contains(step)==true) {
                listsortie.remove(step);
            }else{
                step.setSortie(true);
                step.setSelectionner(false);
                this.listsortie.add(step);
            }
        }
    }

    /**
     * Fonction qui supprime la selection
     */
   public void SuppSelect() {
       for (EtapeIG step : selectedEtape) {
           step.setSelectionner(false);
       }
       selectedEtape.clear();
   }
    /**
     * Fonction qui supprime l'activité selectionnée
     */
    public void SuppEtape() {
             for (EtapeIG et : selectedEtape ) {
                 etapes.remove(et.getIdentiant());}
       }
    /**
     * Fonction qui supprime l'arc selectionné
     */
    public void SuppArc() {
        for (ArcIG arc : selectedArc ) {
            arclist.remove(arc);
        }
    }

}
