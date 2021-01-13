import java.util.Scanner;

class BloggingInHTML{
  public static void main(String[] args){
  Scanner input = new Scanner(System.in);

  String Header = input.next();
  String Source = input.next();
  String Description = input.next();
  String Author = input.next();
  String Date = input.next();

  System.out.printf("<html><body><h1>%s</h1><img src='%s' /><p>%s</p><small>By %s, %s</small></body></html>", Header, Source, Description, Author, Date);
  
  }
}
