package td1.generalisation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Noeud<A> implements Arbre<A> {

    private final List<Arbre<A>> fils;

    public Noeud(final List<Arbre<A>> fils) {
        this.fils = fils;
    }

    @Override
    public int taille() {
        int rtr = 0;
        for (final Arbre<A> a : fils) {
            rtr += a.taille();
        }
        return rtr;
    }

    @Override
    public boolean contient(final A val) {
        boolean rtr = false;
        for (final Arbre<A> a : fils) {
            if (a.contient(val)) return true;
        }
        return rtr;
    }

    @Override
    public Set<A> valeurs() {
        Set<A> rtr = new HashSet<>();
        for (final Arbre<A> a : fils) {
            rtr.addAll(a.valeurs());
        }
        return rtr;
    }

}