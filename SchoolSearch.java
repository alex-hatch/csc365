import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SchoolSearch {

    public static void main(String[] args) throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("/Users/alexhatch/Desktop/Code/Poly/src/students.txt"));
        String line = br.readLine();
        while(line != null) {
            String[] lineSplit = line.split(",");
            Student s = new Student(lineSplit[0], lineSplit[1], Integer.parseInt(lineSplit[2]), Integer.parseInt(lineSplit[3]), Integer.parseInt(lineSplit[4]), lineSplit[5], lineSplit[6], lineSplit[7]);
            students.add(s);
            line = br.readLine();
        }


        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter in a command\n>>> ");

        String command = sc.nextLine();

        while(!"Quit".contains(command)) {
            String[] commandSplit = command.split(" ");
            if("Student".contains(commandSplit[0])) {
                if(commandSplit.length == 3 && "Bus".contains(commandSplit[2])) {
                    student(commandSplit[1], students, true);
                } else {
                    student(commandSplit[1], students, false);
                }
            }

            System.out.print(">>> ");
            command = sc.nextLine();
        }

    }

    public static void student(String lastname, ArrayList<Student> students, boolean printBus) {
        for(Student s : students) {
            if(s.getStLastName().equals(lastname)) {
                if(!printBus) {
                    System.out.println("Last name: " + s.getStLastName());
                    System.out.println("First name: " + s.getStFirstName());
                    System.out.println("Grade: " + s.getGrade());
                    System.out.println("Classroom: " + s.getClassroom());
                } else {
                    System.out.println("Last name: " + s.getStLastName());
                    System.out.println("First name: " + s.getStFirstName());
                    System.out.println("Bus route: " + s.getBus());
                }

            }
        }
    }

    public static void teacher(String lastname, ArrayList<Student> students) {

    }

    public static void bus(int busNum, ArrayList<Student> students) {

    }

    public static void grade(int gradeNum) {

    }

    public static void average(int num) {

    }

    public static void info() {

    }

}

class Student {
    private final String stLastName;
    private final String stFirstName;
    private final int grade;
    private final int classroom;
    private final int bus;
    private final String gpa;
    private final String tLastName;
    private final String tFirstName;

    public Student(String stLastName, String stFirstName, int grade, int classroom, int bus, String gpa, String tLastName, String tFirstName) {
        this.stLastName = stLastName;
        this.stFirstName = stFirstName;
        this.grade = grade;
        this.classroom = classroom;
        this.bus = bus;
        this.gpa = gpa;
        this.tLastName = tLastName;
        this.tFirstName = tFirstName;
    }

    public String getStLastName() {
        return stLastName;
    }

    public String getStFirstName() {
        return stFirstName;
    }

    public int getGrade() {
        return grade;
    }

    public int getClassroom() {
        return classroom;
    }

    public int getBus() {
        return bus;
    }

    public String getGpa() {
        return gpa;
    }

    public String gettLastName() {
        return tLastName;
    }

    public String gettFirstName() {
        return tFirstName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stLastName='" + stLastName + '\'' +
                ", stFirstName='" + stFirstName + '\'' +
                ", grade=" + grade +
                ", classroom=" + classroom +
                ", gpa=" + gpa +
                ", tLastName='" + tLastName + '\'' +
                ", tFirstName='" + tFirstName + '\'' +
                '}';
    }
}
