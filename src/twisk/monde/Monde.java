package twisk.monde;

import java.util.Iterator;

public class Monde implements Iterable<Etape>{
    /*
    Les variables
     */
    private GestionnaireEtapes Gest_etapes;
    private SasEntree SasE;
    private SasSortie  SasS;
    /*
    Les constructeurs
     */
    public Monde(){
        this.Gest_etapes=new GestionnaireEtapes();
        this.SasE=new SasEntree();
        this.SasS=new SasSortie();
    }
    /*
    Les fonctions
     */
    public void aCommeEntree(Etape... etapes){
      this.SasE.ajouterSucceseur(etapes);
    }
    public void aCommeSortie(Etape... etapes){
        this.SasS.ajouterSucceseur(etapes);
    }
    public void ajouter(Etape...etapes){
        this.Gest_etapes.ajouter(etapes);
    }
    public int nbEtapes(){
        return Gest_etapes.nbEtapes();
    }
    public int nbGuichet(){
        int i=0;
        for(Etape etape:Gest_etapes){
            if(etape.estUnGuichet()){
                i+=1;
            }
        }
        return i;
    }

    @Override
    public Iterator<Etape> iterator() {
        return this.Gest_etapes.iterator();
    }
    @Override
    public String toString(){
        return "Le monde: \n "+Gest_etapes.toString()+"\n Les entrées: "+this.SasE.toString()+ " \n Les sorties: "+this.SasS.toString();
    }
}
