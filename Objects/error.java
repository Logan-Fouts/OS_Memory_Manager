package Objects;

public class error {
    String instruction;
    int instructionNum;
    int failureReason;
    Boolean attemptedFailure;

    error() {
        instruction = null;
        instructionNum = '\0';
        failureReason = '\0';
        attemptedFailure = false;
    }

    public error(String instruction, int instructionNum, int failureReason, Boolean attemptedFailure) {
        this.instruction = instruction;
        this.instructionNum = instructionNum;
        this.failureReason = failureReason;
        this.attemptedFailure = attemptedFailure;
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

    public void setAttemptedFailure(Boolean attemptedFailure) {
        this.attemptedFailure = attemptedFailure;
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

    public int getAttemptedFailure() {
        if (attemptedFailure) return 1;
        return 0;
    }
}
