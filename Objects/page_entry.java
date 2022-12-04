package Objects;

public class page_entry {
    int startAddress;
    int endAddress;

    public page_entry() {
        startAddress = '\0';
        endAddress = '\0';
    }

    public page_entry(int startAddress, int endAddress) {
        this.startAddress = startAddress;
        this.endAddress = endAddress;
    }

    public void setStartAddress(int startAddress) {
        this.startAddress = startAddress;
    }

    public void setEndAddress(int endAddress) {
        this.endAddress = endAddress;
    }

    public int getStartAddress() {
        return startAddress;
    }

    public int getEndAddress() {
        return endAddress;
    }
}
