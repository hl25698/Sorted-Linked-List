public class ItemType {
    private int value;

    public int compareTo(ItemType item) {
        if (this.value < item.getValue()) {
            return -1;
        } else if (this.value == item.getValue()) {
            return 0;
        } else if (this.value > item.getValue()) {
            return 1;
        }
        return 0;
    }
    public int getValue() {
        return value;
    }

    public void initialize(int num) {
        this.value = num;
    }
}
