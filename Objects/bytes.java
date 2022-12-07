package Objects;

public class bytes {
    Boolean allocated;
    int id;

    public bytes() {
        allocated = false;
        id = '\0';
    }

    public void setAllocated(Boolean allocated) {
        this.allocated = allocated;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getAllocated() {
        return allocated;
    }

    public int getId() {
        return id;
    }
}
