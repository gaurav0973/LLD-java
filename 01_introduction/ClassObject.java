class Employee {
    private int salary;
    public String employeeName;
    public void setName(String s) {
        employeeName = s;
    }
    public void setSalary(int val) {
        salary = val;
    }
    public int getSalary() {
        return salary;
    }
    public String getName(){
        return employeeName;
    }
}




class ClassObject {
    public static void main(String[] args){
        Employee gaurav = new Employee();
        gaurav.setName("Gaurav");
        gaurav.setSalary(10000000);
        System.out.println(gaurav.getSalary());
        System.out.println(gaurav.getName());

    }
}



