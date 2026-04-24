package com.apps.quantitymeasurement;
public class qualityclass {
        static class Length {
            private final double value;
            private final LengthUnit unit;
            enum LengthUnit {
                FEET(12.0),
                INCHES(1.0);
                private final double conversionFactor;
                LengthUnit(double conversionFactor) {
                    this.conversionFactor = conversionFactor;
                }
                public double getConversionFactor() {
                    return conversionFactor;
                }
            }
            public Length(double value, LengthUnit unit) {
                if (unit == null) {
                    throw new IllegalArgumentException("Unit cannot be null");
                }
                this.value = value;
                this.unit = unit;
            }
            private double toBaseUnit() {
                return this.value * this.unit.getConversionFactor();
            }
            public boolean compare(Length other) {
                if (other == null) return false;
                return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
            }
            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;
                if (obj == null || getClass() != obj.getClass()) return false;
                Length other = (Length) obj;
                return this.compare(other);
            }
            @Override
            public int hashCode() {
                return Double.hashCode(toBaseUnit());
            }
            @Override
            public String toString() {
                return "Quantity(" + value + ", \"" + unit.name().toLowerCase() + "\")";
            }
        }
        public static void demonstrateLengthEquality(Length l1, Length l2) {
            boolean result = l1.equals(l2);
            System.out.println("Input: " + l1 + " and " + l2);
            System.out.println("Output: Equal (" + result + ")");
        }
        public static void demonstrateFeetEquality() {
            Length l1 = new Length(1.0, Length.LengthUnit.FEET);
            Length l2 = new Length(1.0, Length.LengthUnit.FEET);
            demonstrateLengthEquality(l1, l2);
        }
        public static void demonstrateInchesEquality() {
            Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
            Length l2 = new Length(1.0, Length.LengthUnit.INCHES);
            demonstrateLengthEquality(l1, l2);
        }
        public static void demonstrateFeetInchesComparison() {
            Length l1 = new Length(1.0, Length.LengthUnit.FEET);
            Length l2 = new Length(12.0, Length.LengthUnit.INCHES);
            demonstrateLengthEquality(l1, l2);
        }
        public static void main(String[] args) {
            demonstrateFeetEquality();
            demonstrateInchesEquality();
            demonstrateFeetInchesComparison();
        }
    }
