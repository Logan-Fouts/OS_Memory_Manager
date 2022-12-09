package Algorithms.GenericAlgorithms;

import java.util.ArrayList;

import App.readwrite;
import Objects.bytes;
import Objects.command;
import Objects.error;
import Objects.page_entry;

public interface alloalgo {
    public void doAlgorithm(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, ArrayList<command> commands,
    allocater allocater, ArrayList<error> errors, readwrite readwrite);

    public void search(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, command command,
    allocater allocater, ArrayList<error> errors);
}
