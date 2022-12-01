package App;

import java.util.ArrayList;

public class Start {
    public static void main(String args[]) {
        readwrite readerwriter = new readwrite();
        String filePath = "InputOutput/input.txt";
        memmanger memmanger = new memmanger();
        ArrayList<commands> instructions = readerwriter.read(filePath);

        memmanger.manageMemory(instructions, readerwriter);
     }
}
