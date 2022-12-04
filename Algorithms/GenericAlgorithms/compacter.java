package Algorithms.GenericAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import Objects.bytes;
import Objects.command;
import Objects.page_entry;

public class compacter {
    public void compact(ArrayList<bytes> memory, HashMap<Integer, page_entry> memoryTable, command command) {
        allocater allocater = new allocater();
        // TODO
        // memoryTable.forEach((key, value) -> {
        //     for (int i = 0; i < memory.size(); i++) {
        //         if (!memory.get(i).getAllocated()) {
        //             int newEnd = (value.getEndAddress() - value.getStartAddress()) + i;
        //             value.setStartAddress(i);
        //             value.setEndAddress(newEnd);
        //             allocater.allocate(i, newEnd, memory, memoryTable, command);
        //         }
        //     }
        // });
    }
}
