#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]) {
  
  for(int i = 0; i < atoi(argv[1]); i++){
  	int status;
  	if(fork() != 0){
		//Parent Code
  		waitpid(-1, &status, 0);
  	}
  	else{
  		continue;
  	}
  	
  }
  
  
  
  FILE *out = fopen("3_out.txt", "a");
  printf("PID: %d ; PPID: %d\n",getpid(),getppid());
  fprintf(out, "%d ; %d\n",getpid(),getppid()); 
  return 0;
}
