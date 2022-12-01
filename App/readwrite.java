package App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Algorithms.bytes;

public class readwrite {

    public ArrayList<commands> read(String filePath) {
        ArrayList<commands> commands = new ArrayList<commands>();
        try {
            String tempString;
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((tempString = reader.readLine()) != null) {
                String split[] = tempString.split(";");
                commands tempCommands = new commands();
                if (split.length > 0) {
                    tempCommands.setInstruction(split[0]);
                }
                if (split.length > 1) {
                    tempCommands.setBlock(Integer.parseInt(split[1]));
                }
                if (split.length > 2) {
                    tempCommands.setSize(Integer.parseInt(split[2]));
                }
                commands.add(tempCommands);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return commands;
    }

    public void write(ArrayList<bytes> memory, HashMap<Integer, pageentry> memoryTable) {
        System.out.println("\nWriting To File\n~~~~~~~~~~~~~~~");
        // Show All Allocated Blocks.
        System.out.println("Allocated Blocks:");
        for (int i = 0; i < memoryTable.size(); i++) {
            if (memoryTable.get(i).getAllocated()) {
                System.out.println(
                        +i + ";" + memoryTable.get(i).getStartBlock() + ";" + memoryTable.get(i).getEndBlock());
            }
        }

        // Show All Free Blocks In Memory.
        System.out.println("\nFree Blocks:");
        int size = 0;
        for (int i = 0; i < memory.size(); i = i + (size + 1)) {
            size = 0;
            for (int j = i; j < memory.size() && !memory.get(j).getAllocated(); j++) {
                size++;
            }
            if (size != 0) {
                System.out.println(i + ";" + ((i - 1) + size));
            }
        }
        calcFragment(memory);
    }

    private void calcFragment(ArrayList<bytes> memory) {
        // TODO  fragmentation = 1-(largest block of free memory/ total free memory)
    }
}
