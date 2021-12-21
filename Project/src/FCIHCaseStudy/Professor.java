package FCIHCaseStudy;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Tamer A.Yassen
 */
public class Professor extends Staff implements Serializable {

    private String officeHours;

    private final String professorFileName = "Professor.bin";

    public static ArrayList<Professor> Professors = new ArrayList<Professor>();

    public Professor() {
    }

    public Professor(String user, String pass, int id, String fname, String lname, int age, double salary, String officeHours, Department dept) {
        super(user, pass, id, fname, lname, age, salary, dept);

        this.officeHours = officeHours;
    }

    public void setOfficeHours(String h) {
        this.officeHours = h;
    }

    public String getOfficeHours() {
        return this.officeHours;
    }

    public boolean addProf() {
        loadFromFile();
        Professors.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManger.write(professorFileName, Professors);
    }

    public void loadFromFile() {
        Professors = (ArrayList<Professor>) FManger.read(professorFileName);
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

    public ArrayList<Professor> listProfs() {
        loadFromFile();
        return Professors;
    }

    public boolean updateProf() {
        loadFromFile();
        int index = getProfIndex(this.getID());

        if (index != -1) {
            Professors.set(index, this);

            return commitToFile();
        }

        return false;
    }

    public boolean deleteProf(int id) {
        loadFromFile();
        int index = getProfIndex(id);

        if (index != -1) {
            Professors.remove(index);

            return commitToFile();
        }

        return false;
    }

    @Override
    public String toString() {
        return "\nI'm Prof : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : " + officeHours + "\n" + "Dept. : " + myDept.getDeptName() + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    public void teach() {
        System.out.println("I'm Teaching all Lectures !");
    }

    @Override
    public boolean login(String userName, String Pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
