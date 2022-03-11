import java.util.ArrayList;

public class Process {
    private final int arrivalTime;
    private final ArrayList<Operation> operations;
    private final int priority;

//    public enum States {
//        New,
//        Ready,
//        Running,
//        Terminated,
//        WaitingForIO
//
//    }
//    private States state;
    public Process(int a, int p) {
        arrivalTime=a;
        operations=new ArrayList<>();
        priority=p;
//        state=States.New;
    }


    public int getArrivalTime() {
        return arrivalTime;
    }

//    States getState() {
//        return state;
//    }
//
//    void setState(States s) {
//        state=s;
//    }

    public int getPriority() {
        return priority;
    }

    ArrayList<Operation> getOperations() {
        return operations;
    }
}
