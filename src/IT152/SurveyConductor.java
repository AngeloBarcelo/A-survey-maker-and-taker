/* This is just a simple survey taker. The first user enters the number of 
 * questions and people taking the survey. Then hands the survey off to the 
 * people taking the survey. The results are provided in grid form and allows 
 * the user to review the answers provided for a particular question.
 */

package IT152;

import java.util.Scanner;
import IT152.Survey;

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
        System.out.println("Hello there! Would you like to enter a custom title " +
                           "for the survey you are about to create?");
        
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
        System.out.println();
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
                int response=0;

                //Calls the logResponse method with what was entered and in the loop
                newSurvey.logResponse (qustionNumb, respondentCounter, response);
            }    
        }
        
        System.out.println();
        
        //Calls the displaySurveyResults method
        newSurvey.displaySurveyResults();
        
        System.out.println();
        
        //Sets variable entered to 0 to prep for the validation loop
        int entered =0;
        
        System.out.println("Would you like to see all of the answers provided to " +
                           "one particulr question?");
        
        Scanner questionReview = new Scanner(System.in);
        
        String showQuestion = questionReview.next();
        
        /* If the user enters any version of "y" or "yes" the first statment is 
        true and calls the overloaded Survery method and sets the new survey 
        title. If anything else is entered the default survey method is called*/
        if (showQuestion.equalsIgnoreCase("y")||showQuestion.equalsIgnoreCase("yes"))
        {
            System.out.println();
            //Calls the displayQuestionStats method
            newSurvey.displayQuestionStats(entered);   
        }
        System.out.println();
        //Calls the topRatedQuestion method
        newSurvey.topRatedQuestion();
        
        //Calls the lowRatedQuestion question
        newSurvey.lowRatedQuestion();
        
        //Prints a nice goodbye message with the survey title 
        System.out.println(String.format("\nThank you for partisipating in %s " +
                            "\nHave a nice day", newSurvey.getSurveyTitle()));                   
    }
}
    
    
