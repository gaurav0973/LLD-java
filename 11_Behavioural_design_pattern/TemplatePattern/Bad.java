public class Bad {
    public static void main(String[] args){

        // Create tea
        Tea lemon = new Tea();
        // lemon.prepareRecipe();


        // create Coffee
        Coffee coffee = new Coffee();
        coffee.prepareRecipe();
    }
}
class Tea {
    void prepareRecipe() {
        boilWater();
        steepTeaBag();
        pourInCup();
        addLemon();
    }
    public void boilWater() { System.out.println("Boiling water"); }
    public void steepTeaBag() { System.out.println("Steeping the tea"); }
    public void pourInCup() { System.out.println("Pouring into cup"); }
    public void addLemon() { System.out.println("Adding Lemon"); }
}

class Coffee {
    void prepareRecipe() {
        boilWater();
        brewCoffeeGrinds();
        pourInCup();
        addSugarAndMilk();
    }
    public void boilWater() { System.out.println("Boiling water"); }
    public void pourInCup() { System.out.println("Pouring into cup"); }
    public void brewCoffeeGrinds() { System.out.println("Dripping Coffee through filter"); }
    public void addSugarAndMilk() { System.out.println("Adding Sugar and Milk"); }
}