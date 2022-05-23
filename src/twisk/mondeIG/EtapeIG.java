package twisk.mondeIG;

import twisk.outils.TailleComposants;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public abstract class EtapeIG implements Iterable<PointDeControleIG>{
    protected String nom;
    protected String identiant;
    protected int posX;
    protected int posY;
    protected int largeur;
    protected int hauteur;

    protected PointDeControleIG[] ptcont;
    protected boolean selectionner;
    protected boolean entree;
    protected boolean Sortie;
    protected int delai;
    protected int ecartTemps;
    protected int nbJeton;

    /**
     * Constructeur de EtapeIG
     * @param nom
     * @param idf
     * @param larg
     * @param haut
     */
    public EtapeIG(String nom,String idf,int larg,int haut){
        this.nom=nom;
        this.identiant=idf;
        this.largeur=larg;
        this.hauteur=haut;
        this.ecartTemps=3;
        this.delai=1;
        this.nbJeton=2;
        Random r=new Random();
        this.posX=r.nextInt(300);
        this.posY=r.nextInt(300);
        TailleComposants tc = new TailleComposants().getInstance();
        this.largeur=tc.getLargeur();
        this.hauteur=tc.getHauteur();
        ptcont=new PointDeControleIG[4];
        if(this.estUneActivite()) {
            ptcont[0] = new PointDeControleIG(this, posX, posY + hauteur / 2, "0"); //gauche
            ptcont[1] = new PointDeControleIG(this, posX + largeur / 2, posY, "1");//haut
            ptcont[2] = new PointDeControleIG(this, posX + largeur, posY + hauteur / 2, "2");//droite
            ptcont[3] = new PointDeControleIG(this, posX + largeur / 2, posY + hauteur, "3");
        }else {
            ptcont = new PointDeControleIG[2];
            ptcont[0] = new PointDeControleIG(this, posX, posY + hauteur / 2, "0"); //gauche
            ptcont[1] = new PointDeControleIG(this, posX + largeur, posY + hauteur / 2, "2");//droite
        }
    }

    /**
     * Les point de controle pour le deplacement de l'activité
     */
    public void pointcontrole(){
        if(this.estUneActivite()) {
            ptcont = new PointDeControleIG[4];
            ptcont[0] = new PointDeControleIG(this, posX, posY + hauteur / 2, "0"); //gauche
            ptcont[1] = new PointDeControleIG(this, posX + largeur / 2, posY, "1");//haut
            ptcont[2] = new PointDeControleIG(this, posX + largeur, posY + hauteur / 2, "2");//droite
            ptcont[3] = new PointDeControleIG(this, posX + largeur / 2, posY + hauteur, "3");
        }else{
            ptcont = new PointDeControleIG[2];
            ptcont[0] = new PointDeControleIG(this, posX, posY + hauteur / 2, "0"); //gauche
            ptcont[1] = new PointDeControleIG(this, posX + largeur, posY + hauteur / 2, "2");//droite
        }
    }
    /**
     * Fonction qui valide si une etape est une activite
     * @return FALSE
     */
    public boolean estUneActivite(){
        return false;
    }
    /*
     * Fonction qui valide si une etape est un Guichet
     * @return FALSE

     */
     public boolean estUnGuichet(){return false;}
    /**
     * Getter de temps
     * @return
     */
    public int getTemps() {
        return delai;
    }

    /**
     * Getter de l'ecart temps
     * @return
     */
    public int getEcartTemps(){
        return ecartTemps;
    }
    public int getNbjetons() {return nbJeton;}

    /**
     * Getter de nom
     * @return
     */
    public String getNom(){
        return nom;
    }

    /**
     * Setter de nom
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }


    /**
     * Getter de la position x
     * @return
     */
   public int getPosX() {
       return posX;
   }
    public void setPosX(int posX) {
        this.posX = posX;
    }

    public String getIdentiant() {
        return identiant;
    }

    /**
 * Getter de la position y
 */
   public int getPosY() {
       return posY;
   }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    /**
     * Getter de la fonction selectionner
     * @return
     */
    public boolean getselectionner(){
        return selectionner;
    }
    /**
     * Setter de selectionner
     */
    public void setSelectionner(boolean selectionner) {
        this.selectionner = selectionner;
    }

    /**
     * Iterateur qui parcour tous les points de controles
     * @return
     */
    public Iterator<PointDeControleIG> iterator() {
        return Arrays.asList(ptcont).iterator();
    }

    public boolean isSelectionner() {
        return selectionner;
    }

    /**
     * enttree
     * @return
     */
    public boolean isEntree() {
        return entree;
    }

    /**
     * setter
     * @param entree
     */
    public void setEntree(boolean entree) {
        this.entree = entree;
    }

    /**
     * fonction sortie
     * @return
     */
    public boolean isSortie() {
        return Sortie;
    }

    /**
     * Setter delai
     * @param delai
     */
    public void setDelai(int delai) {
        this.delai = delai;
    }

    public void setEcartTemps(int ecartTemps) {
        this.ecartTemps = ecartTemps;
    }

    public void setSortie(boolean sortie) {
        Sortie = sortie;
    }
}
