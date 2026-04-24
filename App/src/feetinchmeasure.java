package com.apps.quantitymeasurement;
public class feetinchmeasure {


        // Inner class to represent Feet measurement
        public static class Feet {
            private final double value;

            public Feet(double value) {
                this.value = value;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;

                if (obj == null || getClass() != obj.getClass()) return false;

                Feet other = (Feet) obj;

                return Double.compare(this.value, other.value) == 0;
            }

            @Override
            public int hashCode() {
                return Double.hashCode(value);
            }
        }

        // Inner class to represent Inches measurement
        public static class Inches {
            private final double value;

            public Inches(double value) {
                this.value = value;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) return true;

                if (obj == null || getClass() != obj.getClass()) return false;

                Inches other = (Inches) obj;

                return Double.compare(this.value, other.value) == 0;
            }

            @Override
            public int hashCode() {
                return Double.hashCode(value);
            }
        }

        // Method to demonstrate Feet equality
        public static void demonstrateFeetEquality() {
            double value1 = 1.0;
            double value2 = 1.0;

            Feet f1 = new Feet(value1);
            Feet f2 = new Feet(value2);

            boolean result = f1.equals(f2);

            System.out.println("Input: " + value1 + " ft and " + value2 + " ft");
            System.out.println("Output: Equal (" + result + ")");
        }

        // Method to demonstrate Inches equality
        public static void demonstrateInchesEquality() {
            double value1 = 1.0;
            double value2 = 1.0;

            Inches i1 = new Inches(value1);
            Inches i2 = new Inches(value2);

            boolean result = i1.equals(i2);

            System.out.println("Input: " + value1 + " inch and " + value2 + " inch");
            System.out.println("Output: Equal (" + result + ")");
        }

        // Main method
        public static void main(String[] args) {
            demonstrateInchesEquality();
            demonstrateFeetEquality();
        }
    }

