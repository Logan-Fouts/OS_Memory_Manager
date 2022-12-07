package Objects;

public class page_entry {
    int id;
    int startAddress;
    int endAddress;

    public page_entry() {
        id = '\0';
        startAddress = '\0';
        endAddress = '\0';
    }

    public page_entry(int id, int startAddress, int endAddress) {
        this.startAddress = startAddress;
        this.endAddress = endAddress;
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartAddress(int startAddress) {
        this.startAddress = startAddress;
    }

    public void setEndAddress(int endAddress) {
        this.endAddress = endAddress;
    }

    public int getId() {
        return id;
    }

    public int getStartAddress() {
        return startAddress;
    }

    public int getEndAddress() {
        return endAddress;
    }
}
