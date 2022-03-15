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
    }
    /*
    Les fonctions
     */
    public void aCommeEntree(Etape... etapes){
      this.sasE.ajouterSucceseur(etapes);
    }
    public void aCommeSortie(Etape... etapes){
        this.sasS.ajouterSucceseur(etapes);
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
    public StringBuilder toC(){
        StringBuilder s = new StringBuilder();
        s.append("#include <stdlib.h>\n" +
                "#include <stdio.h>\n" +
                "#include <time.h>\n" +
                "#include \"def.h\" \n" );
        for (Etape e : getGestionnaireEtapes()) {
            s.append("#define ").append(e.getNom().replaceAll("\\s+", "")).append(" ").append(e.getNum()).append("\n");
        }
        s.append(
                "\nvoid simulation(int ids) " +
                        "{");
        s.append(getSasEntree().toC());
        s.append("}");
        return s;
    }
    @Override
    public Iterator<Etape> iterator() {
        return this.gestEtapes.iterator();
    }
    @Override
    public String toString(){
        return " Le monde:  "+"\n Entree"+this.sasE.toString()+"Le nb de successeur:"+ sasE.nbSuccesseur()+"\n Activite"+this.gestEtapes+"Le nb de successeur:"+ getSasEntree().nbSuccesseur()+ "\n Sortie: "+this.sasS.toString()+"Le nb de successeur:"+ sasS.nbSuccesseur();
    }
}
