
package calculadoraempleado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alecs
 */
public class Main {

    public static void main(String[] args) {
        
        File file = null; //---> a variable of type File with null value is created
        
        try {
            
         //FILE OPENING
         file = new File ("EmpleadosHorarios.txt"); //----> initialize the file with its path
         Scanner scan = new Scanner(file); //---> scan the file
        
         //READING THE FILE
         
         //This loop reads every line of text in the file until there is no left to read
         while(scan.hasNextLine()){
            
            String line = scan.nextLine(); //----> nextLine to read the text line
         
            String l = (String)line; //----> converts the line of text into a character string
            
            //Regular expressions to match strings. It includes two classes: Pattern and Matcher.
            //remove whitespace from string
            Pattern p = Pattern.compile("[\\s]"); 
            Matcher m = p.matcher(l);
            String result = m.replaceAll("");
            
            // Text line interaction
            System.out.println(result); // Example:  RENE=MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00
            
            //The next threes lines of code convert the string into an array separated by the symbol "=", 
            //in order to have the names of the days-hours separately.
            ArrayList<String> list = new ArrayList<String>(Arrays.asList(result.split("="))); //Example: [RENE , MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00]           
            String name = list.get(0); //Example: RENE
            String daysHours = list.get(1);  //Example: MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00
            
            //Converts the string of dayshours to an array
            ArrayList<String> workWeek = new ArrayList<String>(Arrays.asList(daysHours.split(","))); //[MO10:00-12:00,TU10:00-12:00,TH01:00-03:00,SA14:00-18:00,SU20:00-21:00]
            
            //Counter to accumulate the salary of each day of the week worked from the workWeek list
            int totalSalary = 0;
            
            //Each item in the workWeek list is traversed
            for(int i=0;i<workWeek.size();i++){
                
                //A String variable is initialized to save the traversed string, the day with the hours worked
                String dayHours = workWeek.get(i); //MO10:00-12:00
                
                //substring to save the day
                String day = dayHours.substring(0, 2); // MO
                
                //substring to save the hours
                String hours = dayHours.substring(2,dayHours.length()); // 10:00-12:00
                
                
                //The string "hours" is separated into substrings to get the entry time and exit time.
                ArrayList<String> HorarioInicioFin = new ArrayList<String>(Arrays.asList(hours.split("-"))); //Example: [10:00,12:00]
                String hourStart = (HorarioInicioFin.get(0)).substring(0,2); //Example: 10
                String hourEnd = (HorarioInicioFin.get(1)).substring(0,2); //Example: 12
                
                //The input and output time variables are converted to integers
                //This to be able to calculate the hours worked in the day.
                int hourStartInteger = Integer.parseInt(hourStart);
                int hourEndInteger = Integer.parseInt(hourEnd);
                
                //conditional to differentiate the salary change that occurs when it is not a weekend.
                //         --------- Monday - Friday ---------
                if ( day.equals("MO")|| day.equals("TU")|| day.equals("WE")|| day.equals("TH")|| day.equals("FR")){
                    
                    // range [00:01 - 09:00]  $ 25 USD
                    if (0 < hourStartInteger  && hourEndInteger <= 9){
                        
                        //The total value of the hours of the day is the subtraction 
                        //between the departure time minus the entry time
                        //then it is multiplied by the value of the hours in the established range ($ 25) 
                        //And added to the variable "totalSalary"
                        int Totalhours = hourEndInteger - hourStartInteger;
                        int salary = Totalhours * 25;
                        totalSalary = totalSalary + salary;
                        
                    } 
                    else if ( 9 < hourStartInteger && hourEndInteger <= 18){
                        int Totalhours = hourEndInteger - hourStartInteger;
                        int salary = Totalhours * 15;
                        
                        totalSalary = totalSalary + salary;
                    }
                    else if ( 18 < hourStartInteger && hourEndInteger <= 24){
                        
                        if ( hourEndInteger == 0 ){
                            int Totalhours = 24 - hourStartInteger;
                            int salary = Totalhours * 20;
                            
                            totalSalary = totalSalary + salary;
                        }
                        else if ( hourEndInteger !=0 ){
                            int Totalhours = hourEndInteger - hourStartInteger;
                            int salary = Totalhours * 20;
                            
                            totalSalary = totalSalary + salary;
                        }
                        
                    }
                    
                }
                //conditional to differentiate the salary change that occurs when it is a weekend
                else if ( day.equals("SA")|| day.equals("SU")){
                    
                    
                    if (0 < hourStartInteger  && hourEndInteger <= 9){
                        int Totalhours = hourEndInteger - hourStartInteger;
                        int salary = Totalhours * 30;
                        
                        totalSalary = totalSalary + salary;
                    } 
                    else if ( 9 < hourStartInteger && hourEndInteger <= 18){
                        int Totalhours = hourEndInteger - hourStartInteger;
                        int salary = Totalhours * 20;
                        
                        totalSalary = totalSalary + salary;
                    }
                    else if ( 18 < hourStartInteger && hourEndInteger <= 24){
                        
                        if ( hourEndInteger == 0 ){
                            int Totalhours = 24 - hourStartInteger;
                            int salary = Totalhours * 25;
                            
                            totalSalary = totalSalary + salary;
                        }
                        else if ( hourEndInteger !=0 ){
                            int Totalhours = hourEndInteger - hourStartInteger;
                            int salary = Totalhours * 25;
                            
                            totalSalary = totalSalary + salary;
                        }
                        
                    }
                }
                
            }
            
            //a sentence is printed on the screen with the name of the employee together with the salary
            System.out.println("The amount to pay "+ name +" is: " + totalSalary + " USD");
         }
        scan.close();
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
}
