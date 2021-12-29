package Classes;

import java.util.ArrayList;

public class Course {
    private String CName ;
    private String CId ;
    private int CreditHours ;

    FileManger FManger = new FileManger();
    private final String CourseFileName = "Courses.txt" ;

    public Department dept = Main.general;
//    Exam finalExam ;

    public static ArrayList<Course> Courses = new ArrayList<Course>();

    public Course() {
    }

    public Course(String CId){
        this.CId = CId;
    }

    public Course(String CName,String CId,int CreditHours,Department dept) {
        this.CName = CName;
        this.CId = CId;
        this.CreditHours = CreditHours;
        this.dept = dept;

//        finalExam = new Exam(CName + " Final Exam", CId + " 01", 100);
//        System.out.println("\n" + finalExam.toString() + "Added Successfully");
//        finalExam.addExam();
    }

    public void setCName(String CName){
        this.CName = CName ;
    }

    public String getCName(){
        return this.CName ;
    }

    public void setCId(String CId){
        this.CId = CId ;
    }

    public String getCId(){
        return this.CId ;
    }

    public void setCreditHours(int CreditHours){
        this.CreditHours = CreditHours ;
    }

    public int getCreditHours() {
        return this.CreditHours;
    }

    public void setDept(Department dept){
        this.dept = dept ;
    }

    public boolean addCourse(){
        if (FManger.write(getCourseData(), CourseFileName, true)){
            return true ;
        }
        else {
            return false ;
        }
    }

    private String getCourseData(){
        return this.CName + "#" + this.CId + "#" + this.CreditHours + "#" + this.dept.getDeptName() + "#";
    }

    private void commitToFile(){
        FManger.write(Courses.get(0).getCourseData(), CourseFileName, false);
        for (int i = 1; i< Courses.size();i++){
            FManger.write(Courses.get(i).getCourseData(),CourseFileName, true);
        }
    }

    private int getCourseIndex(String id){
        for (int i = 0; i< Courses.size();i++){
            if(Courses.get(i).getCId().equals(id))
                return i;
        }
        return -1;
    }

    private void loadFromFile(){
        Courses = (ArrayList<Course>) (Object) FManger.read(CourseFileName);
    }

    public String displayAllCourses(){
        loadFromFile();
        String S = "\nAll Courses Data:\n" ;
        for (Course x : Courses){
            S = S + x.toString();
        }
        return S ;
    }

    public Course searchCourse(String id){
        Course temp = new Course();
        loadFromFile();
        int index = getCourseIndex(id);
        if(index != -1)
            return Courses.get(index);
        else
            return temp;
    }

    public ArrayList<Course> listCourses() {
        loadFromFile();
        return Courses;
    }

    public boolean updateCourse(String oldID, Course x){
        loadFromFile();
        int index = getCourseIndex(oldID);
        if (index != -1) {
            Courses.set(index, x);
            commitToFile();
            return true;
        }
        return false;
    }

    public boolean deleteCourse(String id){
        loadFromFile();
        int index = getCourseIndex(id);
        if (index != -1) {
            Courses.remove(index);
            commitToFile();
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "\nCourse Name : " + CName + "\tCourse ID : " + CId + "Course Credit Hours : " + CreditHours + "\n" ;
    }
}

