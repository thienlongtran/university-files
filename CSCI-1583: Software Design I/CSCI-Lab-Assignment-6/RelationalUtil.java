public class RelationalUtil{
static boolean isIncreasing(int x, int y, int z){
  if (x<y && y < z){
    return true;
  }
  else{
    return false;
  }
}
//Returns true if x is smaller than y and y is smaller than z, exclusive

static boolean isDecreasing(int x, int y, int z){
  if(x > y && y > z){
    return true;
  }
  else{
    return false;
  }
}
//Returns true if x is larger than y and y is larger than z, exclusive

static boolean isBetween(int x, int y, int z){
  if(y > z && x > y || y < z && x < y){
    return true;
  }
  else{
    return false;
  }
}
//Returns true if y is between x and z, inclusive

static boolean isPositive(int x){
  if (x >= 0){
    return true;
  }
  else{
    return false;
  }
}
//Returns true if the number is positive

static boolean isNegative(int x){
  if (x < 0){
    return true;
  }
  else{
    return false;
  }
}
//Returns true if the number is negative

static boolean overlaps(int min1, int max1, int min2, int max2){
  if(isBetween(min1, min2, max1)){
    return true;
  }
  else if(isBetween(min1, max2, max1)){
    return true;
  }
  else if(isBetween(min2, max1, max2)){
    return true;
  }
  else if(isBetween(min2, min1, max2)){
    return true;
  }
  else{
    return false;
  }
}
//Returns true if two line segments, min to max, overlap with one another
}