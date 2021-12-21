package FCIHCaseStudy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Tamer A.Yassen
 */
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
                String[] seprated = Line.split("@");

                // 20140011@Ahmed@Ali@20@2@3.5@CS@STU_1@12345678@
                x.setID(Integer.parseInt(seprated[0]));
                x.setFName(seprated[1]);
                x.setLName(seprated[2]);
                x.setAge(Integer.parseInt(seprated[3]));
                x.setLevel(Integer.parseInt(seprated[4]));
                x.setGPA(Double.parseDouble(seprated[5]));

                if (seprated[6].equals("CS")) {
                    x.setDept(Main.cs);
                } else if (seprated[6].equals("IS")) {
                    x.setDept(Main.is);
                } else if (seprated[6].equals("IT")) {
                    x.setDept(Main.it);
                } else if (seprated[6].equals("SW")) {
                    x.setDept(Main.sw);
                }

                x.setUserName(seprated[7]);
                x.setPass(seprated[8]);

                Students.add(x);
            }

            return (ArrayList<Object>) (Object) Students;

        } else if (FilePath.equals("Professor.txt")) {

            ArrayList<Professor> Professors = new ArrayList<Professor>();
            Professor x;

            while (Reader.hasNext()) {

                x = new Professor();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

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

                x.setUserName(seprated[7]);
                x.setPass(seprated[8]);

                Professors.add(x);
            }

            return (ArrayList<Object>) (Object) Professors;

        } else if (FilePath.equals("TA.txt")) {

            ArrayList<TeachingAssistant> TAs = new ArrayList<TeachingAssistant>();
            TeachingAssistant x;

            while (Reader.hasNext()) {

                x = new TeachingAssistant();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

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

                x.setUserName(seprated[7]);
                x.setPass(seprated[8]);

                TAs.add(x);
            }

            return (ArrayList<Object>) (Object) TAs;

        } else if (FilePath.equals("Employee.txt")) {

            ArrayList<Employee> Employees = new ArrayList<Employee>();
            Employee x;

            while (Reader.hasNext()) {

                x = new Employee();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                // 1@Shaima@Ali@35@3500.0@SA@SA_1@12345678@
                x.setID(Integer.parseInt(seprated[0]));
                x.setFName(seprated[1]);
                x.setLName(seprated[2]);
                x.setAge(Integer.parseInt(seprated[3]));
                x.setSalary(Double.parseDouble(seprated[4]));

                if (seprated[5].equals("SA")) {
                    x.setDept(Main.sa);
                }

                x.setUserName(seprated[6]);
                x.setPass(seprated[7]);

                Employees.add(x);
            }

            return (ArrayList<Object>) (Object) Employees;

        } else if (FilePath.equals("Courses.txt")) {

            ArrayList<Course> Courses = new ArrayList<Course>();
            Course x;

            while (Reader.hasNext()) {

                x = new Course();
                String Line = Reader.nextLine();
                String[] seprated = Line.split("@");

                // PL2@CS213@100@
                x.setCname(seprated[0]);
                x.setCId(seprated[1]);
                x.setCreditHours(Integer.parseInt(seprated[2]));

                Courses.add(x);
            }

            return (ArrayList<Object>) (Object) Courses;

        } else {
            return null;
        }

    }

}
