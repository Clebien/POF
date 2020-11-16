package client;

import td1.paire.Paire1;

public class App {
    public static void main (String[] args){
        Paire1<Integer,String> paire1 = new Paire1<>(1,"un");
        System.out.println(paire1);
        Paire1<Double,String> paire2 = paire1.changeFst(1.0);
        System.out.println(paire2);
        Paire1<Double, Paire1<Integer,String>> paire3 = paire2.changeSnd(paire1);
        System.out.println(paire3);

    }
}
