public abstract class Scheduler {

    private Operation running;
    abstract void add(Operation p);

//    abstract ArrayList<Operation> run();

    public abstract boolean isEmpty();

    public abstract Operation dispatch();

    public abstract Operation next();

    public abstract int getAverageWaitingTime();

    public abstract int getAverageTurnAroundTime();
}
