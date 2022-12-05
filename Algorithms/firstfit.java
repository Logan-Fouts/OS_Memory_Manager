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

    @Override
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

    @Override
    public void search(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, command command,
            allocater allocater) {

        // Find first open block large enough for the size from the insruction.
        for (int i = 0; i < memory.size(); i++) {
            if (!memory.get(i).getAllocated()) {
                int endBlock = 0;
                for (int j = i; j < (command.getSize() + i) - 1 && !memory.get(j).getAllocated()
                        && j < (memory.size() - 1); j++) {
                    endBlock++;
                }

                // If large enough spot is found allocate it.
                if (endBlock == command.getSize() - 1) {
                    allocater.allocate(i, endBlock + i, memory, memoryTable, command);
                    return;
                }
            }
        }

        // If no spot is found throw an exception.
        try {
            throw new Exception("Cannot Find Space To Allocate");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
