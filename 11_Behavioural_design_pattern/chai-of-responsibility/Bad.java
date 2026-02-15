public class Bad {
    public static void main(String[] args){
        LeaveHandler handler = new LeaveHandler();
        handler.processLeave(new LeaveRequest("Gaurav", 1)); 
        handler.processLeave(new LeaveRequest("Maurya", 10));
    }
}

class LeaveRequest {
    public String employeeName;
    public int days;
    public LeaveRequest(String name, int days) { 
        this.employeeName = name; 
        this.days = days; 
    }
}
class LeaveHandler {
    public void processLeave(LeaveRequest request) {
        if (request.days <= 2) {
            System.out.println("Team Lead approved " + request.days + " days for " + request.employeeName);
        } 
        else if (request.days <= 5) {
            System.out.println("HR approved " + request.days + " days for " + request.employeeName);
        } 
        else {
            System.out.println("Project Manager approved " + request.days + " days for " + request.employeeName);
        }
    }
}


