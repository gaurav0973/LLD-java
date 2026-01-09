public class Igood {
    public static void main(String[] args){
        Student student = new Student();
        student.viewCourse();
        student.deleteUser();
    }
}



interface Viewer {
    void viewCourse();
}
interface AdminOpt {
    void viewCourse();
    void deleteUser();
}


class Student implements Viewer {
    public void viewCourse() { 
        System.out.println("Viewing course..."); 
    }
    public void deleteUser() { 
        System.out.println("Deleating course..."); 
    }
}

class Admin implements AdminOpt{
    public void viewCourse() { 
        System.out.println("Viewing course..."); 
    }
    public void deleteUser() { 
        System.out.println("Deleating course..."); 
    }

}