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
class Planner  {
   private  Appointment [] array = new Appointment[20];
   
   
   Planner() {
   
   array[0] = new Appointment("MAR", 4, 17, 30, "Quiz 1");
   array[1] = new Appointment("APR", 1, 17, 30, "Midterm");
   array[2] = new Appointment("MAY", 6, 17, 30, "Quiz 2");
   array[3] = new Appointment("JUN", 3, 17, 30, "Final");
   }
   
   public void run () {
       boolean exit = true;
       System.out.println("Menu");
       System.out.println(" ");
       System.out.print("1: Add Appointment  ");
       System.out.print("2: Delete Appointment  ");
       System.out.print("3: List Appointment  ");
       System.out.println("4: Close the program  ");
       System.out.print("Enter the one of the integer above:  ");
       
           int answer = UserInput.getInt(1, 4);
           
           switch(answer){
               case 1:
                   System.out.println("Add Appointment.");  
                   addAppointment();
                   break;
               case 2:
                   System.out.println("Delete Appointment.");
                   deleteAppointment();
                   break;
               case 3:
                   System.out.println("List Appointment.");                  
                   listAppointment();
                   break;
               case 4: System.exit(0);
             
                
       }             
   } 
   public boolean compareAppointment(Appointment A1, Appointment A2){
      Appointment convert = new Appointment();
      if (numMonth(A1) < numMonth(A2)) {
      return true;     
      }
      else if (numMonth(A1) == numMonth(A2)){
                if (A1.getDay() < A2.getDay()){
                    return true;
                }
                else if (A1.getDay() == A2.getDay()){
                        if (A1.getHour() < A2.getHour()){
                                return true;
                        }
                        else if (A1.getHour() == A2.getHour()) {
                                if (A1.getMinute() < A2.getMinute()){
                                        return true;
                                }
                                else {
                                    return false;
                                }
                        }
                else {
                    return false;
                } 
                }
          else {
              return false;
          }    
      }
     else {
        return false;
     }
   }
         
  public void insertAppointment (Appointment A1){
      Planner insert = new Planner();
      for (int i = array.length-1; i >= 0; i--){
          if (array[i] != null){
              if (insert.compareAppointment(A1, array[i]) == true){
                  array[i+1] = array[i];
                  array [i] = A1;
              }
              else {
                  array[i+1] = A1;
                  break;                 
              }
          }              
      }      
  }
  
  public void listAppointment (){
      int i;
      for (i = 0; i < array.length; i++){
          System.out.println((i +1)+ "." + array[i]);
      }
      run();
  }
  public void deleteAppointment(){
    
      System.out.print("Which index would you like to delete: ");
      int delete = UserInput.getInt(1, array.length)-1;
      for (int i = delete; i < array.length-1; i++){
          array[i] = array[i +1]; 
      }
      run();

  }
  public void addAppointment() {
      Appointment object = new Appointment();
      object.inputAppointment();
      Appointment x = object;
      insertAppointment(x);
      run();
      
  }
  
  // I added this because it is easier to compare the months instead of a string
  public int numMonth(Appointment x){
       switch (x.getMonth()){
           case "JAN": return 1;
           case "FEB": return 2;
           case "MAR": return 3;
           case "APR": return 4;
           case "MAY": return 5;
           case "JUN": return 6;
           case "JUL": return 7;
           case "AUG": return 8;
           case "SEP": return 9;
           case "OCT": return 10;
           case "NOV": return 11;
           case "DEC": return 12;
           default:
               return 0;
         
       }
    }

}

