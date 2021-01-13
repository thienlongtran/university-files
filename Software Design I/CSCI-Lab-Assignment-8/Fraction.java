public class Fraction{
  private int Numerator;
  private int Denominator;

  public Fraction(int Numerator, int Denominator) {
    int sign = 1;
    if ((Numerator * Denominator) < 0 ) {
          sign = -1;}
    this.Numerator = Math.abs(Numerator) * sign;
    this.Denominator = Math.abs(Denominator);  
 }

  public Fraction add(Fraction other){
    int Numerator = (this.getNumerator() * other.getDenominator()) + (other.getNumerator() * this.getDenominator());
    int Denominator = (other.getDenominator() * this.getDenominator());
    return simplify(Numerator, Denominator);
  }
  //Returns new fraction object based on this fraction added to other fraction

  public Fraction divide(Fraction other){
    int Numerator = (this.getNumerator() * other.getDenominator());
    int Denominator = (this.getDenominator() * other.getNumerator());
    return simplify(Numerator, Denominator);
  }
  //Returns new fraction object based on this fraction divided by other fraction

  public int getDenominator(){
    return this.Denominator;
  }
  //Returns the denominator

  public int getNumerator(){
    return this.Numerator;
  }
  //Returns the numerator

  public Fraction multiply(Fraction other){
    int Numerator = (other.getNumerator() * this.getNumerator());
    int Denominator = (other.getDenominator() * this.getDenominator());
    return simplify(Numerator, Denominator);
  }
  //Returns new fraction object based on this fraction multiplied by other fraction

  public Fraction simplify(int numerator, int denominator){
    for (int i = denominator; i>0; i--){
      if(((numerator % i)==0) && ((denominator %i)==0)){
        numerator = numerator / i;
        denominator = denominator / i;
      }
    }
    return new Fraction(numerator, denominator);
  }
  //Returns a fraction of simplified form using the given integer arguments

  public Fraction subtract(Fraction other){
    int Numerator = (this.getNumerator() * other.getDenominator()) - (other.getNumerator() * this.getDenominator());
    int Denominator = (other.getDenominator() * this.getDenominator());
    return simplify(Numerator, Denominator);
  }
  //Returns new fraction object based on this fraction subtracted from other fraction

  public String toString(){
    return String.format("(%d/%d)",Numerator,Denominator);
  }
  //Returns a text representation of fraction in form of: "(numerator/denominator)"
  
}