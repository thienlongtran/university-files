public class Account{
  public static int count = 0;
  private int id;
  private String pin;
  private String name;
  private double balance = 0.0;

  public Account(String name, String pin){
    this.name = name;
    this.pin = pin;
    this.balance = balance;
    this.id = count;
    this.count = count + 1;
    
  }

  public String getName(){
    return this.name;
  }

  public int getID(){
    return this.id;
  }

  public double getBalance(){
    return this.balance;
  }

  public boolean isPin(String attempt){
    boolean isValid = attempt.equals(this.pin);
    return isValid;
  }

  public void withdraw(double amount){
    this.balance = this.balance - amount;
  }

  public void deposit(double amount){
    this.balance = this.balance + amount;
  }

  public String toString(){
    return String.format("Name: %s, Account ID: %s, Balance: $%.2f", this.name, this.id, this.balance);
  }
}
