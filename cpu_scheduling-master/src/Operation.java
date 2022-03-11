public abstract class Operation {
    protected int operationTime, priority;
    private int arrivalTime, startTime;
    private Operation next;


    public int getOperationTime() {
        return operationTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }
    public void setArrivalTime(int at) {
        arrivalTime = at;
    }

    public void setStartTime(int st) {
        startTime=st;
    }

    public void setNext(Operation n) {
        next=n;
    }
    Operation getNext() {
        return next;
    }
}
