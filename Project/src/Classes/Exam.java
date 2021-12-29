package Classes;

import java.io.Serializable;
import java.util.ArrayList;




public class Exam implements Serializable {

    private static void add(Exam aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void set(int index, Exam aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static Exam get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String EName, EId, EQuestions, EAnswer, CourseName;
    private double MaxGrade;

    FileManger FManger = new FileManger();
    private final String ExamsFileName = "Exams.txt";
    private int EDate;
    public Department dept;
    private ArrayList<Exam> Exams;
    private ArrayList<Object> Exam;

    public Exam() {
        
    }

    public Exam(String EName, String EId, double MaxGrade) {
        this.EName = EName;
        this.EId = EId;
        this.MaxGrade = MaxGrade;
    }

    public void setEName(String EName) {
        this.EName = EName;
    }

    public void setEId(String EId) {
        this.EId = EId;
    }
    
    public void setEDate(int EDate){
        this.EDate = EDate;
    }
    
     public void setDept(Department d) {
        this.dept = d;
    }
    
    public void setEQuestions(String EQuestions){
        this.EQuestions = EQuestions;
    }
    
    public void setEAnswer(String EAnswer){
        this.EAnswer = EAnswer;
    }
    
    public void setCourse(String CourseName){
        this.CourseName = CourseName;
    }

    public void setMaxGrade(double MaxGrade) {
        this.MaxGrade = MaxGrade;
    }

    public String getEName() {
        return this.EName;
    }

    public String getEId() {
        return this.EId;
    }
    
    public String getEQuestions(){
        return this.EQuestions;
    }

    public int getEDate() {return this.EDate;}

    public  String getCourse(){
        return this.CourseName;
    }
    
    public double getMaxGrade() {
        return this.MaxGrade;
    }

    public boolean addExam() {
        if (FManger.write(getExamData(), ExamsFileName, true)) {
            return true;
        } else {
            return false;
        }
    }

    private String getExamData() {
        return this.EName + "#" + this.EId + "#" + this.EDate + "#" + this.CourseName + "#" + this.dept.getDeptName()+ "#";
    }

    private int getExamIndex(String id) {
        for (int i = 0; i < Exams.size(); i++) {
            if (Exams.get(i).getEId().equals(id)) {
                return i;
            }
        }

        return -1;
    }

    public Exam searchExamById(String id) {
        Exam temp = new Exam();
        int index = getExamIndex(id);
        if (index != -1) {
            return (Exam) Exam.get(index);
        } else {
            return temp;
        }
    }

    private void loadFromFile() {Exams = (ArrayList<Exam>) (Object) FManger.read(ExamsFileName);}


    public ArrayList<Exam> listExams() {
        return Exams;
    }

    public boolean updateExam(String oldID, Exam x){
        loadFromFile();
        int index = getExamIndex(oldID);
        if (index != -1) {
            Exams.set(index, x);
            commitToFile();
            return true;
        }
        return false;
    }

    private void commitToFile(){
        FManger.write(Exams.get(0).getExamData(), ExamsFileName, false);
        for (int i = 1; i< Exams.size();i++){
            FManger.write(Exams.get(i).getExamData(),ExamsFileName, true);
        }
    }

    @Override
    public String toString() {
        return "Exam Name : " + EName + "\t" + "Exam ID : " + EId + "\n" + "Exam Max Grade : " + MaxGrade + "\n";
    }

}
