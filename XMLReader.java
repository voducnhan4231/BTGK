package BTGK;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {
    public static List<Student> readStudentsFromFile(String fileName) throws IOException {
        List<Student> students = new ArrayList<>();

        try {
            File file = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("student");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String id = element.getAttribute("id");
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                String address = element.getElementsByTagName("address").item(0).getTextContent();
                String dateOfBirth = element.getElementsByTagName("dateOfBirth").item(0).getTextContent();
                students.add(new Student(id, name, address, dateOfBirth));
            }
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }

        return students;
    }
}
