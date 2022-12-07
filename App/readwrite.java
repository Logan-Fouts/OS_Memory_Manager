package App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Objects.bytes;
import Objects.command;
import Objects.error;
import Objects.page_entry;

public class readwrite {

    public ArrayList<command> read(String filePath) {
        ArrayList<command> commands = new ArrayList<command>();
        try {
            String tempString;
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            int i = 0;
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
                tempCommands.setIndex(i);
                commands.add(tempCommands);
                i++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Reading Error: " + e);
        }
        return commands;
    }

    public void write(ArrayList<bytes> memory, ArrayList<page_entry> memoryTable, String fileName, String method, ArrayList<error> errors) {

        writeFile(fileName, method);

        writeFile(fileName, "Allocated Blocks");
        ArrayList<Double> sizes = new ArrayList<>();
        memoryTable.forEach((b) -> {
            String text = b.getId() + ";" + b.getStartAddress() + ";" + b.getEndAddress();
            writeFile(fileName, text);
        });

        writeFile(fileName, "Free Blocks");
        int size = 0;
        for (int i = 0; i < memory.size(); i = i + (size + 1)) {
            size = 0;
            for (int j = i; j < memory.size() && !memory.get(j).getAllocated(); j++) {
                size++;
            }
            if (size != 0) {
                String text = i + ";" + ((i - 1) + size);
                writeFile(fileName, text);
                sizes.add((double) (size));
            }
        }
        calcFragment(sizes, fileName);

        writeFile(fileName, "Errors");
        for (int i = 0; i < errors.size(); i++) {
            String text;
            if (errors.get(i).getInstruction().charAt(0) == 'A') {
                text = errors.get(i).getInstruction() + ";" + errors.get(i).getInstructionNum() + ";" + errors.get(i).getFailureReason();
                writeFile(fileName, text);
            }  else {
                // TODO: Figure out the attempted failure shit.
            }
        }
    }

    public void writeFile(String fileName, String text) {
        try {
            String path = "InputOutput/" + fileName;
            FileWriter w = new FileWriter(path, true);
            w.write(text);
            w.write("\n");
            w.close();
        } catch (Exception e) {
            System.out.println("File: " + fileName + " could not be written to");
            e.printStackTrace();
        }
    }

    private void calcFragment(ArrayList<Double> sizes, String fileName) {
        double largestFree = -1;
        double totalFree = 0;
        for (int i = 0; i < sizes.size(); i++) {
            if (sizes.get(i) > largestFree)
                largestFree = sizes.get(i);
            totalFree = totalFree + sizes.get(i);
        }
        double fragmentation = 1 - ((largestFree) / (totalFree));
        writeFile(fileName, "Fragmentation\n" + String.format("%.6f", fragmentation));
    }
}