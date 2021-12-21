package FCIHCaseStudy;

import java.io.Serializable;

/**
 *
 * @author Tamer A.Yassen
 */
public class Exam implements Serializable {

    private String EName, EId;
    private double MaxGrade;

    FileManger FManger = new FileManger();
    private final String ExamsFileName = "Exams.txt";

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

    public void setMaxGrade(double MaxGrade) {
        this.MaxGrade = MaxGrade;
    }

    public String getEName() {
        return this.EName;
    }

    public String getEId() {
        return this.EId;
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
        return this.EName + "@" + this.EId + "@" + this.MaxGrade + "@";
    }

    @Override
    public String toString() {
        return "Exam Name : " + EName + "\t" + "Exam ID : " + EId + "\n" + "Exam Max Grade : " + MaxGrade + "\n";
    }

}
