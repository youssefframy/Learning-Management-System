package Classes;

import java.util.ArrayList;

public class RegisteredCourse extends Course{

    private int studentID;
    private Course c;
    private String courseID;

    Student x = new Student();
    private final String RegisteredCoursesFileName = "RegisteredCourses.txt" ;

    public static ArrayList<RegisteredCourse> RegisteredCourses = new ArrayList<RegisteredCourse>();

    public RegisteredCourse(){

    }
    public RegisteredCourse(String courseID){
        super(courseID);
        c = searchCourse(courseID);
    }
    public void setStudentID(int studentID){
        this.studentID = studentID;
    }

    public int getStudentID(){
        return studentID;
    }

    public void setCId(String CId){
        this.courseID = CId ;
    }

    public boolean addRegisteredCourse(){
        if (FManger.write(getRegisteredCourseData(), RegisteredCoursesFileName, true)){
            return true ;
        }
        else {
            return false ;
        }
    }

    private void loadFromFileReg(){
        RegisteredCourses = (ArrayList<RegisteredCourse>) (Object) FManger.read(RegisteredCoursesFileName);
    }

    public ArrayList<RegisteredCourse> listCoursesReg() {
        loadFromFileReg();
        return RegisteredCourses;
    }

    private String getRegisteredCourseData(){

        return this.studentID + "#" + c.getCName() + "#" + c.getCId() + "#" + c.getCreditHours() + "#" + c.dept.getDeptName();
    }

    private int getRegCourseIndex(int id){
        for (int i = 0; i < RegisteredCourses.size(); i++) {
            if(RegisteredCourses.get(i).getStudentID() == id)
                return i;
        }
        return -1;
    }

//    public RegisteredCourse searchRegCByStudentId(int id){
//        RegisteredCourse temp;
//        loadFromFileReg();
//        temp = new RegisteredCourse();
//        int index = getRegCourseIndex(id);
//        if (index != -1)
//            return RegisteredCourses.get(index);
//        else
//            return temp;
//    }

    public ArrayList<RegisteredCourse> searchRegCByStudentId(int id){
        RegisteredCourse temp;
        loadFromFileReg();
        while(!RegisteredCourses.isEmpty()) {
            temp = new RegisteredCourse();
            int index = getRegCourseIndex(id);
            if (index != -1)
                RegisteredCourses.add(RegisteredCourses.get(index));
        }
        return RegisteredCourses;
    }
}
