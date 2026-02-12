public class Bad {
    public static void main(String[] args) {
        NavigationApp nav = new NavigationApp();
        nav.buildRoute("Home", "Office", "CAR");
        nav.buildRoute("Home", "Park", "WALK");
    }
}

class NavigationApp {
    public void buildRoute(String A, String B, String mode) {
        if (mode.equals("CAR")) {
            System.out.println("Calculating route for CAR (Avoid traffic) from " + A + " to " + B);
        } 
        else if (mode.equals("WALK")) {
            System.out.println("Calculating route for WALKING (Scenic view) from " + A + " to " + B);
        }
        else {
            System.out.println("Mode not supported");
        }
    }
}
