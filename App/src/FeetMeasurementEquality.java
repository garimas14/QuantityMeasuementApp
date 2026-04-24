public class FeetMeasurementEquality {

        // Inner class to represent Feet measurement
        public static class Feet {
            private final double value;

            // Constructor
            public Feet(double value) {
                this.value = value;
            }

            // Getter (optional)
            public double getValue() {
                return value;
            }

            // Override equals method
            @Override
            public boolean equals(Object obj) {
                // Reflexive property
                if (this == obj) {
                    return true;
                }

                // Null and type check
                if (obj == null || getClass() != obj.getClass()) {
                    return false;
                }

                // Type casting
                Feet other = (Feet) obj;

                // Compare double values safely
                return Double.compare(this.value, other.value) == 0;
            }

            // Override hashCode (important when equals is overridden)
            @Override
            public int hashCode() {
                return Double.hashCode(value);
            }
        }

        // Main method
        public static void main(String[] args) {

            // Input values
            double value1 = 1.0;
            double value2 = 1.0;

            // Create Feet objects
            Feet f1 = new Feet(value1);
            Feet f2 = new Feet(value2);

            // Compare
            boolean result = f1.equals(f2);

            // Output
            System.out.println("Input: " + value1 + " ft and " + value2 + " ft");
            System.out.println("Output: Equal (" + result + ")");
        }
    }