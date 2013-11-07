/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Lucho
 */
public class URLList 
{
    private String urls[] = new String[4];
    /**
     *
     */
    public URLList() 
    {
         try        
        {
            File abc=new File("E:\\CMUA\\Trial\\src\\java\\urlList.xml");
            DocumentBuilder db=DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc=db.parse(abc);
            doc.getDocumentElement().normalize();
           System.out.println("Java Scheduler");
            System.out.println("Loading 4 Schedules");
            System.out.println();
            NodeList n=doc.getElementsByTagName("URLList");
            for(int i=0;i< n.getLength();i++)
            {
               Node node=n.item(i);
                   Element e=(Element)node;               
                  urls[0]= e.getElementsByTagName("URL").item(0).getTextContent();
                urls[1]= e.getElementsByTagName("URL").item(1).getTextContent();
                urls[2]=e.getElementsByTagName("URL").item(2).getTextContent();
                 urls[3]= e.getElementsByTagName("URL").item(3).getTextContent();
            }
        }
        catch(Exception ee)
        {
            System.out.println("Here is an exception, Anoop" +  ee);
        }
        
    }
     public int getNumURLs() throws Exception 
     {
      return urls.length;
     }
    public String getURL(int i) throws Exception 
    {
       
        return urls[i];
        
    }
    
}
