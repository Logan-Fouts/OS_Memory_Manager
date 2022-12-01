package App;

import Algorithms.bestfit;
import Algorithms.bytes;
import Algorithms.firstfit;
import Algorithms.worstfit;
import java.util.ArrayList;
import java.util.HashMap;

public class memmanger {

    public void manageMemory(ArrayList<commands> instructions, readwrite readerwriter) {
        System.out.println("\n\nStarting The Memory Manager!\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        firstfit firstfit = new firstfit();
        bestfit bestfit = new bestfit();
        worstfit worstfit = new worstfit();
        int size = Integer.parseInt(instructions.get(0).getInstruction());

        // First Fit.
        ArrayList<bytes> memory = freeMemory(size);
        HashMap<Integer, pageentry> memoryTable = freeTable(size);
        firstfit.doAlgorithm(instructions, memory, memoryTable, readerwriter);

        // Best Fit.
        // memory = freeMemory(size);
        // memoryTable = freeTable(size);
        // bestfit.doAlgorithm(instructions, memory, memoryTable, readerwriter);

        // Worst Fit.
        // memory = freeMemory(size);
        // memoryTable = freeTable(size);
        // worstfit.doAlgorithm(instructions, memory, memoryTable, readerwriter);
    }

    // Get size and create that amount of empty availiable bytes in the memory Array
    // List. False means free True means taken.
    private ArrayList<bytes> freeMemory(int size) {
        ArrayList<bytes> memory = new ArrayList<bytes>();
        for (int i = 0; i < size; i++) {
            bytes tempByte = new bytes();
            memory.add(tempByte);
        }
        return memory;
    }

    // Run before each algorithm to free the memory table.
    private HashMap<Integer, pageentry> freeTable(int size) {
        HashMap<Integer, pageentry> memoryTable = new HashMap<Integer, pageentry>();
        for (int i = 0; i < size; i++) {
            pageentry tempEntry = new pageentry();
            memoryTable.put(i, tempEntry);
        }
        return memoryTable;
    }
}
