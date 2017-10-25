import java.util.*;

public class HappySpring {

    //Zadeklarowanie stałych
    private static int quantityOfThings; //Liczba rzeczy
    private static int backpackACapacity; //Pojemność plecaka A
    private static int backpackBCapacity; //Pojemność plecaka B

    //Metoda main
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Zadeklarowanie listy rzeczy
        ArrayList<Thing> things = new ArrayList<>();

        //Zadeklarowanie plecaków
        ArrayList<Backpack> backpacks = new ArrayList<>(); //Wszystkie możliwe konfiguracje rzeczy
        ArrayList<Backpack> backpacksA = new ArrayList<>(); //Wszystkie możliwe konfiguracje rzeczy dla plecaka A
        ArrayList<Backpack> backpacksB = new ArrayList<>(); //Wszystkie możliwe konfiguracje rzeczy dla plecaka B

        inputConst(in); //Pobranie stałych programu z konsoli

        addThingsToArrayList(things, in); //Pobranie listy rzeczy z konsoli

        //Wyznaczenie listy wszystkich możliwych konfiguracji plecaków
        ArrayList<int[]> combinations = Combinations.combine(quantityOfThings);

        //Dodanie wszystkich możliwych konfiguracji plecaków do listy "backpacks"
        addBackpacksToArrayList(combinations, things, backpacks);

        //Wyznaczenie listy wszystkich możliwych konfiguracji dla plecaka A
        verifyBackpack(backpackACapacity, backpacksA, backpacks);

        //Wyznaczenie listy wszystkich możliwych konfiguracji dla plecaka B
        verifyBackpack(backpackBCapacity, backpacksB, backpacks);

        //Obliczenie i wydrukowanie wyjścia programu
        results(backpacksA, backpacksB);
    }

    //Metoda pobierająca stałe programu
    private static void inputConst(Scanner in) {
        quantityOfThings = in.nextInt();
        backpackACapacity = in.nextInt();
        backpackBCapacity = in.nextInt();

        if (quantityOfThings >= 100) {
            error("Quantity of things can't be larger than 100!");
        }

        if (backpackACapacity >= 500 | backpackBCapacity >= 500) {
            error("Capacity of any backpack can't be larger than 500!");
        }
        in.nextLine();
    }

    private static void error(String communicate){
        System.out.println(communicate);
        System.exit(0);
    }

    //Metoda dodająca rzeczy do odpowiedniej listy
    private static void addThingsToArrayList(ArrayList<Thing> arrayList, Scanner in) {
        for (int i = 1; i <= quantityOfThings; i++) {
            arrayList.add(new Thing(i, in.nextInt(), in.nextInt()));
        }
    }

    //Metoda dodająca wszystkie możliwe konfiguracje plecaków do odpowiedniej listy
    private static void addBackpacksToArrayList(ArrayList<int[]> combinations, ArrayList<Thing> things, ArrayList<Backpack> backpacks) {
        Thing temp;
        int tempWeight = 0;
        int tempValue = 0;

        for (int i = 0; i < combinations.size(); i++) {
            for (int j = 0; j < combinations.get(i).length; j++) {
                temp = things.get(combinations.get(i)[j] - 1);
                tempWeight += temp.getWeight();
                tempValue += temp.getValue();
            }
            backpacks.add(new Backpack(combinations.get(i), tempWeight, tempValue));
            tempWeight = 0;
            tempValue = 0;
        }
    }

    //Metoda znajdująca zestawy, które mogą być włożone do danego plecaka
    private static void verifyBackpack(int capacity, ArrayList<Backpack> subList, ArrayList<Backpack> mainList) {
        Backpack temp;
        for (int i = 0; i < mainList.size(); i++) {
            temp = mainList.get(i);
            if (temp.getWeight() <= capacity) {
                subList.add(temp);
            }
        }
        //Posortowanie plecaków według ich wartości (od największej do najmniejszej)
        subList.sort(Comparator.comparingInt(Backpack::getBackpackValue).reversed());
    }

    //Metoda znajdująca i drukująca wyjście
    private static void results(ArrayList<Backpack> backpacksA, ArrayList<Backpack> backpacksB) {
        Backpack maxA = backpacksA.get(0);
        Backpack maxB = backpacksB.get(0);

        Backpack AltMaxA = altMax(backpacksB, backpacksA);
        Backpack AltMaxB = altMax(backpacksA, backpacksB);

        int optionA = maxA.getBackpackValue() + AltMaxB.getBackpackValue();
        int optionB = maxB.getBackpackValue() + AltMaxA.getBackpackValue();

        System.out.println();
        if (optionA >= optionB) {
            System.out.println(optionA);
            prettyArrayPrint(maxA.getElements());
            prettyArrayPrint(AltMaxB.getElements());
        } else {
            System.out.println(optionB);
            prettyArrayPrint(maxB.getElements());
            prettyArrayPrint(AltMaxA.getElements());
        }
    }

    //Metoda znajdująca zestaw o maksymalnej wartości dla drugiego plecaka,
    //bez wspólnych elementów z zestawem o maksymalnej wartości dla pierwszego plecaka
    private static Backpack altMax(ArrayList<Backpack> backpacks1, ArrayList<Backpack> backpacks2) {
        int[] backpack1Max = backpacks1.get(0).getElements();
        int indexOfBackpack2AltMax = 0;
        for (int i = 0; i < backpacks2.size(); i++) {
            if (isNoCommonElements(backpack1Max, backpacks2.get(i).getElements())) {
                indexOfBackpack2AltMax = i;
                break;
            }
        }

        return backpacks2.get(indexOfBackpack2AltMax);
    }

    //Metoda sprawdzająca czy dwie tablice liczb nie mają wspólnych elementów
    private static boolean isNoCommonElements(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    //Metoda służąca do wydrukowania tablicy liczb w sposób wymagany w zadaniu
    private static void prettyArrayPrint(int[] a) {
        String separator = " ";
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + separator);
        }
        System.out.println();
    }

}
