import java.util.Random;

public class Thief extends Thread{
    @Override    
    public void run(){
        System.out.println("The sneaky thief sets out on a quest to steal from the Louvre!");
        Random rand = new Random();
        try {
            for(int i=1;i<=5;i++){
                System.out.println("Thief: Step " + i);
                Thread.sleep(rand.nextInt(1000) + 500);
        }
    }catch(InterruptedException e) {
        System.err.println("Thief's plot was interrupted");
    }
    System.out.println("The Thief was victorious");
}       
    }
