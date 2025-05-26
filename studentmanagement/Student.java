package studentmanagement;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {
    private static final Logger logger = Logger.getLogger(Student.class.getName());

    String id;
    String name;
    List<Double> grades;
    String pass = "unknown";
    boolean honor;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        grades = new ArrayList<>();
    }

    public void addGrade(Double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        double total = 0;
        for (Double grade : grades) {
            total += grade;
        }
        return grades.isEmpty() ? 0 : total / grades.size();
    }

    public void checkHonorStatus() {
        if (calculateAverage() > 90) {
            honor = true;
        }
    }

    public void removeGrade(int index) {
        if (index >= 0 && index < grades.size()) {
            grades.remove(index);
        } else {
            if (logger.isLoggable(Level.INFO)) {
                logger.warning(String.format("Invalid grade index: %d", index));
            }
        }
    }

    public void reportCard() {
        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format("Student: %s", name));
            logger.info(String.format("ID: %s", id));
            logger.info(String.format("Grades #: %d", grades.size()));
            logger.info(String.format("Average: %.2f", calculateAverage()));
            logger.info(String.format("Honor Roll: %b", honor));
        }
    }
}
