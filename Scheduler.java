/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucho
 */
public class Scheduler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        try 
        {
            URLList urlList = new URLList();
            for(int i = 0; i< urlList.getNumURLs(); i++)
            {
                String url = urlList.getURL(i);
                URL xmlurl = new URL(url);
                System.out.println();
                String sub = url.substring(56,65);
                System.out.println(sub + " : ");
               // System.out.println();
               Schedule schedule = new Schedule(xmlurl);
             //schedule.
               // print the information
               // calculate if there is a meeting time
               
            }
        } catch (Exception ex) {
            Logger.getLogger(Scheduler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
