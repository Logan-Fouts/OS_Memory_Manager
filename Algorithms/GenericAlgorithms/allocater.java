package Algorithms.GenericAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import Objects.bytes;
import Objects.command;
import Objects.page_entry;

public class allocater {
    public void allocate(int startByte, int endByte, ArrayList<bytes> memory, HashMap<Integer, page_entry> memoryTable, command command) {
        System.out.println("ID:" + command.getId() + "   Allocating Bytes: " + startByte + " to " + endByte);
        // Set start bytes id to the Id from the command input and set allocation to true. Also, add new entry into the memory table.
        memory.get(startByte).setId(command.getId());
        memory.get(startByte).setAllocated(true);
        memoryTable.put(command.getId(), new page_entry(startByte, endByte));

        // Set all memory in the range to allocated and make sure they have no id.
        for (int i = startByte + 1; i < endByte + 1; i++) {
            memory.get(i).setAllocated(true);
            memory.get(i).setId('\0');
        }
    }
}
