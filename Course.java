/**
 * TODO: Complete the solution for Course
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Course {
    HashSet<Student> enrolled;
    private final int capacity;
    private final String department;
    private final String number;
    private final String description;

    public Course(String department, String number, String description, 
        int capacity){
            if(department == null||number == null||description == null){
                throw new IllegalArgumentException();
            }
            if(capacity < 1){
                throw new IllegalArgumentException();
            }

            this.department = department;
            this.number = number;
            this.description = description;
            this.capacity = capacity;
        }

    public String getDepartment(){
        return this.department;
    }

    public String getNumber(){
        return this.number;
    }

    public String getDescription(){
        return this.description;
    }

    public int getCapacity(){
        return this.capacity;
    }

    public boolean enroll(Student student) {
        if(student == null){
            throw new IllegalArgumentException();
        }

        if(this.getEnrolledCount() < capacity && !enrolled.contains(student)){
            return true;
        }
        return false;
    }

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

    public void cancel() {
        enrolled.clear();
    }

    public boolean isFull() {
        return false;
    }

    public int getEnrolledCount(){
        return enrolled.size();
    }

    public int getAvailableSeats() {
        return this.getCapacity() - this.getEnrolledCount();
    }

    public HashSet<Student> getStudents() {
        HashSet<Student> copySet = new HashSet<Student>(this.enrolled);
        return copySet;
    }

    public ArrayList<Student> getRoster() {
        Iterator<Student> arrIt = this.enrolled.iterator();
        ArrayList<Student> roster = new ArrayList<Student>(this.getEnrolledCount());

        while(arrIt.hasNext()){
            roster.add(arrIt.next());
        }
        return roster;
    }

    public String toString() {
        return this.getDepartment()+this.getNumber()+
            "["+this.getCapacity()+"]"+"\n"+this.getDescription();
    }
}

