package twisk.mondeIG;


public class ActiviteIG extends EtapeIG {

  private boolean rest;
    /**
     * Constructeur de ActiviteIG
     * @param nom
     * @param idf
     * @param larg
     * @param haut
     */
    public ActiviteIG(String nom,String idf,int larg,int haut){
        super(nom,idf,larg,haut);
    }


    /**
     * Fonction qui retourne vrai si l'etape est une activite
     * @return
     */
    @Override
    public boolean estUneActivite(){
        return true;
    }
    public boolean estUneActiviteRestreinte(){
        return rest;
    }
}
