package td1.generalisation2;

public class Chaine implements Sommable<Chaine>{

    private String valeur;

    public Chaine(String valeur) {
        this.valeur = valeur;
    }

    public String valeur(){
        return valeur;
    }
    @Override
    public Chaine sommer(final Chaine other) {
        return new Chaine(String.format("%d%d", this.valeur(),other.valeur()));
    }
}
