public class LogicalUtil{
  static boolean thereExists(boolean p, boolean q, boolean r){
    if (p == true || q == true || r == true){
      return true;
    }
    else{return false;}
  }

  static boolean forAll(boolean p, boolean q, boolean r){
    if (p == true && q == true && r == true){
      return true;
    }
    else{return false;}
  }

  static boolean majority(boolean p, boolean q, boolean r){
    int counter = 0;

    if (p == true && q == true && r == true){
      counter = 3;
    }

    else if (p == true && q == true || p == true && r == true || q == true && r == true){
      counter = 2;
    }
    
    if (counter >= 2){return true;}
    else{return false;}

  }

  static boolean minority(boolean p, boolean q, boolean r){
    int counter = 0;
    if (p == true){counter =+ 1;}
    if (q == true){counter =+ 1;}
    if (r == true){counter =+ 1;}

    if (counter <= 1){return true;}
    else{return false;}
  }

  static boolean implies(boolean p, boolean q){
    if(p == true && q == false){
      return false;
    }
    else{return true;}
  }

  static boolean implies(boolean p, boolean q, boolean r){
    if (p == true && q == true && r == false){
      return false;
    }
    else{return true;}
  }

}