package App;

import Algorithms.*;
import Algorithms.GenericAlgorithms.*;
import java.util.ArrayList;
import Objects.*;

public class mem_manage {
    public void startManage(ArrayList<page_entry> memoryTable, readwrite readwrite,
            ArrayList<command> commands, ArrayList<error> errors) {

        System.out.println("\n\nStarting Memory Manager!\n~~~~~~~~~~~~~~~~~~~~~~~~");

        // Set up the memory.
        int memSize = Integer.parseInt(commands.get(0).getInstruction());
        ArrayList<bytes> memory = freeMemory(0, memSize, memoryTable, errors);
        commands.remove(0);
        allocater allocater = new allocater();

        // Do each fit algorithm.
        int numFiles = 0;

        // First Fit, write, then clear memory and memorytable.
        System.out.println("\nFirstFit:");
        firstfit firstfit = new firstfit();
        numFiles = firstfit.doAlgorithm(memory, memoryTable, commands, allocater, errors, readwrite, numFiles);
        readwrite.write(memory, memoryTable, "input.out", "First Fit", errors);
        memory = freeMemory(0, memSize, memoryTable, errors);

        // Best Fit, write, then clear memory.
        System.out.println("\nBestFit:");
        bestfit bestfit = new bestfit();
        numFiles = bestfit.doAlgorithm(memory, memoryTable, commands, allocater, errors, readwrite, numFiles);
        readwrite.write(memory, memoryTable, "input.out", "Best Fit", errors);
        memory = freeMemory(0, memSize, memoryTable, errors);

        // Worst Fit then write.
        System.out.println("WorstFit:");
        worstfit worstfit = new worstfit();
        numFiles = worstfit.doAlgorithm(memory, memoryTable, commands, allocater, errors, readwrite, numFiles);
        readwrite.write(memory, memoryTable, "input.out", "Worst Fit", errors);

        System.out.println("Finished!");
    }

    // Clears all the memory, memoryTable, and errors.
    private ArrayList<bytes> freeMemory(int startByte, int endByte, ArrayList<page_entry> memoryTable,
            ArrayList<error> errors) {
        ArrayList<bytes> tempMemory = new ArrayList<>();
        for (int i = 0; i < endByte; i++) {
            bytes tempByte = new bytes();
            tempMemory.add(tempByte);
        }
        for (int i = memoryTable.size() - 1; i > -1; i--) {
            memoryTable.remove(i);
        }
        for (int i = errors.size() - 1; i > -1; i--) {
            errors.remove(i);
        }
        return tempMemory;
    }
}
