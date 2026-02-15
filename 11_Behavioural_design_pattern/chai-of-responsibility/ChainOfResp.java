public class ChainOfResp {
    public static void main(String[] args){
        Approver teamLead = new TeamLead();
        Approver hr = new HR();
        Approver manager = new ProjectManager();

        teamLead.setNextApprover(hr);
        hr.setNextApprover(manager);

        // 3. Employee Submits Requests (They only ever talk to the Team Lead)
        System.out.println("--- Submitting 1 Day Leave ---");
        LeaveRequest req1 = new LeaveRequest("Gaurav", 1);
        teamLead.processLeave(req1); 
        // Output: Team Lead approves.

        System.out.println("\n--- Submitting 4 Day Leave ---");
        LeaveRequest req2 = new LeaveRequest("Gaurav", 4);
        teamLead.processLeave(req2); 
        // Output: Team Lead escalates -> HR approves.

        System.out.println("\n--- Submitting 12 Day Leave ---");
        LeaveRequest req3 = new LeaveRequest("Gaurav", 12);
        teamLead.processLeave(req3); 
        // Output: Team Lead escalates -> HR escalates -> Manager approves.
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


abstract class Approver {
    protected Approver nextApprover;
    public void setNextApprover(Approver nextApprover) {
        this.nextApprover = nextApprover;
    }
    public abstract void processLeave(LeaveRequest request);
}
class TeamLead extends Approver {
    @Override
    public void processLeave(LeaveRequest request) {
        if (request.days <= 2) {
            System.out.println("Team Lead approved " + request.days + " days for " + request.employeeName);
        } else if (nextApprover != null) {
            System.out.println("Team Lead escalating " + request.employeeName + "'s request...");
            nextApprover.processLeave(request);
        }
    }
}
class HR extends Approver {
    @Override
    public void processLeave(LeaveRequest request) {
        if (request.days <= 5) {
            System.out.println("HR approved " + request.days + " days for " + request.employeeName);
        } else if (nextApprover != null) {
            System.out.println("HR escalating " + request.employeeName + "'s request...");
            nextApprover.processLeave(request);
        }
    }
}
class ProjectManager extends Approver {
    @Override
    public void processLeave(LeaveRequest request) {
        System.out.println("Project Manager approved " + request.days + " days for " + request.employeeName);
    }
}