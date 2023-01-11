/**
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class Student extends Person{
    private int grade;
    public Student(String firstName, String lastName, String phoneNumber, int theGrade)
    {
        super(firstName, lastName, phoneNumber);
        grade = theGrade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
