/* part1.c -- This is part 1 of lab 0, CSCI2467, Fall 2016 */

#include <stdio.h>
#include "student.h"

int main () /* in this case we don't care about command line arguments */
{
	/* create a struct of type student_info called student */
	/* then call the make_student() function from student.c
	 * to fill it with information */
  struct student_info student = make_student (); 

  /* Now start printing out what's stored in student.
   * \n represents the newline character
   * %d is for substituting integer values */
  

  //printf ("Email: %d\n\n", student.email);

  /* %s is for substituting a character array */
  printf("-----Personal Student Info-----\n");
  printf ("Name: %s\n", student.name);
  printf ("ID number: %d\n", student.id);
  printf("Birth Place: %s\n", student.birth_place);
  printf("Email: %s\n", student.email);
  printf("Semesters Studie: %d\n\n\n", student.semesters_studied);

  

  printf("-----Other Info-----\n");
  /* we reference individual array elements with [0] [1] etc */
  printf ("CS Courses taken: CSCI%d, CSCI%d, CSCI%d, CSCI%d\n\n",
	  student.csci_classes[0], student.csci_classes[1], student.csci_classes[2], 	  
	  student.csci_classes[3]);

  printf ("Reason for studying Computer Science:\n%s\n\n", student.reason);

  printf("What I want to get out of this class: \n%s\n\n", student.purpose);

  printf("Non-CS interest: %s\n", student.non_cs_interest);

  return 0; /* 0 is typically returned when no errors have occurred */
};
