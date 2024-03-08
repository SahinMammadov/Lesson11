package Starvation;

public class Worker implements Runnable {
    private String name;

    public Worker(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (Worker.class) {
            System.out.println(name + " is executing.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " is finished.");
        }
    }
}
