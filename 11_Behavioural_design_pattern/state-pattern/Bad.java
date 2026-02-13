public class Bad {
    public static void main(String[] args){
        Order order = new Order();
        
        System.out.println("Initial State: " + order.getState());
        order.nextState();
        order.nextState();
        order.nextState();
        order.cancelOrder();
        System.out.println("Final State: " + order.getState());
    }
}

class Order {
    private String state;
    public Order() {
        this.state = "ORDER_PLACED";
    }

    public void cancelOrder() {
        if (state.equals("ORDER_PLACED")) {
            state = "CANCELLED";
            System.out.println("Order has been cancelled.");
        } else {
            System.out.println("Cannot cancel the order now at : " +  getState() + " State");
        }
    }

    public void nextState() {
        switch (state) {
            case "ORDER_PLACED":
                state = "PREPARING";
                break;
            case "PREPARING":
                state = "OUT_FOR_DELIVERY";
                break;
            case "OUT_FOR_DELIVERY":
                state = "DELIVERED";
                break;
            default:
                System.out.println("No next state from: " + state);
                return;
        }
        System.out.println("Order moved to: " + state);
    }
    public String getState() {
        return state;
    }
}