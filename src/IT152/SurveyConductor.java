/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT152;

import java.util.Scanner;
import IT152.Survey;
import java.util.Arrays;

/**
 *
 * @author Truth
 */
public class SurveyConductor
    {
   
    /**
     * @param args the command line arguments
     */
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
        
        newSurvey.enterQuestions();
        for (int respondentCounter =1; respondentCounter<newSurvey.numberOfRespondentsGet()+1; respondentCounter++ )
            {
            for (int qustionNumb =0; qustionNumb <newSurvey.numberOfQuestionsGet();qustionNumb++ )
                {
                newSurvey.generateRespondentsId ();
                
                newSurvey.presentQuestion(qustionNumb,respondentCounter);
                
                int response =0;
                
                while (response<1||response>5)
                    {
                    System.out.println("Please enter numbered response 1-5");
                    Scanner rating = new Scanner(System.in);
                    response = rating.nextInt();
                    }
                
                }
            }
        }
    }
    
    
