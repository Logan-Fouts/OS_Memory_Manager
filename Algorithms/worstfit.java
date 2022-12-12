package Algorithms;

import Algorithms.GenericAlgorithms.*;
import App.readwrite;
import Objects.*;
import java.util.ArrayList;

public class worstfit implements alloalgo {

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
                readwrite.write(memory, memoryTable, fileName, "Worst Fit", errors);
                j++;
            }
        }
        return j;
    }

    @Override
    public void search(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, command command, allocater allocater,
            ArrayList<error> errors) {
        int size = 0;
        int q = 0;
        ArrayList<page_entry> freeBlocks = new ArrayList<>();
        for (int i = 0; i < memory.size(); i = i + (size + 1)) {
            size = 0;
            for (int j = i; j < memory.size() && !memory.get(j).getAllocated(); j++) {
                size++;
            }
            if (size != 0) {
                freeBlocks.add(new page_entry(q, i, ((i - 1) + size)));
                q++;
            }
        }

        boolean enoughSpace = false;
        int largest = -1;
        for (int i = 0; i < freeBlocks.size(); i++) {
            if (freeBlocks.get(i).getEndAddress() - freeBlocks.get(i).getStartAddress() + 1 >= command.getSize()) {
                enoughSpace = true;
            }
            if (freeBlocks.get(i).getEndAddress() - freeBlocks.get(i).getStartAddress() + 1 > largest)
                largest = freeBlocks.get(i).getEndAddress() - freeBlocks.get(i).getStartAddress() + 1;
        }

        // Adds an error if allocation cannot happen, and throws an exception.
        if (!enoughSpace) {
            try {
                throw new Exception("Cannot Find Space To Allocate");
            } catch (Exception e) {
                e.printStackTrace();
                errors.add(new error(command.getInstruction(), command.getIndex(), largest, command.getId()));
                return;
            }
        }

        int distance = 0;
        page_entry blockToAllocate = new page_entry();
        for (int i = 0; i < freeBlocks.size(); i++) {
            int tempSize = freeBlocks.get(i).getEndAddress() - freeBlocks.get(i).getStartAddress() + 1;
            int tempDistance = Math.abs(tempSize - command.getSize());
            if (tempDistance > distance && tempSize >= command.getSize()) {
                distance = tempDistance;
                blockToAllocate = freeBlocks.get(i);
            }
        }
        allocater.allocate(blockToAllocate.getStartAddress(),
                (blockToAllocate.getStartAddress() + command.getSize() - 1), memory, memoryTable, command, errors);
    }
}