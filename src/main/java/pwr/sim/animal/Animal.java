package pwr.sim.animal;

import pwr.sim.Position2D;
import pwr.sim.World;
import pwr.sim.animal.ai.AiBehaviour;
import pwr.sim.renderer.Renderer;

public abstract class Animal {
    private Animal() {}
    public Animal(AiBehaviour aiBehaviour, int x, int y) {
        this.aiBehaviour = aiBehaviour;
        this.position = new Position2D(x, y);
        this.aiBehaviour.position = position;
    }

    public Animal(AiBehaviour aiBehaviour, int x, int y, World world) {
        this.aiBehaviour = aiBehaviour;
        this.position = new Position2D(x, y);
        this.aiBehaviour.position = position;
        this.world = world;
    }

    public void update() {
        aiBehaviour.update();
    }

    // Chcemy zadeklarować w klasie rodzic że każda klasa pochodna będzie posiadać uchwyt do obiektu pochodzacego od
    // klasy `AiBehaviour` (specyficzny dla każdego obiektu). Jednak w tej klasie nie wiemy jaki konkretny typ
    // obiektu `aiBehaviour` będzie zawierała klasa pochodna, toteż domyślny konstruktor klasy `Animal` nie może go
    // zainicjalizować.
    // Aby uniemożliwić skonstruowanie niezainicjalizowanego w pełni obiektu, domyślny konstruktor ustawiony został jako
    // prywatny.
    // Czy można zrobić to lepiej?
    AiBehaviour aiBehaviour;

    public void draw() {
        world.drawAnimal(this);
    }

    public Position2D getPosition() {
        return new Position2D(this.position);
    }

    abstract public char getAnimalChar();

    private World world;
    private int health;
    private Position2D position;
}
