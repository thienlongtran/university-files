#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
  
  for(int i = 0; i < atoi(argv[1]); i++){
  	fork();
  	usleep(10000);
  }
  
  
  
  FILE *out = fopen("out.txt", "a");
  printf("PID: %d ; PPID: %d\n",getpid(),getppid());
  fprintf(out, "%d ; %d\n",getpid(),getppid()); 
  usleep(8000000); //Wait before exiting to fix PPID mismatch
  return 0;
}
