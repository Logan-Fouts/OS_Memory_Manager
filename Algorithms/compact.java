package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import App.pageentry;

public class compact {
    public void doCompact(ArrayList<bytes> memory, HashMap<Integer, pageentry> memoryTable) {
        System.out.println("Compacting");
        allocate allocater = new allocate();
        // Find id's in table that are taken.
        for (int i = 0; i < memoryTable.size(); i++) {
            if (memoryTable.get(i).getAllocated() && memoryTable.get(i).getStartBlock() != 0) {
                // Find first free block to move the memory to.
                for (int j = 0; j < memory.size(); j++) {
                    if (!memory.get(j).getAllocated()) {
                        int endBlock = (memoryTable.get(i).getEndBlock() - memoryTable.get(i).getStartBlock()) + j;
                        memoryTable.get(i).setStartBlock(j); // New Start Position
                        memoryTable.get(i).setEndBlock(endBlock); // New End Position
                        memory.get(j).setEndBlock(endBlock);
                        allocater.allocater(memory, j, endBlock);
                        break;
                    }
                }
            }
        }
        // Find the first free spot in memory.
        for (int i = 0; i < memory.size(); i++) {
            if (!memory.get(i).getAllocated()) {
                for (int j = i; j < memory.size(); j++) {
                    memory.get(j).setAllocated(false);
                    memory.get(j).setEndBlock(-1);
                    memory.get(j).setId(-1);
                }
            }
        }
    }
}
