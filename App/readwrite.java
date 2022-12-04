package App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Objects.command;

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
            System.out.println("Error: " + e);
        }
        return commands;
    }

    public void write() {
        
    }
}
