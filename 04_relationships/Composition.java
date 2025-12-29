class Engine {
    String type;
    public Engine(String type) { this.type = type; }
}

class Car {
    private String model;
    // COMPOSITION: The Car OWNS this field strictly.
    private Engine engine; 

    public Car(String model) {
        this.model = model;

        // Nobody passed an engine in. The Car birthed it.
        this.engine = new Engine("V8 Turbo"); 
    }
    
    public void drive() {
        System.out.println(model + " is driving with " + engine.type);
    }
}

public class Composition {
    public static void main(String[] args) {
        // 1. Create Car
        Car myFerrari = new Car("Ferrari");
        
        // 2. The Engine exists inside myFerrari now.
        myFerrari.drive();

        // 3. =Crush the car
        myFerrari = null;

        // 4. CHECK: Where is the Engine? => GONE with the Car.
        System.out.println("Car is gone, so is its engine.");
    }
}