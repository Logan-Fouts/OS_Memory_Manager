package OS_Memory_Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.io.IOException;

public class inout {
    public HashMap<Integer, String> read(String path) {
        HashMap<Integer, String> commands = new HashMap<Integer, String>();
        try {
            String tempString;
            int i = 0;
            BufferedReader reader = new BufferedReader(new FileReader("OS_Memory_Manager/input.txt"));
            while ((tempString = reader.readLine()) != null) {
                commands.put(i, tempString);
                i++;
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
        return commands;
    }
}
