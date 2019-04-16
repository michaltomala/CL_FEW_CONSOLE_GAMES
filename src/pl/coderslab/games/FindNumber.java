package pl.coderslab.games;


import java.util.Random;
import java.util.Scanner;


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
