import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.awt.image.BufferedImage;

public class Game {
	public static String nameOfPlayer;
	private static int wrongThreeInARow = 0;
	public static final int RESPONSES_FOR_WRONG = 6;
	public static final int RESPONSES_FOR_RIGHT = 6;
	public static final ArrayList<String> responses = wrongAnswers();
	public static final ArrayList<String> responseForRight = rightAnswers();
	public static final Random r = new Random();
	public static final String WRONG_LETS_REVIEW = "Wrong again...let's go back to the previous question for review"; 
	
	public static void main(String[] args) throws IOException {
		Scanner console = new Scanner(System.in);
		displayPicture("hack title test1.jpg");
		intro(console);
		t1_q1(console);
	}
	
	public static void delayedPrint(String s) {
	    try {
	        for (char c : s.toCharArray()) {
	            System.out.print(c);  // print characters without newline
	            Thread.sleep(20);  // wait for some milli seconds
	        }
	    } catch (InterruptedException e) {
	    }
	    System.out.println(); // finally, add a line break
	}

	public static void displayPicture(String fileName) throws IOException {
		BufferedImage image = ImageIO.read(new File(fileName));
		JLabel label = new JLabel(new ImageIcon(image));
        JFrame f = new JFrame();
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(label);
        f.pack();
        f.setSize(600, 690 );
        //600 by 600
        f.setLocation(0,0);
        f.setVisible(true);
        delayedPrint("                                                                                                                        ");
}

	public static void printOntoConsole(String message, JLabel label) {
		JLabel text = new JLabel(message);
		text.setSize(label.getPreferredSize());
		text.setLocation(30, 30);
		label.add(text);
	}
	
	public static void intro(Scanner console) throws IOException {
		delayedPrint("Welcome to your new CS job! What is your name? Type it below.");
		String name = console.nextLine();
		nameOfPlayer = name;
		delayedPrint("Hi " + name + ", my name is Wired and I'm here to help you! I know it is your first day on the job and you are quite nervous.");
		delayedPrint("Yes, thatís right. I am talking to you through the screen.");
		delayedPrint("Donít freak out! I know this sounds crazy, but I know youíre not all that familiar with Java ");
		delayedPrint("although you claimed to be and I want to help!");
		delayedPrint("I know this because, you know that random laptop sitting on the desk in the background during your job interview? ");
		delayedPrint("Yeah, THAT laptop. Yep, that was me. I know everything!");
		delayedPrint("Oh wait that sounds kind of freaky." );
		delayedPrint("\n");
		delayedPrint("Donít worry, though! I am friendly, I promise! ");
		delayedPrint("I donít know why people keep saying technology will take over the world. All that sci-fi mumbo jumbo. ");
		delayedPrint("We really all just want to help. Well, except for printers, they are actually evil.");
		delayedPrint("\n");
		delayedPrint("Anyway, " + name + " I am going to teach you the basics of Java. ");
		delayedPrint("Or at least enough so that your boss wonít figure out youíre a complete newbie and fire you."); 
		delayedPrint("While I am mostly free, the boss does monitor some of your code. ");
		delayedPrint("Make sure you do well otherwise he will definitely catch you!");
		delayedPrint("Then it will be GAME OVER for you");
		delayedPrint("*******************************************************************************************************************");
		delayedPrint("First, we will review some basic definitions. I expect you to know at least this otherwise I really canít help you.");
		delayedPrint("Level ONE");
		displayPicture("level 1.jpg");

	}
	public static void wrongIncrementCount(Scanner console)throws IOException {
		wrongThreeInARow++;
		if (wrongThreeInARow == 3) {
			delayedPrint("*******************************************************************************************************************");
			delayedPrint("Youíre FIRED!!!");
			displayPicture("youre fired.jpg");
		}
	}
	
	//topic 1
	public static void t1_q1(Scanner console)throws IOException {
		System.out.println();
		delayedPrint("A class is the basic building block of an object-oriented language such as Java. \nIt is a template that describes the data and behavior of a program. \nAn object is something that has a state and behavior. A variable is the name given to a memory location/container that holds a value. \nThe values do not have to be primitive types. What is a primitive type? Primitive types are the most basic data types available within the Java language.\nThere are 8: boolean, byte, char, short, int, long, float and double. These types contain the purest, simple values of a kind.");
		delayedPrint("#Q1 : What is the most basic building block of an object oriented language, such as Java?");
		boolean results = whileLoopForAnswer("class", console);
		String right = "Youíre right itís a class! Nice, you know the most basic building block of Java. ";
		String wrong = "How could you get this incorrect! You're beyond hope!";
		//game over if wrong for first question
		String printResult = results == true? right : wrong;
		delayedPrint(printResult);
		if (!results) {
			wrongThreeInARow = 2;
			wrongIncrementCount(console);
		} else {
			t1_q2(console);
		}
	}
	
	public static void t1_q2(Scanner console) throws IOException {
		System.out.println();
		delayedPrint("onto the next question!");
		boolean result = generalQuestion(console, false, "#Q2 : what is the name given to a memory location that stores a value?", "variable", "-", "-", "-");
		printOut(result, "Yep, the answer is variable", WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t1_q3(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3)
				t1_q1(console);
		}
	}
	
	public static void t1_q3(Scanner console) throws IOException {
		delayedPrint("\n");
		String question = "Now this oneís a little tricky.#Q3 How many primitive types are there in Java?";
		boolean result = generalQuestion(console, true, question, "a","8", "10", "6");
		printOut(result, "Correct! There are 8! I would tell you what they were if I wasnít going to ask you what a few of them are on the next question.", WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t1_q4(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3)
				t1_q2(console);
		}
	}

	public static void t1_q4(Scanner console) throws IOException{
		delayedPrint("\n");
		delayedPrint("Youíre doing great, so I will reward you with a multiple choice question!");
		String question = "#Q4: Identify the correct primitive data types in Java.";
		boolean result = generalQuestion(console, true, question, "c", "boolean , byte , String, Integer ", " char , String , int , long , float", "boolean , byte , double, char");
		printOut(result, "Whoo hoo! At this rate youíre going to get a promotion!", " Awww, wrong and it was a multiple choice question too :(");
		if (result) {
			wrongThreeInARow = 0;
			t2_q5(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3)
				t1_q3(console);
		}
		
	}
	
	//level 2
	public static void t2_q5(Scanner console) throws IOException {
		displayPicture("promotion.jpg");
		delayedPrint("                                                                                ");
		displayPicture("level 2.jpg");
		delayedPrint("\n");
		delayedPrint("Welcome to LEVEL TWO");
		delayedPrint("Now you need to know about java outputs.\nRemember that System.out.Println() just prints out whatever is between the parenthesis.");
		delayedPrint("Integer division- when you divide two integers, if there is a remainder, the computer just drops the remainder. For example: 10 / 4 = 2");
		delayedPrint("When decimal numbers are divided, it outputs as a decimal number.");
		delayedPrint("When a word or letter is added with number, the output comes out as a ìStringî. A String is a sequence of characters.");
		delayedPrint("Remember, it is not a primitive data type. It is an object!");
		delayedPrint("The rest of the operations are normal.");
		delayedPrint("Remember your order of operations- or PEMDAS (parentheses, exponents, multiplication and division, addition and subtraction)!");  
		delayedPrint("The only exceptions to PEMDAS is when you add Strings (String concatenation).");
		delayedPrint("Operations behind Strings are just output as they are unless theyíre in parenthesis. For example: ìabcî + 1 + 2 = abc12");
		delayedPrint("The other is the operation called modulus. Represented by %. It just outputs the remainder of one number divided by the other.\n"); 

		delayedPrint("I am going to test you on basic operations with data types.");
		String question = "#Q5: What does delayedPrint(1.5 / .3 + 6 / 4) yield?"; 
		boolean result = generalQuestion(console, false, question, "6.0", "-", "-", "-");
		printOut(result, "Wow, youíre pretty good!", WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t2_q6(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3)
				t1_q4(console);
		}
	}
	
	public static void t2_q6(Scanner console) throws IOException {
		delayedPrint("\n");
		String question = "#Q6: What does System.out.print(1 + 5 * 0 + \"hi\" + 1.5) yield?";
		boolean result = generalQuestion(console, false, question, "1hi1.5", "a", "b", "c");
		printOut(result, "That was a tricky one. Good job!", WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t2_q7(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3)
				t2_q5(console);
		}
	}
		
	public static void t2_q7(Scanner console) throws IOException {
		delayedPrint("\n");
		String question = "#Q7:  How about System.out.println(\"cp\" + (3 * 3) + \"x\" + (2 / 4)) yield?";
		boolean result = generalQuestion(console, false, question, "cp9x0", "a", "b", "c");
		printOut(result, "You got it!", WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t2_q8(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3)
				t2_q6(console);
		}
	}
	
	public static void t2_q8(Scanner console) throws IOException {
		delayedPrint("\n");
		String question = "#Q8: what does System.out.println(0 % 10 + 5 / 2 + 1.5) yield?";
		boolean result = generalQuestion(console, false, question, "3.5", "a", "b", "c");
		printOut(result, "You got it!", WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t3_q9(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3)
				t2_q7(console);
		}
	}
	
	//level 3
	public static void t3_q9(Scanner console) throws IOException {
		displayPicture("promotion.jpg");
		displayPicture("level 3.jpg");
		delayedPrint("\n");
		delayedPrint("LEVEL THREE: All correct! Looks like you really are going to keep your job!");
		delayedPrint("Also, uh can I at least get a ìthank youî for helping you thus far?");
		boolean ungrateful = true;
		while (ungrateful) {
			String myThanks = console.nextLine();
			if (myThanks.equalsIgnoreCase("Thank You") || myThanks.equalsIgnoreCase("ty") || myThanks.equalsIgnoreCase("gracias"));
				ungrateful = false;
		}
		delayedPrint("Youíre welcome!!! :D \nOh wait, the boss is walking around.\nWe have to keep going." );
		System.out.println();
		delayedPrint("Now we're going to understand print statements and escape sequences\n");
		delayedPrint("The line System.out.println() basically prints out whatever is in between the two parenthesis to the console and then it goes to the next line. ");
		delayedPrint("The line System.out.print() does the same thing, but does not go to the next line.");
		delayedPrint("For outputting, you can not type certain character combinations called escape character. ");
		delayedPrint("For example,  when \\t appears it tabs the output appearing after it. \\n represents a new line, so the output after it will print on the next line. ");
		delayedPrint("Finally, typing \\\\ represents only one \\ in the output.");
		String question = "#Q9What is the result of System.out.println(\"a\\\\b\")";
		String answer = "a\\b";
		boolean result = generalQuestion(console, false, question, answer, "a", "b","c");
		printOut(result, responseForRight.get(r.nextInt(RESPONSES_FOR_RIGHT)), WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t3_q10(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3)
				t2_q8(console);
		}		
	}
	
	public static void t3_q10(Scanner console) throws IOException {
		delayedPrint("\n");
		String question = "#Q10: What will System.out.println(\"a\\tb\") result in";
		String answer = "a        b";
		boolean result = generalQuestion(console, false, question, answer, "a", "b", "C");
		printOut(result, responseForRight.get(r.nextInt(RESPONSES_FOR_RIGHT)), WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t3_q11(console);
		} else {
			wrongIncrementCount(console);
		}	if (wrongThreeInARow != 3) {
				t3_q9(console);
		}
	}
	
	public static void t3_q11(Scanner console) throws IOException {
		delayedPrint("\n");
		String question = "#Q11: What will System.out.println(\"t\\\\t\\\\a\\\\b\\ta\") result in";
		String answer = "t\\t\\a\\b        a";
		boolean result = generalQuestion(console, false, question, answer, "a", "b", "C");
		printOut(result, responseForRight.get(r.nextInt(RESPONSES_FOR_RIGHT)), WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t3_q12(console);
		} else {
			wrongIncrementCount(console);
		}	if (wrongThreeInARow != 3) {
				t3_q10(console);
		}
	}
	
	public static void t3_q12(Scanner console) throws IOException {
		delayedPrint("\n");
		String question = "#Q12: What does \"\\n\" do in a string statement";
		String answer = "b";
		boolean result = generalQuestion(console, true, question, answer, "It prints a \\n", "It starts a new line", "It does nothing");
		printOut(result, responseForRight.get(r.nextInt(RESPONSES_FOR_RIGHT)), WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t4_q13(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3) {
				t3_q11(console);
			}
		}
	}
	
	//topic 4
	public static void t4_q13(Scanner console) throws IOException{
		displayPicture("promotion.jpg");
		displayPicture("level 4.jpg");
		delayedPrint("LEVEL FOUR: Another promotion?! You are on fire! Next, I will test you on recognizing syntax or compile errors.\n");
		delayedPrint("Syntax - rules defining how a Java program is written");
		delayedPrint("A syntax or compiler error is when your code doesnít make sense to your computer."); 
		delayedPrint("When you declare a variable you have to assign or give it a value. This is called initializing.");
		delayedPrint("Strings can only be added (concatenated). No other operations may be used with strings.");
		delayedPrint("Loops are used to run a set of statements repeatedly until a certain condition is satisfied.") ;
		delayedPrint("The syntax is ìfor (initialize a variable; condition; updater) { code to run }\". In the for loop initialization happens first and only one time. ");
		delayedPrint("The condition is evaluated each time until it is false. If the condition is true the code in the loop runs. ");
		delayedPrint("Then at the very end, the updater changes the value of the variable that is initialized and tested with the condition.\n");
		String question = "Q.13)\nString s = \"\";\nint x = 3; \nint y = -10;\ns = x * y + \"res-\" % x;\nSystem.out.print(x + s);\nWhich line does the syntax error occur?";
		boolean result = generalQuestion(console, true, question, "c", "line 1", "line 2", "line 4");
		printOut(result, "Correct! The only operation for Strings is addition", WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t4_q14(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3) 
				t3_q12(console);
		}
	}
	
	public static void t4_q14(Scanner console) throws IOException {
		delayedPrint("\n");
		String question = "#Q14.int a = 3;\nint b;\nint _o = 5;\na *= b + _o;\nSystem.out.print(a);\nWhat causes the syntax error?";
		boolean result = generalQuestion(console, true, question, "b", "line 2", "line 4", "line 3");
		printOut(result, "You're absolutely correct! b has not been initialized", WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t4_q15(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3) 
				t4_q13(console);
		}
	}
	
	public static void t4_q15(Scanner console) throws IOException{
		delayedPrint("\n");
		String question = "#Q15.\n for(int final = 0; final < 10; final++) {\nint a = 10;\nSystem.out.print(a++ * 20);\n What causes the syntax error";
		boolean result = generalQuestion(console, true, question, "a", "line 1", "line 4", "line 3");
		printOut(result, "That's right! You can't use \"final\" as a variable since it is a reserved word", WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t5_q16(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3) 
				t4_q14(console);
		}
	}
		
	public static void t5_q16(Scanner console) throws IOException {
		displayPicture("promotion.jpg");
		displayPicture("level 5.jpg");
		delayedPrint("\n");
		delayedPrint("Congratulations! You reached the final level!");
		delayedPrint("We will go over code tracing.");
		String question = "#Q16 What is output by the following code when it is run?\nint x = 2;\nint y = 5;\nint z = x * y + 1; \ny -= z; \nx++; \nSystem.out.print(x + \" \" + y + \" \" + z);";
		String answer = "3 -6 11";
		boolean result = generalQuestion(console, false, question, answer, "", "", "");
		printOut(result, responseForRight.get(r.nextInt(RESPONSES_FOR_RIGHT)), WRONG_LETS_REVIEW);
		if (result) {
			wrongThreeInARow = 0;
			t5_q17(console);
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3) 
				t4_q15(console);
		}
	}

	public static void t5_q17(Scanner console) throws IOException {
		delayedPrint("\n");
		String question = "#Q17\nWhat is output by the following code when it is run?\nint x = -4;\nint y = 5;\nfor(int i = 0; i <= 4; i++) { \n  x += 2;\n  y = 5 * x; \n}\nSystem.out.print(x + \" \" + y);";
		String answer = "6 30";
		boolean result = generalQuestion(console, false, question, answer, "", "", "");
		printOut(result, responseForRight.get(r.nextInt(RESPONSES_FOR_RIGHT)), WRONG_LETS_REVIEW);
		if (result) {
			delayedPrint("You win! Youíve been offered a permanent position!");
			displayPicture("you win.jpg");
		} else {
			wrongIncrementCount(console);
			if (wrongThreeInARow != 3) 
				t5_q16(console);
		}
	}
		
	public static void printOut(boolean results, String rightAnswer, String wrongAnswer) {
		String printResult = results == true? rightAnswer : wrongAnswer;
		delayedPrint(printResult);	
	}
		
	public static boolean generalQuestion(Scanner console, boolean multipleChoice, String question, String answer, String a, String b, String c) {
		delayedPrint(question);
		if (multipleChoice) {
			delayedPrint("Pick an option");
			System.out.printf("A:%s    B:%s   C:%s\n", a,b,c);
		}
		boolean result = whileLoopForAnswer(answer, console);
		return result;	
	}
	
	public static ArrayList<String> wrongAnswers() {
		ArrayList<String> wrong = new ArrayList<>();
		wrong.add("Wait, seriously? How did you get hired?");
		wrong.add("Ummm...not quite.");
		wrong.add("Nope. Close but not quite.");	
		wrong.add("Not quite. Pay attention to the data type.");
		wrong.add("Nope, but you can do better!");
		wrong.add("Thatís not it. You do want to keep your job right?");
		return wrong;
	}
	
	public static ArrayList<String> rightAnswers() {
		ArrayList<String> right = new ArrayList<>();
		right.add("Wow, youíre pretty good!");
		right.add("That was a tricky one. Good job!");
		right.add("You got it!");
		right.add("Whoo hoo! At this rate youíre going to get a promotion!");
		right.add("Wow, you're a star!");
		right.add("You're one step closer to mastering Java");
		return right;
	}
		
	public static boolean whileLoopForAnswer(String answer, Scanner console) {
		int numWrong = 0;
		boolean correct = false;
		while (numWrong < 3 && !correct) {
			String response = console.nextLine();
			if (answer.equals(response.toLowerCase())) {
				correct = true;
			} else {
				numWrong++;
				if (numWrong != 3) {
					int random = r.nextInt(RESPONSES_FOR_WRONG);
					delayedPrint(responses.get(random));
					delayedPrint("Try again.");
				}
			}
		}
		return correct;
	}	
}
