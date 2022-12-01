package App;

public class pageentry {
    Boolean allocated;
    int startBlock;
    int endBlock;

    public pageentry() {
        allocated = false;
        startBlock = -1;
        endBlock = -1;
    }

    public void setAllocated(Boolean allocated) {
        this.allocated = allocated;
    }

    public void setStartBlock(int startBlock) {
        this.startBlock = startBlock;
    }

    public void setEndBlock(int endBlock) {
        this.endBlock = endBlock;
    }

    public int getEndBlock() {
        return endBlock;
    }

    public Boolean getAllocated() {
        return allocated;
    }

    public int getStartBlock() {
        return startBlock;
    }
}
