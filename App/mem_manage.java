package App;

import java.io.File;
import java.util.ArrayList;
import Algorithms.bestfit;
import Algorithms.firstfit;
import Algorithms.GenericAlgorithms.allocater;
import Objects.bytes;
import Objects.command;
import Objects.error;
import Objects.page_entry;

public class mem_manage {
    public void startManage(ArrayList<page_entry> memoryTable, readwrite readwrite,
            ArrayList<command> commands) {
        System.out.println("\n\nStarting Memory Manager!\n~~~~~~~~~~~~~~~~~~~~~~~~");

        // Remove existing output file.
        String outPath = "output.txt";
        File f = new File("InputOutput/" + outPath);
        f.delete();

        // Error collection.
        ArrayList<error> errors = new ArrayList<>();

        // Set up the memory.
        int memSize = Integer.parseInt(commands.get(0).getInstruction());
        ArrayList<bytes> memory = freeMemory(0, memSize);
        commands.remove(0);
        allocater allocater = new allocater();

        // Do each fit algorithm.

        // First Fit, write, then clear memory.
        firstfit firstfit = new firstfit();
        firstfit.doAlgorithm(memory, memoryTable, commands, allocater, errors);
        readwrite.write(memory, memoryTable, outPath, "First Fit", errors);
        freeMemory(0, memSize);

        // Best Fit, write, then clear memory.
        // bestfit bestfit = new bestfit();
        // bestfit.doAlgorithm(memory, memoryTable, commands, allocater);
        // readwrite.write(memory, memoryTable, outPath);
        // freeMemory(0, memSize);

        System.out.println("\n\n");
    }

    private ArrayList<bytes> freeMemory(int startByte, int endByte) {
        ArrayList<bytes> tempMemory = new ArrayList<>();
        for (int i = 0; i < endByte; i++) {
            bytes tempByte = new bytes();
            tempMemory.add(tempByte);
        }
        return tempMemory;
    }
}
