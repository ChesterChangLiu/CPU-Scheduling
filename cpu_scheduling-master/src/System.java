import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class System {
    private final Scheduler CPUScheduler;
    private final HashMap<Integer, NFCFS> IOScheduler;

    public System(Scheduler CPUSch) {
        CPUScheduler=CPUSch;
        IOScheduler=new HashMap<>();
    }
    void addProcess(Process p) {
        ArrayList<Operation> time=p.getOperations();
        Operation head=new CPUOperation(time.get(0).getOperationTime(), p.getPriority());
        Operation prev=head;
        for (int i=1; i<time.size(); i++) {
            Operation cur;
            if (time.get(i) instanceof CPUOperation) {
                cur=new CPUOperation(time.get(i).getOperationTime(), p.getPriority());
            } else {
                IOOperation curIO= (IOOperation) time.get(i);
                cur = new IOOperation(curIO.getOperationTime(), p.getPriority(), curIO.getDevice());
            }
            prev.setNext(cur);
            prev=cur;
        }
        CPUScheduler.add(head);
    }

    void run() {
        while (true) {
            Scheduler nextQueue=CPUScheduler;
            int nextArrival=-1;
            if (!CPUScheduler.isEmpty()) {
                nextArrival=CPUScheduler.next().getArrivalTime();
            }
            for (Scheduler sch : IOScheduler.values()) {
                if (!sch.isEmpty() && (nextArrival==-1 || sch.next().getArrivalTime()<nextArrival)) {
                    nextArrival=sch.next().getArrivalTime();
                    nextQueue=sch;
                }
            }
            if (nextArrival==-1)
                break;
            Operation next=nextQueue.dispatch();
            next=next.getNext();
            if (next instanceof IOOperation) {
                int device=((IOOperation) next).getDevice();
                if (!IOScheduler.containsKey(device)) {
                    IOScheduler.put(device, new NFCFS());
                }
                IOScheduler.get(device).add(next);
            } else {
                CPUScheduler.add(next);
            }
        }

    }
    public static void main(String[] args) {

    }
}
