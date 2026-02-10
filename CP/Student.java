import java.util.ArrayList;

class Class {
    int id;
    String name;
    double marks;

    public Class() {
    };

    public Class(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}

public class Student {
    public static void main(String[] args) {
        ArrayList<Class> students = new ArrayList<>();

        students.add(new Class(1, "Mayank1", 85.5));
        students.add(new Class(2, "Mayank2", 92.0));
        students.add(new Class(3, "Mayank3", 78.5));
        students.add(new Class(4, "Mayank4", 95.5));
        students.add(new Class(5, "Mayank5", 88.0));

        double averageMarks = calculateAverageMarks(students);
        System.out.println("Average marks: " + averageMarks);

        Class topScorer = findTopScorer(students);
        System.out.println("Top scorer details:");
        System.out.println("ID: " + topScorer.id);
        System.out.println("Name: " + topScorer.name);
        System.out.println("Marks: " + topScorer.marks);
    }

    public static double calculateAverageMarks(ArrayList<Class> students) {
        double sum = 0;
        for (Class student : students) {
            sum += student.marks;
        }
        return sum / students.size();
    }

    public static Class findTopScorer(ArrayList<Class> students) {
        Class topStudent = students.get(0);
        for (Class student : students) {
            if (student.marks > topStudent.marks) {
                topStudent = student;
            }
        }
        return topStudent;
    }
}
