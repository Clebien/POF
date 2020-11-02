package Package1.client;

import Package1.v1.Paire;

public class App {
    public static void main (String[] args){
        Paire<Integer,String> paire1 = new Paire<>(1,"un");
        System.out.println(paire1);
        Paire<Double,String> paire2 = paire1.changeFst(1.0);
        System.out.println(paire2);
        Paire<Double,Paire<Integer,String>> paire3 = paire2.changeSnd(paire1);
        System.out.println(paire3);

    }
}
