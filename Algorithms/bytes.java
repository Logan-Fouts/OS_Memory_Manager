package Algorithms;

import java.util.ArrayList;

// Each item in the memory ararylist holds one of these byte objects.
public class bytes {
    ArrayList<Integer> value = new ArrayList<>();
    Boolean allocated;
    int id;
    int startBlock;
    int endBlock;

    public bytes() {
        for (int i = 0; i < 8; i++) value.add(0);
        allocated = false;
        id = -1;
        startBlock = -1;
        endBlock = -1;
    }

    public void setAllocated(Boolean allocated) {
        this.allocated = allocated;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEndBlock(int endBlock) {
        this.endBlock = endBlock;
    }
    
    public ArrayList<Integer> getValue() {
        return value;
    }

    public Boolean getAllocated() {
        return allocated;
    }

    public int getId() {
        return id;
    }

    public int getEndBlock() {
        return endBlock;
    }
}
