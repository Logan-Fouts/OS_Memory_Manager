package App;

import java.util.ArrayList;
import java.util.HashMap;

import Algorithms.bestfit;
import Algorithms.bytes;
import Algorithms.firstfit;
import Algorithms.worstfit;

public class memmanger {

    public void manageMemory(ArrayList<commands> instructions) {
        bestfit bestfit = new bestfit();
        firstfit firstfit = new firstfit();
        worstfit worstfit = new worstfit();
        int size = Integer.parseInt(instructions.get(0).getInstruction());

        // First Fit.
        ArrayList<bytes> memory = freeMemory(size);
        HashMap<Integer, Boolean> memoryTable = freeTable(size);
        firstfit.doAlgorithm(instructions, memory, memoryTable);

        // // Best Fit.
        // memory = freeMemory(size);
        // memoryTable = freeTable(size);
        // bestfit.doAlgorithm(instructions, memory, memoryTable);

        // // Worst Fit.
        // memory = freeMemory(size);
        // memoryTable = freeTable(size);
        // worstfit.doAlgorithm(instructions, memory, memoryTable);
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

    private HashMap<Integer, Boolean> freeTable(int size) {
        HashMap<Integer, Boolean> memoryTable = new HashMap<Integer, Boolean>();
        for (int i = 0; i < size; i++) {
            memoryTable.put(i, false);
        }
        return memoryTable;
    }
}
