/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package singleton2;
import java.util.Random;
import java.util.Scanner;


class klawisz{
    public int klawisz(){
        Scanner kl = new Scanner(System.in);
        return kl.nextInt();
    }
}

class Blackjack {
    
    public void Blackjack() {
        klawisz klawisz = new klawisz();
        Random rand = new Random();
        int card = rand.nextInt(9)+2;
        int l_wartosc=0;
        int reka[] = new int[5];
        
        int talia[] = new int[11];
        for (int i=1; i<10; i++) {
            talia[i] = 4;
        }
        talia[10]=16;
        
        reka[0]= rand.nextInt(10)+2;
        reka[1]= rand.nextInt(10)+2;
        l_wartosc = reka[0]+reka[1];
        
        for (int i=0; l_wartosc<21; i++) {
            int pozrek=0;
            System.out.println();
            System.out.println("---------BLACKJACK----------");
            System.out.println("(karty numerowane sa od 1-11 i maja takie same wartosci)");
            System.out.println("karty:");
            for (pozrek=0; reka[pozrek]!=0; pozrek++){
                System.out.print(" " + reka[pozrek]);
            }
            System.out.println();
            System.out.println("łączna wartość: "+ l_wartosc);
            System.out.println("1 - dobierz karte");
            System.out.println("2 - sprawdzam!");
            switch (klawisz.klawisz()) {
                case 1: reka[pozrek + 1] = rand.nextInt(10)+2;
                break;
                
                case 2: break;
            }
        }
    }
}


class J_Bandyta {
        
    public void J_Bandyta() {
        System.out.println("dzialam (bandyta)");
    }
}


class Singleton {
    private static Singleton inst;
    private int fundusze=10000;
    
    public Singleton(){  
    }
    
    public static Singleton inst() {
        if (inst == null){
            inst = new Singleton();
        }
        return inst;        
    }
    
    
    public int wartosc () {
        return fundusze;
    }
    
    public int zw_wartosc () {
        fundusze += 100;
        return fundusze;
    }
    
    public int zm_wartosc () {
        fundusze -= 100;
        return fundusze;
    }
    
    
}
/**
 *
 * @author Dominik
 */


public class Singleton2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Blackjack black = new Blackjack();
        J_Bandyta bandyta = new J_Bandyta();
        klawisz klawisz = new klawisz();
        
        int wybor = 0;
        

        
        // System.out.println(Singleton.inst().wartosc());
      //  System.out.println(Singleton.inst().zw_wartosc());
        
        System.out.println("WYBIERZ GRE");
        System.out.println("1 - Blackjack");
        System.out.println("2 - Jednoręki Bandyta");
        
        while (wybor==0) {   
            wybor = klawisz.klawisz();
            switch (wybor) {
                case 1: black.Blackjack();
                break;
                    
                case 2: bandyta.J_Bandyta();
                break;
                    
                default: System.out.println("Błędny wybór");
                break;
            }           
            wybor = 0;
        }
        
        
        /*
        int i=0;
        while (i<card) {
            System.out.print(card + " ");
            card = rand.nextInt(9)+2;
            System.out.println(card);
            
            i++;
        }
        */
        
    }
    
}
