// house class with different properties that can be configured
// we're using builder to create house step by step
class House {
    private int numRooms;
    private int numFloors;
    private boolean hasPool;
    private boolean hasGarage;

    // private constructor to be accessed by builder only
    private House(HouseBuilder builder) {
        this.numRooms = builder.numRooms;
        this.numFloors = builder.numFloors;
        this.hasPool = builder.hasPool;
        this.hasGarage = builder.hasGarage;
    }

    // static nested class that allows us to build a house with flexible configurations
    public static class HouseBuilder {
        private int numRooms;
        private int numFloors;
        private boolean hasPool;
        private boolean hasGarage;

        // builder constructor takes required params first like rooms and floors
        public HouseBuilder(int numRooms, int numFloors) {
            this.numRooms = numRooms;
            this.numFloors = numFloors;
        }

        // optional parameters can be added step by step
        public HouseBuilder setPool(boolean hasPool) {
            this.hasPool = hasPool;
            return this;  // returns builder itself for method chaining
        }

        public HouseBuilder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        // final method to build the house object
        public House build() {
            return new House(this);  // returns final house object
        }
    }

    // overriding toString to show the house details
    @Override
    public String toString() {
        return "House with " + numRooms + " rooms, " + numFloors + " floors, pool: " + hasPool + ", garage: " + hasGarage;
    }
}

// test code that uses the builder to create houses
public class BuilderPatternExample {
    public static void main(String[] args) {
        House house1 = new House.HouseBuilder(3, 2)
                .setPool(true)
                .setGarage(false)
                .build();  // builds house with pool but no garage

        House house2 = new House.HouseBuilder(5, 3)
                .setGarage(true)
                .build();  // builds house with garage but no pool

        System.out.println(house1);  // print first house
        System.out.println(house2);  // print second house
    }
}
