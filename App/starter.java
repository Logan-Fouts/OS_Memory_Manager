package App;

import java.io.File;
import java.util.ArrayList;
import Objects.*;

/*
 * Sets up essential items for the memory manager to run.
 */
public class starter {
    public static void main(String args[]) {
        mem_manage memManager = new mem_manage();
        ArrayList<page_entry> memoryTable = new ArrayList<>();
        readwrite readwrite = new readwrite();
        ArrayList<command> commands = readwrite.read("InputOutput/input.txt");
        ArrayList<error> errors = new ArrayList<>();

        // Remove existing output file(s).
        String outPath = "input.out";
        File f = new File("InputOutput/" + outPath);
        f.delete();
        for (int i = 0; i < 100; i++) { // Please don't have more than 100 output files ;(.
            String path = "input.out" + i;
            File temp = new File("InputOutput/" + path);
            temp.delete();
        }

        if(commands.size() == 0) return;

        memManager.startManage(memoryTable, readwrite, commands, errors);
    }
}
