package td1.generalisation2;

import java.util.Set;

public interface Arbre< A extends Sommable<A>>{
    int taille();
    boolean contient(final A val);
    Set<A> valeurs();
    A somme();
}
