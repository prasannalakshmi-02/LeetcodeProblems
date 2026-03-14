class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
       int squareStd = 0;
       int circularStd = 0;
       for(int std : students){
           if (std == 1) {
              squareStd++;
            } else {
              circularStd++;
            }
       }
       for(int sandwich : sandwiches){
           if(sandwich == 0){
              if(circularStd > 0){
                 circularStd--;
              }else{
                 break;
              }
           }else{
              if (squareStd > 0) {
                    squareStd--;
                } else {
                    break;
                }
            }
        }
        return squareStd + circularStd;
    }
}