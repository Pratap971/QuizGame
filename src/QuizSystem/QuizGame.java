package QuizSystem;

import java.util.ArrayList;
import java.util.Scanner;

class Question
{
    String question;
    String[] options;
    char answer;

    public Question(String question, String[] options, char answer)
    {
        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    public void display() 
    {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((char) ('A' + i) + ") " + options[i]);
        }
    }

    public boolean isCorrect(char userAnswer)
    {
        return Character.toUpperCase(userAnswer) == answer;
    }
}

public class QuizGame {
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        
        ArrayList<Question> quiz = new ArrayList<>();

        // Sample questions
        quiz.add(new Question("What is the capital of India?", new String[]{"Delhi", "Mumbai", "Kolkata", "Chennai"}, 'A'));
        
        quiz.add(new Question("Which keyword is used to inherit a class in Java?", new String[]{"this", "super", "extends", "implements"}, 'C'));
        
        quiz.add(new Question("Which method is the entry point of Java?", new String[]{"start()", "run()", "init()", "main()"}, 'D'));

        int score = 0;

        for (Question q : quiz)
        {
            q.display();
            System.out.print("Enter your answer (A/B/C/D): ");
            
            char userAns = sc.next().charAt(0);
            
            if (q.isCorrect(userAns)) 
            {
                System.out.println("Correct!\n");
                score++;
                
            } else
            {
                System.out.println("Wrong! Correct answer: " + q.answer + "\n");
            }
        }

        System.out.println("Your Score: " + score + "/" + quiz.size());
        
        // Prints message.
        
        if(score <= 1)
        {
        	System.out.println("Better Luck next time well try!");
        }else
        {
        	System.out.println("Congratulations! you are Absolutely right way: ");
        }
        
        sc.close();
    }
}
