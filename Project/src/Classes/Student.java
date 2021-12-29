package Classes;

import javax.swing.*;
import java.util.ArrayList;

public class Student extends Person{

    private int level;
    private double gpa;

    private final String StudentFileName = "Students.txt";

    public static ArrayList<Student> Students = new ArrayList<Student>();

    public Student() {

    }

    public Student(int id, String username, String password, String fname, String lname, int age, Department dept, int level, double gpa){
        super(id, username, password, fname, lname, age, dept);

        this.level = level;
        this.gpa = gpa;
    }

    public void setLevel(int level){
        this.level = level;
    }

    public void setGpa(double gpa){
        this.gpa = gpa;
    }

    public int getLevel(){
        return level;
    }

    public double getGpa(){
        return gpa;
    }

    private String getStudentData(){
        return this.id + "#" + this.username + "#" + this.password + "#" + this.fname + "#"
                + this.lname + "#" + this.age + "#" + myDept.getDeptName() + "#"
                + this.level + "#" + this.gpa + "#" + this.isBlocked + "#";
    }

    public boolean addStudent(){
        if(FManger.write(getStudentData(),StudentFileName,true))
            return true;
        else
            return false;
    }

    protected void commitToFile(){
        FManger.write(Students.get(0).getStudentData(),StudentFileName,false);
        for (int i = 1; i < Students.size(); i++) {
            FManger.write(Students.get(i).getStudentData(),StudentFileName,true);
        }
    }

    private int getStudentIndex(int id){
        for (int i = 0; i < Students.size(); i++) {
            if(Students.get(i).getID() == id)
                return i;
        }
        return -1;
    }

    public void loadFromFile(){
        Students = (ArrayList<Student>) (Object) FManger.read(StudentFileName);
    }

    public Student searchStudentById(int id){
        Student temp = new Student();
        loadFromFile();
        int index = getStudentIndex(id);
        if(index != -1)
            return Students.get(index);
        else
            return temp;
    }

    public ArrayList<Student> listStudents(){
        loadFromFile();
        return Students;
    }

    public boolean updateStudent(int oldId, Student x){
        loadFromFile();
        int index = getStudentIndex(oldId);

        if(index != -1){
            Students.set(index, this);
            commitToFile();
            return true;
        }
        return false;
    }

    public boolean deleteStudent(int id){
        loadFromFile();
        int index = getStudentIndex(id);

        if(index != -1){
            Students.remove(index);
            commitToFile();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nI'm Eng : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + "\n"
                + "Level : " + level + " GPA : " + gpa + "\nDept: " + myDept.getDeptName() + "\nUserName: " + username + "\t Password: " + password + "\n";
    }

    public boolean login(String username, String password){
        loadFromFile();
        for(Student x : Students){
            if(username.equals(x.getUsername()) && password.equals(x.getPassword()) && x.isBlocked1().equals("false"))
                return true;
        }
//        JOptionPane.showMessageDialog(null, "This account isn't available or is blocked");
        return false;
    }
}
//test test