package Function;

public class CustomItem {
    private String text;
    private int value;

    public CustomItem(String text, int value) {
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return text;
    }
}