/* This is just a simple survey taker. The first user enteres the number of 
 * questions and people taking the surevey. Then hands the surevey off to the 
 * peopele takign the survey. The results are provided in  grid form and allows 
 * the user to review the answers provided for a particulare question.
 */

package IT152;

import java.util.Scanner;
import IT152.Survey;
import java.util.Arrays;

/*
 * @author Angelo Barcelo 
 * IT152-1503A-01: Introduction to Java Programming II
 * Student ID: 19313797 
 * angelobarcelo@hotmail.com
 */
public class SurveyConductor
    {
    public static void main(String[] args)
        {
        Survey newSurvey = new Survey();
        
        //Prints welcoming message and asks if they want to add custom survey title
        System.out.println("Hello there survey maker. Would you like to add a " +
                         "custom title for your survey?");
        
        Scanner YesNo = new Scanner(System.in);
        
        String customTitle = YesNo.next();
        
        /* If the user enters any version of "y" or "yes" the first statment is 
        true and calls the overloaded Survery method and sets the new survey 
        title. If anything else is entered the default survey method is called*/
        if (customTitle.equalsIgnoreCase("y")||customTitle.equalsIgnoreCase("yes"))
            {
            System.out.println("Sounds good! What would you like to call this " +
                               "survey?");
            
            Scanner newSurveyTitle = new Scanner (System.in);
            
            String surveyTile =  newSurveyTitle.nextLine();

            newSurvey = new Survey(surveyTile);
            }
        else 
            {
            newSurvey = new Survey();
            }
        
        //Displays title of survey.This confirms what method was called
        System.out.printf("Got it, going forward this survey will be " +
                              "titled: %s\n", newSurvey.getSurveyTitle());
        
        //Calls the enterQuestions method
        newSurvey.enterQuestions();
        
        /* Loops to go through the number of respondentd and the number of 
         * questions to present the question and display the question number to 
         * the user */
        for (int respondentCounter =1; respondentCounter<newSurvey.numberOfRespondentsGet()+
             1; respondentCounter++ )
            {
            for (int qustionNumb =0; qustionNumb <newSurvey.numberOfQuestionsGet();qustionNumb++ )
                {
                newSurvey.generateRespondentsId ();
                
                newSurvey.presentQuestion(qustionNumb,respondentCounter);
                
                //Sets variable response to 0 to prep for the validation loop
                int response =0;
                
                /*validates the user response to that it is 1-5 */
                do
                    {
                    System.out.println("Please enter numbered response 1-5");
                    Scanner rating = new Scanner(System.in);
                    response = rating.nextInt();
                    } 
                while (response<1||response>5);
             
                //Calls the logResponse method with what was entered and in the loop
                newSurvey.logResponse (qustionNumb, respondentCounter, response);
                }    
            }
        //Calls the displaySurveyResults method
        newSurvey.displaySurveyResults();
        
        //Sets variable entered to 0 to prep for the validation loop
        int entered =0;
        
        //Validates what is being enterd from 1 to the number of questions prev entered
        while (entered < 1 ||entered > newSurvey.numberOfQuestionsGet())
            {
            System.out.println("What question would you like to review the results for?");
        
            Scanner displayResults = new Scanner (System.in);
            
            entered =  displayResults.nextInt();
            }
        
        //Calls the displayQuestionStats method
        newSurvey.displayQuestionStats(entered);
        
        //Calls the topRatedQuestion method
        newSurvey.topRatedQuestion();
        
        //Calls the lowRatedQuestion question
        newSurvey.lowRatedQuestion();
        
        //Prints a nice goodbye message with the survey title 
        System.out.println (String.format("Thank you for partisipating in %s " +
                            "\nHave a nice day", newSurvey.getSurveyTitle()));                   
        }
    }
    
    
