package BTGK;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderThread extends Thread {
    private String fileName;
    private List<Student> students;

    public FileReaderThread(String fileName) {
        this.fileName = fileName;
        students = new ArrayList<>();
    }

    @Override
    public void run() {
        // Đọc file student.xml và lấy thông tin học sinh
        // Triển khai logic đọc file và tạo danh sách học sinh
        // Ví dụ:
        try {
            students = XMLReader.readStudentsFromFile(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getStudents() {
        return students;
    }
}
