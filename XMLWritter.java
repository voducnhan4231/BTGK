package BTGK;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class XMLWriter {
    public static void writeResultToFile(List<Student> students, List<Student> processedStudents, List<Student> primeCheckedStudents, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write("<students>\n");

            // Ghi thông tin của từng học sinh
            for (int i = 0; i < students.size(); i++) {
                fileWriter.write("  <student>\n");
                fileWriter.write("    <id>" + students.get(i).getId() + "</id>\n");
                fileWriter.write("    <name>" + students.get(i).getName() + "</name>\n");
                fileWriter.write("    <address>" + students.get(i).getAddress() + "</address>\n");
                fileWriter.write("    <age>" + processedStudents.get(i).getAge() + "</age>\n");
                fileWriter.write("    <sum>" + processedStudents.get(i).getSum() + "</sum>\n");
                fileWriter.write("    <digit>" + processedStudents.get(i).getEncodedDigits() + "</digit>\n");
                fileWriter.write("    <prime>" + primeCheckedStudents.get(i).isPrime() + "</prime>\n");
                fileWriter.write("  </student>\n");
            }

            fileWriter.write("</students>");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
