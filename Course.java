/**
 * Name: Jack Montoro
 * Email: jmontoro@ucsd.edu
 * PID: A17152600
 * File Description: This class implements the Course object
 * with class variables: enrolled, capacity, department, number, and description
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

/**
 * This class represents a university course as an Object through the 
 * implementation of the Course class. Course has the class variables:
 * (HashSet<Student>)enrolled, (private final) (int) capacity,
 * (Strings) department, number, description
 */
public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;
    private final char SPACE = ' ';
    private final char OPEN_BRACKET = '[';
    private final char CLOSE_BRACKET = ']';
    private final char LINE_BREAK = '\n';

    /**
     * Constructor that creates a Course Object
     * @param department String assigned to class variable department
     * @param number String assigned to class variable number
     * @param description String assigned to class variable description
     * @param capacity int assigned to class variable capacity
     */
    public Course(String department, String number, String description, 
        int capacity){
            if(department == null||number == null||description == null){
                throw new IllegalArgumentException();
            }
            if(capacity < 1){
                throw new IllegalArgumentException();
            }

            this.enrolled = new HashSet<Student>();
            this.department = department;
            this.number = number;
            this.description = description;
            this.capacity = capacity;
        }

    /**
     * gets department class variable
     * @return String class variable department
     */
    public String getDepartment(){
        return this.department;
    }

    /**
     * gets number class variable
     * @return String class variable number
     */
    public String getNumber(){
        return this.number;
    }

    /**
     * gets description class variable
     * @return String class variable description
     */
    public String getDescription(){
        return this.description;
    }

    /**
     * gets capacity class variable
     * @return int class variable capacity
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * enrolls student in course, returns true if successful, else false
     * @return boolean value of if enroll was successful
     */
    public boolean enroll(Student student) {
        if(student == null){
            throw new IllegalArgumentException();
        }

        if(this.getEnrolledCount() < capacity && !enrolled.contains(student)){
            enrolled.add(student);
            return true;
        }
        return false;
    }

    /**
     * unenrolls student in course, returns true if successful, else false
     * @return boolean value of if unenroll was successful
     */
    public boolean unenroll(Student student) {
        if(student == null){
            throw new IllegalArgumentException();
        }
        if(enrolled.contains(student)){
            enrolled.remove(student);
            return true;
        }
        return false;
    }

    /**
     * cancels class and unenrolls all students
     */
    public void cancel() {
        enrolled.clear();
    }

    /**
     * checks if Course is full
     * @return true if Course full, else false
     */
    public boolean isFull() {
        if(this.enrolled.size() == capacity){
            return true;
        }
        return false;
    }

    /**
     * @return number of students enrolled in Course
     */
    public int getEnrolledCount(){
        return enrolled.size();
    }

    /**
     * @return number of seats in course still available
     */
    public int getAvailableSeats() {
        return this.getCapacity() - this.getEnrolledCount();
    }

    /**
     * @return HashSet of all Students enrolled in a Course
     */
    public HashSet<Student> getStudents() {
        HashSet<Student> copySet = new HashSet<Student>(this.enrolled);
        return copySet;
    }

    /**
     * @return ArrayList of all Students in Course
     */
    public ArrayList<Student> getRoster() {
        Iterator<Student> arrIt = this.enrolled.iterator();
        ArrayList<Student> roster = new ArrayList<Student>(this.getEnrolledCount());

        while(arrIt.hasNext()){
            roster.add(arrIt.next());
        }
        return roster;
    }

    /**
     * @return String value of course details
     */
    public String toString() {
        return this.getDepartment()+SPACE+this.getNumber()+SPACE+
            OPEN_BRACKET+this.getCapacity()+CLOSE_BRACKET+
            LINE_BREAK+this.getDescription();
    }
}

