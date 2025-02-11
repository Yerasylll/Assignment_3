package project;

public abstract class Entity {
    private int id;
    private static int idGenerator = 1;

    public Entity() {
        this.id = idGenerator++;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    // Abstract methods to be implemented by subclasses (if needed)
    public abstract String getCode();

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + getCode();
    }

    // Optional: We can implement equals() and hashCode() here based on id if needed
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entity that = (Entity) obj;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

