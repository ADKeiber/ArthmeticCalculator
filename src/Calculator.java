import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/***
 * 
 * Calculator that does Arithmetic 
 * 
 * @author Austin Keiber
 *
 */
public final class Calculator {
	
	private Calculator() {
	}
	/**
	 * 
	 * @param a
	 * @return boolean value that says if given string "a" is a number
	 */
	private static boolean isDouble(String a) {
		boolean flag = true;
		 try { 
		        Double.parseDouble(a); 
		    } catch(NumberFormatException e) { 
		        flag = false;
		    } catch(NullPointerException e) {
		    	flag = false;
		    }
		 return flag;
	}
	
	
	/**
	 * Fills a set s with all acceptable inputs for functions
	 * @param s
	 */
	private static void getFunctions(Set<String> s) {
		s.add("multiply");
		s.add("Multiply");
		s.add("*");
		s.add("Divide");
		s.add("divide");
		s.add("/");
		s.add("\\");
		s.add("Add");
		s.add("add");
		s.add("+");
		s.add("Subtract");
		s.add("subtract");
		s.add("-");
		s.add("modulo");
		s.add("Modulo");
		s.add("%");
	}
	
	/**
	 *  asks a user for two numbers and a function then gives the result
	 * @param args
	 */
	public static void main(String[] args) {
		//sets up variables to be used inside the function
		double num1;
		double num2;
		String firstNum;
		String secondNum;
		Scanner input = new Scanner(System.in);
		Set<String> s = new HashSet<String>(); 
		String function;
		double result = 0;
		
		//fills set with acceptable functions
		getFunctions(s); 
		
		//asks for a valid number continually until given one
		do {
			System.out.println( "Enter a VALID number");
		
			firstNum = input.nextLine();
		
		}while(!isDouble(firstNum));
		
		//Parses user inputed number into a double
		num1 = Double.parseDouble(firstNum);
		
		//asks for a valid function continually until given one
		do {
			System.out.println("Would you like to add, subtract, multiply, divide, or modulo");
			function = input.nextLine();
		}while(!s.contains(function));
		
		//asks for a valid function continually until given one 
		do {
			System.out.println("Enter another VALID number");			
			secondNum = input.nextLine();			
		}while(!isDouble(secondNum));	
		
		//Parses user inputed number into a double
		num2 = Double.parseDouble(secondNum);
		
		//Sets up a case switch to decided which function the user actually imputed and running the calculation
		switch(function) {
			case "Multiply":
			case "multiply":
			case "*": {
				result = num1 * num2;
				break;
			}
			case "Divide":
			case "divide":
			case "/": 
			case "\\":{
				result = num1/num2;
				break;
			}
			case "Subtract":
			case "subtract":
			case "-":{
				result = num1 - num2;
				break;
			}
			case "Add":
			case "add":
			case "+":{
				result = num1 + num2;
				break;
			}
			case "Modulo":
			case "modulo":
			case "%":{
				result = num1 % num2;
				break;
			}
			
			default:
				
		}

		System.out.println("\n");
		
		//printing the result
		System.out.println(num1 + " " + function + " " + num2 + " = " + result);
		
		//closes streams
		input.close();
	}
}
