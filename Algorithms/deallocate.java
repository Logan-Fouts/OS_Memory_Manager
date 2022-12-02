package Algorithms;

import App.commands;
import App.pageentry;

import java.util.ArrayList;
import java.util.HashMap;

// Simply finds the location of the specified memory block id. Then deallocates all memory from the memorys location to the end of its allocated memory.
public class deallocate {
    public void doDealloate(ArrayList<bytes> memory, commands instruction, HashMap<Integer, pageentry> memoryTable) {
        // Set block entry to not allocated.
        memoryTable.get(instruction.getBlock()).setAllocated(false);
        // Find the start block with the id from the instruction.
        for (int i = 0; i < memory.size(); i++) {
            if (memory.get(i).getId() == instruction.getBlock()) {
                // Reset the start memory block to have no Id.
                System.out.println("Deallocating..." + i + " to " + memory.get(i).getEndBlock() + "  -ID: "
                        + instruction.getBlock());
                memory.get(i).setId(-1);
                // Deallocate all memory blocks associated with the id.
                for (int j = i; j < memory.get(i).getEndBlock() + 1; j++) {
                    memory.get(j).setAllocated(false);
                    memory.get(j).setEndBlock(-1);
                    memory.get(j).setId(-1);
                }
                break;
            }
        }
    }
}
