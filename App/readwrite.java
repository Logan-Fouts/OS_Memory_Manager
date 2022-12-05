package App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Objects.bytes;
import Objects.command;
import Objects.page_entry;

public class readwrite {

    public ArrayList<command> read(String filePath) {
        ArrayList<command> commands = new ArrayList<command>();
        try {
            String tempString;
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            while ((tempString = reader.readLine()) != null) {
                String split[] = tempString.split(";");
                command tempCommands = new command();
                if (split.length > 0) {
                    tempCommands.setInstruction(split[0]);
                }
                if (split.length > 1) {
                    tempCommands.setId(Integer.parseInt(split[1]));
                }
                if (split.length > 2) {
                    tempCommands.setSize(Integer.parseInt(split[2]));
                }
                commands.add(tempCommands);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Reading Error: " + e);
        }
        return commands;
    }

    public void write(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable) {
        ArrayList<Double> sizes = new ArrayList<>();
        System.out.println("\nAllocated Blocks\n~~~~~~~~~~~~~~~~");
        memoryTable.forEach((b) -> {
            System.out.println(b.getId() + ";" + b.getStartAddress() + ";" + b.getEndAddress());
        });

        System.out.println("\nUn-allocated Blocks\n~~~~~~~~~~~~~~~~");
        int size = 0;
        for (int i = 0; i < memory.size(); i = i + (size + 1)) {
            size = 0;
            for (int j = i; j < memory.size() && !memory.get(j).getAllocated(); j++) {
                size++;
            }
            if (size != 0) {
                System.out.println(i + ";" + ((i - 1) + size));
                sizes.add((double) (size ));
            }
        }
        calcFragment(sizes);
    }

    private void calcFragment(ArrayList<Double> sizes) {
        double largestFree = -1;
        double totalFree = 0;
        for (int i = 0; i < sizes.size(); i++) {
            if (sizes.get(i) > largestFree)
                largestFree = sizes.get(i);
            totalFree = totalFree + sizes.get(i);
        }
        double fragmentation = 1 - ((largestFree) / (totalFree));
        System.out.println("\nFragmentation\n~~~~~~~~~~~~~\n" + String.format("%.6f", fragmentation));
    }
}
