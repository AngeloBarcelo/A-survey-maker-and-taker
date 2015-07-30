package IT152;


import IT152.Survey;
import java.util.Arrays;

/* This is a test class for the Survey.java file. This is only to test the 
 * methodes being used in that class.That class is a simple survey taker. The 
 * first user enteres the number of questions and people taking the surevey. 
 * Then hands the surevey off to the peopele takign the survey. The results are 
 * provided in  grid form and allows the user to review the answers provided for 
 * a particulare question.
 */

/*
 * @author Angelo Barcelo 
 * IT152-1503A-01: Introduction to Java Programming II
 * Student ID: 19313797 
 * angelobarcelo@hotmail.com
 */
public class test
    {
    @SuppressWarnings("empty-statement")
    public static void main(String[] arg)
        {
        //This tests the Survey method
        Survey defaultSurvey = new Survey();
        
        //This tests the enterQuestions method in the Survey class
        defaultSurvey.enterQuestions();
        
        //This tests the  getSurveyTitle method in the Survey class
        System.out.println("The title of defualt survey is " + 
                           defaultSurvey.getSurveyTitle ());
        
        //This tests the defaultSurvey.generateRespondentsId method in the Survey class
        System.out.println("Respondent ID = " +
                           defaultSurvey.generateRespondentsId ());
        
        //This tests the getSurveyTitle method in the Survey class with the overloaded args
        Survey overloadSurvey = new Survey("Angelos Survey");
        System.out.println("The title of the overload survey is " + 
                           overloadSurvey.getSurveyTitle ());
       
        for (int i = 0; i < overloadSurvey.numberOfRespondentsGet(); i++)
            {
            System.out.println("respondents Id = " + 
                               overloadSurvey.generateRespondentsId());
            }
        //This tests the logResponse method in the Survey class and gives it #'s
        defaultSurvey.logResponse((int)(Math.random() * defaultSurvey.numberOfQuestionsGet()+1),(int)(Math.random() * defaultSurvey.numberOfQuestionsGet()+1), (int)(Math.random() * 5 + 1)); 
        
        //This just lets one know visualy what class is being tested next
        System.out.println("Survey Results");
        
        //This tests the displaySurveyResults method in the Survey class
        defaultSurvey.displaySurveyResults();
        
        //This just lets one know visualy what class is being tested next
        System.out.println("Question Stats");
        
        //This tests the displayQuestionStats method in the Survey class
        defaultSurvey.displayQuestionStats((int)(Math.random() * defaultSurvey.numberOfQuestionsGet()));
        
        //This just lets one know visualy what class is being tested next
        System.out.println("Present Question");
        
        //This tests the presentQuestion method in the Survey class
        defaultSurvey.presentQuestion((int)(Math.random() * defaultSurvey.numberOfQuestionsGet() +1 ),(int)(Math.random() * defaultSurvey.numberOfQuestionsGet()+1));
        
        //This tests the lowRatedQuestion method in the Survey class
        defaultSurvey.lowRatedQuestion();
        
        //This tests the topRatedQuestion method in the Survey class
        defaultSurvey.topRatedQuestion();
        }
    
    }
