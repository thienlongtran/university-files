public class Philosopher{
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(Fork leftFork, Fork rightFork){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    public Fork getLeftFork(){
        return this.leftFork;
    }

    public Fork getRightFork(){
        return this.rightFork;
    }
}