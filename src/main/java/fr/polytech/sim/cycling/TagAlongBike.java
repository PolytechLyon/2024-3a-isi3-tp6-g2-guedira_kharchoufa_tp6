package fr.polytech.sim.cycling;

public class TagAlongBike extends SimpleBike{

    public TagAlongBike() {
        this.components.add(new SimpleBike());
    }

}
