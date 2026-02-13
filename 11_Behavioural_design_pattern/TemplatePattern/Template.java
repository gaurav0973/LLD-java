public class Template {
    public static void main(String[] args) {
        System.out.println("--- Making Tea ---");
        Beverage tea = new Tea();
        tea.prepareRecipe(); // The Template handles the flow

        System.out.println("\n--- Making Coffee ---");
        Beverage coffee = new Coffee();
        coffee.prepareRecipe();
    }
}

abstract class Beverage {
    
    // 1. THE TEMPLATE METHOD
    // It is 'final' so subclasses CANNOT change the sequence of steps.
    public final void prepareRecipe() {
        boilWater();      // Common
        brew();           // Abstract (Variant)
        pourInCup();      // Common
        addCondiments();  // Abstract (Variant)
    }

    // 2. COMMON STEPS (Implemented here)
    private void boilWater() {
        System.out.println("Boiling water");
    }
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // 3. VARIANT STEPS (Abstract - Children MUST implement these)
    protected abstract void brew();
    protected abstract void addCondiments();
}

class Tea extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Lemon");
    }
}

class Coffee extends Beverage {
    @Override
    protected void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}