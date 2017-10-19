//Kod służący do wygenerowania wszystkich możliwych kombinacji plecaków, pochodzący z:
// https://github.com/hmkcode/Java/blob/master/java-combinations/Combination.java
// i mocno zmodyfikowany na potrzeby tego projektu

import java.util.ArrayList;

public class Combinations extends HappySpring {

    //Metoda na podstawie podanej liczby rzeczy zwraca wszystkie możliwe kombinacje plecaków w postaci ArrayLista zawierającego tablice integerów.
    public static ArrayList combine(int length){

        ArrayList<int[]> a = new ArrayList<>();
        int[] elements = new int[length];

        for (int i = 0; i < length; i++){
            elements[i] = i+1;
        }

        for (int i = 1; i<= elements.length; i++){
            combination(elements, i, a);}

            return a;
    }

    //Pomocnicza metoda
    private static void combination(int[]  elements, int K, ArrayList arraylist){

        int N = elements.length;
        c(N,K);
        int combination[] = new int[K];

        int r = 0;
        int index = 0;

        while(r >= 0){

            if(index <= (N + (r - K))){
                combination[r] = index+1;

                if(r == K-1){
                    addSetsToArrayList(combination, arraylist);
                    index++;
                }
                else{
                    index = combination[r]+1;
                    r++;
                }
            }
            else{
                r--;
                if(r > 0)
                    index = combination[r]+1;
                else
                    index = combination[0]+1;
            }
        }
    }

    //Pomocnicza metoda
    private static int c(int n, int r){
        int nf=fact(n);
        int rf=fact(r);
        int nrf=fact(n-r);
        int npr=nf/nrf;
        int ncr=npr/rf;

        return ncr;
    }

    //Pomocnicza metoda
    private static int fact(int n)
    {
        if(n == 0)
            return 1;
        else
            return n * fact(n-1);
    }


    //Metoda dodająca tablice do ArrayLista
    private static void addSetsToArrayList(int[] combination, ArrayList arraylist){

        int[] temp = new int[combination.length];
        for(int z = 0 ; z < combination.length;z++){
            temp[z] = combination[z];
        }
        arraylist.add(temp);
    }
}
