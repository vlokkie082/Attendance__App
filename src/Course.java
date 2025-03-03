import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Course with multiple Students.
 * This class allows adding students, retrieving them by seat number,
 * and displaying the list of enrolled students.
 */
public class Course {
    /** The name of the course. */
    private String courseName;

    /** List of students enrolled in the course. */
    private final List<Student> students;

    /**
     * Default constructor that initializes the course with an "Unknown" name
     * and an empty student list.
     */
    public Course() {
        courseName = "Unknown";
        students = new ArrayList<>();
    }

    /**
     * Overloaded constructor that sets the course name.
     *
     * @param courseName The name of the course.
     * @throws Exception If the course name is blank.
     */
    public Course(String courseName) throws Exception {
        this();
        setCourseName(courseName);
    }

    /**
     * Retrieves the course name.
     *
     * @return The name of the course.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Sets the course name, ensuring it is not blank.
     *
     * @param courseName The new name for the course.
     * @throws Exception If the provided course name is blank.
     */
    public void setCourseName(String courseName) throws Exception {
        courseName = courseName.trim();
        if (courseName.isBlank()) {
            throw new Exception("Course name cannot be blank.");
        }
        this.courseName = courseName;
    }

    /**
     * Retrieves a student by their seat number.
     *
     * @param seatNumber The seat number of the student.
     * @return The Student object if found, otherwise null.
     * @throws Exception If an error occurs during retrieval.
     */
    public Student getStudent(int seatNumber) throws Exception {
        for (Student student : students) {
            if (student.getSeatNumber() == seatNumber) {
                return student;
            }
        }
        return null;
    }

    /**
     * Adds a student to the course with a specified seat number.
     * Ensures that no two students have the same seat number.
     *
     * @param name The name of the student.
     * @param seatNumber The seat number of the student.
     * @throws Exception If the seat number is already assigned.
     */
    public void addStudent(String name, int seatNumber) throws Exception {
        if (getStudent(seatNumber) != null) {
            throw new Exception("Seat #" + seatNumber + " is already assigned!");
        }
        students.add(new Student(name, seatNumber));
    }

    /**
     * Displays the list of students in the course, showing their details.
     */
    public void displayStudents() {
        System.out.println("Course: " + courseName);
        for (Student student : students) {
            student.displayStudent();
        }
    }
}


