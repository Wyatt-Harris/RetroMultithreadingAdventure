import java.util.Random;

public class Wizard extends Thread{
    @Override
    public void run(){
        System.out.println("The intelliegent wizard sets out to find the elder wand!");
        Random rand = new Random();
        try {
            for(int i=1;i<=5;i++){
                System.out.println("Wizard: Step " + i);
                Thread.sleep(rand.nextInt(1000) + 500);
        }
    }catch(InterruptedException e) {
        System.err.println("Wizard's quest was interrupted");
    }
    System.out.println("The Wizard was victorious");
        }        
    }    
