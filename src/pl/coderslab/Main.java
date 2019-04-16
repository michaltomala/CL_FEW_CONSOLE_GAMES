package pl.coderslab;

import pl.coderslab.games.FindNumber;
import pl.coderslab.services.ScannerService;

import java.util.HashSet;

public class Main {


    public static void main(String[] args) {

        chooseGame();
    }


    private static void chooseGame(){

        System.out.println("Hello,choose game!");
        System.out.println("1.findNumber");

        for(;;) {

            int choice = ScannerService.getInt("Try again!");
            if(checkIfGameExist(choice)){
                switch (choice) {
                    case 1:
                        FindNumber.findNumber();
                        break;
                }
                break;
            }
        }
    }


    private static boolean checkIfGameExist(int choice){

        HashSet<Integer> gameNumbers = new HashSet<>();
        gameNumbers.add(1);

        if(!gameNumbers.contains(choice)){
            System.out.println("Game doesn't exist,try again !");
            return false;
        }

        return true;
    }

}
