package Algorithms.GenericAlgorithms;

import java.util.ArrayList;
import Objects.*;

/*
 * Incrementaly runs through memory and moves memory blocks to the start of the memory.
 */
public class compacter {
    public void compact(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, command command) {
        for (int f = 0; f < memory.size(); f++) {
            int firstUnallocated = -1;
            int firstAllocated = -1;
            for (int i = 0; i < memory.size(); i++) {
                if (!memory.get(i).getAllocated()) {
                    firstUnallocated = i;
                    break;
                }
            }
            for (int i = firstUnallocated + 1; i < memory.size(); i++) {
                if (memory.get(i).getAllocated()) {
                    firstAllocated = i;
                    break;
                }
            }
            if (firstUnallocated == -1 || firstAllocated == -1)
                return;
            for (int i = 0; i < memoryTable.size(); i++) {
                if (memoryTable.get(i).getId() == memory.get(firstAllocated).getId()) {
                    System.out.println("Compacting");
                    int size = memoryTable.get(i).getEndAddress() - memoryTable.get(i).getStartAddress() + 1;

                    System.out.println("Deallocating " + memoryTable.get(i).getStartAddress() + " To "
                            + (memoryTable.get(i).getEndAddress()));
                    for (int q = memoryTable.get(i).getStartAddress(); q < memoryTable.get(i).getEndAddress() + 1
                            && q < memory.size(); q++) {
                        memory.get(q).setAllocated(false);
                        memory.get(q).setId(-1);
                    }

                    memoryTable.get(i).setStartAddress(firstUnallocated);
                    memoryTable.get(i).setEndAddress(size + firstUnallocated - 1);

                    memory.get(firstUnallocated).setAllocated(true);
                    memory.get(firstUnallocated).setId(memoryTable.get(i).getId());

                    System.out.println("Allocating " + firstUnallocated + " To " + (size + firstUnallocated - 1));
                    for (int m = firstUnallocated + 1; m < size + firstUnallocated && m < memory.size(); m++) {
                        memory.get(m).setAllocated(true);
                        memory.get(m).setId(-1);
                    }

                    System.out.println("Done Compacting");
                    break;
                }
            }
        }
    }
}