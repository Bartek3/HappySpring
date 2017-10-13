import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class HappySpring {

    private static int quantityOfThings;
    private static int bagpackACapacity;
    private static int bagpackBCapacity;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Thing> things = new ArrayList<>();
        ArrayList<Backpack> backpackA = new ArrayList<>();
        ArrayList<Backpack> backpackB = new ArrayList<>();
        inputVariables(in);
        addThingsToArrayList(things, in);
        things.sort(Comparator.comparingDouble(Thing::getRatio).reversed());

    }

    private static void inputVariables(Scanner in) {
        quantityOfThings = in.nextInt();
        bagpackACapacity = in.nextInt();
        bagpackBCapacity = in.nextInt();
        in.nextLine();
    }

    private static void addThingsToArrayList(ArrayList arrayList, Scanner in) {
        for (int i = 1; i <= quantityOfThings; i++) {
            arrayList.add(new Thing(i, in.nextInt(), in.nextInt()));
        }
    }

    private static void addBackpacksToArrayList(ArrayList arrayList) {
        //Do uzupełnienia
    }

    private static void results() {
        //Do uzupełnienia
    }

    private static void printResults() {
        //Do uzupełnienia
    }

}
