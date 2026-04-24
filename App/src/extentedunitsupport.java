package com.apps.quantitymeasurement;

enum LengthUnit {
    FEET(12.0),
    INCHES(1.0),
    YARDS(36.0),
    CENTIMETERS(0.393701);

    private final double conversionFactor;

    LengthUnit(double conversionFactor) {
        this.conversionFactor = conversionFactor;
    }

    public double getConversionFactor() {
        return conversionFactor;
    }
}

class Length {
    private double value;
    private LengthUnit unit;

    public Length(double value, LengthUnit unit) {
        this.value = value;
        this.unit = unit;
    }

    private double convertToBaseUnit() {
        return Math.round(this.value * this.unit.getConversionFactor() * 100.0) / 100.0;
    }

    public boolean compare(Length other) {
        return this.convertToBaseUnit() == other.convertToBaseUnit();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Length other = (Length) obj;
        return Double.compare(this.convertToBaseUnit(), other.convertToBaseUnit()) == 0;
    }
}

public class extentedunitsupport {
    public static void main(String[] args) {

        System.out.println("1 yard == 3 feet: " +
                new Length(1.0, LengthUnit.YARDS)
                        .equals(new Length(3.0, LengthUnit.FEET)));

        System.out.println("1 yard == 36 inches: " +
                new Length(1.0, LengthUnit.YARDS)
                        .equals(new Length(36.0, LengthUnit.INCHES)));

        System.out.println("1 cm == 0.393701 inches: " +
                new Length(1.0, LengthUnit.CENTIMETERS)
                        .equals(new Length(0.393701, LengthUnit.INCHES)));

        System.out.println("2 yards == 6 feet: " +
                new Length(2.0, LengthUnit.YARDS)
                        .equals(new Length(6.0, LengthUnit.FEET)));

        System.out.println("Invalid case (1 yard != 2 feet): " +
                new Length(1.0, LengthUnit.YARDS)
                        .equals(new Length(2.0, LengthUnit.FEET)));
    }
}