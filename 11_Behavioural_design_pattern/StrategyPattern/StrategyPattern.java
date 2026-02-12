public class StrategyPattern {
    public static void main(String[] args) {
        NavigationApp nav = new NavigationApp(new CarStrategy());
        nav.buildRoute("Home", "Office");

    
        nav.setRouteStrategy(new WalkStrategy()); 
        nav.buildRoute("Office", "Park");

        nav.setRouteStrategy(new BusStrategy());
        nav.buildRoute("Park", "Museum");
    }
}


interface RouteStrategy {
    void buildRoute(String A, String B);
}

class CarStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String A, String B) {
        System.out.println("Calculating Route for CAR (Highways)");
        System.out.println("   - Check Traffic: Moderate");
        System.out.println("   - Route: " + A + " to " + B);
    }
}
class WalkStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String A, String B) {
        System.out.println("Calculating Route for WALK (Scenic Path)");
        System.out.println("   - Check Parks: Open");
        System.out.println("   - Route: " + A + " to " + B);
    }
}
class BusStrategy implements RouteStrategy {
    @Override
    public void buildRoute(String A, String B) {
        System.out.println("Calculating Route for BUS (Public Transit)");
        System.out.println("   - Check Schedule: On Time");
        System.out.println("   - Route: " + A + " to " + B);
    }
}

class NavigationApp {
    private RouteStrategy strategy;
    public NavigationApp(RouteStrategy strategy) {
        this.strategy = strategy;
    }
    public void setRouteStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }
    public void buildRoute(String A, String B) {
        if (strategy == null) {
            System.out.println("Please select a mode of transport!");
            return;
        }
        strategy.buildRoute(A, B);
    }
}