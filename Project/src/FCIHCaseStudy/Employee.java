package FCIHCaseStudy;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Tamer A.Yassen
 */
public class Employee extends Staff implements Serializable {

    private final String EmpFileName = "Employee.bin";

    public static ArrayList<Employee> Employees = new ArrayList<Employee>();

    public Employee() {
    }

    public Employee(String user, String pass, int id, String fname, String lname, int age, double salary, Department dept) {
        super(user, pass, id, fname, lname, age, salary, dept);
    }

    public boolean addEmp() {
        loadFromFile();
        Employees.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManger.write(EmpFileName, Employees);
    }

    public void loadFromFile() {
        Employees = (ArrayList<Employee>) FManger.read(EmpFileName);
    }

    private int getEmpIndex(int id) {
        for (int i = 0; i < Employees.size(); i++) {
            if (Employees.get(i).getID() == id) {
                return i;
            }
        }

        return -1;
    }

    public Employee searchEmpById(int id) {
        Employee temp = new Employee();
        loadFromFile();
        int index = getEmpIndex(id);
        if (index != -1) {
            return Employees.get(index);
        } else {
            return temp;
        }
    }

    public ArrayList<Employee> listEmployees() {
        loadFromFile();
        return Employees;
    }

    public boolean updateEmp() {
        loadFromFile();
        int index = getEmpIndex(this.id);

        if (index != -1) {
            Employees.set(index, this);

            return commitToFile();
        }

        return false;
    }

    public boolean deleteEmp(int id) {
        loadFromFile();
        int index = getEmpIndex(id);

        if (index != -1) {
            Employees.remove(index);

            return commitToFile();
        }

        return false;
    }

    @Override
    public String toString() {
        return "\nI'm Student Affairs Emp : " + fname + " " + lname + "\n" + "ID : " + id + " Age : " + age + " Salary : " + salary + "\n" + "Dept. : " + myDept.getDeptName() + "\nUserName: " + userName + "\t Password: " + pass + "\n";
    }

    @Override
    public boolean login(String userName, String Pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
