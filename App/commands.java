package App;

public class commands {
    String instruction;
    String block;
    String num2;
    String num3;

    commands() {
        instruction = null;
        block = null;
        num2 = null;
        num3 = null;
    }
    commands(String instruction, String block, String num2, String num3) {
        this.instruction = instruction;
        this.block = block;
        this.num2 = num2;
        this.num3 = num3;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public void setNum2(String num2) {
        this.num2 = num2;
    }

    public void setNum3(String num3) {
        this.num3 = num3;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getBlock() {
        return block;
    }

    public String getNum2() {
        return num2;
    }

    public String getNum3() {
        return num3;
    }
}
