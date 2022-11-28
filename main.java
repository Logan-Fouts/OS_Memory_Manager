package OS_Memory_Manager;

import java.util.HashMap;

public class main {
    public static void main(String args[]) {
        memmanager memSystem = new memmanager();
        inout readwrite = new inout();
        String path = "OS_Memory_Manager/input.txt";
        HashMap<Integer, String> commands = readwrite.read(path);

        memSystem.startMemManager(commands, readwrite);
    }
}