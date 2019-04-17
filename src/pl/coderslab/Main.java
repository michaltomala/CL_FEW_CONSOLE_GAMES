package pl.coderslab;

import pl.coderslab.games.*;
import pl.coderslab.services.ScannerService;

import java.util.HashSet;

public class Main {


    public static void main(String[] args) {

        chooseGame();
    }


    private static void chooseGame(){

        System.out.println("Hello,choose game!");
        System.out.println("1.findNumber");
        System.out.println("2.LOTTOGame");
        System.out.println("3.findNumber2");
        System.out.println("4.TicTacToe");
        System.out.println("5.Dice");

        for(;;) {

            int choice = ScannerService.getInt("Try again!");
            if(checkIfGameExist(choice)){
                switch (choice) {
                    case 1:{
                        FindNumber.findNumber();
                        break;
                    }
                    case 2:{
                        LOTTOGame.lottoGame();
                        break;
                    }
                    case 3:{
                        FindNumber2.findNumber2();
                        break;
                    }
                    case 4:{
                        TicTacToe.ticTacToe();
                        break;
                    }
                    case 5:{
                        Dice.dice();
                    }
                }
                break;
            }
        }
    }


    private static boolean checkIfGameExist(int choice){

        HashSet<Integer> gameNumbers = new HashSet<>();
        gameNumbers.add(1);
        gameNumbers.add(2);
        gameNumbers.add(3);
        gameNumbers.add(4);
        gameNumbers.add(5);

        if(!gameNumbers.contains(choice)){
            System.out.println("Game doesn't exist,try again !");
            return false;
        }

        return true;
    }

}
