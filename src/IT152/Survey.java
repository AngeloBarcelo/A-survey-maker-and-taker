package IT152;
import java.util.Scanner;

/* This is just a simple survey taker. The first user enters the number of 
 * questions and people taking the survey. Then hands the survey off to the 
 * people taking the survey. The results are provided in grid form and allows 
 * the user to review the answers provided for a particular question.
 * 
 * If you want to change the high limits of anything in the program you only 
 * have to change one or all of the first three variables. What is displayed 
 * to the user, counters, and validation limites are all based on these three
 * variables.
 */

/*
 * @author Angelo Barcelo 
 * angelobarcelo@hotmail.com
 */
public class Survey
{
    //declares the variable that sets the highest response possible to answer questions
    private static int highestResponsePossible = 5;
    
    //declares the variable that sets the highest number of questions to be entered
    private static int higestNumbQuestionsAllowed = 10;
    
    //declares the variable that sets the highest number of people that can take the survey
    private static int higestNumbRespondentsAllowed = 10;
    private static int questionNumber = higestNumbQuestionsAllowed;
    private static int numberOfRespondents = higestNumbRespondentsAllowed;
    private static int respondentsId = 0;
    private String surveyTitle;
    private String [] questionArray = new String [questionNumber];
    private int [][] responseArray = new int [questionNumber][numberOfRespondents];
    void enterQuestions()
    {
        questionNumber =0;
        
        do 
        {
            //Asks the user how many questions and then sets the variable questionNumber
            System.out.println("\nHow many questions would you like the survey to have?");
            System.out.println("Please enter a number between 1-"+higestNumbQuestionsAllowed );
       
            Scanner howManyQuestions = new Scanner (System.in);
        
            questionNumber = howManyQuestions.nextInt(); 
        
            if (questionNumber <1)
            {
                //The message to show if the user enters anything less than 1
                System.out.println("\nI think you should ask at least one question");
            }
        
            if (questionNumber >higestNumbQuestionsAllowed)
            {
                //The message to show if the user enters anything higher than allowed
                System.out.println("\nI'm sorry there can't be more than " + higestNumbQuestionsAllowed);
            }
        }
        
        while (questionNumber < 1 || questionNumber > higestNumbQuestionsAllowed);
        
        //Shows the user what is expected of them when entering the questions
        System.out.println("\nThe next part is going to ask you to enter your questions"); 
        System.out.println("When writing your question keep in mind that the " +
                           "survey takers can only respond with numbers on a "
                           + "scale of 1 -" + highestResponsePossible + "\n" );
        
        /* Allows the user to enter the questions to be asked later and also 
         * displays the question number they are entering. It will only allow as 
         * many question to be entered as prev. entered */
        for (int counter =0; counter < questionNumber; counter ++)
        {
            System.out.println("Please enter question #" +(counter+1));

            Scanner wholeLineOfText = new Scanner (System.in);
            
            String enteredQuestion = wholeLineOfText.nextLine();
            
            questionArray[counter] = enteredQuestion;   
        }
        
        //Sets the variable numberOfRespondents for the validation loop
        numberOfRespondents=0;
        
        //Validates what the user is entering and sets the variable numberOfRespondents
        do 
        {
            System.out.println("\nAnd how many people will be taking the survey?");
        
            Scanner respondents = new Scanner (System.in);
        
            numberOfRespondents = respondents.nextInt(); 
        
            if (numberOfRespondents < 1)
            {
                //Shows this message if the user enters something less than 1
                System.out.println("I'm sorry there has to be at least one person you want to take the survey");
            }
            if (numberOfRespondents > higestNumbRespondentsAllowed)
            {
                //Shows this message if the user enters something higher than allowed
                System.out.println("I'm sorry there can't be more than " + higestNumbRespondentsAllowed);
            }
        }
        
        while (numberOfRespondents <1 ||numberOfRespondents > questionNumber);
    }
    //Sets the survey title to the default title if none is provided
    Survey()
    {
        this("Customer Survey");
    }
    
    Survey (String surveyTitle)
    {
        respondentsId = 0;
        this.surveyTitle = surveyTitle; 
    }
    
    int generateRespondentsId ()
    {
        respondentsId = (respondentsId +1);
        return respondentsId;     
    }
    
    String getSurveyTitle()
    {
        return surveyTitle; 
    }
    
    //displays all of the surveys results in a grid
    void displaySurveyResults()
    {   
        //Shows the user what is going to be printed out
        System.out.print("All of the results provided by the survey takers for ");
        System.out.println(surveyTitle +" are: ");
        
        //Loop to print out the colum headers for the grid
        for (int respondent =0; respondent < numberOfRespondents; respondent ++)
        {    
            System.out.printf("\t%2s", "Resp"); 
            System.out.print(respondent+1); 
        }
        
        System.out.println();
        
        //Displays the actual results entered for the survey
        for (int question =0; question < questionNumber; question ++)
        {  
            System.out.print("Q# " +(question+1) +": " );
            
            for (int respondent =0; respondent< numberOfRespondents; respondent ++)
            {   
                System.out.printf("\t%3d", responseArray [question][respondent]);
            }
        System.out.println();
        }    
    } 
    
    //Allows the user to selct a qustion and view all the answers provided for it
    void displayQuestionStats(int entered)
    {   
        //Validation loop to make sure the # is at lest 1 and no more than the # of questions
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
      
    void presentQuestion(int numberOfQuestions, int respondentsId)
    {
        System.out.println ("\nSurvey taker #" + (respondentsId) + 
                ", on a scale to 1 - "+ highestResponsePossible +
                ". With 1 being the lowest rating and " +highestResponsePossible +
                " being the highest rating ");
        System.out.print("Quesion #" +(numberOfQuestions+1)+ " of "+ questionNumber + " is: ");
        
        System.out.println(questionArray [numberOfQuestions]);
    }
    
    //Stores the users responses to the questions
    void logResponse (int question, int respondentsId, int response)
    {
        //Validates the # being entered is at leas t 1 and no more than the highestResponsePossable
        do
        {
            System.out.println("Please enter a number between 1- " + highestResponsePossible);
            Scanner rating = new Scanner(System.in);
            response = rating.nextInt();
            
            if (response<1)
                    {
                    System.out.println("I'm sorry could you enter a higher number please"
                                     + " Preferabley something between 1-5");
                    }
            if (response>  highestResponsePossible)
                    {
                    System.out.println("I'm sorry could you enter a lower number please"
                                     + " Preferabley something between 1-5");
                    }
        }
        
        while (response < 1|| response > highestResponsePossible);
        
        responseArray[(question)][(respondentsId-1)]= response;
    }
    
    int numberOfQuestionsGet()
    { 
        return questionNumber;
    }
    
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
    
