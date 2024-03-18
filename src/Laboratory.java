import java.util.List;
import java.util.*;
class Laboratory {
    private String name;
    private String facilities;
    private double cost;

    public Laboratory(String name, String facilities, double cost) {
        this.name = name;
        this.facilities = facilities;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getFacilities() {
        return facilities;
    }

    public double getCost() {
        return cost;
    }
}

class LaboratoryInventory {
    private List<Laboratory> laboratories;

    public LaboratoryInventory() {
        laboratories = new ArrayList<>();
    }

    public void addLaboratory(Laboratory laboratory) {
        laboratories.add(laboratory);
    }

    public void removeLaboratory(Laboratory laboratory) {
        laboratories.remove(laboratory);
    }

    public List<Laboratory> getLaboratories() {
        return laboratories;
    }
}