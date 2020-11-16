import td1.paire.Paire1;
import td2.etudeDeCas.Annee;
import td2.etudeDeCas.Etudiant;
import td2.etudeDeCas.Matiere;
import td2.etudeDeCas.UE;
import td2.interfacesFonc.Somme;
import td2.predicats.Paire;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {


    public static void PredicatsQuestion1(){
        Paire<Integer,Double> client1 = new Paire<>(145,180.0);
        Paire<Integer,Double> client2 = new Paire<>(96,125.0);

        Predicate<Paire<Integer,Double>> tropPetit = x -> x.fst < 100;
        System.out.println(tropPetit.test(client1));

        Predicate<Paire<Integer,Double>> tropGrand = x -> x.fst > 200;
        System.out.println(tropGrand.test(client2));

        Predicate<Paire<Integer,Double>>  tailleIncorrect = tropPetit.or(tropGrand);
        System.out.println(tailleIncorrect.test(client1));

        Predicate<Paire<Integer,Double>> tailleCorrecte = tropGrand.negate().and(tropPetit.negate());
        System.out.println(tailleCorrecte.test(client1));

        Predicate<Paire<Integer,Double>> tropLourd = x -> x.snd < 150.0;
        System.out.println(tropLourd.test(client1));

        Predicate<Paire<Integer,Double>> poidsAutorise = tropLourd.negate();
        System.out.println(poidsAutorise.test(client1));

    }

    public static void interfaceFonctionnelleQuestion1()
    {

        Somme<Integer> entier = (x1, x2) -> x1+x2;
        System.out.println(entier.somme(15,5));
        Somme<Double> sommeDouble = (Double x1,Double x2) -> x1+x2;
        System.out.println(sommeDouble.somme(13.2,6.8));
        Somme<Long> sommeLong = (Long x1, Long x2) -> x1+x2;
        System.out.println(sommeLong.somme(15845L,55956L));
        Somme<String> sommeString = (String s1, String s2) -> s1 + s2;

        System.out.println(sommeString.somme("Hello ","World"));



    }

    public static void afficheSiV1(String entete, Predicate<Etudiant> p, Annee a)
    {

        StringBuilder sr = new StringBuilder(String.format("**%s\n\n", entete));
        List<Etudiant> etudiants = a.etudiants().stream().filter(p).collect(Collectors.toList());
        for (Etudiant e : etudiants){
            sr.append(etudiants.toString()+"\n");
        }
    }

//    public static void etudeDecasQuestion1V2(String entete, Predicate<Etudiant> p, Annee a)
//    {
//        StringBuilder s = new StringBuilder(String.format("**%s\n\n", entete));
//        List<Etudiant> etudiants = a.etudiants().stream().filter(p).forEach( etudiant -> s.append(etudiant.toString()).append("\n"););
//
//
//    }
    public static Predicate<Etudiant> tousLesEtudiants()
    {
        return p ->{
            return true;
        };
    }
    public static Predicate<Etudiant> aDEF()
    {
        return p -> {
            for(UE e : p.annee().ues()){
                for(Map.Entry<Matiere,Integer> ect : e.ects().entrySet()){
                    if(!p.notes().containsKey(ect.getKey())) return true;
                }
            }
            return false;
        };
    }
    public static Predicate<Etudiant> aNoteEliminatoire()
    {
        return p -> {
            for(UE e : p.annee().ues()){
                for(Map.Entry<Matiere,Integer> ect : e.ects().entrySet()){
                    if(p.notes().containsKey(ect.getKey()) && p.notes().get(ect.getKey()) < 6.0) return true;
                }
            }
            return false;
        };
    }

    public static Double moyenne(Etudiant e)
    {
        double res = 0.0;
        int coef = 0;
        if(aDEF().test(e)){
            return null;
        }else{
            for(UE ue : e.annee().ues()){
                for (Map.Entry<Matiere,Integer> ect : ue.ects().entrySet()){
                    if(e.notes().containsKey(ect.getKey())){
                        coef += ect.getValue();
                        res += e.notes().get(ect.getKey()) * ect.getValue();
                    }
                }
            }
            return res/coef;
        }
    }

    public static Predicate<Etudiant> naPasLaMoyennev1(){
        return p ->{
            if(moyenne(p) < 10){
                return true;
            }else{
                return false;
            }
        };
    }

    public static Predicate<Etudiant> naPasLaMoyennev2() {
        return p -> {
            if (aDEF().test(p) || moyenne(p) < 10) {
                return true;
            } else {
                return false;
            }
        };
    }

    public static Predicate<Etudiant> session2v1(){
        return  p -> {
            if(naPasLaMoyennev1().test(p) || aNoteEliminatoire().test(p) || aDEF().test(p)){
                return true;
            }else {
                return false;
            }
        };
    }
    //public static void afficheS1v2()

    public static void main (String[] args){
        Paire1<Integer,String> paire1 = new Paire1<>(1,"un");
        System.out.println(paire1);
        Paire1<Double,String> paire2 = paire1.changeFst(1.0);
        System.out.println(paire2);
        Paire1<Double, Paire1<Integer,String>> paire3 = paire2.changeSnd(paire1);
        System.out.println(paire3);
        System.out.println("\n");
        App.PredicatsQuestion1();
        System.out.println("\n");
       App.interfaceFonctionnelleQuestion1();

//        Matiere m1 = new Matiere("MAT1");
//        Matiere m2 = new Matiere("MAT2");
//        UE ue1 = new UE("UE1", Map.of(m1, 2, m2, 2));
//        Matiere m3 = new Matiere("MAT3");
//        UE ue2 = new UE("UE2", Map.of(m3, 1));
//        Annee a1 = new Annee(Set.of(ue1, ue2));
//        Etudiant e1 = new Etudiant("39001", "Alice", "Merveille", a1);
//        e1.noter(m1, 12.0);
//        e1.noter(m2, 14.0);
//        e1.noter(m3, 10.0);
//        System.out.println(e1);
//        Etudiant e2 = new Etudiant("39002", "Bob", "Eponge", a1);
//        e2.noter(m1, 14.0);
//        e2.noter(m3, 14.0);
//        Etudiant e3 = new Etudiant("39003", "Charles", "Chaplin", a1);
//        e3.noter(m1, 18.0);
//        e3.noter(m2, 5.0);
//        e3.noter(m3, 14.0);
//
//        App.afficheSiV1("TOUS LES ETUDIANTS",tousLesEtudiants(),a1);
//        App.afficheSiV1("ETUDIANT(S) DEFAILLANT(S)",aDEF(),a1);
//        App.afficheSiV1("ETUDIANTS AVEC NOTE ELIMINATOIRE",aNoteEliminatoire(),a1);
//        App.moyenne(e1);
//        App.moyenne(e2);
//        App.afficheSiV1("ETUDIANTS SOUS LA MOYENNE (v1)",naPasLaMoyennev1(),a1);
//        App.afficheSiV1("ETUDIANTS SOUS LA MOYENNE (v2)",naPasLaMoyennev2(),a1);
    }
}
