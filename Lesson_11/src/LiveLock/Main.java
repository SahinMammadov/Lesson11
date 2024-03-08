package LiveLock;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        final Diner husband = new Diner("Husband");
        final Diner wife = new Diner("Wife");

        final Spoon s = new Spoon(husband);

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                husband.eatWith(s, wife);
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                wife.eatWith(s, husband);
            }
        });
        t2.start();
    }
}
