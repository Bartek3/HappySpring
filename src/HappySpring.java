import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class HappySpring {

    private static int quantityOfThings;
    private static int backpackACapacity;
    private static int backpackBCapacity;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Thing> things = new ArrayList<>();
        ArrayList<Backpack> backpacks = new ArrayList<>();

        inputVariables(in);

        addThingsToArrayList(things, in);

        ArrayList<int[]> combinations = Combinations.combine(quantityOfThings);
        addBackpacksToArrayList(combinations, things, backpacks);
        //things.sort(Comparator.comparingDouble(Thing::getRatio).reversed());
        Backpack temp;
        //for (int i = 0; i < combinations.size(); i++){System.out.println(Arrays.toString(combinations.get(i)));}
        for (int i = 0; i < backpacks.size(); i++){
            temp = backpacks.get(i);
            System.out.print(Arrays.toString(temp.getElements()));
            System.out.print(" - weight = " + temp.getWeight() + ", value = " + temp.getBackpackValue());
            System.out.println();
        }

    }

    private static void inputVariables(Scanner in) {
        quantityOfThings = in.nextInt();
        backpackACapacity = in.nextInt();
        backpackBCapacity = in.nextInt();
        in.nextLine();
    }

    private static void addThingsToArrayList(ArrayList arrayList, Scanner in) {
        for (int i = 1; i <= quantityOfThings; i++) {
            arrayList.add(new Thing(i, in.nextInt(), in.nextInt()));
        }
    }

    private static void addBackpacksToArrayList(ArrayList<int[]> combinations, ArrayList<Thing> things, ArrayList<Backpack> backpacks) {
        Thing temp;
        int tempWeight = 0;
        int tempValue = 0;

        for (int i = 0; i < combinations.size(); i++){
            for (int j = 0; j < combinations.get(i).length; j++){
                temp = things.get(combinations.get(i)[j] - 1);
                tempWeight += temp.getWeight();
                tempValue += temp.getValue();
            }
            backpacks.add(new Backpack(combinations.get(i), tempWeight, tempValue));
            tempWeight = 0;
            tempValue = 0;
        }
    }

    private static void results() {
        //Do uzupełnienia
    }

    private static void printResults() {
        //Do uzupełnienia
    }

}
