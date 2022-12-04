package Objects;

public class command {
    String instruction;
    int id;
    int size;

    public command() {
        instruction = null;
        id = '\0';
        size = '\0';
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

    public String getInstruction() {
        return instruction;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }
}
