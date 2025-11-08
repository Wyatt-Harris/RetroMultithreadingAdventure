package main;

public class Hermione extends Character {
    public Hermione(String name, GameWorld world) { super(name, world); }


    @Override
    protected void performTurn() {
        System.out.println(name + ": I will research and solve puzzles.");
        // simple demo: if horcrux present try to lock it (simulate research)
        room.getItems().stream()
        .filter(i -> i instanceof HorcruxFragment)
        .findFirst()
        .ifPresent(i -> {
        HorcruxFragment h = (HorcruxFragment) i;
        if (h.examine(this)) {
            System.out.println(name + " performed research on the Horcrux.");
            }
        });
    }
}  
