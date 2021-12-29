package Classes;

import java.util.ArrayList;

public class Lecture {
    private String LName;
    private String LNumber;
    private String LDate;

    FileManger FManger = new FileManger();
    private final String LectureFileName = "Lectures.txt";

    Course course;
    public Department dept = Main.general;
    public static ArrayList<Lecture> Lectures = new ArrayList<Lecture>();

    public Lecture(){
    }

    public Lecture(String LName , String LNumber , Course course){
        this.LName =LName;
        this.LNumber = LNumber;
        this.course = course ;
    }

    public void setLName(String LName){
        this.LName = LName ;
    }

    public String getLName() {
        return LName;
    }

    public void setLNumber(String LNumber) {
        this.LNumber = LNumber;
    }

    public String getLNumber() {
        return LNumber;
    }

    public void setLDate(String LDate){
        this.LDate = LDate ;
    }

    public String getLDate(){
        return LDate;
    }

    public void setDept(Department dept){
        this.dept = dept;
    }

    public Department getDept(){
        return this.dept;
    }

    public boolean addLecture(){
        if (FManger.write(getLectureData(),LectureFileName,true)){
            return true;
        }
        else {
            return false;
        }
    }

    private String getLectureData(){
        return this.LName + "#" + this.LNumber +"#" + this.dept.getDeptName() + "#" + this.LDate + "#";
    }

    private void commitToFile(){
        FManger.write(Lectures.get(0).getLectureData(),LectureFileName,false);
        for (int i = 1;i<Lectures.size();i++){
            FManger.write(Lectures.get(i).getLectureData(),LectureFileName,true);
        }
    }

    private int getLectureIndex(String LNumber){
        for(int i = 0;i< Lectures.size();i++)
            if(Lectures.get(i).getLNumber().equals(LNumber))
                return i;
        return -1;
    }

    private void loadFromFile(){
        Lectures = (ArrayList<Lecture>) (Object) FManger.read(LectureFileName);
    }

    public String displayAllLectures(){
        loadFromFile();
        String S = "\nAll Lectures Data :\n";
        for (Lecture x : Lectures){
            S = S + x.toString();
        }
        return S;
    }

    public Lecture searchLecture(String number){
        Lecture temp = new Lecture();
        loadFromFile();
        int index = getLectureIndex(number);
        if(index != -1)
            return Lectures.get(index);
        else
            return temp;
    }

    public ArrayList<Lecture> listLectures() {
        loadFromFile();
        return Lectures;
    }

    public boolean updateLecture(String oldNumber, Lecture x) {
        loadFromFile();
        int index = getLectureIndex(oldNumber);
        if (index != -1) {
            Lectures.set(index, x);
            commitToFile();
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteLecture(String Lnumber){
        loadFromFile();
        int index = getLectureIndex(Lnumber);
        if (index != -1) {
            Lectures.remove(index);
            commitToFile();
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public String toString(){
        return "\nLecture Name : " + LName + "\tLecture Number : " + LNumber + "\n" ;
    }

}

