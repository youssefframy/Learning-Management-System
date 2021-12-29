package Classes;

public class Admin extends Staff{

    public Admin(){

    }

    public Admin(int id, String username, String password, String fname, String lname, int age, Department dept, double salary){
        super(id, username, password, fname, lname, age, dept, salary);
    }

    @Override
    public String toString(){
        return "I'm Manager: " + fname + " " + lname + "\n" + "ID: " + id + "\n" + "Age: " + age + "\n" +
                "Department: " + myDept.getDeptName() + "Username: " + username + "\n" +
                "Password: " + password + "\n";
    }

    public boolean login(String username, String password){
        if(username.equals("Admin@yahoo.com") && password.equals("12345678"))
            return true;
        else
            return false;
    }
}
