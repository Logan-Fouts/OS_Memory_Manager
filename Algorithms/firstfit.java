package Algorithms;

import Algorithms.GenericAlgorithms.*;
import App.readwrite;
import java.util.ArrayList;
import Objects.*;

public class firstfit implements alloalgo {

    @Override
    public int doAlgorithm(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, ArrayList<command> commands,
            allocater allocater, ArrayList<error> errors, readwrite readwrite, int numFiles) {

        deallocater deallocater = new deallocater();
        compacter compacter = new compacter();

        int j = numFiles;
        for (int i = 0; i < commands.size(); i++) {
            char command = commands.get(i).getInstruction().charAt(0);
            if (command == 'A')
                search(memory, memoryTable, commands.get(i), allocater, errors);
            else if (command == 'D')
                deallocater.deallocate(memory, memoryTable, commands.get(i), errors);
            else if (command == 'C')
                compacter.compact(memory, memoryTable, commands.get(i));
            else if (command == 'O') {
                String fileName = "input.out" + j;
                readwrite.write(memory, memoryTable, fileName, "First Fit", errors);
                j++;
            }
        }
        return j;
    }

    // Find first open block large enough for the size from the insruction.
    @Override
    public void search(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, command command,
            allocater allocater, ArrayList<error> errors) {
        int largest = -1;
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
            errors.add(new error(command.getInstruction(), command.getIndex(), largest, command.getId()));
        }
    }
}
