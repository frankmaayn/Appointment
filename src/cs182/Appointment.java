
package cs182;

/**
 *
 * @author serde
 */
class Appointment {
    private int day, hour, minute;
    private String month, message;
    private  int DAY_MIN = 1, DAY_MAX = 31, 
                HOUR_MIN = 0, HOUR_MAX = 24, 
                MINUTE_MIN = 0, MINUTE_MAX = 59,
                MONTH_MAX = 3,
                MESSAGE_MIN = 1, MESSAGE_MAX = 40;
         
    public Appointment () {
        month = "Not specified.";
        message = "No message.";
        day = 0;
        hour = 0;
        minute = 0;
    }
    public Appointment (String month, int day, int hour, int minute, String message){
        setMonth(month);
        setMessage(message);
        setHour(hour);
        setDay(day);
        setMinute(minute);
    }
    public void setMonth(String month){
            if (month.length() == MONTH_MAX){
                switch(month){
                    case "JAN": this.month = "JAN"; break;
                    case "FEB": this.month = "FEB"; break;
                    case "MAR": this.month = "MAR"; break;
                    case "APR": this.month = "APR"; break;
                    case "MAY": this.month = "MAY"; break;
                    case "JUN": this.month = "JUN"; break;
                    case "JUL": this.month = "JUL"; break;
                    case "AUG": this.month = "AUG"; break;
                    case "SEP": this.month = "SEP"; break;
                    case "OCT": this.month = "OCT"; break;
                    case "NOV": this.month = "NOV"; break;
                    case "DEC": this.month = "DEC"; break;
                    default : 
                        System.out.print("Please Enter the first 3 character of the month: ");
                        month = UserInput.getString();
                        setMonth(month);
                }
            }
            else {
                System.out.print("Please enter the first 3 character of the month: ");
                month = UserInput.getString();
                setMonth(month);                
           }
    }    
    public String getMonth() {
        return month;
    }
   
    public void setDay(int day){     
           if (day <= DAY_MAX && day >= DAY_MIN){ 
               if (getMonth().equals("JAN") || getMonth().equals("MAR") || getMonth().equals("MAY") 
                   || getMonth().equals("JUL") || getMonth().equals("AUG") || getMonth().equals("OCT")
                       || getMonth().equals("DEC")){
                     if (day >=1 && day <= 31){
                         this.day = day;
                     }
                     else {
                         System.out.print("Enter a valid day for the month: ");
                         day = UserInput.getInt();
                         setDay(day);
                     }               
               }
               else if (getMonth().equals("APR") || getMonth().equals("JUN") || getMonth().equals("SEP")
                       || getMonth().equals("NOV")){
                   if (day >1 && day <= 30){
                       this.day = day;
                   }               
               }
               else if (getMonth().equals("FEB")){
                   if (day >1 && day <= 28 || day == 29){
                       this.day = day;
                   }
                   else {
                       System.out.print("Enter a valid day for the month: ");
                       day = UserInput.getInt();
                       setDay(day);
                   }
               }
               else {
                   System.out.println("Month has not been set. ");
                   month = UserInput.getString();
                   setMonth(month);
                   System.out.print("Enter a valid day of the month: ");
                   day = UserInput.getInt();
                   setDay(day);
               }             
           }
           else {
               System.out.print("Enter a valid day of the month: ");   
               day = UserInput.getInt();
               setDay(day);          
        }  
    }  
    public int getDay() {
        return day;
    }    
    public void setHour(int hour){
            if (hour <= HOUR_MAX && hour >= HOUR_MIN){
                this.hour = hour;             
            }
            else {
                System.out.print("Invalid input. Try again: ");
                hour = UserInput.getInt();
                setHour(hour);
            }
        }    
    public int getHour(){      
        return hour;        
    }   
    public void setMinute(int minute){
            if (minute <= MINUTE_MAX && minute >= MINUTE_MIN) {
                this.minute = minute;             
            }
            else {
                System.out.print("Invalid input. Try again: ");
                minute = UserInput.getInt();
                setMinute(minute);
            }      
    }    
    public int getMinute(){
        return minute;
    }     
    public void setMessage(String message){
            if (message.length() <= MESSAGE_MAX && message.length() >= MESSAGE_MIN){
                this.message = message;                  
            }
            else if (message.length() < MESSAGE_MIN || message.length() > MESSAGE_MAX) {
                System.out.println("Invalid. Enter a reason: ");
                message = UserInput.getString();
                setMessage(message);                
            }     
    }
    public String getMessage(){
        return message;
    }
    
    
    @Override
    public String toString() {
        if (hour < 10 && minute < 10 && hour >= 0 && minute >=0 ){
        return month + " " + day + " " + "0" + hour + ":" + "0" + minute + " " +  message;
        }
        else if (hour < 10 && hour >= 0){
        return month + " " + day + " " + "0"+ hour + ":"+ minute + " " +  message;
        }
        else if (minute < 10 && minute >= 0){
        return month + " " + day + " " + hour + ":" + "0" + minute + " " +  message;
        }
        return month + " " + day + " " + hour + ":" + minute + " " +  message;
    }  
    public void inputAppointment() {
        System.out.print("Enter the first 3 letters of the month: ");
        Appointment object1 = new Appointment();
        String month1 = UserInput.getString(3,3);
        setMonth(month1);
        System.out.print("Enter the day: ");
        int day1 = UserInput.getInt(1, 31);
        setDay(day1);
        System.out.print("Enter the hours: ");
        int hour1 = UserInput.getInt(0, 24);
        setHour(hour1);
        System.out.print("Enter the minutes: ");
        int minute1 = UserInput.getInt(0, 59);
        setMinute(minute1);
        System.out.print("Enter the reason: ");
        UserInput.getString();
        String message1 = UserInput.getString(1, 40);
        setMessage(message1);
        object1.toString();
        
    }
  
    
    public static void main (String[] args){
  /*    Appointment object1 = new Appointment();
        object1.inputAppointment();
        System.out.println(object1);
        System.out.println(" ");
        System.out.println("Second appointment: ");
        Appointment object2 = new Appointment("JAN", 24, 6, 3, "hello");
        System.out.println(object2);
    */  
      Planner go = new Planner();
      go.run();
        
    }
}

