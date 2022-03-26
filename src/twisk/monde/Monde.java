package twisk.monde;

import java.util.Iterator;

public class Monde implements Iterable<Etape>{
    /*
    Les variables
     */
    private GestionnaireEtapes gestEtapes;
    private SasEntree sasE;
    private SasSortie sasS;
    /*
    Les constructeurs
     */
    public Monde(){
        this.gestEtapes =new GestionnaireEtapes();
        this.sasE =new SasEntree();
        this.sasS =new SasSortie();
        this.gestEtapes.ajouter(sasE,sasS);
    }
    /*
    Les fonctions
     */
    public void aCommeEntree(Etape... etapes){
      this.sasE.ajouterSucceseur(etapes);
    }
    public void aCommeSortie(Etape... etapes){
        for (Etape e:etapes)
            e.ajouterSucceseur(sasS);
    }
    public void ajouter(Etape...etapes){
        this.gestEtapes.ajouter(etapes);
    }
    public int nbEtapes(){
        return gestEtapes.nbEtapes();
    }
    public int nbGuichet(){
        int i=0;
        for(Etape etape: gestEtapes){
            if(etape.estUnGuichet()){
                i+=1;
            }
        }
        return i;
    }
    public GestionnaireEtapes getGestionnaireEtapes() {
        return gestEtapes;
    }
    public SasEntree getSasEntree(){
        return sasE;
    }
    public SasSortie getSasSortie(){
        return sasS;
    }

    public String toC(){
        StringBuilder s = new StringBuilder();
        s.append("#include <time.h>\n" +
                "#include \"def.h\" \n");
        for (Etape e : gestEtapes) {
            s.append("#define "+e.getNom()+" "+e.getNum()+"\n");
            if (e.estUnGuichet()){
                s.append(e.getDefineSema()+"\n");
            }
        }
        s.append("\nvoid simulation(int ids){\n");
        s.append(sasE.toC());
        s.append("}");
        return s.toString();
    }
    @Override
    public Iterator<Etape> iterator() {
        return this.gestEtapes.iterator();
    }
    @Override
    public String toString(){
        return " Le monde: \n"+getGestionnaireEtapes().toString();
    }

    public String getNomEtape(int i){
        return gestEtapes.getEtapes(i).getNom();
    }
}
