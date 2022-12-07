package App;

import java.util.ArrayList;
import Objects.command;
import Objects.page_entry;

public class starter {
    public static void main(String args[]) {
        mem_manage memManager = new mem_manage();
        ArrayList<page_entry> memoryTable = new ArrayList<>();
        readwrite readwrite = new readwrite();
        ArrayList<command> commands = readwrite.read("InputOutput/input.txt");

        memManager.startManage(memoryTable, readwrite, commands);
    }
}
