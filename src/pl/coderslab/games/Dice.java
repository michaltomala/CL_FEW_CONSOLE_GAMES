package pl.coderslab.games;

import pl.coderslab.services.ScannerService;

import java.util.Random;
import java.util.regex.Pattern;

/**
 * Kostka do gry
 * W grach planszowych i papierowych RPG używa się wielu rodzajów kostek do gry, nie tylko tych dobrze znanych, sześciennych. Jedną z popularniejszych kości jest np. kostka dziesięciościenna, a nawet stuścienna!
 *
 * Ponieważ w grach kośćmi rzuca się często, pisanie za każdym razem np. "rzuć dwiema kostkami dziesięciościennymi, a do wyniku dodaj 20", byłoby żmudne, czasochłonne i marnowałoby ogromne ilości papieru.
 *
 * W takich sytuacjach używa się kodu skracającego polecenie np.:
 *
 * "rzuć 2D10+20".
 */

public class Dice {

    public static void dice(){

        System.out.println("Hello it's Dice here!");
        for(int i=0;i<1;i++){
            int result = diceRoll(getCode());
            if(result !=-1) System.out.println(result);
            else i--;
        }

    }

    private static String getCode(){

        return ScannerService.getString("Provide scheme dice in format xDy+z , where \n" +
                "-x is number rolls of the dice \n" +
                "-y is number of walls cube\n" +
                "-z is number adding to result","You have to provide something!");
    }


    private static int diceRoll(String str){

        int modIndex,mod,rolls,diceType,result=0;
        String diceCode = str.toUpperCase().trim();
        int dIndex = diceCode.indexOf('D');
        if (dIndex == -1) {
            System.out.println("Dice type not found");
            return -1;
        }

        try {
            if (diceCode.contains("+")) {
                modIndex = diceCode.indexOf('+');
                mod = Integer.parseInt(diceCode.substring(modIndex +1).trim());
            } else if (diceCode.contains("-")) {
                modIndex = diceCode.indexOf('-');
                mod = -Integer.parseInt(diceCode.substring(modIndex +1).trim());
            } else {
                modIndex = diceCode.length();
                mod = 0;
            }

            if (dIndex == 0) {
                rolls = 1;
            } else {
                rolls = Integer.parseInt(diceCode.substring(0, dIndex).trim());
            }
            diceType = Integer.parseInt(diceCode.substring(dIndex+1, modIndex).trim());

        } catch (NumberFormatException e) {
            System.out.println("Format error: use the xDy+z format (x and z optional)");
            return -1;
        }

        return randomize(mod, rolls, diceType, result);

    }

    private static int randomize(int mod, int rolls, int diceType, int result) {
        Random r = new Random();

        for (int i = 1; i <= rolls; i++) {
            result += r.nextInt(diceType)+1;
        }

        return result + mod;
    }

}
