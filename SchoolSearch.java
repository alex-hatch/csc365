import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SchoolSearch {

    public static void main(String[] args) throws IOException {
        ArrayList<Student> students = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader("/Users/alexhatch/Desktop/Code/Poly/src/students.txt"));
        String line = br.readLine();
        while(line != null) {
            String[] lineSplit = line.split(",");
            Student s = new Student(lineSplit[0], lineSplit[1], Integer.parseInt(lineSplit[2]), Integer.parseInt(lineSplit[3]), Double.parseDouble(lineSplit[4]), lineSplit[5], lineSplit[6]);
            students.add(s);
            line = br.readLine();
        }

    }

}

class Student {
    private final String stLastName;
    private final String stFirstName;
    private final int grade;
    private final int classroom;
    private final double gpa;
    private final String tLastName;
    private final String tFirstName;

    public Student(String stLastName, String stFirstName, int grade, int classroom, double gpa, String tLastName, String tFirstName) {
        this.stLastName = stLastName;
        this.stFirstName = stFirstName;
        this.grade = grade;
        this.classroom = classroom;
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

    public double getGpa() {
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
