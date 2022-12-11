package Algorithms.GenericAlgorithms;

import App.readwrite;
import java.util.ArrayList;
import Objects.*;

public interface alloalgo {
    // Runs through all the instructions and executes them.
    public int doAlgorithm(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, ArrayList<command> commands,
    allocater allocater, ArrayList<error> errors, readwrite readwrite, int numFiles);

    // The method of deciding where to allocate memory goes here.
    public void search(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, command command,
    allocater allocater, ArrayList<error> errors);
}
