package Classes;

public abstract class Staff extends Person {

    protected double salary;

    public Staff(){

    }

    public Staff(int id, String username, String password, String fname, String lname, int age, Department dept, double salary){
        super(id, username, password, fname, lname, age, dept);

        if (salary <= 0)
            this.salary = MyEX.checkPositive("Salary");
        else
            this.salary = salary;

        this.myDept = dept;
    }

    public void setSalary(double salary){
        if (salary <= 0)
            this.salary = MyEX.checkPositive("Salary");
        else
            this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getDepartmentName(){
        return myDept.getDeptName();
    }

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        Staff u = (Staff) o;
        return id == u.id && fname.equals(u.fname) && lname.equals(u.lname) && age == u.age && salary == u.salary && myDept.getDeptName().equals(u.myDept.getDeptName());
    }
}
