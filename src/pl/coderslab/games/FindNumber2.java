package pl.coderslab.games;


import pl.coderslab.services.ScannerService;

public class FindNumber2 {

    public static void findNumber2(){

        System.out.println("Hello it's findNumber2");
        System.out.println("Think of number from 0 to 1000 and i will guess this at 10steps");
        int min=0,max=1000;
        findNumber(min, max);

    }

    private static void findNumber(int min, int max) {

        while(true){
            int guess = (max-min)/2 + min;
            System.out.println("I guess it is "+guess);
            int choice = getUserChoice();
            if(choice==3) {
                System.out.println("I won!");
                break;
            }
            if(choice==1){
                max=guess;
            }else if(choice==2){
                min=guess;
            }
        }
    }

    private static int getUserChoice() {
        int numberToReturn;
        while(true){

            System.out.println("\nProvide a number of your answer");
            System.out.println("1. too much");
            System.out.println("2. too little");
            System.out.println("3. Yeah,you guessed ! ");
            int choice = ScannerService.getInt("It's not a number!");

            if(choice == 1 || choice ==2 || choice ==3) {
                numberToReturn=choice;
                break;
            }
            else System.out.println("You are out of your option!");
        }
        return numberToReturn;
    }

}
