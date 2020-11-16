package td1.paire;

public class Paire1<A,B>{
    private A fst;
    private B snd;


    public Paire1(final A fst, final B snd) {
        this.fst = fst;
        this.snd = snd;
    }

    public A fst() {
        return this.fst;
    }
    public B snd(){
        return this.snd;
    }

    @Override
    public String toString(){
        return String.format("(%s,%s) :: Paire[%s,%s]", this.fst, this.snd, this.fst.getClass().getSimpleName(), this.snd.getClass().getSimpleName());
    }

    public <C> Paire1<C,B> changeFst(C val){
        return new Paire1<>(val, this.snd);

    }
    public <C> Paire1<A,C> changeSnd(C val){
        return new Paire1<>(this.fst, val);

    }
}
