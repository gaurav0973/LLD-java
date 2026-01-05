import java.util.*;
// T => can be anything: User, Product, Order...
class ApiResponse<T> {
    private T data;
    private String status;

    public ApiResponse(T data, String status) {
        this.data = data;
        this.status = status;
    }
    public T getData() { 
        return data; 
    }
}

public class Generics {
    // PRODUCER: We are reading numbers to sum them up.
    // only produce, not consumes
    public static double sumList(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue(); 
        }
        // list.add(10); // COMPILE ERROR! You cannot add to 'extends'
        return sum;
    }

    public static void main(String[] args) {
        // 1. Generic Class Usage
        ApiResponse<String> userResp = new ApiResponse<>("Gaurav", "200 OK");
        ApiResponse<Integer> scoreResp = new ApiResponse<>(95, "200 OK");
        
        // No casting needed!
        System.out.println("User: " + userResp.getData());

        // 2. Wildcard Usage
        List<Integer> ints = new ArrayList<>();
        ints.add(10);
        ints.add(20);
        
        System.out.println("Sum: " + sumList(ints));
    }
}
/*
The "PECS" Rule (Wildcards)
PECS => (Producer Extends, Consumer Super).
- Producer Extends (? extends T): Use this when I only want to READ (produce) data from a list.I cannot add to it.
- Consumer Super (? super T): Use this when I want to WRITE (consume) data into a list.
*/