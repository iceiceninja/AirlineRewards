/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airlineflightrewards;
import java.util.ArrayList;

/**
 *
 * @author Josh Bonham
 * @version 1.0.0
 */
public class AirlineRewardsMember {
    /**creates an arraylist of flightDates*/
    ArrayList<String> flightDates = new ArrayList<>();
    /**creates an arraylist of flightmiles*/
    ArrayList<Integer> flightMiles = new ArrayList<>();
    
    /**Creates variable to hold */
    String id;
    
    AirlineRewardsMember(String date, String id, String miles)
    {
        
        this.flightDates.add(date);
        this.id = id;
        this.flightMiles.add(Integer.parseInt(miles));
        
    }
    /**
     * returns this objects i
     * @return d
     */
    public String getId()
    {
        return this.id;
    }
    
    /**Adds miles and date to list of miles and date
     * @param date
     * @param miles
    */
    public void newFlight(String date, String miles)
    {
        flightDates.add(date);
        flightMiles.add(Integer.parseInt(miles));
    }
    
    /**
     * Adds up all of the miles in the flightMiles for this object 
       @return sumMiles
    */
    public int totalMiles()
    {
        int sumMiles = 0;
        for(int mileNum : flightMiles)
        {
            sumMiles += mileNum;
        }
        return sumMiles;
    }
    
    /**
     * Returns date that this member joined
     * @return d
     */
    public String joinDate()
    {
        return flightDates.get(0);
    }
    
    /**
     * Calculates how many miles this member has flown in a year
     * 
     * @param year
     * @return sumMiles
     */
    public int milesInYear(String year)
    {
        int sumMiles = 0;
        int counter = 0;
        for(String flight : flightDates)
        {
            String currFlightYear = flight.split("-")[0];
            if(year.equals(currFlightYear))
            {
               sumMiles += flightMiles.get(counter);
            }
            counter++;
        }
        return sumMiles;
    }
    
    //Determines what reward tier that the member falls into based on given year
    public String rewardTier(String year)
    {
        int prevYear = Integer.parseInt(year)-1;
        int miles = milesInYear(String.valueOf(prevYear));
        if(miles < 25000)
        {
        return "No Teir";
        } else if(miles < 50000)
        {
        return "Gold";
        } else if(miles < 75000)
        {
        return "Platinum";
        } else if(miles < 100000)
        {
        return "Platinum Pro";
        } else if(miles < 150000)
        {
        return "Executive Platinum";
        } else if(miles >= 150000)
        {
        return "Super Executive Platinum";
        }
        return "Error: Reward Tier not found";
    }

}
