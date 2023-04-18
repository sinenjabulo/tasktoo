/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package javaapp;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }
    
    //method that will be used for task 5
    private static class MyHandler extends DefaultHandler {
        private String fieldName;
        private boolean isFieldFound;
        private JSONArray jsonArray;

        public MyHandler(String fieldName) {
            this.fieldName = fieldName;
            this.isFieldFound = false;
            this.jsonArray = new JSONArray();
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equalsIgnoreCase(fieldName)) {
                isFieldFound = true;
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (isFieldFound) {
                String fieldValue = new String(ch, start, length);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put(fieldName, fieldValue);
                jsonArray.put(jsonObject);
                isFieldFound = false;
            }
        }

        public JSONArray getJsonArray() {
            return jsonArray;
        }
    }
    public static void UsingSAXParser(String fieldName){

        try {
                // Step 1: Create SAXParserFactory and SAXParser
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser = factory.newSAXParser();

                // Step 2: Create a custom DefaultHandler to handle SAX events
                MyHandler handler = new MyHandler(fieldName);

                // Step 3: Parse the XML file
                File file = new File("C:/Users/g20g3211/SDP/task2/app/src/main/resources/data.xml");
                parser.parse(file, handler);

                // Step 4: Get the retrieved field values as JSON
                JSONArray jsonArray = handler.getJsonArray();
                if (jsonArray != null) {
                    System.out.println(jsonArray.toString());
                } else {
                    System.out.println("Field not found in the XML file.");
                }
        } 
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    public static void main(String[] args) {
        
        String fieldName = "name";
        
        System.out.println(new App().getGreeting());
       
        new App().UsingSAXParser(fieldName);                                                             
                                                                    
    }

}