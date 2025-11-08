package main;

public class Harry extends Character {
public Harry(String name, GameWorld world) { super(name, world); }


@Override
protected void performTurn() {
    System.out.println(name + ": I will seek the Horcrux.");
    // simple demo behavior: try to pick up any Horcrux in the room
    room.getItems().stream()
    .filter(i -> i instanceof HorcruxFragment)
    .findFirst()
    .ifPresent(i -> {
    HorcruxFragment h = (HorcruxFragment) i;
    if (h.examine(this)) {
    System.out.println(name + " examined the horcrux.");
    }
    });
    }
    }
