/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Lucho
 */
public class XMLReaderSample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            URL url = new URL("http://www.andrew.cmu.edu/user/mm6/95-702/McCarthysSchedule/schedule1.xml");
            inputStream = url.openStream();
            System.out.println(url);
            XMLInputFactory factory = XMLInputFactory.newFactory();
            //System.out.println(factory);
            XMLStreamReader xmlReader = factory.createXMLStreamReader(inputStream);
          //  System.out.println(xmlReader);
            ArrayList<String> weekDays = new ArrayList<String>();
            weekDays.add("Monday");
            weekDays.add("Tuesday");
            weekDays.add("Wednesday");
            weekDays.add("Thursday");
            weekDays.add("Friday");
            weekDays.add("Saturday");
            weekDays.add("Sunday");
            
            int code = xmlReader.next();
       //     System.out.println(code);
            String weekDay = "";
            String tagName = "";
            String startTime = "";
            String endTime = "";
            while (code != XMLStreamConstants.END_DOCUMENT)
            {
                // .....
                
                //  file://C:/myapplications/urlList.xml
                switch(code)
                {
                    case XMLStreamConstants.START_ELEMENT:
                        tagName = xmlReader.getLocalName();
                       // System.out.println(tagName);
                        if(weekDays.contains(tagName))
                            weekDay = tagName;
                        //System.out.println(weekDay);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        tagName = xmlReader.getLocalName();
                        //System.out.println(tagName);
                        if(tagName.equals("start"))
                            tagName = "";
                        if(tagName.equals("end"))
                            System.out.println(weekDay + ":" + startTime + "-" + endTime);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        if(tagName.equals("start"))
                            startTime = xmlReader.getText();
                        else if (tagName.equals("end"))
                            endTime = xmlReader.getText();
                        //System.out.println("Text: " + text);
                        break;
                }
                code = xmlReader.next();
            }
            
            
            
        } catch (XMLStreamException ex) {
            Logger.getLogger(XMLReaderSample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(XMLReaderSample.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(XMLReaderSample.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(XMLReaderSample.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}




