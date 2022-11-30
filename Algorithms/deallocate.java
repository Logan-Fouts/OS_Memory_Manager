package Algorithms;

import App.commands;
import java.util.ArrayList;
import java.util.HashMap;

public class deallocate {
    public void doDealloate(ArrayList<bytes> memory, commands instruction, HashMap<Integer, Boolean> memoryTable) {
        // Set block entry to not allocated.
        memoryTable.put(instruction.getBlock(), false);
        // Find the start block with the id from the instruction.
        for (int i = 0; i < memory.size(); i++) {
            if (memory.get(i).getId() == instruction.getBlock()) {
                for (int j = i; j < memory.get(i).getEndBlock(); j++) {
                    memory.get(j).setAllocated(false);
                    memory.get(j).setEndBlock(-1);
                    memory.get(j).setId(-1);
                }
                
            }
        }
    }
}
