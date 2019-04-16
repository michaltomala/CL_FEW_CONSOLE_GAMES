package pl.coderslab.services;

import java.util.Scanner;

public class ScannerService {


    static public char getChar(String errorText){
        Scanner scan = new Scanner(System.in);

        while(true){
            String choice  = scan.next();
            if(choice.length()==1) return choice.charAt(0);
            else System.out.println(errorText);
        }

    }


    static public int getInt(String errorText){
        Scanner scan = new Scanner(System.in);

        while (!scan.hasNextInt()){
            scan.next();
            System.out.println(errorText);
        }

        return scan.nextInt();
    }

    static public double getDouble(String promptText, String errorText){
        Scanner scan = new Scanner(System.in);

        System.out.println(promptText);
        while (!scan.hasNextDouble()){
            scan.next();
            System.out.println(errorText);
        }

        return scan.nextDouble();
    }

    static public String getString(String promptText, String errorText) {
        Scanner scan = new Scanner(System.in);

        System.out.println(promptText);
        while (true){
            String text = scan.nextLine();
            if(text.length() > 0){
                return text;
            }else{
                System.out.println(errorText);
            }
        }
    }


}