#include <string.h>
#include "student.h"

struct student_info make_student(void){
   struct student_info me;

   me.id = 2575712;
   strcpy(me.name, "Thien Tran"); /* strcpy is necessary */

   strcpy(me.email, "tltran5@uno.edu");

   strcpy(me.birth_place, "Ho Chi Minh City, Vietnam");
   
   me.semesters_studied = 3;
   
   me.csci_classes[0]=1581;
   me.csci_classes[1]=2120; /* array indices always being with 0 */
   me.csci_classes[2]=2125;
   me.csci_classes[3]=2450;

   strcpy(me.reason, "I took a Python course when I was a sophomore in high school and I loved it, so I figured that Computer Science would fit me the most if I decided to go to university!");

   strcpy(me.purpose, "I want to learn something new and broaden my horizon!");

   strcpy(me.non_cs_interest, "I love watching Disney movies!");


   return me;
}
