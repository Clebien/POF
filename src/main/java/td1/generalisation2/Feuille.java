package td1.generalisation2;

import java.util.Set;

public class Feuille<A extends Sommable<A>> implements Arbre<A>{

    private final A valeur;

    public Feuille(final A valeur) {
        this.valeur = valeur;
    }

    @Override
    public int taille() {
        return 1;
    }

    @Override
    public boolean contient(final A val) {
        return val.equals(valeur);
    }

    @Override
    public Set<A> valeurs() {
        return Set.of(valeur);
    }

    @Override
    public A somme() {
        return valeur;
    }
}