package App;

// Stores and allows for easy access to each line and elements of the instructions.
public class commands {
    String instruction;
    int block;
    int size;

    commands() {
        instruction = null;
        block = '\0';
        size = '\0';
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getInstruction() {
        return instruction;
    }

    public int getBlock() {
        return block;
    }

    public int getSize() {
        return size;
    }
}
