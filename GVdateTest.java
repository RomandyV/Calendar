
/*************************************************************************************************
 * Software test to test GVdate methods and constructors.
 * Help from Professor Resendiz (and geeksforgeeks.org) to help determine the string comparison is true
 * Help from Zybooks for the rest (methods, objects, assert).
 * 
 *
 * @author Romandy Vu
 * @version October 1, 2020
 ***********************************************************************************************/
public class GVdateTest{
    
    
    public static void main (String [] args) {
        
        System.out.println ("Testing begings");
        
        //Testing the default constructor where the object is named test rather than day
        
        GVdate test = new GVdate();
        assert test.getMonth() == 10 : "month should be 10";
        assert test.getDay() == 12 : "day should be 12";
        assert test.getYear() == 2020 : "year should be 2020";
        
        // testing constructor 2 where the object is named test2 rather than theday
        GVdate test2 = new GVdate(1, 10, 1995);
        assert test2.getMonth() == 1 : "month should be 1";
        assert test2.getDay() == 10 : "day should be 10";
        assert test2.getYear() == 1995 : "year should be 1995";
        
        // testing setter methods
        
        //testing setMonth
        test2.setMonth(8);
        assert test2.getMonth() == 8 : "month should be 8";
        
        //testing setDay
        test2.setDay(31);
        assert test2.getDay() == 31 : "day should be 31";
        
        //testing setYear
        test2.setYear(2000);
        assert test2.getYear() == 2000 : "year should be 2000";
        
        ///testing third constructor
        GVdate test3 = new GVdate("1/10/2010");
        assert test3.getYear() == 2010 : "year should be 2010 and an integer";
        assert test3.getMonth() == 1 : "month should be 1";
        assert test3.getDay() == 10: "day should be 10";
        
        ///testing isLeapYear()
        assert test3.isLeapYear(2001) == false : "Should be false";
        
        ///testing if date is valid
        GVdate test4 = new GVdate(1, 0, 2000);
        assert test4.getDay() == 12: "Should be 12 due to error for day false due to day";
        test4.setDay(5);
        assert test4.getDay() == 5:"Should be 5";
        
        //testing isMyBirthday()
        assert test2.isMyBirthday() == false : "Should be false unless day is set to 10" +
                                               "and year is set to 7";
                                            
        ///testing if leapyear()
        assert test.isLeapYear(2000) == true : "Should be true";
        assert test.isLeapYear(1700) ==false : "Should be false due to not being divisble by 400";
        
                                               
        //testing toString
        assert test2.toString().equals("8/31/2000") == true : "Should be \"8/31/2000\"";
        
        //testing nextDay
        GVdate test5 = new GVdate(1,1,2005);
        test5.nextDay();
        assert test5.getDay() == 2: "Day should be 2";
        
        //testing skipAhead()
        test5.skipAhead(20);
        assert test5.getDay() == 22: "Day should be 22";
        //testing isLeapYear
        assert test5.isLeapYear(test5.getMonth()) == false: "Should be false";
        //testing isMyBirthday
        assert test5.isMyBirthday() == false:"Should be false";
        //testing if equals
        GVdate test6 = new GVdate(1,22,2005);
        assert test5.equals(test6) == true: "Should be true";
        
        //testing formatDate
        assert test5.toString(1).equals("1/22/2005") == true: "Should be 1/22/2005";
        assert test6.toString(2).equals("01/22/2005") == true : "Should be 01/22/2005";
        assert test6.toString(3).equals("Jan 22, 2005") == true: "Should be Jan 22, 2005";
        assert test6.toString(4).equals("January 22, 2005") == true: "Should be January 22, 2005";
        
        
        
        
        System.out.println("Test ended");
    }
}
