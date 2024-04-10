package BTGK;

import java.util.ArrayList;
import java.util.List;

public class AgeCalculatorThread extends Thread {
    private List<Student> students;
    private List<Student> processedStudents;


    public AgeCalculatorThread() {
        processedStudents = new ArrayList<>();
    }

    @Override
    public void run() {
        // Tính toán tuổi và mã hóa chữ số
        // Triển khai logic tính toán và mã hóa chữ số
        // Ví dụ:
        for (Student student : students) {
            student.calculateAgeAndEncodeDigits();
            processedStudents.add(student);
        }
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Student> getProcessedStudents() {
        return processedStudents;
    }
}
