package LiveLock;

public class Diner {
    private String name;
    private boolean isHungry;

    public Diner(String n) {
        name = n;
        isHungry = true;
    }

    public String getName() {
        return name;
    }

    public synchronized void eatWith(Spoon spoon, Diner spouse) {
        while (isHungry) {
            // Bu diner aç ve aynı anda eşinin de aç olup olmadığını kontrol eder.
            if (spoon.getOwner() != this) {
                try {
                    Thread.sleep(100); // Diğer dini bekleyin
                } catch (InterruptedException ex) {
                    continue;
                }
                continue;
            }

            // Eğer aynı anda eş açsa, bu diner yemeğe başlar
            if (spouse.isHungry) {
                System.out.println(name + ": You eat first, my darling " + spouse.getName());
                spoon.setOwner(spouse);
                continue;
            }

            // Eğer eş aç değilse ama kendisi açsa, yine beklemeye devam eder
            spoon.use();
            isHungry = false;
            System.out.println(name + ": I am done eating, my darling " + spouse.getName());
            spoon.setOwner(spouse);
        }
    }
}
