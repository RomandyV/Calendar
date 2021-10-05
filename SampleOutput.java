
/**
 * This is to show the Sample Output for GVdate class.
 *
 * @author Romandy Vu
 * @version October 8, 2020
 */
public class SampleOutput
{
 public static void main (String [] args) {
     ///Creating new object
     GVdate output1 = new GVdate();
     
     System.out.println("The default constructor date is: " + output1);
     output1.nextDay();
     System.out.println("Tomorrow will be: " + output1);
     output1.skipAhead(20);
     System.out.println("20 days after tomorrow will be: " + output1 + "\n");
     System.out.println("Is the year a leap year?: "+ output1.isLeapYear(2020));
     System.out.println("Is the date my birthday? (7/10/2001): "+ output1.isMyBirthday());
     System.out.println("Is " + output1 + " equal to " + output1 + "?: " + output1.equals(output1));
     GVdate output2 = new GVdate(5,5,1700);
     System.out.println("Is " + output2 + " equal to " + output1 + "?: " + output2.equals(output1));
     System.out.println("Is the "+ output2 + " a leap year?: "+ output2.isLeapYear(1700) + "\n");
     System.out.println("Format 1: " + output1.toString(1));
     System.out.println("Format 2: " + output1.toString(2));
     System.out.println("Format 3: " + output1.toString(3));
     System.out.println("Format 4: " + output1.toString(4));
     
     
     
    
}
}
