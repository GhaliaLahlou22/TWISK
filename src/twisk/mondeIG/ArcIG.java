package twisk.mondeIG;

import javafx.scene.shape.Arc;
import twisk.vues.VueArcIG;

public class ArcIG extends Arc {
    private EtapeIG et;
    private PointDeControleIG[] pointcont=new PointDeControleIG[2];
    private VueArcIG vueArcIG;
    private boolean selectionnerarc;

    /**
     * Constructeur de ArcIG
     * @param pt1
     * @param pt2
     */
    public ArcIG(PointDeControleIG pt1, PointDeControleIG pt2){
        pointcont[0]=pt1;
        pointcont[1]=pt2;

    }

    /**
     *  Getter de position
     * @param cpt
     * @return position du point de controle
     */
    public PointDeControleIG getpos(int cpt){
        return pointcont[cpt];
    }
    public boolean getselectionnerarc(){
        return selectionnerarc;
    }
    public void setSelectionnerarc(boolean selectionnerarc) {
        this.selectionnerarc = selectionnerarc;
    }
    public boolean isSelectionnerarc() {
        return selectionnerarc;
    }

}
