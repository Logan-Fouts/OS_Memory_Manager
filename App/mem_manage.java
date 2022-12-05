package App;

import java.util.ArrayList;
import java.util.HashMap;

import Algorithms.firstfit;
import Algorithms.GenericAlgorithms.allocater;
import Objects.bytes;
import Objects.command;
import Objects.page_entry;

public class mem_manage {
    public void startManage(ArrayList<page_entry> memoryTable, readwrite readwrite,
            ArrayList<command> commands) {
        System.out.println("\n\nStarting Memory Manager!\n~~~~~~~~~~~~~~~~~~~~~~~~");
        ArrayList<bytes> memory = freeMemory(0, Integer.parseInt(commands.get(0).getInstruction()));
        commands.remove(0);
        allocater allocater = new allocater();
        firstfit firstfit = new firstfit();

        firstfit.doAlgorithm(memory, memoryTable, commands, allocater);
        readwrite.write(memory, memoryTable);


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
