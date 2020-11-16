package td1.generalisation2;

import java.util.Set;

public interface Arbre< A extends Sommable<A> & Comparable<A>>{
    int taille();
    boolean contient(final A val);
    Set<A> valeurs();
    A somme();
    A min();
    A max();
    boolean estTrie();
}
