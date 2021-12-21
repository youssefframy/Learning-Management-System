package FCIHCaseStudy;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Tamer A.Yassen
 */
public class Student extends Person implements Serializable {

    private int level;
    private double GPA;

    private final String studentFileName = "Students.bin";

    public static ArrayList<Student> Students = new ArrayList<Student>();

    public Student() {

    }

    public Student(String user, String pass, int id, String fname, String lname, int age, int level, double GPA, Department dept) {
        super(user, pass, id, fname, lname, age, dept);

        this.level = level;
        this.GPA = GPA;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public int getLevel() {
        return this.level;
    }

    public double getGPA() {
        return this.GPA;
    }

    public boolean addStudent() {
        loadFromFile();
        Students.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManger.write(studentFileName, Students);
    }

    public void loadFromFile() {
        Students = (ArrayList<Student>) FManger.read(studentFileName);
    }

    private int getStudentIndex(int id) {
        for (int i = 0; i < Students.size(); i++) {
            if (Students.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public Student searchStudentById(int id) {
        Student temp = new Student();
        loadFromFile();
        int index = getStudentIndex(id);
        if (index != -1) {
            return Students.get(index);
        } else {
            return temp;
        }
    }

    public ArrayList<Student> listStudents() {
        loadFromFile();
        return Students;
    }

    public boolean updateStudent() {
        loadFromFile();
        int index = getStudentIndex(this.getID());

        if (index != -1) {
            Students.set(index, this);

            return commitToFile();
        }

        return false;
    }

    public boolean deleteStudent(int id) {
        loadFromFile();
        int index = getStudentIndex(id);

        if (index != -1) {
            Students.remove(index);

            return commitToFile();
        }

        return false;
    }

    @Override
    public String toString() {
        return "\nI'm Eng : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + "\n"
                + "Level : " + level + " GPA : " + GPA + "\nDept: " + myDept.getDeptName() + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    public void study() {
        System.out.println("I'm Studying Undergraduate Courses @ FCIH :) ");
    }

    @Override
    public boolean login(String userName, String Pass) {
        loadFromFile();
        for (Student x : Students) {
            if (userName.equals(x.userName) && Pass.equals(x.pass)) {
                return true;
            }
        }
        return false;
    }
}
