package Algorithms.GenericAlgorithms;

import java.util.ArrayList;
import Objects.bytes;
import Objects.command;
import Objects.page_entry;

public class allocater {
    public void allocate(int startByte, int endByte, ArrayList<bytes> memory, ArrayList<page_entry> memoryTable,
            command command) {
        System.out.println("Allocating Bytes: " + startByte + " to " + endByte);
        
        // Set start bytes id to the Id from the command input and set allocation to
        // true. Also, add new entry into the memory table.
        memory.get(startByte).setId(command.getId());
        memory.get(startByte).setAllocated(true);

        // Check if id is already in use.
        for (int i = 0; i < memoryTable.size(); i++) {
            if (command.getId() == memoryTable.get(i).getId()) {
                try {
                    throw new Exception("Memory Block ID In Use!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        memoryTable.add(new page_entry(command.getId(), startByte, endByte));

        // Set all memory in the range to allocated and make sure they have no id.
        for (int i = startByte + 1; i < endByte + 1; i++) {
            memory.get(i).setAllocated(true);
            memory.get(i).setId('\0');
        }
    }
}
