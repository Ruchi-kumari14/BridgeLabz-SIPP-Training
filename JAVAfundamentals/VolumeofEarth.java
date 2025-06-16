public class VolumeofEarth{
public static void main(String[] args){
    double radiusKm =6378;
    double kmToMilesCubes=0.239913;
    double pi=Math.PI;
    double volumeKm3=(4.0/3.0)*pi*Math.pow(radiusKm,3);
    double volumeMiles3= volumeKm3 * kmToMilesCubes;
    System.out.printf("The volume of Earth in cubic kilometers is %.2f km^3%n",volumeKm3);
    System.out.printf("The Volume of Earth in cubic miles is %.2f miles^3%n",volumeMiles3);
      }
}













