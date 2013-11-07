/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author Lucho
 */
public class Day {
    private String weekDay;
    private ArrayList<Slot> slots = new ArrayList<Slot>();

    public void setSlots(ArrayList<Slot> slots) {
        this.slots = slots;
    }

    public ArrayList<Slot> getSlots() {
        return slots;
    }

    public void setWeekDay(String weekDay) {
        this.weekDay = weekDay;
    }


    public String getWeekDay() {
        return weekDay;
    }

   
}
