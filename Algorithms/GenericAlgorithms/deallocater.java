package Algorithms.GenericAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import Objects.bytes;
import Objects.command;
import Objects.page_entry;

public class deallocater {
    public void deallocate(ArrayList<bytes> memory, HashMap<Integer, page_entry> memoryTable, command command) {
        // Set start bytes id to null and set allocation to false. Also, remove entry from the memory table.
        int startByte = memoryTable.get(command.getId()).getStartAddress();
        int endByte = memoryTable.get(command.getId()).getEndAddress();
        System.out.println("ID:" + command.getId() + "   Deallocating Bytes: " + startByte + " to " + endByte);
        memory.get(startByte).setId('\0');
        memory.get(startByte).setAllocated(false);
        memoryTable.remove(command.getId());

        // Set all memory in the range to not allocated and make sure they have no id.
        for (int i = startByte + 1; i < endByte + 1; i++) {
            memory.get(i).setAllocated(true);
            memory.get(i).setId('\0');
        }
    }
}
