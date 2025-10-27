import java.util.Random;

public class Knight extends Thread{
    @Override
    public void run(){
        System.out.println("The brave knight sets out on a quest to slay the dragon!");
        Random rand = new Random();
        try {
            for(int i=1;i<=5;i++){
                System.out.println("Knight: Step " + i);
                Thread.sleep(rand.nextInt(1000) + 500);
        }
    }catch(InterruptedException e) {
        System.err.println("Knight's adventure was interrupted");
    }
    System.out.println("The knight was victorious");
}
}
