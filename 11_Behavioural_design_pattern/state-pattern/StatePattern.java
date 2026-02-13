public class StatePattern {
    public static void main(String[] args){
        Order order = new Order();
        
        order.printCurrentState();
        
        order.nextState();
        order.printCurrentState();
        
        order.cancelOrder(); // Cannot cancel. Food is being prepared!
        
        order.nextState();
        order.nextState(); 
        
        order.nextState(); // Order is already delivered.
    }
}

interface OrderState {
    void next(Order order);
    void cancel(Order order);
    void printStatus();
}
class OrderPlacedState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order moved to: PREPARING");
        // State changes itself!
        order.setState(new PreparingState()); 
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Order has been cancelled successfully.");
        order.setState(new CancelledState());
    }

    @Override
    public void printStatus() { System.out.println("Current State: ORDER_PLACED"); }
}
class PreparingState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order moved to: OUT_FOR_DELIVERY");
        order.setState(new OutForDeliveryState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cannot cancel. Food is already being prepared!");
    }

    @Override
    public void printStatus() { System.out.println("Current State: PREPARING"); }
}
class OutForDeliveryState implements OrderState {
    @Override
    public void next(Order order) {
        System.out.println("Order moved to: DELIVERED");
        order.setState(new DeliveredState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Cannot cancel. Driver is on the way!");
    }

    @Override
    public void printStatus() { System.out.println("Current State: OUT_FOR_DELIVERY"); }
}
class DeliveredState implements OrderState {
    @Override
    public void next(Order order) { System.out.println("Order is already delivered."); }
    @Override
    public void cancel(Order order) { System.out.println("Cannot cancel a delivered order."); }
    @Override
    public void printStatus() { System.out.println("Current State: DELIVERED"); }
}
class CancelledState implements OrderState {
    @Override
    public void next(Order order) { System.out.println("Cancelled orders cannot move forward."); }
    @Override
    public void cancel(Order order) { System.out.println("Order is already cancelled."); }
    @Override
    public void printStatus() { System.out.println("Current State: CANCELLED"); }
}

class Order {
    private OrderState state;
    public Order() {
        this.state = new OrderPlacedState();
    }
    public void setState(OrderState state) {
        this.state = state;
    }

    // DELEGATION: "I don't know the rules, let my current state handle it."
    public void nextState() {
        state.next(this);
    }
    public void cancelOrder() {
        state.cancel(this);
    }
    public void printCurrentState() {
        state.printStatus();
    }
}