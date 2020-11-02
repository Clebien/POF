package td1.generalisation2;

public class Entier implements Sommable<Entier> {

    private Integer valeur;

    public Entier(int valeur) {
        this.valeur = valeur;
    }
    public  Integer valeur(){
        return valeur;
    }

    @Override
    public Entier sommer(final Entier other) {
        return new Entier( this.valeur + other.valeur());
    }

}

