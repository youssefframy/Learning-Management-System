package Classes;

public abstract class Person {

    protected int id;
    protected String username;
    protected String password;
    protected String fname;
    protected String lname;
    protected int age;

    //TODO department var

    static MyException MyEX = new MyException();

    //TODO filemanager var

    public Person(){
    }

    public Person(int id, String username, String password, String fname, String lname, int age) { //TODO missing department
        if (id <= 0)
            this.id = MyEX.checkPositive("ID");
        else
            this.id = id;

        if (!username.contains("@") || !username.contains("."))
            this.username = MyEX.checkEmail("UserName");
        else
            this.username = username;

        if (password.length() < 8)
            this.password = MyEX.checkPassLength("Password");
        else
            this.password = password;

        this.fname = fname;
        this.lname = lname;

        if (age <= 0)
            this.id = MyEX.checkPositive("Age");
        else
            this.age = age;
    }

    public abstract String toString();

    public void setID(int id){
        if (id <= 0)
            this.id = MyEX.checkPositive("ID");
        else
            this.id = id;
    }

    public void setFName(String fname){
        this.fname = fname;
    }

    public void setLName(String lname){
        this.lname = lname;
    }

    public void setUsername(String username) {
        if (!username.contains("@") || !username.contains("."))
            this.username = MyEX.checkEmail("UserName");
        else
            this.username = username;
    }

    public void setPassword(String password) {
        if (password.length() < 8)
            this.password = MyEX.checkPassLength("Password");
        else
            this.password = password;
    }

    public void setAge(int age){
        if (age <= 0)
            this.id = MyEX.checkPositive("Age");
        else
            this.age = age;
    }

    //TODO setDepartment

    public int getID(){
        return this.id;
    }

    public String getFName(){
        return this.fname;
    }

    public String getLName(){
        return this.lname;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public int getAge(){
        return this.age;
    }

    //TODO getDepartment

    public abstract boolean login(String username, String password);
}
