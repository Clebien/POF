package td1.generalisation;

import java.util.Set;

public interface Arbre <A>{
    int taille();
    boolean contient(final A val);
    Set<A> valeurs();
}
