package BTGK;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Khởi tạo và chạy các thread
        FileReaderThread fileReaderThread = new FileReaderThread("student.xml");
        AgeCalculatorThread ageCalculatorThread = new AgeCalculatorThread();
        PrimeCheckerThread primeCheckerThread = new PrimeCheckerThread();

        fileReaderThread.start();
        ageCalculatorThread.start();
        primeCheckerThread.start();

        try {
            // Chờ cho các thread kết thúc
            fileReaderThread.join();
            ageCalculatorThread.join();
            primeCheckerThread.join();

            // Lấy kết quả từ các thread
            List<Student> students = fileReaderThread.getStudents();
            List<Student> processedStudents = ageCalculatorThread.getProcessedStudents();
            List<Student> primeCheckedStudents = primeCheckerThread.getPrimeCheckedStudents();

            // Ghi kết quả vào file kq.xml
            XMLWriter.writeResultToFile(students, processedStudents, primeCheckedStudents, "kq.xml");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
