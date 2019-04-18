package pl.coderslab.games;


import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TicTacToe {

    private static char[][] fields = new char [3][3];
    private static int tour=1;

    public static void ticTacToe(){

        System.out.println("Hello, ticTacToe here");
        startGame();
        Scanner scanner = new Scanner(System.in);
        while(!isWin()){
            showGame();
            try{
                getPoint(scanner);
            }catch (NoSuchElementException e){
                break;
            }
        }

        if(isWin()){
//           todo - code here
        }
    }

    private static void startGame(){
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                fields[i][j] = '.';
            }
        }
    }

    private static void showGame(){
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                System.out.print(fields[i][j]);
            }
            System.out.println(" ");
        }
    }

    private static boolean isWin(){

//       todo -  doesn't work
//       poziomo
        int xWin = 0,yWin = 0;
        for(int i=0;i<=2;i++){
            if(fields[0][i] == 'X') xWin++;
            if(fields[0][i] == 'Y') yWin++;
        }
        if(xWin==3 || yWin==3) return true;

//       pionowo
        xWin=0;yWin=0;
        for(int i=0;i<=2;i++){
            if(fields[i][0] == 'X') xWin++;
            if(fields[i][0] == 'Y') yWin++;
        }
        if(xWin==3 || yWin==3) return true;

//       po skosie
        xWin=0;yWin=0;
        for(int i=0;i<=2;i++){
            if(fields[i][i] == 'X') xWin++;
            if(fields[i][i] == 'Y') yWin++;
        }
        if(xWin==3 || yWin==3) return true;

//       po drugim skosie
        xWin=0;yWin=0;
        int j=2;
        for(int i=0;i<=2;i++){
            if(fields[j][i] == 'X') xWin++;
            if(fields[j][i] == 'Y') yWin++;
            j--;
        }

        return (xWin == 3 || yWin == 3);

    }

    private static void getPoint(Scanner scanner){

        if (scanner.hasNextLine()) {
            String choice = scanner.next();
            if(isCorrect(choice)) {
                if(isEmpty(choice)){
                    int a=Character.getNumericValue(choice.charAt(0));
                    int b=Character.getNumericValue(choice.charAt(2));
                    if(tour%2==1){
                        fields[a][b]='O';
                        tour++;
                    }else if(tour%2==0){
                        fields[a][b]='X';
                        tour++;
                    }
                }
            }

        }

    }

    private static boolean isEmpty(String choice){

        int a=Character.getNumericValue(choice.charAt(0));
        int b=Character.getNumericValue(choice.charAt(2));
        return fields[a][b] == '.';
    }

    private static boolean isCorrect(String choice){

        Pattern pattern = Pattern.compile("^[0-2],[0-2]");
        Matcher matcher = pattern.matcher(choice);
        return matcher.matches();
    }



}



