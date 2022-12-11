package Algorithms.GenericAlgorithms;

import java.util.ArrayList;
import Objects.*;

/*
 * Simply deallocates the byte(s) passed to it.
 */
public class deallocater {
    public void deallocate(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, command command,
            ArrayList<error> errors) {

        // Set start bytes id to null and set allocation to false. Also, remove entry
        // from the memory table.
        int startByte = '\0';
        int endByte = '\0';
        Boolean exists = false;
        for (int i = 0; i < memoryTable.size(); i++) {
            if (command.getId() == memoryTable.get(i).getId()) {
                exists = true;
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
                for (int q = startByte; q < endByte + 1 && q < memory.size(); q++) {
                    memory.get(q).setAllocated(false);
                    memory.get(q).setId('\0');
                }
            }
        }

        // Adds an error if deallocation cannot happen, and throws exception.
        if (!exists) {
            try {
                throw new Exception("Cannot Find and Deallocate");
            } catch (Exception e) {
                e.printStackTrace();
                errors.add(new error(command.getInstruction(), command.getIndex(), '\0', command.getId()));
            }
        }
    }
}
