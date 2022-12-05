package Algorithms;

import java.util.ArrayList;
import Algorithms.GenericAlgorithms.alloalgo;
import Algorithms.GenericAlgorithms.allocater;
import Algorithms.GenericAlgorithms.compacter;
import Algorithms.GenericAlgorithms.deallocater;
import Objects.bytes;
import Objects.command;
import Objects.page_entry;

public class firstfit implements alloalgo {
    public void doAlgorithm(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, ArrayList<command> commands,
            allocater allocater) {
        deallocater deallocater = new deallocater();
        compacter compacter = new compacter();
        commands.forEach((c) -> {
            char command = c.getInstruction().charAt(0);
            if (command == 'A')
                search(memory, memoryTable, c, allocater);
            else if (command == 'D')
                deallocater.deallocate(memory, memoryTable, c);
            else if (command == 'C')
                compacter.compact(memory, memoryTable, c);
        });
    }

    private void search(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, command command,
            allocater allocater) {
        for (int i = 0; i < memory.size(); i++) {
            if (!memory.get(i).getAllocated()) {
                int endBlock = 0;
                for (int j = i; j < command.getSize() + (i - 1) && !memory.get(j).getAllocated() && j < memory.size() - 1; j++) {
                    endBlock++;
                }
                if (endBlock == command.getSize() - 1) {
                    allocater.allocate(i, endBlock + i, memory, memoryTable, command);
                    return;
                }
            }
        }
    }
}
