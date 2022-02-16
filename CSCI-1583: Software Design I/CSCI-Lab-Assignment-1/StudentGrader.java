import java.util.Scanner;

class StudentGrader{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    double TestAvg = input.nextDouble();
    double HomeworkAvg = input.nextDouble();
    double LabAvg = input.nextDouble();

    double FinalGrade = (TestAvg * 0.4) + (HomeworkAvg * 0.5) + (LabAvg * 0.1);

    System.out.println(FinalGrade);
  }
}