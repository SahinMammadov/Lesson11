package LiveLock;

public class Spoon {
    private Diner owner;

    public Spoon(Diner d) {
        owner = d;
    }

    public Diner getOwner() {
        return owner;
    }

    public synchronized void setOwner(Diner d) {
        owner = d;
    }

    public synchronized void use() {
        System.out.println(owner.getName() + " is eating");
    }
}
