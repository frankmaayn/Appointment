/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs182;

/**
 *
 * @author serde
 */
import java.util.Scanner;
import static java.lang.Character.toLowerCase;
import static java.lang.Character.toUpperCase;

public class UserInput {
    static Scanner input = new Scanner(System.in);
    static String int1, double1, ch1, string1, string2, string3; 
    static int int2, int3;
    static double double2, double3;
    static char ch2, ch3;
 
    public static int getInt(){
        while (true){
            int1 = input.next();
            try{
                Integer object = Integer.parseInt(int1);
                int2 = object;
                return int2; } catch (NumberFormatException e){
                    System.out.print("Enter an integer input: ");
                } 
        }
    }
    public static int getInt(int min, int max){
        while (true) {
            int3 = getInt();
            if (int3 <= max && int3>= min){
                return int3;
            }
            else {
                System.out.print("Wrong input. Try again: ");
            }
        }
    }
    
       public static char getChar(){
        input.nextLine();
        while(true){
            ch1 = input.nextLine();
                if ( ch1.length()== 1){
                    ch2 = ch1.charAt(0);
                    ch3 = Character.toUpperCase(ch2);
                    return ch3;                   
                }
                else {System.out.print("Invalid. Try again: ");}
        }       
    }
       
    public static char getChar (char min, char max){
        while (true){
        char ch3 = getChar();
        if (ch3 <= max && ch3 >= min){      
            return ch3;
        }
        else {
            System.out.print("Invalid. Try again: ");
        }
        }
    }   
    public static double getDouble(){
        while (true) {
        double1 = input.next();
            try {
                Double object = Double.parseDouble(double1);
                double2 = object;
                return double2;
                } catch (NumberFormatException e){
                    System.out.print("Invalid. Try again: ");
                }
        }
    }
    
    
    public static double getDouble (double min, double max){
       while (true){
        double3 = getDouble();
        if (double3 <= max && double3 >= min) {
            return double3;
        }
        else {
            System.out.print("Invalid. Try again: ");
        }
       }
    }
    public static String getString(){
        
        string1 = input.nextLine();
        string2 = string1.toUpperCase();
        return string2;    
    }
    
    public static String getString (int min, int max){
        while (true){
            string3 = getString();
            if (string3.length() >= min && string3.length() <= max ){
                return string3.toUpperCase();
            }
            else {
                System.out.print("Invalid. Try again: ");
            }        
        }   
    }
          
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
       
        System.out.print("Enter an integer: ");
        int integer1 = UserInput.getInt();
        System.out.println("You entered an integer " + integer1);
    
        System.out.print("Enter a double: ");
        double double1 = UserInput.getDouble();
        System.out.println("You enterd a double number " + double1 );
        
        System.out.print("Enter a character: ");
        char character1 = UserInput.getChar();
        System.out.println("The character you entered is " + character1);
        
        System.out.print("Enter a string: ");
        String string1 = UserInput.getString();
        System.out.println("The string you entered is " + string1);
    }
}