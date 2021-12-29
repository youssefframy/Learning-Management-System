/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author menam
 */
public class TA extends Staff implements Serializable {

    private String academicHours;

    private final String TAFileName = "TA.txt";

    public static ArrayList<TA> TAs = new ArrayList<TA>();

    public TA() {
    }

    public TA(int id, String username, String password, String fname, String lname, int age, Department dept, double salary){
        super(id, username, password, fname, lname, age, dept, salary);
        this.academicHours = academicHours;
    }

    public void setacademicHours(String h) {
        this.academicHours = h;
    }

    public String getacademicHours() {
        return this.academicHours;
    }

    public boolean addTA() {
        if (FManger.write(getTAData(), TAFileName, true)) {
            return true;
        } else {
            return false;
        }
    }

    private String getTAData() {
    return this.id + "#" + this.fname + "#" + this.lname + "#" + this.age + "#" + this.salary + "#" + this.academicHours + "#" + this.myDept.getDeptName() + "#" + this.username + "#" + this.password + "#";
    }
       
    public void commitToFile() {
        FManger.write(TAs.get(0).getTAData(), TAFileName, false);
        for (int i = 1; i < TAs.size(); i++) {
            FManger.write(TAs.get(i).getTAData(), TAFileName, true);
        }
    }

    public void loadFromFile() {
            TAs = (ArrayList<TA>) (Object) FManger.read(TAFileName);
    }

    private int getTAIndex(int id) {
        for (int i = 0; i < TAs.size(); i++) {
            if (TAs.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public TA searchTAsById(int id) {
        TA temp = new TA();
        loadFromFile();
        int index = getTAIndex(id);
        if (index != -1) {
            return TAs.get(index);
        } else {
            return temp;
        }
    }

    public ArrayList<TA> listTAs() {
        loadFromFile();
        return TAs;
    }

    public boolean updateTA(int oldId, TA x){
        loadFromFile();
        int index = getTAIndex(oldId);

        if(index != -1){
            TAs.set(index, this);
            commitToFile();
            return true;
        }
        return false;
    }

    public boolean deleteTA(int id){
        loadFromFile();
        int index = getTAIndex(id);

        if(index != -1){
            TAs.remove(index);
            commitToFile();
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\nI'm Teaching Assistant : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : " + salary + "\n" + "Dept. : " + myDept.getDeptName() + "\nUserName: " + username + "\t Password: " + password + "\n";
    }

    public void teach() {
        System.out.println("I'm Teaching all Sections!");
    }

    public void study() {
        System.out.println("I'm Studying Postgraduate Courses @ FCIH :) ");
    }

    @Override
    public boolean login(String userName, String Pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
