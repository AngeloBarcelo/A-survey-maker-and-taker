# Survey maker/taker in terminal window 

In the terminal window, the program asks the first user to enter questions to ask in a survey. The all users after the second will take the survey. Once all survey takers have answered all of the questions. The total results of the survey will be displayed in grid form and the option to view all of the answers given to a particular question will be presented. The user will then be presented with the best and worst rated question based on the results provided.  

The first user has the opportunity to:                  |All other user will:
---------------------------------------                  |--------------------
Create a custom title for the survey.| Answer the questions previously entered by user one on a scale of one through five.
Enter the questions to be asked of the survey takers later on.| 
Enter number of users that will take the survey.| 
View all responses provided to any one question.|
View the survey results in grid form.|

In order to increase or decrease the limits set on the number of questions, respondents, or highest answer possible you only have to change (one or all) of the first three variables depending on what you want to change. Everything from what is displayed to the survey taker, the validation loops, number of respondents, number of questions, and highest answer allowed are based on those variables. None of the numbers are hard coded into the program. This was done to make the program much more maintainable and avoid the need to read through all the code and change all variables associated with the limits.


