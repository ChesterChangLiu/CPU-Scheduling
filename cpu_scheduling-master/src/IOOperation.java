public class IOOperation extends Operation{
    private final int device;
    public IOOperation(int op, int p, int d) {
        operationTime=op;
        priority=p;
        device=d;
    }

    public int getDevice() {
        return device;
    }
}
