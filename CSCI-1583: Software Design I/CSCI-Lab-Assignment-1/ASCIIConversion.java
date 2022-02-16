import java.util.Scanner;
class ASCIIConversion{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    int ASCIIa = input.nextInt();
    int ASCIIb = input.nextInt();
    int ASCIIc = input.nextInt();
    int ASCIId = input.nextInt();
    int ASCIIe = input.nextInt();
    int ASCIIf = input.nextInt();

    System.out.printf("%s%s%s%s%s%s",(char)ASCIIa,(char)ASCIIb,(char)ASCIIc,(char)ASCIId,(char)ASCIIe,(char)ASCIIf);
  }
}