/**
 * TODO: Complete the solution for Student
 */
import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    public Student(String firstName, String lastName, String PID) {
        if (firstName == null||lastName == null||PID == null){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.PID = PID;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getPID() {
        return this.PID;
    }

    @Override
    public boolean equals(Object o) {
        if(this.hashCode() == o.hashCode()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getFirstName(),this.getLastName(),this.getPID());
    }

    @Override
    public int compareTo(Student o) {
        if(this.hashCode() == o.hashCode()){
            return 0;
        }
        if (this.hashCode() > o.hashCode()){
            return 1;
        }
        else{
            return -1;
        }
    }
}
