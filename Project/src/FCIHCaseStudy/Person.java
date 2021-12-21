package FCIHCaseStudy;

import java.io.Serializable;

/**
 *
 * @author Tamer A.Yassen
 */
public abstract class Person implements Serializable {

    protected int id;
    protected String userName;
    protected String pass;
    protected String fname;
    protected String lname;
    protected int age;
    public Department myDept = Main.general;

    FileMangerBinary FManger = new FileMangerBinary();

    static MyException MyEX = new MyException("Tamer Exception");

    public Person() {
    }

    public Person(String user, String pass, int id, String fname, String lname, int age, Department dept) {
        /*     
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.age = age;
        this.userName = user;
        this.pass = pass;
        this.myDept = dept;
         */

        if (id < 0) {
            this.id = MyEX.checkPositive("ID");
        } else {
            this.id = id;
        }
        this.fname = fname;
        this.lname = lname;

        if (age < 0) {
            this.age = MyEX.checkPositive("Age");
        } else {
            this.age = age;
        }

        if (!user.contains("@") || !user.contains(".")) {
            this.userName = MyEX.checkEmail("User name");
        } else {
            this.userName = user;
        }

        if (pass.length() < 8) {
            this.pass = MyEX.checkPassLength("Password");
        } else {
            this.pass = pass;
        }

        this.myDept = dept;
    }

    @Override
    public abstract String toString();

    //setter
    public void setID(int id) {
        this.id = id;
    }

    public void setFName(String fname) {
        this.fname = fname;
    }

    public void setLName(String lname) {
        this.lname = lname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setDept(Department dept) {
        this.myDept = dept;
    }

    //getter
    public String getuserName() {
        return this.userName;
    }

    public String getPass() {
        return this.pass;
    }

    public int getID() {
        return this.id;
    }

    public String getFName() {
        return this.fname;
    }

    public String getLName() {
        return this.lname;
    }

    public int getAge() {
        return this.age;
    }

    public abstract boolean login(String userName, String Pass);
}
