/**
 * Name: Jack Montoro
 * Email: jmontoro@ucsd.edu
 * PID: A17152600
 * File Description: This class implements the Student Object 
 */
import java.util.Objects;

/**
 * This class implements the Student object with
 * class variables(String) firstName, lastName, and PID
 */
public class Student implements Comparable<Student> {
    private final String firstName;
    private final String lastName;
    private final String PID;

    /**
     * Constructor that creates a Student Object
     * @param firstName String assigned to class variable firstName
     * @param lastName String assigned to class variable lastName
     * @param PID String assigned to class variable PID
     */
    public Student(String firstName, String lastName, String PID) {
        if (firstName == null||lastName == null||PID == null){
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.PID = PID;
    }

    /**
     * @return class variable lastName
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * @return class variable firstName
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * @return class variable PID
     */
    public String getPID() {
        return this.PID;
    }

    /**
     * checks if Student Object equal to other Object
     * @param o object that Student is compared to
     * @return boolean true if Student equals o, else false
     */
    @Override
    public boolean equals(Object o) {
        if(this.hashCode() == o.hashCode()){
            return true;
        }
        return false;
    }

    /**
     * @return hashCode value for a Student object
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getFirstName(),this.getLastName(),this.getPID());
    }

    /**
     * compares two Student Objects
     * @returns boolean value corresponding to comparison
     */
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
