/**
 * Name: Jack Montoro
 * ID: A17152600
 * Email: jmontoro@ucsd.edu
 * Sources used: None
 * 
 * This file tests the Student, Course, and Sanctuary classes.
 * The tests below are custom tests designed by Jack Montoro
 */

import java.util.*;
import static org.junit.Assert.*;
import org.junit.*;

/**
 * CustomTester tests the Student, Course, and Sanctuary class methods.
 * These tests were designed and implemented by Jack Montoro.
 * 
 * IMPORTANT: Do not change the method names and points are awarded
 * only if your test cases cover cases that the public tester file
 * does not take into account.
 */
public class CustomTester {

    // ----------------Student class----------------
    /**
     * Test the equals method when two Student objects not equal
     */
    @Test
    public void testEquals() {
        Student student1 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        Student student2 = new Student(new String("This"), 
            new String("Should"), new String("Fail"));
        assertFalse("equals should return false", student1.equals(student2));
    }

    /**
     * Test the compareTo method when hash codes are different for two Students
     */
    @Test
    public void testCompareTo() {
        Student student1 = new Student(new String("Test"), 
            new String("Student"), new String("A12345678"));
        Student student2 = new Student(new String("Different"), 
            new String("Student"), new String("A45678901"));
        assertTrue("compareTo should not return 0",
                        student1.compareTo(student2) != 0);
    }

    // ----------------Course class----------------
    /**
     * Test the enroll method when student is null
     */
    @Test
    public void testEnroll() {
        boolean exCaught = false;
        Course course = new Course("CSE", "12", "Data Structure", 100);
        try{
            course.enroll(null);
        } catch (IllegalArgumentException e){
            exCaught = true;
        }
        assertTrue("enrolling null value should throw illegal arg exception",
                        exCaught);

    }

    /**
     * Test the unenroll method when student not enrolled
     */
    @Test
    public void testUnenroll() {
        Course course = new Course("CSE", "12", "Data Structure", 100);
        Student stu = new Student("Whales", "Ocean", "A123");

        assertFalse("unenroll should be unsuccessful", course.unenroll(stu));

    }

    /**
     * Test the getRoster method when three students are enrolled
     */
    @Test
    public void testGetRoster() {
        Course course = new Course("CSE", "12", "Data Structure", 100);
        Student stu1 = new Student("Whales1", "Ocean1", "A123");
        Student stu2 = new Student("Whales2", "Ocean2", "A124");
        Student stu3 = new Student("Whales3", "Ocean1", "A125");

        course.enroll(stu1);
        course.enroll(stu2);
        course.enroll(stu3);

        ArrayList<Student> roster = new ArrayList<Student>();
        roster.add(stu1);
        roster.add(stu2);
        roster.add(stu3);

        ArrayList<Student> retRoster = course.getRoster();
        for(Student x : roster){
            assertTrue("getRoster should have each element in roster", 
                            retRoster.contains(x));
        }

    }

    // ----------------Sanctuary class----------------
    /**
     * Test the constructor when Sanctuary args are < 0
     */
    @Test
    public void testSanctuaryConstructor() {
        boolean exCaught = false;
        try{
            Sanctuary sanct = new Sanctuary(-1, -1);
        } catch (IllegalArgumentException e){
            exCaught = true;
        } 
        assertTrue("args<0 should throw exception",exCaught);
    }

    /**
     * Test the rescue method when species null and num = 0
     */
    @Test
    public void testRescueTestOne(){
        Sanctuary sanct = new Sanctuary(100, 50);
        boolean exCaught = false;

        try{
            sanct.rescue(null, 0);
        } catch (IllegalArgumentException e){
            exCaught = true;
        } 
        assertTrue("rescue throws exception for given args",exCaught);

    }

    /**
     * Test the rescue method when num > maxAnimals
     */
    @Test
    public void testRescueTestTwo(){
        Sanctuary sanct = new Sanctuary(100, 50);
        assertEquals("Should be 1 animal that cannot be rescued", 
                        sanct.rescue("Zebra", 101), 1);
        assertEquals("Sanctuary should have 100 animals",
                        sanct.getTotalAnimals(),100);
        assertEquals("Sanctuary should have 100 zebras", 
                        sanct.getNum("Zebra"), 100);
    }

    /**
     * Test the release method when null species arg
     */
    @Test
    public void testReleaseTestOne(){
        boolean exCaught = false;
        Sanctuary sanct = new Sanctuary(10, 5);
        try{
            sanct.release(null, 5);
        } catch (IllegalArgumentException e){
            exCaught = true;
        }
        assertTrue("null species arg and num > 0 should throw exception",
                        exCaught);

    }

    /**
     * Test the release method when an entire species is deleted
     */
    @Test
    public void testReleaseTestTwo(){
        Sanctuary sanct =  new Sanctuary(60, 20);
        sanct.rescue("Zebra", 10);
        sanct.rescue("Lion", 5);
        sanct.rescue("Penguin", 15);

        sanct.release("Lion", 5);

        assertFalse("Lion should be deleted", sanct.sanctuary.containsKey("Lion"));

        assertEquals("Number of animals should be 25",
                        sanct.getTotalAnimals(), 25);
        
        assertEquals("Number of species should be 2",
                        sanct.getTotalSpecies(), 2);

    }
}

