package week_7.set_2;

class TrafficLight {
    private final String id;
    private final String[] cycle = {"RED", "GREEN", "YELLOW"};
    private int currentIndex;

    public TrafficLight(String id) {
        this.id = id;
        this.currentIndex = 0; // Starts at RED
    }

    public void next() {
        currentIndex = (currentIndex + 1) % cycle.length;
        System.out.println("-> " + getColor());
    }

    public String getColor() {
        return cycle[currentIndex];
    }

    public String getId() {
        return id;
    }
}

public class P4_TrafficLight {
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        System.out.println("t.getColor() -> " + t.getColor());
        t.next();
        t.next();
        t.next();
    }
}