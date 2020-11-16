package td1.paire;

public class Paire <A,B>{
    private _fst;
    private _snd;


    public Paire(final A fst, final B snd) {
        _fst = fst;
        _snd = snd;
    }

    public fst() {
        return _fst;
    }
    public snd(){
        return _snd;
    }

    @Override
    public String toString(){
        return String.format("(%s,%s) :: Paire[%s,%s]", _fst, _snd, _fst.getClass().getSimpleName, _snd.getClass().getSimpleName());
    }

    public <C> Paire<C,B> changeFst(C val){
        return new Paire<>(val, _snd);

    }
    public <C> Paire<A,C> changeSnd(C val){
        return new Paire<>(_fst, val);

    }
}
