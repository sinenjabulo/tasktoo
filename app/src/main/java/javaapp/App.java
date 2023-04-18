/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaapp;
import java.util.*;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.*;
//import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }
    
    //output only the user-selected fields from the file, Task 2.2
    public static void UserFieldValue(String field){

        try {
            // Step 1: Parse the XML file
            File file = new File("C:/Users/g20g3211/SDP/task2/app/src/main/resources/data.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            // Step 2: Retrieve the field values
            NodeList nodeList = doc.getElementsByTagName(field);
            if (nodeList.getLength() > 0) {
                for (int i = 0; i < nodeList.getLength(); i++) {
                    Node node = nodeList.item(i);
                    if (node.getNodeType() == Node.ELEMENT_NODE) {
                        Element element = (Element) node;
                        System.out.println(field + " (" + (i + 1) + "): " + element.getTextContent());
                    }
                }
            } else {
                System.out.println("Field not found in the XML file.");
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        
        String fieldName = "name";
        
        System.out.println(new App().getGreeting());
       
        new App().UserFieldValue(fieldName);                                                                //Task 2.2
                                                                    
    }

}