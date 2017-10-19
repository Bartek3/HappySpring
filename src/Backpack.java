//Klasa przechowująca dane na temat plecaków

import java.util.ArrayList;

public class Backpack extends HappySpring{

    private int[] elements; //Tablica przechowująca ID przedmiotów znajdujących się w plecaku
    private int weight; //Waga przedmiotów znajdujących się w plecaku
    private int backpackValue; //Wartość przedmiotów znajdujących się w plecaku

    public Backpack(int[] elements, int weight, int backpackValue) {
        this.elements = elements;
        this.weight = weight;
        this.backpackValue = backpackValue;
    }

    public int[] getElements() {
        return elements;
    }

    public int getWeight() {
        return weight;
    }

    public int getBackpackValue() {
        return backpackValue;
    }

    public int getSumOfWeight(ArrayList<Thing> things, int[] elements){
        return 0;
    }

}
