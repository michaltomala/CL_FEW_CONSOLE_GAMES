package pl.coderslab.games;

import pl.coderslab.services.ScannerService;

import java.util.*;
import java.util.stream.Collectors;

public class LOTTOGame {


    public static void lottoGame(){

        System.out.println("Hello, lottoGame here");

        ArrayList<Integer> sortedNumbers = (ArrayList<Integer>) drawUniqueRandomNumbers().stream()
                .sorted()
                .collect(Collectors.toList());
        getNumbersFromUser(sortedNumbers);
    }

    private static HashSet<Integer> drawUniqueRandomNumbers(){
        HashSet<Integer> numbers = new HashSet<>();

        Random rand = new Random();

        do {
            int n = rand.nextInt(49) + 1;
            numbers.add(n);
        } while (numbers.size() != 6);

        return numbers;
    }

    private static void getNumbersFromUser(ArrayList<Integer> sortedNumbers){

        ArrayList<Integer> userNumbers = new ArrayList<>();
        System.out.println("Provide 6 numbers to simulator.After each number click enter!");
        int guessed = 0;
        do{
            int choice = ScannerService.getInt("It's not a number! Try again! ");
            if(choice>=1 && choice<=49){
                if(userNumbers.contains(choice)){
                    System.out.println("You're already picked that number!");
                }else{
                    userNumbers.add(choice);
                    if(sortedNumbers.contains(choice)) guessed++;
                }
            }else System.out.println("Pick number from 1 to 49!");
        }while(userNumbers.size()!=6);

        ArrayList<Integer> userSortedNumbers = (ArrayList<Integer>) userNumbers.stream()
                                                                                .sorted()
                                                                                .collect(Collectors.toList());
        seeResult(sortedNumbers, guessed, userSortedNumbers);
    }


    private static void seeResult(ArrayList<Integer> sortedNumbers, int guessed, ArrayList<Integer> userSortedNumbers) {
        System.out.println("Your numbers:");
        for(Integer number : userSortedNumbers){
            System.out.print(number + " ");
        }
        System.out.println("\nLotto Numbers:");
        for(Integer number : sortedNumbers){
            System.out.print(number + " ");
        }
        System.out.println("\nYou strike "+guessed+" numbers");
    }

}
