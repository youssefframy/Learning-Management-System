package Classes;

import java.util.ArrayList;

public class Assignment {
    private String AName;
    private String AType;
    private String ADueDate;

    FileManger FManger = new FileManger();
    private final String AssignmentFileName = "Assignments.txt";

    Course course ;
    public Department dept = Main.general;

    public static ArrayList<Assignment> Assignments = new ArrayList<Assignment>();

    public Assignment(){
    }

    public Assignment(String AName,String AType,String ADueDate,Course course){
        this.AName = AName;
        this.AType = AType;
        this.ADueDate = ADueDate ;
        this.course = course;
    }

    public void setAName(String AName){
        this.AName = AName;
    }

    public String getAName() {
        return this.AName;
    }

    public void setAType(String AType){
        this.AType = AType ;
    }

    public String getAType(){
        return this.AType;
    }

    public void setADueDate(String ADueDate){
        this.ADueDate = String.valueOf(ADueDate);
    }

    public String getADueDate(){
        return this.ADueDate;
    }

    public void setDept(Department dept){
        this.dept = dept;
    }

    public Department getDept(){
        return dept;
    }

    public boolean addAssignment(){
        if (FManger.write(getAssignmentData(), AssignmentFileName,true)) {
            return true;
        }
        else {
            return false;
        }
    }

    private String getAssignmentData(){
        return this.AName + "#" + this.AType + "#" + this.ADueDate +"#" + this.dept.getDeptName() + "#";
    }

    private void commitToFile(){
        FManger.write(Assignments.get(0).getAssignmentData(),AssignmentFileName,false);
        for (int i = 1; i<Assignments.size();i++){
            FManger.write(Assignments.get(i).getAssignmentData(), AssignmentFileName,true);
        }
    }

    private int getAssignmentIndex(String name){
        for(int i=0; i<Assignments.size();i++)
            if(Assignments.get(i).getAName().equals(AName))
                return i;
        return -1;
    }

    private void loadFromFile(){
        Assignments = (ArrayList<Assignment>) (Object) FManger.read(AssignmentFileName);
    }

    public String displayAllAssignments(){
        loadFromFile();
        String S = "\nAll Courses Data:\n";
        for(Assignment x : Assignments){
            S = S + x.toString();
        }
        return S ;
    }

    public Assignment searchAssignment(String name){
        Assignment temp = new Assignment();
        loadFromFile();
        int index = getAssignmentIndex(name);
        if(index != -1)
            return Assignments.get(index);
        else
            return temp;
    }

    public boolean updateAssignment(String oldName,Assignment x){
        loadFromFile();
        int index = getAssignmentIndex(oldName);
        if (index != -1) {
            Assignments.set(index, x);
            commitToFile();
            return true;
        }
        else{
            return false;
        }
    }

    public boolean deleteAssignment(String name){
        loadFromFile();
        int index = getAssignmentIndex(name);
        if (index != -1) {
            Assignments.remove(index);
            commitToFile();
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString(){
        return "\nAssignment Name : " + AName + "\tAssignment Type : " + AType + "\nAssignment Due Date : " + ADueDate ;
    }

    public ArrayList<Assignment> listAssignmets() {
        loadFromFile();
        return Assignments;
    }
}





