package Objects;

/*
 * Object that holds info about errors that can occur.
 * instruction- The command from the instruction that failed.
 * instuctionNum- The index of the instuction that failed.
 * failureReason- Either the size of largest block of memory or the state if the allocation of the id failed previously.
 * id- The id of the failed command from the instuction.
 */
public class error {
    String instruction;
    int instructionNum;
    int failureReason;
    int id;

    error() {
        instruction = null;
        instructionNum = '\0';
        failureReason = '\0';
        id = '\0';
    }

    public error(String instruction, int instructionNum, int failureReason, int id) {
        this.instruction = instruction;
        this.instructionNum = instructionNum;
        this.failureReason = failureReason;
        this.id = id;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setInstructionNum(int instructionNum) {
        this.instructionNum = instructionNum;
    }

    public void setFailureReason(int failureReason) {
        this.failureReason = failureReason;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInstruction() {
        return instruction;
    }

    public int getInstructionNum() {
        return instructionNum;
    }

    public int getFailureReason() {
        return failureReason;
    }

    public int getId() {
        return id;
    }
}
