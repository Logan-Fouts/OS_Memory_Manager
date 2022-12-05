package Algorithms.GenericAlgorithms;

import java.util.ArrayList;
import Objects.bytes;
import Objects.command;
import Objects.page_entry;

public class deallocater {
    public void deallocate(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, command command) {
        // Set start bytes id to null and set allocation to false. Also, remove entry
        // from the memory table.
        int startByte = -1;
        int endByte = -1;
        for (int i = 0; i < memoryTable.size(); i++) {
            if (command.getId() == memoryTable.get(i).getId()) {
                startByte = memoryTable.get(i).getStartAddress();
                endByte = memoryTable.get(i).getEndAddress();
                System.out.println("Deallocating Bytes: " + startByte + " to " + endByte);
                memory.get(startByte).setId('\0');
                memory.get(startByte).setAllocated(false);
                for (int j = 0; j < memoryTable.size(); j++) {
                    if (command.getId() == memoryTable.get(j).getId()) {
                        memoryTable.remove(j);
                        break;
                    }
                }
                // Set all memory in the range to not allocated and make sure they have no id.
                for (int q = startByte + 1; q < endByte + 1; q++) {
                    memory.get(q).setAllocated(false);
                    memory.get(q).setId('\0');
                }
            }
        }
    }
}
