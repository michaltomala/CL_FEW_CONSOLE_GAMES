package pl.coderslab.games;

import pl.coderslab.services.ScannerService;

import java.util.Random;
import java.util.Scanner;

/**
 * Gra w zgadywanie liczb
 * Napisz prostą grę w zgadywanie liczb. Komputer ma wylosować liczbę w zakresie od 1 do 100. Następnie:
 *
 * wypisać: "Zgadnij liczbę" i pobrać liczbę z klawiatury;
 * sprawdzić, czy wprowadzony napis, to rzeczywiście liczba i w razie błędu wyświetlić komunikat: "To nie jest liczba", po czym wrócić do pkt. 1;
 * jeśli liczba podana przez użytkownika jest mniejsza niż wylosowana, wyświetlić komunikat: "Za mało!", po czym wrócić do pkt. 1;
 * jeśli liczba podana przez użytkownika jest większa niż wylosowana, wyświetlić komunikat: "Za dużo!", po czym wrócić do pkt. 1;
 * jeśli liczba podana przez użytkownika jest równa wylosowanej, wyświetlić komunikat: "Zgadłeś!", po czym zakończyć działanie programu.
 */

public class FindNumber{

    public static void findNumber(){

        System.out.println("Hello, findNumber here");
        Random rand = new Random();

        int n = rand.nextInt(100)+1;
        System.out.println("Hello, I picked number from within a range of 1-100.Guess what :) ?");

        Scanner scan = new Scanner(System.in);
        while (true ){
            if(scan.hasNextInt()){
                int choice = scan.nextInt();
                if(choice > n) System.out.println("Well,it's too much");
                else if(choice < n) System.out.println("Well,it's too little");
                else{
                    System.out.println("Yeah, you won!");
                    break;
                }

            }else{
                scan.next();
                System.out.println("It's not a number! Try again! ");
            }
        }

    }
}
