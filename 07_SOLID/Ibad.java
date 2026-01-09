public class Ibad {
    public static void main(String[] args){

    }
}

/*
useraction  => wery fat/big interface => split into chunks 
- viewCourse => by both
- deleteUser => by admin
*/
interface UserActions {
    void viewCourse();
    void deleteUser();
}

class Student implements UserActions {
    public void viewCourse() { 
        System.out.println("Viewing course..."); 
    }

    public void deleteUser() {
        // A Student should NEVER be able to do this.
        // But the interface forces us to write this method.
        throw new RuntimeException("ACCESS DENIED"); 
    }
}
