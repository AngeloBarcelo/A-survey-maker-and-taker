package IT152;
import java.util.Scanner;

/* This is just a simple survey taker. The first user enters the number of 
 * questions and people taking the survey. Then hands the survey off to the 
 * people taking the survey. The results are provided in grid form and allows 
 * the user to review the answers provided for a particular question.
 */

/*
 * @author Angelo Barcelo 
 * IT152-1503A-01: Introduction to Java Programming II
 * Student ID: 19313797 
 * angelobarcelo@hotmail.com
 */
public class Survey
{
    private static int highestResponsePossable = 5;//added to make program flexable in future and easier to adjust
    private static int questionNumber = 10;//declaring variable for the number of questions
    private static int numberOfRespondents = 10;//declaring variable for the number of respondents
    private static int respondentsId = 0;//declaring variable for the respondents ID
    private String surveyTitle;//declaring variable for the survey title
    private String [] questionArray = new String [questionNumber];//declaring the array to hold the questions
    private int [][] responseArray = new int [questionNumber][numberOfRespondents];//declaring the array to hold the answers to the questions
    
    //Asks the user how many questions and asks them to enter them
    void enterQuestions()
    {
        //Asks the user how many questions and then sets the variable questionNumber
        System.out.print("How many questions would you like the survey to have?\n");
       
        Scanner howManyQuestions = new Scanner (System.in);
        questionNumber = howManyQuestions.nextInt();    
        
        /* Allows the user to enter the questions to be asked later and also 
         * displays the question number they are entering. It will only allow as 
         * many question to be entered as prev. entered */
        for (int counter =0; counter < questionNumber; counter ++)
        {
            System.out.print("Please enter question #" +(counter+1)+"\n");
            //Stores the qustions entered in the question array
            questionArray[counter] = howManyQuestions.next();
        }
        
        System.out.println("And how many people will be taking the survey?");
        
        numberOfRespondents=0;
        
        //Validates what the user is entering and sets the variable numberOfRespondents
        while (numberOfRespondents <1 ||numberOfRespondents > questionNumber)
        {
            System.out.println("(There as to be at least one and no more than 10 please)");
        
            Scanner respondents = new Scanner (System.in);
        
        numberOfRespondents = respondents.nextInt(); 
        }
    }
    
    //Sets the survey title to the default title if none is provided
    Survey()
    {
        this("Customer Survey");
    }
    
    //Sets the survey title to what was provided
    Survey (String surveyTitle)
    {
        respondentsId = 0;
        this.surveyTitle = surveyTitle; 
    }
    
    //Creates/collects the respondents ID
    int generateRespondentsId ()
    {
        respondentsId = (respondentsId +1);
        return respondentsId;     
    }
    
    //Gets the survey title to put in the survey method
    String getSurveyTitle()
    {
        return surveyTitle; 
    }
    
    //displays all of the surveys results in a grid
    void displaySurveyResults()
    {
        System.out.print(surveyTitle +"\n");
    
        for (int respondent =0; respondent < numberOfRespondents; respondent ++)
        {      
            for (int question =0; question< questionNumber; question ++)
            {   
                System.out.print(responseArray[respondent][question]);
            }
            
            System.out.println();
        }    
    } 
    
    //Allows the user to selct a qustion and view all the answers provided for it
    void displayQuestionStats(int entered)
    {    
        while (entered < 1 ||entered > questionNumber)
        {
            System.out.println("What question would you like to review the results for?");
        
            Scanner displayResults = new Scanner (System.in);
            
            entered =  displayResults.nextInt();
        }
        
        for (int respondent =0; respondent < numberOfRespondents; respondent ++) 
        {
            System.out.println(responseArray[entered-1][respondent]);
        }
    }
    
    //Show the user the questions to be answered
    void presentQuestion(int numberOfQuestions)
    {
        System.out.println ("Question # " + numberOfQuestions + " is:");
        
        System.out.println(questionArray [numberOfQuestions-1]);
    }
    
    //Show the user the questions to be answered in overloaded presentQuestion method    
    void presentQuestion(int numberOfQuestions, int respondentsId)
    {
        System.out.println ("Survey taker #" + (respondentsId) + ". Quesion #" +(numberOfQuestions+1)+ " of "+ questionNumber + " is:");
        
        System.out.println(questionArray [numberOfQuestions]);
    }
    
    //Stores the users responses to the questions
    void logResponse (int question, int respondentsId, int response)
    {
        do
        {
            System.out.println("Please enter numbered response 1- " + highestResponsePossable);
            Scanner rating = new Scanner(System.in);
            response = rating.nextInt();
        }
        
        while (response < 1|| response > highestResponsePossable);
        
        responseArray[(question)][(respondentsId-1)]= response;
    }
    
    //Getter for the numberOfQuestions for reuse in test class
    int numberOfQuestionsGet()
    { 
        return questionNumber;
    }
    
    //Getter for the numberOfRespondents for reuse in test class
    int numberOfRespondentsGet()
    {
        return numberOfRespondents;
    }
    
    //Finds the top rated question
    void topRatedQuestion()
    {
        int total = 0;
        int highestNumber = 0;
        int highestQuestion = 0;
        
        for (int question = 0; question < questionNumber; question++)
        {
            for(int respondent = 0; respondent < numberOfRespondents; respondent++)
            {
                total += responseArray[question][respondent];
            }
            if (total>highestNumber)
            {
                highestNumber=total;
                highestQuestion= question;
            }
            
            total=0;
        }
        
        System.out.println("The highest rated question was " +questionArray[highestQuestion]);
    }
        
    //finds the lowest rated question
    void lowRatedQuestion()
    {
        int total = 0;
        int lowestNumber = 1000;
        int lowestQuestion = 0;
        
        for (int question = 0; question < questionNumber; question++)
        {
        
            for(int respondent = 0; respondent < numberOfRespondents; respondent++)
            {
                total=total+responseArray[question][respondent];
            }
            
            if (total<lowestNumber)
            {
                lowestNumber = total;
                lowestQuestion = question;
            }
            
            total=0;           
        }
        
        System.out.println("The lowest rated question was " +questionArray[lowestQuestion]);
        }
    }
    