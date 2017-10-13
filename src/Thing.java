//Klasa przechowująca informacje na temat rzeczy, które mogą być umieszczone w plecaku

public class Thing {

    private int number; //ID danej rzeczy
    private int value; //Wartość danej rzeczy
    private int size; //Wymiary danej rzeczy

    public Thing(int number, int value, int size) {
        this.number = number;
        this.value = value;
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public int getValue() {
        return value;
    }

    public int getSize() {
        return size;
    }

    public double getRatio() {
        return ((double) value) / ((double) size);
    }

}
