import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SchoolSearch {

    public static void main(String[] args) throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/students.txt"));
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

        while(!command.equals("Q") && !command.equals("Quit")) {
            String[] commandSplit = command.split(" ");
            if("Student:".equals(commandSplit[0]) || "S:".equals(commandSplit[0])) {
                if(commandSplit.length == 3 && "Bus".contains(commandSplit[2])) {
                    student(commandSplit[1], students, true);
                } else {
                    student(commandSplit[1], students, false);
                }
            }
            else if("Teacher:".equals(commandSplit[0]) || "T:".equals(commandSplit[0])) {
                teacher(commandSplit[1], students);
            }
            else if(("Grade:".equals(commandSplit[0]) || "G:".equals(commandSplit[0])) && commandSplit.length == 2) {
                grade(Integer.parseInt(commandSplit[1]), students);
            }
            else if("Bus:".equals(commandSplit[0]) || "B:".equals(commandSplit[0])) {
                bus(Integer.parseInt(commandSplit[1]), students);
            }
            else if(("Grade:".equals(commandSplit[0]) || "G:".equals(commandSplit[0])) && commandSplit.length == 3) {
                if ("High".equals(commandSplit[2]) || "H".equals(commandSplit[2])) {
                    gradeHigh(Integer.parseInt(commandSplit[1]), students);
                } else if ("Low".equals(commandSplit[2]) || "L".equals(commandSplit[2])) {
                    gradeLow(Integer.parseInt(commandSplit[1]), students);
                }
            }
            else if("Average:".equals(commandSplit[0]) || "A".equals(commandSplit[0])) {
                average(Integer.parseInt(commandSplit[1]), students);
            }
            else if("Info".equals(commandSplit[0]) || "I".equals(commandSplit[0])) {
                info(students);
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
        for(Student s : students) {
            if(s.gettLastName().equals(lastname)) {
                System.out.println(s.getStLastName()+ ", " + s.getStFirstName());
            }
        }
    }

    public static void bus(int busNum, ArrayList<Student> students) {
        for(Student s : students) {
            if(s.getBus() == busNum) {
                System.out.println(s.getStLastName()+ ", " + s.getStFirstName() + " " + s.getGrade() + " " + s.getClassroom());
            }
        }

    }

    public static void grade(int gradeNum, ArrayList<Student> students) {
        for(Student s : students) {
            if(s.getGrade() == gradeNum) {
                System.out.println(s.getStLastName()+ ", " + s.getStFirstName());
            }
        }
    }

    public static void gradeHigh(int gradeNum, ArrayList<Student> students) {
        double highest = Integer.MIN_VALUE;
        Student highestStudent = null;

        for(Student s : students) {
            if(s.getGrade() == gradeNum) {
                if(Double.parseDouble(s.getGpa()) > highest) {
                    highestStudent = s;
                    highest = Double.parseDouble(s.getGpa());
                }

            }
        }

        assert highestStudent != null;
        printGrade(highestStudent);
    }

    public static void gradeLow(int gradeNum, ArrayList<Student> students) {
        double lowest = Integer.MAX_VALUE;
        Student lowestStudent = null;

        for(Student s : students) {
            if(s.getGrade() == gradeNum) {
                if(Double.parseDouble(s.getGpa()) < lowest) {
                    lowestStudent = s;
                    lowest = Double.parseDouble(s.getGpa());
                }

            }
        }

        assert lowestStudent != null;
        printGrade(lowestStudent);
    }

    public static void average(int num, ArrayList<Student> students) {
        double sumGpa = 0;
        double studentCount = 0.0;
        for(Student s : students) {
            if(s.getGrade() == num) {
                sumGpa += Double.parseDouble(s.getGpa());
                studentCount++;
            }
        }

        System.out.println(num + ": " + (sumGpa / studentCount));

    }

    public static void info(ArrayList<Student> students) {
        int[] gradeCount = new int[7];

        for(Student s : students) {
            gradeCount[s.getGrade()]++;
        }

        for(int i = 0; i < gradeCount.length; i++) {
            System.out.println(i + ": " + gradeCount[i]);
        }
    }

    private static void printGrade(Student s) {
        System.out.println(s.getStLastName() + ", " + s.getStFirstName() + " " + s.getGpa() + " " + s.gettLastName() + ", " + s.gettFirstName() + " " + s.getBus());
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
