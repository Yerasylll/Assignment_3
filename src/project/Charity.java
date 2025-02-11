import java.util.ArrayList;

import java.util.*;

public class Charity {
    private String name;
    private ArrayList<Entity> entities;

    public Charity(String name) {
        this.name = name;
        this.entities = new ArrayList<>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void addDonations(ArrayList<Donation> donations) {
        entities.addAll(donations);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public ArrayList<Donation> getDonations() {
        ArrayList<Donation> donations = new ArrayList<>();
        for (Entity entity : entities) {
            if (entity instanceof Donation) {
                donations.add((Donation) entity);
            }
        }
        return donations;
    }

    public void sortEntities() {
        entities.sort(Comparator.comparingInt(Entity::getId));
    }

    @Override
    public String toString() {
        return "Charity Name: " + name + " | Entities Count: " + entities.size();
    }

    public String getName() {
        return name;
    }
}

