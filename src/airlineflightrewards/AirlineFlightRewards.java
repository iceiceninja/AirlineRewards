/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airlineflightrewards;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author Josh Bonham
 * @version 1.0.0
 * 
 * This class stores the main functionality of the program
 * It is used to pilot and loop through the queries and their results
 */
public class AirlineFlightRewards {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * 
     */
    public static void main(String[] args) throws IOException {        
        /**Create a scanner*/
        Scanner scnr = new Scanner(System.in);
        
        /**Creating a boolean to see if the user still wishes to be in
         the program or not*/
        boolean inProgram = true;
        
        /** Create arraylist to add members to*/ 
        ArrayList<AirlineRewardsMember> airlineMembers = new ArrayList<AirlineRewardsMember>();
        
        /**creates a variable that holds the current year while also filling
        the member array list with correct member data*/
        int currYear = LoadMemberData(scnr, airlineMembers);
        
        /**Main program loop*/
        while(inProgram)
        {
            /** List of queries for the user to respond to */
         System.out.println("Hello rewards member! Please press a key to "
                 + "choose an option from the menu below.");
         System.out.println("---------------------------");
         System.out.println("Press 0 | to quit");
         System.out.println("Press 1 | for questions about the rewards program");
         System.out.println("Press 2 | to access the membership menu");
         System.out.println("---------------------------");
         
         /** Taking in the user's response */
         String input = scnr.nextLine();
         
         /** Checking to see what to do with user response */
            switch (input) {
                case "1":
                    /**Runs reward query method that will walk 
                    user through prompts dealing with reward tiers */
                    RewardQuery(scnr);
                    break;
                case "2":
                    /**Runs user through member query*/
                    MemberQuery(scnr,airlineMembers,currYear);
                    break;
                case "0":
                    /**Breaks user out of loop*/
                    inProgram = false;
                    break;
                default:
                    /**If input isnt valid it returns an error message*/
                    System.out.println("Input not recognized. Please try again");
                    break;
            }
       }
    }
    /**Takes user through queries about the reward tiers*/
    private static void RewardQuery(Scanner scnr)
    {
        /**boolean to test if user wishes to be in program*/
        boolean inProgram = true;
        
        /**main loop*/
        while(inProgram){
            /**Ask user a series of prompts*/
        System.out.println("Welcome to our Rewards catalog!\n"
                + "Press a key to select from the menu below.");
        System.out.println("---------------------------");
            System.out.println("Press 0 | to quit");
            System.out.println("Press 1 | to view Gold Member perks");
            System.out.println("Press 2 | to view Platinum Member perks");
            System.out.println("Press 3 | to view Platinum Pro perks");
            System.out.println("Press 4 | to view Executive Platinum perks");
            System.out.println("Press 5 | to view Super Executive Platinum perks");
            System.out.println("---------------------------");
            
            /**Based on user input will choose a proper action to take*/
            switch(scnr.nextLine())
            {
               case "0":
                   /**Exits program*/
                   inProgram = false;
                   break;
               case "1":
                   /**Explains perks of Gold member*/
                   System.out.println("Gold passengers get special perks such as a seat to sit in during the flight.");
                   System.out.println("Press Enter to go back to menu");
                   scnr.nextLine();
                   break;
               case "2":
                   /**Explains perks of Platinum member*/
                   System.out.println("Along with all of the perks from the previous tiers, \n "
                           + "Platinum passengers get complementary upgrades to padded seats");
                   System.out.println("Press Enter to go back to menu");
                   scnr.nextLine();
                   break;
               case "3":
                   /**Explains perks of Platinum pro member*/
                   System.out.println("Along with all of the perks from the previous tiers,\n"
                           + " Platinum Pro is a special sub-tier of Platinum,\n"
                           + " in which the padded seats include arm rests");
                   System.out.println("Press Enter to go back to menu");
                   scnr.nextLine();
                   break;
               case "4":
                   /**Explains perks of Executive Platinum member*/
                   System.out.println("Along with all of the perks from the previous tiers, \n"
                           + "Executive Platinum passengers enjoy perks such as complementary \n"
                           + "upgrades from the cargo hold to main cabin.");
                   System.out.println("Press Enter to go back to menu");
                   scnr.nextLine();
                   break;
               case "5":
                   /**Explains perks of Super Executive Platinum member*/
                   System.out.println("Along with all of the perks from the previous tiers,\n"
                           + " Super Executive Platinum is a special sub-tier of Executive Platinum, reserved for the most loyal passengers.\n "
                           + "To save costs, airline management decided to eliminate the position of co-pilot,\n "
                           + "instead opting to reserve the co-pilot's seat for Super Executive Platinum passengers.");
                   System.out.println("Press Enter to go back to menu");
                   scnr.nextLine();
                   break;
               default:
                   /**Ask for different input*/
                   System.out.println("Input not recognized. Please try again.");
                   break;
            }
        }
    }
    private static void MemberQuery(Scanner scnr, ArrayList<AirlineRewardsMember> airlineMembers, int currYear)
    {
        /**Determines if user wishes to be in program*/
        boolean inProgram = true;
        while(inProgram)
        {
            /** Prompt user for input */
            System.out.println("Enter a member ID or Enter 0 to exit:");
            
            /**creates variable to hold user input*/
            String input = scnr.nextLine();
              if(input.equals("0"))
              {
                  /**exit program*/
                  inProgram = false;
              }else{
                for(AirlineRewardsMember member : airlineMembers)
                {
                    /**Compare user input to member ID*/
                    if(input.equals(member.getId()))
                    {
                        
                        System.out.println("Member Found");
                        
                        /**Found member*/
                        boolean inMemberQuery = true;
                        System.out.println("Hello member " + member.getId());
                        
                        /** Loop for member queries*/
                        while(inMemberQuery)
                        {
                            System.out.println("Please choose an option from the list below");
                            System.out.println("---------------------------");
                            System.out.println("Press 0 | Quit");
                            System.out.println("Press 1 | Miles accumulated in the current year.");
                            System.out.println("Press 2 | Total miles accumulated since joining the rewards program");
                            System.out.println("Press 3 | Join date of the rewards program");
                            System.out.println("Press 4 | Current reward tier");
                            System.out.println("Press 5 | Reward tier of specific year");
                            System.out.println("---------------------------");
                            
                            /**Decides what to do based on user input*/
                            switch(scnr.nextLine())
                            {
                                case "1":
                                    System.out.println("This year you have flown " + member.milesInYear(String.valueOf(currYear)) + " miles!");                                    
                                    System.out.println("Press Enter to go back.");
                                    scnr.nextLine();
                                    break;
                                case "2":
                                    System.out.println("You have flown " +member.totalMiles()+ " miles since joining our rewards program!");
                                    System.out.println("Press Enter to go back.");
                                    scnr.nextLine();
                                    break;
                                case "3":
                                    System.out.println("You joined " + member.joinDate());
                                    System.out.println("Press Enter to go back.");
                                    scnr.nextLine();
                                    break;
                                case "4":
                                    int prevYear = currYear -1;
                                    System.out.println("The year before this you flew " + member.milesInYear(String.valueOf(prevYear)) + " miles!"); 
                                    System.out.println("That makes you a " + member.rewardTier(String.valueOf(currYear)) + " member!");
                                    System.out.println("Press Enter to go back.");
                                    scnr.nextLine();
                                    break;
                                case "5":
                                    System.out.println("Enter year:");
                                    String year = scnr.nextLine();
                                    prevYear =Integer.parseInt(year)-1;
                                    System.out.println("In the year prior to  " + year + " you accumulated " + member.milesInYear(String.valueOf(prevYear)));
                                    System.out.println("Which made you a " + member.rewardTier(year) + " member!");
                                    System.out.println("Press Enter to go back.");
                                    scnr.nextLine();
                                    break;
                                case "0":
                                    inMemberQuery = false;
                                    break;
                                default:
                                    System.out.println("Invalid input, please try again.");
                                    System.out.println("Press Enter to go back.");
                                    scnr.nextLine();
                            }
                        }
                    }
                } 
            }
        }
    }
    
    /**Gets a file and loads member data from it*/
    private static int LoadMemberData(Scanner scnr, ArrayList<AirlineRewardsMember> airlineMembers) throws IOException
    {
        /**Creates current year variable*/
        int currYear = 0;
        
        /**Get input file*/
        File input = new File("./input.txt");
        
        /** Create fileReader to read from the input file*/
        Scanner fileReader = new Scanner(input);
        
        /**Loops through each line in file while there are next lines*/
        while(fileReader.hasNextLine())
        {
            boolean userFound = false;
            String data = fileReader.nextLine();
            String[] userData = data.split(" ");
            for(AirlineRewardsMember member : airlineMembers)
            {
                /** Loops through each member to compare the id to existing Id*/
                if(userData[1].equals(member.getId()))
                {
                    /**If member exists  then add miles and flight date to you*/
                    member.newFlight(userData[0],userData[2]);
                    userFound = true; 
                }
            }
            
            /** If user has not been added to airlineRewardsMember list then add it*/
            if(!userFound){
                AirlineRewardsMember newMember = new AirlineRewardsMember(userData[0],userData[1],userData[2]);
                airlineMembers.add(newMember);
            }
            
            /**parses date to get current year*/
            int year = Integer.parseInt(userData[0].split("-")[0]);
            if(currYear < year)
            {
                currYear = year;
            }
        }
        return currYear;
    }
    
}
