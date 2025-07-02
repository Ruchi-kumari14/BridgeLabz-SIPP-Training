class Device{
   String deviceId;
   String status;

   Device( String deviceId,String status){
      this.deviceId=deviceId;
      this.status=status;
   }

   void displayStatus(){
      System.out.println("Device Id: "+deviceId);
      System.out.println("Device status "+status);
   }
}

class Thermostat extends Device{
   double temperatureSettings;
  
   Thermostat(String deviceId,String status,double temperatureSettings){
      super(deviceId,status);
      this.temperatureSettings=temperatureSettings;
   }


   @Override
   void displayStatus(){
      super.displayStatus();
      System.out.println("Temperature Setting: " + temperatureSettings + "°C");
   }
}
class  SmartHomeSystem{
   public static void main(String[] args){
       Thermostat t1=new Thermostat("T1001","ON",24.5);
       t1.displayStatus();
   }
}
   

    


