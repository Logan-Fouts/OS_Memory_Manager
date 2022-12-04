package App;

import java.util.ArrayList;
import java.util.HashMap;

import Objects.command;
import Objects.page_entry;

public class starter {
    public static void main(String args[]) {
        mem_manage memManager = new mem_manage();
        HashMap<Integer, page_entry> memoryTable = new HashMap<>();
        readwrite readwrite = new readwrite();
        ArrayList<command> commands = readwrite.read("InputOutput/input.txt");

        memManager.startManage(memoryTable, readwrite, commands);
    }
}
