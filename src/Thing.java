//Klasa przechowująca informacje na temat rzeczy, które mogą być umieszczone w plecaku

public class Thing {

    private int number; //ID danej rzeczy
    private int value; //Wartość danej rzeczy
    private int weight; //Wymiary danej rzeczy

    public Thing(int number, int value, int weight) {
        this.number = number;
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

}
