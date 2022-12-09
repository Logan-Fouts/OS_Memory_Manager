package Algorithms;

import java.util.ArrayList;
import Algorithms.GenericAlgorithms.alloalgo;
import Algorithms.GenericAlgorithms.allocater;
import Algorithms.GenericAlgorithms.compacter;
import Algorithms.GenericAlgorithms.deallocater;
import App.readwrite;
import Objects.bytes;
import Objects.command;
import Objects.error;
import Objects.page_entry;

public class firstfit implements alloalgo {

    @Override
    public void doAlgorithm(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, ArrayList<command> commands,
            allocater allocater, ArrayList<error> errors, readwrite readwrite) {
        deallocater deallocater = new deallocater();
        compacter compacter = new compacter();

        int j = 0;
        for (int i = 0; i < commands.size(); i++) {
            char command = commands.get(i).getInstruction().charAt(0);
            if (command == 'A')
                search(memory, memoryTable, commands.get(i), allocater, errors);
            else if (command == 'D')
                deallocater.deallocate(memory, memoryTable, commands.get(i), errors);
            else if (command == 'C')
                compacter.compact(memory, memoryTable, commands.get(i));
            else if (command == 'O') {
                String fileName =  "output" + j + ".txt";
                readwrite.write(memory, memoryTable, fileName, null, errors);
                j++;
            }
        }
    }

    @Override
    public void search(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, command command,
            allocater allocater, ArrayList<error> errors) {
        int largest = -1;
        // Find first open block large enough for the size from the insruction.
        for (int i = 0; i < memory.size(); i++) {
            if (!memory.get(i).getAllocated()) {
                int endBlock = 0;
                for (int j = i; j < (command.getSize() + (i - 1)) && !memory.get(j).getAllocated()
                        && j < memory.size() - 1; j++) {
                    endBlock++;
                    if (j == memory.size() - 2)
                        endBlock++;
                }
                // If large enough spot is found allocate it.
                if (endBlock >= command.getSize() - 1) {
                    allocater.allocate(i, endBlock + i, memory, memoryTable, command, errors);
                    return;
                } else if (largest < endBlock) {
                    largest = endBlock;
                }
            }
        }

        // Adds an error if allocation cannot happen, and throws an exception.
        try {
            throw new Exception("Cannot Find Space To Allocate");
        } catch (Exception e) {
            e.printStackTrace();
            // Find the largest open block.
            errors.add(new error(command.getInstruction(), command.getIndex(), largest, command.getId()));
        }
    }
}
