import java.util.ArrayList;
import java.util.List;

class Medicine {
    private String name;
    private String company;
    private String expiryDate;
    private double cost;

    public Medicine(String name, String company, String expiryDate, double cost) {
        this.name = name;
        this.company = company;
        this.expiryDate = expiryDate;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public double getCost() {
        return cost;
    }
}

class MedicineInventory {
    private List<Medicine> medicines;

    public MedicineInventory() {
        medicines = new ArrayList<>();
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public void removeMedicine(Medicine medicine) {
        medicines.remove(medicine);
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }
}
