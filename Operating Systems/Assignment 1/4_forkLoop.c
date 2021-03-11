#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
  
  for(int i = 0; i < atoi(argv[1]); i++){
  	int status;
  	int printedStatus = 0;
  	
  	if(!printedStatus){
  		printf("PID: %d ; PPID: %d ; Level: %d\n",getpid(),getppid(),i);
  		printedStatus = 1;
  	}
  	
  	fork();
  }
  
  
  usleep(8000000); //Wait before exiting to fix PPID mismatch
  FILE *out = fopen("4_out.txt", "a");
  fprintf(out, "%d ; %d\n",getpid(),getppid()); 
  return 0;
}
