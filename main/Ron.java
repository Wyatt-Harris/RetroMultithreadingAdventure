package main;

public class Ron extends Character {
    public Ron(String name, GameWorld world) { super(name, world); }


    @Override
    protected void performTurn() {
        System.out.println(name + ": I will scout and disarm traps.");
        // simple demo: pick up first non-null item
        room.getItems().stream().findFirst().ifPresent(this::pickUpItem);
    }
}
