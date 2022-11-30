package Algorithms;

import App.commands;
import java.util.ArrayList;
import java.util.HashMap;

public class firstfit {
    public void doAlgorithm(ArrayList<commands> instructions, ArrayList<bytes> memory,
            HashMap<Integer, Boolean> memoryTable) {
        for (int i = 1; i < instructions.size(); i++) {
            char command = instructions.get(i).getInstruction().charAt(0);
            if (command == 'A') {
                search(instructions.get(i), memory, memoryTable);
            } else if (command == 'D') {
                deallocate deallocater = new deallocate();
                deallocater.doDealloate(memory, instructions.get(i), memoryTable);
            } else if (command == 'C') {
                // TODO: Create Generic Compact;
            }
        }
        // TODO: Create Generic write;
    }

    private void search(commands instruction, ArrayList<bytes> memory, HashMap<Integer, Boolean> memoryTable) {

        // Check Free Memory List
        if (memoryTable.get(instruction.getBlock())) {
            System.out.println("Requested Memory Block Is In Use!");
            return;
        }
        // Loop through memory and find first availble large enough block of memory.
        for (int i = 0; i < memory.size() - (instruction.getNum2()); i++) {
            int spaceAvailable = 0;
            for (int j = i; j < instruction.getNum2() + j; j++) {
                if (memory.get(j).getAllocated()) {
                    break;
                }
                spaceAvailable++;
                if (spaceAvailable == instruction.getNum2()) {
                    j++;
                    System.out.println(i + " to " + j);
                    memoryTable.put(instruction.getBlock(), true);
                    memory.get(i).setId(instruction.getBlock());
                    allocate(memory, i, j);
                    return;
                }
            }
        }
        // Not enough contiguous memory
        System.out.println("Not Enough Space for " + instruction.getInstruction() + ";" + instruction.getBlock() + ";"
                + instruction.getNum2());
    }

    private void allocate(ArrayList<bytes> memory, int startBlock, int endBlock) {
        memory.get(startBlock).setEndBlock(endBlock);
        for (int i = startBlock; i < endBlock + 1; i++) {
            memory.get(i).setAllocated(true);
        }
    }
}