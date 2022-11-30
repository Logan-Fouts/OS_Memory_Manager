package App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
                    tempCommands.setNum2(Integer.parseInt(split[2]));
                }
                commands.add(tempCommands);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return commands;
    }
}
