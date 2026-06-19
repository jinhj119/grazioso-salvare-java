public class Monkey extends RescueAnimal {

    // monkey attributes
    private String species;
    private double tailLength;
    private double height;
    private double bodyLength;

    // default constructor
    public Monkey() {
        setAnimalType("monkey");
    }

    // species getter and setter
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String monkeySpecies) {
        this.species = monkeySpecies;
    }

    // tail length getter and setter
    public double getTailLength() {
        return tailLength;
    }

    public void setTailLength(double monkeyTailLength) {
        this.tailLength = monkeyTailLength;
    }

    // height getter and setter
    public double getHeight() {
        return height;
    }

    public void setHeight(double monkeyHeight) {
        this.height = monkeyHeight;
    }

    // body length getter and setter
    public double getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(double monkeyBodyLength) {
        this.bodyLength = monkeyBodyLength;
    }
}