/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.io.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Element;

/**
 *
 * @author Lucho
 */
public class Schedule 
{
    private Day [] days = new Day[7];
    Slot slot[]=new Slot[7];
    public Schedule(URL url)
    {
       InputStream inputStream = null;
        try 
        {   
            inputStream = url.openStream();
            //System.out.println(url);
            XMLInputFactory factory = XMLInputFactory.newFactory();
            //System.out.println(factory);
            XMLStreamReader xmlReader = factory.createXMLStreamReader(inputStream);
           // System.out.println(xmlReader);
            ArrayList<String> weekDays = new ArrayList<String>();
            weekDays.add("Monday");
            weekDays.add("Tuesday");
            weekDays.add("Wednesday");
            weekDays.add("Thursday");
            weekDays.add("Friday");
            weekDays.add("Saturday");
            weekDays.add("Sunday");
            int code = xmlReader.next();
            //System.out.println(code);
            String weekDay = "";
            String tagName = "";
            String startTime = "";
            String endTime = "";
            if(weekDays.contains(weekDay))
            {
                
            }
            while (code != XMLStreamConstants.END_DOCUMENT)
            {
                switch(code)
               {
                    case XMLStreamConstants.START_ELEMENT:
                        tagName = xmlReader.getLocalName();
                        if(weekDays.contains(tagName))
                            weekDay = tagName;
                        
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        tagName = xmlReader.getLocalName();
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
     public void getAvailable(String day)
    {
       
        {
            
        }
    }
}
