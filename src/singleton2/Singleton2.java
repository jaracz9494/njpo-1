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

class GraczWBlackjacka {
    
    public void Blackjack() {
        int wybor=1;
        while (wybor==1) {
            klawisz klawisz = new klawisz();
            Random rand = new Random();
            int wynik=0, krupier=0, x=0;

            int reka[] = new int[20];
            int reka_k[] = new int [20];
            int pozrek=0;

            int talia[] = new int[12];
            for (int i=2; i<12; i++) {
                talia[i] = 4;
            }
            talia[10]=16;


            x=rand.nextInt(10)+2;
            talia[x]-=1;
            reka[0]= x;
            x=rand.nextInt(10)+2;
            talia[x]-=1;
            reka[1]= x;
            wynik = reka[0]+reka[1];

            x=rand.nextInt(10)+2;
            talia [x]-=1;
            reka_k[0]=x;
            x=rand.nextInt(10)+2;
            talia [x]-=1;
            reka_k[1]=x;
            krupier = reka_k[0] + reka_k[1];
            x=0;
            

            while (wynik<21) {
                pozrek=0;           

                System.out.println();  

                System.out.println("KASA KASYNA: "+ Singleton.inst().wartosc());
                System.out.println("-----BLACKJACK-----BLACKJACK-----BLACKJACK-----");
                System.out.println("(karty numerowane sa od 2-11 i maja takie same wartosci)");
                System.out.println("odkryta karta krupiera: "+ reka_k[0]);
                System.out.print("karty:");
                for (pozrek=0; reka[pozrek]!=0; pozrek++){
                    System.out.print(" " + reka[pozrek]);
                }
                System.out.println();
                System.out.println("łączna wartość: "+ wynik);
                System.out.println("1 - dobierz karte");
                System.out.println("2 - sprawdzam!");
                x=0;
                while (x==0) {
                    x=klawisz.klawisz();
                    switch (x) {
                        case 1: 
                            int z=rand.nextInt(10)+2;
                            while (talia[z]==0) {
                                z=rand.nextInt(10)+2;
                            }

                            talia[z]-=1;
                            reka[pozrek] = z;
                            wynik=wynik + reka[pozrek];
                            if (wynik>21) x=2;
                        break;

                        case 2: break;

                        default: System.out.println("Błędny wybór");
                        x=0;
                        break;
                    }
                }
                if (x==2) break;
            }       
            if (wynik>21) {
                System.out.println("--------PRZEGRAŁEŚ--------");
                Singleton.inst().zw_wartosc();
                System.out.print("karty:");
                for (pozrek=0; reka[pozrek]!=0; pozrek++){
                    System.out.print(" " + reka[pozrek]);
                }
                System.out.println();
                System.out.println("łączna wartość: "+ wynik);
                System.out.println("przekroczyłeś wartość 21!");
            }       
            if (wynik<=21 && x==2) {               
                
                for (int i=2; krupier<=wynik; i++) {
                    int z=rand.nextInt(10)+2;
                    while (talia[z]==0) {
                        z=rand.nextInt(10)+2;
                    }

                    talia[z]-=1;
                    reka_k[i] = z;
                    krupier = krupier + reka_k[i];
                    
                    
                    
                }
                
                System.out.print("karty krupiera:");
                for (pozrek=0; reka_k[pozrek]!=0; pozrek++){
                    System.out.print(" " + reka_k[pozrek]);
                }
                System.out.println();

                if (krupier>21) {
                    pozrek=krupier;
                    krupier = 0;              
                }

                if (wynik>krupier) {
                    System.out.println("-------WYGRAŁEŚ------");
                    Singleton.inst().zm_wartosc();

                    if (krupier == 0) {
                        System.out.println("krupier przekroczył 21!");
                        System.out.println("krupier miał: "+pozrek);
                    } else{
                        System.out.println("krupier miał: "+krupier);
                    }
                }
                if (wynik==krupier) {
                    System.out.println("-------REMIS------");
                    System.out.println("Wasz wynik: " + wynik);
                }
                if (wynik<krupier) {
                    System.out.println("--------PRZEGRAŁEŚ--------");
                    Singleton.inst().zw_wartosc();
                    System.out.println("krupier miał wynik: " + krupier);
                }
            }
        if (x==2) {
            System.out.println("1 - JESZCZE RAZ!");
            System.out.println("2 - Wyjście");
            wybor = klawisz.klawisz();
            while (wybor==0) {
                switch (wybor) {
                    case 1: break;

                    case 2:
                        wybor=2;
                        break;

                    default: System.out.println("Błędny wybór");
                    break;
                }
                if (wybor==2) {            
                } else {
                wybor = 0;
                }
            }
        }
        }
    }
}


class GraczWJednorekiegoBandyte {
        
    public void J_Bandyta() {
        klawisz klawisz = new klawisz();
        Random rand = new Random();
        boolean wygrana=false;
        int wybor=1;
        int linia1[] = new int[3], linia2[] = new int[3], linia3[] = new int[3], x[]=new int[3];
        
        while (wybor==1) {
            wygrana=false;
        
            for (int z=1; z<4; z++) {

                for (int i=0; i<3; i++) {
                    x[i] = rand.nextInt(8)+1;
                }

                while (x[0]==x[1] || x[0]==x[2] || x[1]==x[2]) {
                    if (x[0]==x[1] || x[0]==x[2]){
                        x[0]+=1;
                        if (x[0]>9) {
                            x[0]=1;
                        };
                    }
                    if (x[1]==x[2]){
                        x[1]+=1;
                        if (x[1]>9) {
                            x[1]=1;
                        };
                    }
                }

                if (z==1) for (int i=0; i<3; i++) linia1[i]=x[i];
                if (z==2) for (int i=0; i<3; i++) linia2[i]=x[i];
                if (z==3) for (int i=0; i<3; i++) linia3[i]=x[i];  
            }

            System.out.println("KASA KASYNA: "+ Singleton.inst().wartosc());
            System.out.println("-----JEDNORĘKI BANDYTA-----");
            System.out.println("(Wygrywasz jeśli w linii środkowej lub po skosie są te same cyfry.");
            System.out.println("Stawka wygranej to 500!)");
            System.out.println("╔════════╗");
            for (int i=0; i<3; i++) {
                System.out.println("║----"+ linia1[i]+" "+linia2[i]+" "+linia3[i]+ "----|");  
            }
            System.out.println("╚════════╝");
            Singleton.inst().zw_wartosc();

            if (linia1[1]==linia2[1] && linia2[1]==linia3[1]){
                System.out.println("$$$ !WYGRANA! $$$ - w linii!");
                wygrana = true;
                Singleton.inst().zm_wartosc2();         
            }
            if ((linia1[0]==linia2[1] && linia2[1]==linia3[1]) || linia1[2]==linia2[1] && linia2[1]==linia3[0]) {
                System.out.println("$$$ !WYGRANA! $$$ - po skosie!");
                wygrana = true;
                Singleton.inst().zm_wartosc2();
            }

            if (wygrana == false) {
                System.out.println("PRZEGRAŁEŚ");
                Singleton.inst().zw_wartosc();
            }

            System.out.println("1 - JESZCZE RAZ!");
            System.out.println("2 - Wyjście");
            wybor = klawisz.klawisz();
            while (wybor==0) {
                switch (wybor) {
                    case 1: break;

                    case 2:
                        wybor=2;
                        break;

                    default: System.out.println("Błędny wybór");
                    break;
                }
                if (wybor==2) {            
                } else {
                wybor = 0;
                }
            }
        }
        
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
    
    public void zw_wartosc () {
        fundusze += 100;
    }
    
    public void zm_wartosc () {
        fundusze -= 100;
    }
    
    public void zm_wartosc2 () {
        fundusze -= 500;
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
        
        GraczWBlackjacka black = new GraczWBlackjacka();
        GraczWJednorekiegoBandyte bandyta = new GraczWJednorekiegoBandyte();
        klawisz klawisz = new klawisz();
        
        int wybor = 0;

        
        System.out.println("Stawka początkowa w każdej grze to 100.");
        while (wybor==0) { 
        System.out.println("KASA KASYNA: "+ Singleton.inst().wartosc());      
        System.out.println("WYBIERZ GRE");
        System.out.println("1 - Blackjack");
        System.out.println("2 - Jednoręki Bandyta");
        System.out.println("3 - Wyjście");
            wybor = klawisz.klawisz();
            switch (wybor) {
                case 1: black.Blackjack();                    
                break;
                    
                case 2: bandyta.J_Bandyta();               
                break;
                    
                case 3: break;
                    
                default: System.out.println("Błędny wybór");
                break;
            } 
            if (wybor==3) {            
            } else {
            wybor = 0;
            }
        }
        
        
        
    }
    
}
