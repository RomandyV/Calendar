import java.text.DecimalFormat;
/***************************************************************************************************************
 *This is a calendar.
 *
 *
 *
 *@author Romandy Vu
 *
 *Zybooks and https://docs.oracle.com/javase/tutorial/i18n/format/decimalFormat.html has helped
 *with determing how to write the code. Java Documentation has helped with the DecimalFormat class while
 *Zybooks has helped with the rest.
 *
 * @version Start date: October 1, 2020
 **************************************************************************************************************/
public class GVdate{
    /** These are the variables. */

    /** This hold a value (an integer) for a month. */
    private int month;

    /** This hold a value (an integer) for a day. */
    private int day;

    /** This hold a value (an integer) for a year. */
    private int year;

    /** This hold a value (an integer) for a birth month. */
    private int myBirthMonth = 7;

    /** This hold a value (an integer) for a birth day.*/
    private int myBirthDay = 10;

    /********************************************************************************************
     * GVdate Constructor This code below is the default constructor setting the month, day, 
     * and year variable to a given value integer where the month is 10, day is 12
     * and year is 2020. 
     *
     *******************************************************************************************/
    public GVdate(){
        this.month = 10;
        this.day = 12;
        this.year = 2020;
    }

    /********************************************************************************************
     * GVdate Constructor sets the first int in the parameter to month,
     * the second to day, and the last to year ONLY IF THE DATE ENTRY IS VALID 
     * DUE TO THE isDateValid method.
     *
     * @param m A parameter sets the month to m.
     * @param d A parameter sets the day to d.
     * @param y A parameter sets the year to y.
     ********************************************************************************************/
    public GVdate(int m, int d, int y){
        isDateValid(m,d,y);

        if (isDateValid(m,d,y)){
            this.month = m;
            this.day = d;
            this.year = y;
        }

        else{
            this.month = 10;
            this.day = 12;
            this.year = 2020;
        }
    }

    /********************************************************************************************
     * GVdate Constructor that if written in the "month/day/year" format it will set the first string
     * number as a integer so that it can set the integer variable for month, set the next string
     * values after the firstslash as a integer for the day variable,
     * and set the next string values after the second slash to a integer for the year variable.
     * IF IT IS VALID else the values will be the default constructor values
     *
     * @param date A string parameter that IF the parameter input is written in the format of
     * "month/day/year" it will set the string characters before the first slash and convert to
     * an integer to set the month variable,the first string character after the first slash
     * to before the second slash will be converted to an integer so that it can be set to the
     * day variable, and the last characters after the second slash will be converted to an
     * integer so that it can set the year variable. IF THE DATE IS VALID
     * 
     *******************************************************************************************/
    public GVdate(String date){
        int firstSlash = date.indexOf("/");
        int secondSlash = date.lastIndexOf("/");
        int cutMonth = Integer.parseInt(date.substring(0, firstSlash));
        int cutDay = Integer.parseInt(date.substring(firstSlash + 1, secondSlash));
        int cutYear = Integer.parseInt(date.substring(secondSlash + 1, date.length()));

        isDateValid(cutMonth,cutDay,cutYear);
        if (isDateValid(cutMonth,cutDay,cutYear)){
            this.month = cutMonth;
            this.day = cutDay;
            this.year = cutYear;
        }
        else{
            month = 10;
            day = 12;
            year = 2020;
        }

    }

    /*******************************************************************************************
     * Method getMonth returns the year.
     *
     * @return The return value for the month variable.
     *******************************************************************************************/
    public int getMonth(){ 
        return this.month;
    }

    /******************************************************************************************
     * Method getDay returns the year.
     *
     * @return The return value for the day variable.
     *****************************************************************************************/
    public int getDay(){
        return this.day;
    }

    /******************************************************************************************
     * Method getYear returns the year.
     *
     * @return The return value for the year variable.
     *****************************************************************************************/
    public int getYear(){
        return this.year;
    }

    /******************************************************************************************
     * Method toString returns string "month/day/year".
     *
     * @return returns a string where the date format is "month/day/year".
     ******************************************************************************************/
    public String toString(){
        String monthInString = Integer.toString(month);
        String dayInString = Integer.toString(day);
        String yearInString = Integer.toString(year);
        return monthInString+"/"+dayInString+"/"+yearInString;
    }

    /************************************************************************************************
     * Method toString This method will return a certain date format when given a specific integer value
     * (1-4) by using a switch statement. If 1 it uses the toString() method. If 2 it uses the DecimalFormat
     * class by creating an object and then adds a zero if the day or month is only 1 digit.
     * If 3 then it will determine the substring of a string that contains all the abbreviations of
     * the months so it can get the abbreviation of said month.
     * month. If 4 it uses a switch statement to determine the entire word of the month.
     *
     * @param format A parameter that will determine the format to be returned if input is a integer from 1 
     * to 4.
     * @return If 1 it will return "month/day/year". 
     * If 2 it will return "month/day/year" where month and day contain two digits.
     * If 3 it will reutrn "month day, year" where month is abbreviated.
     * If 4 it will return "month day, year"where month is the entire word.
     ***************************************************************************************************/
    public String toString(int format){
        String stringFormat = "";
        String dayInString = Integer.toString(day);
        String yearInString = Integer.toString(year);

        switch (format) {

            case 1:
            stringFormat = toString();
            break;

            case 2:
            DecimalFormat case2Format = new DecimalFormat("00");
            String case2Month = case2Format.format(month);
            String case2Day = case2Format.format(day);
            stringFormat = case2Month + "/" + case2Day + "/" + yearInString;
            break;

            case 3:
            String case3Month;
            String allMonthAbbrev = "JanFebMarAprMayJunJulAugSepOctNovDec";
            case3Month = allMonthAbbrev.substring(((month * 3) - 3), (month * 3));
            stringFormat = case3Month + " " + dayInString + ", " + yearInString;
            break;

            case 4:
            String case4Month;
            switch (month) {

                case 1:
                case4Month = "January";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

                case 2:
                case4Month = "February";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

                case 3:
                case4Month = "March";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

                case 4:
                case4Month = "April";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

                case 5:
                case4Month = "May";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

                case 6:
                case4Month = "June";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

                case 7:
                case4Month = "July";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

                case 8:
                case4Month = "August";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

                case 9:
                case4Month = "September";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

                case 10:
                case4Month = "October";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

                case 11:
                case4Month = "November";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

                case 12:
                case4Month = "December";
                stringFormat = case4Month + " " + dayInString + ", " + yearInString;
                break;

            }
        }
        return stringFormat;
    }

    /******************************************************************************************
     * Method isMyBirthday returns true of false if it is my birthday.
     *
     * @return The return of a boolean value if the date matches the birth month and birth day.
     ******************************************************************************************/
    public boolean isMyBirthday(){
        if ((month == myBirthMonth) && (day ==myBirthDay)){
            return true;
        }

        else{
            return false;
        }
    }

    /*******************************************************************************************
     * Method setMonth sets the month if valid.
     *
     * @param m A parameter that sets the month to the variable m IF IT IS VALID if not will print
     * "Error".
     *******************************************************************************************/
    public void setMonth(int m){
        if(isDateValid(m,day,year)){
            this.month = m;
        }
        else{
            System.out.println("Error");
        }
    }

    /*********************************************************************************************
     * Method setDay sets the day if valid.
     *
     * @param d A parameter that sets the day variable to d if the day is valid from the given
     * month other wise it will print error.
     ******************************************************************************************/
    public void setDay(int d){
        isDateValid(this.month,d,this.year);
        if (isDateValid(this.month,d,this.year)){
            this.day = d;
        }
        else{
            System.out.println("Error");
        }

    }

    /********************************************************************************************
     * Method setYear sets the year if valid.
     *
     * @param y A parameter that sets the year variable to y if the year is valid else it will
     * print error.
     *******************************************************************************************/
    public void setYear(int y){
        if (y > 0){
            this.year = y;
        }

        else{
            System.out.println("Error");
        }

    }

    /******************************************************************************************
     * Method setDate sets the date to said numbers if valid.
     *
     * @param m A parameter that sets the month variable to m.
     * @param d A parameter that sets the day variable to d.
     * @param y A parameter that sets the year variable to y.
     * THESE WILL BE SET ONLY IF THE DATE IS VALID ELSE it will print an error.
     *****************************************************************************************/
    public void setDate(int m, int d, int y){
        isDateValid(m,d,y);
        if (isDateValid(m,d,y)){
            this.month = m;
            this.day = d;
            this.year = y;
        }

        else{
            System.out.println("Error");
        }

    }

    /*********************************************************************************************
     * Method isLeapYear detemines if year is a leap year by checking if it is divisble by 400,100, and 4.
     * If it is divisble by 400 or 4 and not 100 it is true, else returns false.
     *
     * @param y A parameter
     * @return The return value will return true if the year is a leap year else it will be false.
     ******************************************************************************************/
    public boolean isLeapYear(int y){
        if (y % 400 == 0){
            return true;
        }
        else if (y % 100 == 0){
            return false;
        }
        else if (y % 4 == 0){
            return true;
        }
        else{
            return false;
        }

    }

    /*******************************************************************************************
     * Method getLastDayOfMonth finds the last day of the given month, needs two parameters,
     * the month to determine the last day of the month, and the year to determine if it is a
     * leap year due to Feburary having an added day. Only checks if the month is 1 to 12, it will
     * be set to a certain day. Else it will do nothing.
     *
     * @param m A parameter for the month where the last day is checked in that month.
     * @param y A parameter to check if it is a leap year.
     * @return The return value returns lastDay a variable that holds the last day of the given
     * month
     *****************************************************************************************/
    private int getLastDayOfMonth(int m, int y){
        int lastDay = day;
        if (m == 2){
            isLeapYear(y);
            if (isLeapYear(y)){
                lastDay = 29;
            }

            else{
                lastDay = 28;
            }
        }
        else if ((m==4) || (m==6) || (m==9) || (m==11)){
            lastDay = 30;
        }

        else if ((m >= 1) || (m <=12)){
            lastDay = 31;
        }

        return lastDay;
    }

    /*******************************************************************************************
     * Method isDateValid determines if the given parameters for the date is valid.
     * First a variable is created, where the private method will return the variable after going 
     * through the test to determine if the date is valid. It checks to see if the month, day, and
     * year is negative, but also if the month is greater than 12, if any of the entered 
     * parameters meet the requirement, the variable would be set to false and the method would
     * will return false. Else it will compare if the day is equal to or less than the last day
     * of the given month using the getLastDayOfMonth method. If the conditions
     * are met the variable will be set to true, therefore the method would return true.If it
     * doesn't then it variable will be set to false.
     *
     * @param m A parameter that will be used to determine if the month is valid. It will be valid
     * if it is between 1 and 12.
     * @param d A parameter that will be used if the day is valid.It will be valid if it is between
     * or is the first day of the month or the last day of the month.
     * @param y A parameter that will be used to to determine if the year is valid. It will be 
     * valid if it is greater than 0 since 0 CE doesn't exist.
     * @return The return value will be true if the date is valid.
     ******************************************************************************************/
    private boolean isDateValid(int m, int d, int y){
        boolean isValid = false;
        if ((m <= 0) || (d <= 0) || (y <= 0) || (m > 12)){
            isValid = false;
        }

        else{

            if(d <= getLastDayOfMonth(m,y)){
                isValid = true;
            }

        }
        return isValid;
    }

    /***************************************************************************************************
     * Method nextDay determines what the next day will be. Checks first 
     * if the day is 31 and month is 12, if sothen the year will be added by 1 
     * and the day and month will be set to 1 to determine the start day of the new year.
     * If not, it checks if the day is the last day of the month.
     * If it is then will will add 1 to the month and set the day to 1 to determine the start day of the
     * month.
     * Otherwise it will add 1 to the day.
     *
     *************************************************************************************************/
    public void nextDay(){
        if ((month == 12) && (day == 31)){
            this.year = this.year + 1;
            month = 1;
            day = 1;
        }

        else if (day == getLastDayOfMonth(this.month, this.year)){
            day = 1;
            this.month = this.month + 1;

        }

        else{
            this.day = this.day + 1;
        }

    }

    /***************************************************************************************************
     * Method equals returns a true or false if the object matches with each other by getting
     * and comparing the month, day and year.
     *
     * @param otherDate A parameter of the object that is being comapred to.
     * @return The return value is true if it matches the day, year, and month. Otherwise false.
     *************************************************************************************************/
    public boolean equals(GVdate otherDate){
        boolean isDateEqual = false;

        if ((otherDate.getMonth() == month) && (otherDate.getDay() == day)
        && (otherDate.getYear() == year)){
            isDateEqual = true;

        }

        else{
            isDateEqual = false;

        }

        return isDateEqual;
    }
    
    /***************************************************************************************************
     * Method skipAhead determines the date using a loop that uses the nextDay() method a certain number
     * of times that is determined by the input. It will only determine the said date if the input is
     * positive.
     *
     * @param numDays A parameter that will determine the date after numDays.
     **************************************************************************************************/
    public void skipAhead(int numDays){
        if(numDays > 0){
            int count;
            
            for(count = 0; count < numDays; ++count){
                nextDay();
            }
        
        }
    
    }

}
