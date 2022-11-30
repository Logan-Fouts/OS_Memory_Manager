package Algorithms;

import java.util.ArrayList;

public class bytes {
    ArrayList<Integer> value = new ArrayList<>();
    Boolean allocated;
    int Id;
    int endBlock;

    public bytes() {
        for (int i = 0; i < 8; i++) value.add(0);
        allocated = false;
        Id = -1;
        endBlock = -1;
    }

    public void setAllocated(Boolean allocated) {
        this.allocated = allocated;
    }

    public void setId(int id) {
        Id = id;
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
        return Id;
    }

    public int getEndBlock() {
        return endBlock;
    }
}
