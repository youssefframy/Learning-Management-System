package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;


public class FileManger implements Serializable {

    public boolean write(String Query, String FilePath, boolean appendType) {

        PrintWriter writter = null;
        try {
            System.out.print("\nwritting in ! " + FilePath);

            writter = new PrintWriter(new FileWriter(new File(FilePath), appendType));
            writter.println(Query);

            System.out.println(" ... Done ! ");
            return true;
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            writter.close();
        }
        return false;
    }

    public ArrayList<Object> read(String FilePath) {
        // Scanner input = new Scanner(System.in);

        Scanner Reader = null;
        try {
            System.out.println("Reading ! From " + FilePath);

            Reader = new Scanner(new File(FilePath));

        } catch (FileNotFoundException e) {
            System.out.println(e);
        }

        if (FilePath.equals("Students.txt")) {

            ArrayList<Student> Students = new ArrayList<Student>();
            Student x;

            while (Reader.hasNext()) {

                x = new Student();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("#");

//                this.id + "#" + this.username + "#" + this.password + "#" + this.fname + "#"
//                        + this.lname + "#" + this.age + "#" + myDept.getDeptName() + "#"
//                        + this.level + "#" + this.gpa + "#";
                // 20140011@Ahmed@Ali@20@2@3.5@CS@STU_1@12345678@
                x.setID(Integer.parseInt(seprated[0]));
                x.setUsername(seprated[1]);
                x.setPassword(seprated[2]);
                x.setFName(seprated[3]);
                x.setLName(seprated[4]);
                x.setAge(Integer.parseInt(seprated[5]));
                x.setLevel(Integer.parseInt(seprated[7]));
                x.setGpa(Double.parseDouble(seprated[8]));

                x.setBlocked1(seprated[9]);

                if (seprated[6].equals("CS")) {
                    x.setDept(Main.cs);
                } else if (seprated[6].equals("IS")) {
                    x.setDept(Main.is);
                } else if (seprated[6].equals("IT")) {
                    x.setDept(Main.it);
                } else if (seprated[6].equals("SW")) {
                    x.setDept(Main.sw);
                }

                x.setBlocked1(seprated[9]);


                Students.add(x);
            }

            return (ArrayList<Object>) (Object) Students;

        } else if (FilePath.equals("Professor.txt")) {

            ArrayList<Professor> Professors = new ArrayList<Professor>();
            Professor x;

            while (Reader.hasNext()) {

                x = new Professor();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("#");

                // 1@Ayman@Ezzat@30@8000.0@Mon 12pm to 2pm@CS@Prof_1@12345678@
                x.setID(Integer.parseInt(seprated[0]));
                x.setFName(seprated[1]);
                x.setLName(seprated[2]);
                x.setAge(Integer.parseInt(seprated[3]));
                x.setSalary(Double.parseDouble(seprated[4]));
                x.setOfficeHours(seprated[5]);

                if (seprated[6].equals("CS")) {
                    x.setDept(Main.cs);
                } else if (seprated[6].equals("IS")) {
                    x.setDept(Main.is);
                } else if (seprated[6].equals("IT")) {
                    x.setDept(Main.it);
                } else if (seprated[6].equals("SW")) {
                    x.setDept(Main.sw);
                }

                x.setUsername(seprated[7]);
                x.setPassword(seprated[8]);

                x.setBlocked1(seprated[9]);

                Professors.add(x);
            }

            return (ArrayList<Object>) (Object) Professors;

        } else if (FilePath.equals("TA.txt")) {

            ArrayList<TA> TAs = new ArrayList<TA>();
            TA x;

            while (Reader.hasNext()) {

                x = new TA();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("#");

                // 1@Tamer@Yassen@25@5000.0@Sun 10am to 12pm@CS@TA_1@12345678@
                x.setID(Integer.parseInt(seprated[0]));
                x.setFName(seprated[1]);
                x.setLName(seprated[2]);
                x.setAge(Integer.parseInt(seprated[3]));
                x.setSalary(Double.parseDouble(seprated[4]));
                x.setacademicHours(seprated[5]);

                if (seprated[6].equals("CS")) {
                    x.setDept(Main.cs);
                } else if (seprated[6].equals("IS")) {
                    x.setDept(Main.is);
                } else if (seprated[6].equals("IT")) {
                    x.setDept(Main.it);
                } else if (seprated[6].equals("SW")) {
                    x.setDept(Main.sw);
                }

                x.setUsername(seprated[7]);
                x.setPassword(seprated[8]);

                TAs.add(x);
            }

            return (ArrayList<Object>) (Object) TAs;

        } else if (FilePath.equals("Courses.txt")) {

            ArrayList<Course> Courses = new ArrayList<Course>();
            Course x;

            while (Reader.hasNext()) {

                x = new Course();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("#");

                // PL2@CS213@100@
                x.setCName(seprated[0]);
                x.setCId(seprated[1]);
                x.setCreditHours(Integer.parseInt(seprated[2]));
                if (seprated[3].equals("CS")) {
                    x.setDept(Main.cs);
                } else if (seprated[3].equals("IS")) {
                    x.setDept(Main.is);
                } else if (seprated[3].equals("IT")) {
                    x.setDept(Main.it);
                } else if (seprated[3].equals("SW")) {
                    x.setDept(Main.sw);
                }

                Courses.add(x);
            }

            return (ArrayList<Object>) (Object) Courses;

        } else if (FilePath.equals("RegisteredCourses.txt")) {

            ArrayList<RegisteredCourse> RegisteredCourse = new ArrayList<Classes.RegisteredCourse>();
            Classes.RegisteredCourse x;

            while (Reader.hasNext()) {

                x = new RegisteredCourse();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("#");

                x.setStudentID(Integer.parseInt(seprated[0]));
                x.setCName(seprated[1]);
                x.setCId(seprated[2]);
                x.setCreditHours(Integer.parseInt(seprated[3]));

                if (seprated[4].equals("CS")) {
                    x.setDept(Main.cs);
                } else if (seprated[4].equals("IS")) {
                    x.setDept(Main.is);
                } else if (seprated[4].equals("IT")) {
                    x.setDept(Main.it);
                } else if (seprated[4].equals("SW")) {
                    x.setDept(Main.sw);
                }


                RegisteredCourse.add(x);
            }

            return (ArrayList<Object>) (Object) RegisteredCourse;

        } else if (FilePath.equals("Lectures.txt")) {

            ArrayList<Lecture> Lectures = new ArrayList<Lecture>();
            Lecture x;

            while (Reader.hasNext()) {

                x = new Lecture();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("#");

                x.setLName(seprated[0]);
                x.setLNumber(seprated[1]);
                x.setLDate(seprated[3]);

                if (seprated[2].equals("CS")) {
                    x.setDept(Main.cs);
                } else if (seprated[2].equals("IS")) {
                    x.setDept(Main.is);
                } else if (seprated[2].equals("IT")) {
                    x.setDept(Main.it);
                } else if (seprated[2].equals("SW")) {
                    x.setDept(Main.sw);
                }

                Lectures.add(x);
            }
            return (ArrayList<Object>) (Object) Lectures;
        } else if (FilePath.equals("Assignments.txt")) {

            ArrayList<Assignment> Assignments = new ArrayList<Assignment>();
            Assignment x;

            while (Reader.hasNext()) {

                x = new Assignment();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("#");

                x.setAName(seprated[0]);
                x.setAType(seprated[1]);
                x.setADueDate(seprated[2]);

                if (seprated[2].equals("CS")) {
                    x.setDept(Main.cs);
                } else if (seprated[2].equals("IS")) {
                    x.setDept(Main.is);
                } else if (seprated[2].equals("IT")) {
                    x.setDept(Main.it);
                } else if (seprated[2].equals("SW")) {
                    x.setDept(Main.sw);
                }

                Assignments.add(x);
            }
            return (ArrayList<Object>) (Object) Assignments;
        }else if (FilePath.equals("Exams.txt")){
            ArrayList<Exam> Exams = new ArrayList<Exam>();
            Exam x;

            while (Reader.hasNext()) {
                x = new Exam();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("#");

                //return this.EName + "#" + this.EId + "#" + this.EDate + "#" + this.CourseName + "#" + this.dept.getDeptName()+ "#";
                x.setEName(seprated[0]);
                x.setEId(seprated[1]);
                x.setEDate(Integer.parseInt(seprated[2]));
                x.setCourse(seprated[3]);
                if (seprated[4].equals("CS")) {
                    x.setDept(Main.cs);
                } else if (seprated[4].equals("IS")) {
                    x.setDept(Main.is);
                } else if (seprated[4].equals("IT")) {
                    x.setDept(Main.it);
                } else if (seprated[4].equals("SW")) {
                    x.setDept(Main.sw);
                }


                Exams.add(x);
            }





            return (ArrayList<Object>) (Object) Exams;
        }else {
            return null;
        }

    }

}
