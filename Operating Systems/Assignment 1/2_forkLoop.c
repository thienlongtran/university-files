#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
  
  for(int i = 0; i < atoi(argv[1]); i++){
  	fork();
  	usleep(10000);
  }
  
  //printf("PID: %d ; PPID: %d\n",getpid(),getppid());

  printf("%d ; %d\n",getpid(),getppid()); 
  usleep(8000000);
  return 0;
}
