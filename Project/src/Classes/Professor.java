package Classes;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Professor extends Staff implements Serializable {

    private String officeHours;

    private final String professorFileName = "Professor.txt";

    public static ArrayList<Professor> Professors = new ArrayList<Professor>();

    public Professor() {
    }

    public Professor(String username, String password, int id, String fname, String lname, int age, double salary, String officeHours, Department dept) {
        super(id, username, password, fname, lname, age, dept, salary);

        this.officeHours = officeHours;
    }

    public void setOfficeHours(String h) {
        this.officeHours = h;
    }

    public String getOfficeHours() {
        return this.officeHours;
    }

    public boolean addProf() {
        if (FManger.write(getProfData(), professorFileName, true)) {
            return true;
        } else {
            return false;
        }
    }
    private String getProfData() {
        return this.id + "#" + this.fname + "#" + this.lname + "#" + this.age + "#" + this.salary + "#" + this.officeHours + "#" + this.myDept.getDeptName() + "#" + this.username + "#" + this.password + "#" + this.isBlocked + "#";
    }

    public void commitToFile() {
        FManger.write(Professors.get(0).getProfData(), professorFileName, false);
        for (int i = 1; i < Professors.size(); i++) {
            FManger.write(Professors.get(i).getProfData(), professorFileName, true);
        }
    }

    public ArrayList<Professor> listProfs() {
        loadFromFile();
        return Professors;
    }

    public void loadFromFile() {
        Professors = (ArrayList<Professor>)(Object) FManger.read(professorFileName);
    }

    private int getProfIndex(int id) {
        for (int i = 0; i < Professors.size(); i++) {
            if (Professors.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public Professor searchProfById(int id) {
        Professor temp = new Professor();
        loadFromFile();
        int index = getProfIndex(id);
        if (index != -1) {
            return Professors.get(index);
        } else {
            return temp;
        }
    }


    public boolean updateProf(int oldID, Professor x){
        loadFromFile();
        int index = getProfIndex(oldID);
        if (index != -1) {
            Professors.set(index, x);
            commitToFile();
            return true;
        }
        return false;
    }



    public boolean deleteProf(int oldID){
        loadFromFile();
        int index = getProfIndex(oldID);
        if (index != -1) {
            Professors.remove(index);
            commitToFile();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nI'm Prof : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : " + officeHours + "\n" + "Dept. : " + myDept.getDeptName() + "\nUserName: " + username + "\t Password: " + password + "\n";
    }

    public void teach() {
        System.out.println("I'm Teaching all Lectures !");
    }

    @Override
    public boolean login(String username, String password) {
        loadFromFile();
        for(Professor x : Professors){
            if(username.equals(x.getUsername()) && password.equals(x.getPassword()) && x.isBlocked1().equals("false"))
                return true;
        }
//        JOptionPane.showMessageDialog(null, "This account isn't available or is blocked");
        return false;
    }

}


