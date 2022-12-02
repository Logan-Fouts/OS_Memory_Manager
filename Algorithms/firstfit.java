package Algorithms;

import App.commands;
import App.pageentry;
import App.readwrite;
import java.util.ArrayList;
import java.util.HashMap;

public class firstfit {
    public void doAlgorithm(ArrayList<commands> instructions, ArrayList<bytes> memory,
            HashMap<Integer, pageentry> memoryTable, readwrite readerwriter) {
        deallocate deallocater = new deallocate();
        compact compacter = new compact();
        for (int i = 1; i < instructions.size(); i++) {
            char command = instructions.get(i).getInstruction().charAt(0);
            if (command == 'A') {
                search(instructions.get(i), memory, memoryTable);
            } else if (command == 'D') {
                deallocater.doDealloate(memory, instructions.get(i), memoryTable);
            } else if (command == 'C') {
                compacter.doCompact(memory, memoryTable);
            }
        }
        // When all inctructions have been read and executed write to the file.
        readerwriter.write(memory, memoryTable);
    }

    private void search(commands instruction, ArrayList<bytes> memory, HashMap<Integer, pageentry> memoryTable) {
        allocate allocater = new allocate();
        // Check Free Memory List
        if (memoryTable.get(instruction.getBlock()).getAllocated()) {
            System.out.println("Requested Memory Block Is In Use!");
            return;
        }
        // Loop through memory and find first availble large enough block of memory.
        for (int i = 0; i < memory.size() - (instruction.getSize()); i++) {
            int spaceAvailable = 0;
            for (int j = i; j < instruction.getSize() + j; j++) {
                if (memory.get(j).getAllocated()) {
                    break;
                }
                spaceAvailable++;
                if (spaceAvailable == instruction.getSize()) {
                    System.out.println("Allocating..." + i + " to " + j + "  -ID: " + instruction.getBlock());
                    // Update Page Entry.
                    memoryTable.get(instruction.getBlock()).setAllocated(true);
                    memoryTable.get(instruction.getBlock()).setStartBlock(i);
                    memoryTable.get(instruction.getBlock()).setEndBlock(j);
                    memory.get(i).setId(instruction.getBlock());
                    allocater.allocater(memory, i, j);
                    return;
                }
            }
        }
        // Not enough contiguous memory.
        System.out.println("Not Enough Space for " + instruction.getInstruction() + ";" + instruction.getBlock() + ";"
                + instruction.getSize());
    }
}