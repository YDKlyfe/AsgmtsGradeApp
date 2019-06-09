import java.util.*;
import java.util.Scanner;


//* You are to build a grading application for an instructor to input exam and assignment grades; including curves*//

public class GradingApp {

	public static void main(String[] args) {
		Scanner imTheReader = new Scanner(System.in);
		
		System.out.println("How many students in the class? ");
		int size = imTheReader.nextInt();
		int[] studentsScores = new int[size];
		for(int n = 0; n < studentsScores.length; n++)
		{
		    int [] exams = new int[4];
    		int [] assignments = new int[4];
    		
    		int score = 0;
    		for(int i = 0; i < exams.length; i++)
    		{
    		   System.out.print("Enter the score for exam #"+(i+1));
    		   exams[i] = imTheReader.nextInt();
    		   score += exams[i];
    		}
    		
    		for(int i = 0; i < assignments.length; i++)
    		{
    		    System.out.println("Enter the score for assignment #"+ (i+1));
    		    assignments[i] = imTheReader.nextInt();
    		    score += assignments[i];
    		}
    		
    		System.out.println("The Total score is: " +score);
    		studentsScores[n] = score;
		}
		
		double sum = 0;
		for(int i = 0; i < studentsScores.length; i++)
		{
		    sum += studentsScores[i];
		}
		double mean = sum / studentsScores.length;
		
		double sumSD = 0;
		for(int i = 0; i < studentsScores.length; i++)
		{
		    sumSD += (studentsScores[i]-mean)*(studentsScores[i]-mean);
		}
		double sd = sumSD/(studentsScores.length-1);
		
	    
	    //THE LAST PRINTS SHOULD BE SIMILAR (USING THE RESPECTIVE CONDITIONS) TO THIS
		for(int i = 0; i < studentsScores.length; i++)
		{
		    int actualScore = studentsScores[i];
    		if (actualScore >= mean + 2*sd)    
    		{
    		    System.out.println("Score for student#"+(i+1)+": A");
    		}
    		else if (actualScore >= mean + 1*sd)    
    		{
    		    System.out.println("Score for student#"+(i+1)+": B");
    		}
    	    else if (actualScore >= mean)
    	    {
    	        System.out.println("Score for student#"+(i+1)+": C");
    		}
    		else if (actualScore >= mean - 1*sd)
    		{
    		    System.out.println("Score for student#"+(i+1)+": D");
    		}
    		else
    		{
    		    System.out.println("Score for student#"+(i+1)+": F");
    		}
		}
	}
}
