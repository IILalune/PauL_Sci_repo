import java.util.Scanner;
public class AgeCheck  
{
    public static void main(String[] args) 
    {
        System.out.print("Your age? ");
        Scanner console = new Scanner(System.in);
        int myAge = console.nextInt();
        message(myAge);
    }

    // Displays message about driving to user based on given age
    public static void message(int age) 
    {
        if (age >= 16) 
        {
            System.out.println("I'm old enough to drive!");
        }
        else
        {
            System.out.println("Not old enough yet... :*(");
        }
    
    }
}