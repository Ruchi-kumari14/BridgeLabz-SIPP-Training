class PenDistribution{
   public static void main(String[] args){
      int totalPens = 14;
      int totalStudents = 4;
      int PenperStudent=totalPens/totalStudents;
      int remainingPens =totalPens % totalStudents;
      System.out.printf("The Pen per Student is" + PenperStudent + " and the remaining pen not distributed is " + remainingPens);
  }
}
