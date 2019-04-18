package pl.coderslab.games;

public class Test {

    public static void main(String[] args) {

        Solution solution = new Solution();
//        int N = 1;
//        int N = 2;
//        int N = 3;
//        int N = 4;
//        int N = 5;
//        int N = 6;
//        int N = 7;
        int N = 8;
//        int N = 9;
//        int N = 10;

        int[] result = solution.solution(N);

        for(int i:result){
            System.out.print(i+" ");
        }
    }
}



class Solution {

    public int[] solution(int N) {
        // write your code in Java SE 8
        if(N==1){
            return new int[1];
        }

        int even=1,odd=-1;
        int[] tab = new int[N];

        if(N%2 ==1){
            // nieparzyste
            tab[0]=0;
            for(int i=1;i<tab.length;i++){
                if(i%2==1){
                    tab[i]=even;
                    even++;
                }else if(i%2==0){
                    tab[i]=odd;
                    odd--;
                }

            }
        }else if(N%2 == 0){
                // parzyste
            for(int i=0;i<tab.length;i++){
                if(i%2==1){
                    tab[i]=even;
                    even++;
                }else if(i%2==0){
                    tab[i]=odd;
                    odd--;
                }
            }

        }

        return tab;

    }
}