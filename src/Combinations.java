//Kod służący do wygenerowania wszystkich możliwych kombinacji plecaków, pochodzący z:
// https://github.com/hmkcode/Java/blob/master/java-combinations/Combination.java
// i mocno zmodyfikowany na potrzeby tego projektu

import java.util.ArrayList;

public class Combinations extends HappySpring {

    //Metoda na podstawie podanej liczby rzeczy zwraca wszystkie możliwe kombinacje plecaków
    //w postaci ArrayLista zawierającego tablice integerów.
    static ArrayList<int[]> combine(int length) {

        ArrayList<int[]> a = new ArrayList<>();
        int[] elements = new int[length];

        for (int i = 0; i < length; i++) {
            elements[i] = i + 1;
        }

        for (int i = 1; i <= elements.length; i++) {
            combination(elements, i, a);
        }

        return a;
    }

    //Pomocnicza metoda
    private static void combination(int[] elements, int K, ArrayList<int[]> arraylist) {

        int N = elements.length;
        int combination[] = new int[K];
        int r = 0;
        int index = 0;

        while (r >= 0) {

            if (index <= (N + (r - K))) {
                combination[r] = index + 1;

                if (r == K - 1) {
                    addSetsToArrayList(combination, arraylist);
                    index++;
                } else {
                    index = combination[r];
                    r++;
                }
            } else {
                r--;
                if (r > 0)
                    index = combination[r];
                else
                    index = combination[0];
            }
        }
    }

    //Metoda dodająca tablice do odpowiedniej listy
    private static void addSetsToArrayList(int[] combination, ArrayList<int[]> arraylist) {

        int[] temp = new int[combination.length];
        System.arraycopy(combination, 0, temp, 0, combination.length);
        arraylist.add(temp);
    }
}
