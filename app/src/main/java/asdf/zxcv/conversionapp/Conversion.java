package asdf.zxcv.conversionapp;

public class Conversion {

    private final int FEET = 1;
    private final double METERS_PER_FEET = 0.3048;
    private final int INCHES = 2;
    private final double CETIMETERS_PER_INCHES = 2.56;
    private final int POUNDS = 3 ;
    private final double GRAMS_PER_POUNDS = 453.592;

    public Double input;
    public Double output;
    public int type; // what the user chooses (feet,inches,or pounds)

    public String inputLabel;
    public String outputLabel;

    public Conversion() {
        type = FEET;
        inputLabel = "Feet";
        outputLabel = "Meters";
        input = 0.0;
        output = 0.0;
    }

    public void switchToMeters() {
        type = FEET;
        inputLabel = "Feet";
        outputLabel = "Meters";
        convert();
    }
    public void switchToCentimeters() {
        type = INCHES;
        inputLabel = "Inches";
        outputLabel = "Centimeters";
        convert();
    }
    public void switchToGrams() {
        type = POUNDS;
        inputLabel = "Pounds";
        outputLabel = "Grams";
        convert();
    }
    public void convert() {
        switch (type) {
            case FEET:
                output = input * METERS_PER_FEET;
                break;
            case INCHES:
                output = input * CETIMETERS_PER_INCHES;
                break;
            case POUNDS:
                output = input * GRAMS_PER_POUNDS;
                break;
        }
    }
}
