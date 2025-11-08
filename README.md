-Magic Multithreading   
Summary  
In this action-packed, text-based adventure game, the power trio from the Harry Potter world, Harry, Ron, and Hermione, embark on an adventure to find and study the Horcrux fragment that is 
stashed away somewhere in Hogwarts.

-Features & Use Cases     
The main feature of this game is the use of multithreading to tell multiple action-packed stories at once. The use cases would be anytime a user wants to have some fun!    
-Technologies Used    
Java, weather meteo API, Multithreading, Lambda Expressions     
-How to run the project    
Make sure your machine can compile and run Java source code and download these files. After the download, run the file titled GameEngine   
-Contributors & Responsibilities    
Wyatt Harris - Game Developer  
-Classes, Interfaces, Superclasses  
⚙️ Technical Overview  
Concept	Implementation  
-Abstraction	Character is an abstract superclass defining core behavior.  
-Inheritance	Harry, Hermione, and Ron extend Character with unique traits.  
-Polymorphism	Each overrides performTurn() and handles events differently.  
-Arrays	Each character’s inventory is a fixed-size Item[] array.  
-Collections	Rooms use ConcurrentLinkedQueue<Item> and ConcurrentHashMap for flags.  
-Lambdas & Streams	Used for event handling (Consumer<Event>), inventory filtering, and logging.  
-Parallelism / Threads	Each character, the event dispatcher, and the logger run in independent threads.  
-Synchronization	The HorcruxFragment uses a ReentrantLock to prevent concurrent examination.  
-Functional Programming	Streams process inventory and events cleanly with concise lambda expressions.  
-Safe Concurrency	Uses BlockingQueue<Event>, ExecutorService, and ReentrantLock for safe coordination.  
🧙 Characters & Abilities  
Character	Thread Role	Abilities  
-Harry	Fighter / Seeker	Seeks Horcrux faster, uses basic spells  
-Hermione	Scholar / Spellcaster	Researches and unlocks magical puzzles  
-Ron	Rogue / Scout	Disarms traps, can sneak to avoid enemies  
