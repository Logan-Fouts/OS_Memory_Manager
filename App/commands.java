package App;

public class commands {
    String instruction;
    int block;
    int num2;
    int num3;

    commands() {
        instruction = null;
        block = '\0';
        num2 = '\0';
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    public String getInstruction() {
        return instruction;
    }

    public int getBlock() {
        return block;
    }

    public int getNum2() {
        return num2;
    }
}
