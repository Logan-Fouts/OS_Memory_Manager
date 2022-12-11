package Objects;

/*
 * Object that holds the info grabbed from the input file.
 * instruction- The actual command to run.
 * id- The id of the memory block to do the instruction on.
 * size- The entire amount of bytes.
 * index- The line/position of the command in the input file.
 */
public class command {
    String instruction;
    int id;
    int size;
    int index;

    public command() {
        instruction = null;
        id = '\0';
        size = '\0';
        index = '\0';
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getInstruction() {
        return instruction;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public int getIndex() {
        return index;
    }
}
