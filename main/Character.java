package main;

public abstract class Character implements Runnable {
protected final String name;
protected final Item[] inventory = new Item[10];
protected Room room;
protected final GameWorld world;
protected volatile boolean alive = true;


public Character(String name, GameWorld world) {
    this.name = name;
    this.world = world;
    // place character in first room by default
    this.room = world.getRooms().get(0);
}


public String getName() { return name; }
public Room getRoom() { return room; }


protected void pickUpItem(Item item) {
synchronized (room) {
if (room.removeItem(item)) {
for (int i = 0; i < inventory.length; i++) {
if (inventory[i] == null) { inventory[i] = item;
System.out.println(name + " picked up " + item.getName());
return; }
}
System.out.println(name + " inventory full, dropped " + item.getName());
room.addItem(item);
}
}
}


protected void moveTo(Room r) {
System.out.println(name + " moves from " + room.getName() + " to " + r.getName());
this.room = r;
}


public void run() {
while (!world.isGameOver() && alive) {
    performTurn();
try { Thread.sleep(ThreadLocalRandom.current().nextInt(300, 800)); }
    catch (InterruptedException e) { Thread.currentThread().interrupt(); break; }
}
System.out.println(name + " thread exiting.");
}


protected abstract void performTurn();
}