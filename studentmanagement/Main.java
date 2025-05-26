package studentmanagement;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("abc", "Jair");
        student.addGrade(100.0);
        student.addGrade(90.0);
        student.calculateAverage();
        student.checkHonorStatus();
        student.removeGrade(9);
        student.reportCard();
    }
}
