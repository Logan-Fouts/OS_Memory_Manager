package Algorithms.GenericAlgorithms;

import java.util.ArrayList;
import Objects.bytes;
import Objects.command;
import Objects.page_entry;

public class compacter {
    public void compact(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, command command) {
        System.out.println("Compacting");

        for (int i = 0; i < memory.size(); i++) {
            memory.get(i).setAllocated(false);
            memory.get(i).setId('\0');
        }

        for (int i = 0; i < memoryTable.size(); i++) {
            for (int j = i; j < memory.size(); j++) {
                if (!memory.get(j).getAllocated()) {
                    int newEnd = (memoryTable.get(i).getEndAddress() - memoryTable.get(i).getStartAddress()) + j;
                    if (newEnd >= memory.size())
                        newEnd = memory.size() - 1;
                    memoryTable.get(i).setStartAddress(j);
                    memoryTable.get(i).setEndAddress(newEnd);
                    System.out.println("Moving Block ID: " + memoryTable.get(i).getId() + " to byte " + j);
                    memory.get(j).setId(command.getId());
                    memory.get(j).setAllocated(true);
                    for (int q = j + 1; q < newEnd + 1; q++) {
                        memory.get(q).setAllocated(true);
                        memory.get(q).setId('\0');
                    }
                    break;
                }
            }
        }
    }
}