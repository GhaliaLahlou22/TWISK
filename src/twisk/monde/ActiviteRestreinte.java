package twisk.monde;

public class ActiviteRestreinte extends Activite {
    /**
     *
     * @param nom
     */
    public ActiviteRestreinte(String nom){
        super(nom);
    }

    /**
     *
     * @param nom
     * @param t
     * @param e
     */
    public ActiviteRestreinte(String nom , int t , int e){
        super(nom ,t ,e);
    }

    /**
     * Fonctions qui affiche l'activité restrainte
     * @return
     */
    public String toString(){
        return super.toString();
    }

    /**
     * Fonction qui genere le code c
     * @return
     */
    @Override
    public String toC() {
        return super.toC();
    }

}
