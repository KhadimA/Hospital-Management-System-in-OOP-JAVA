import java.util.Date;
class Patient extends Person {
    private int age;
    private double totalBill;
    private String city;
    private String diseases;
    private Date dischargeDate;

    public Patient(int id, String name, String address, String phone, int age, String city, String diseases,
                   String gender) {
        super(id, name, address, phone, "", gender);
        this.age = age;
        this.city = city;
        this.totalBill = 0.0;
        this.diseases = diseases;
        this.dischargeDate = null;
    }

    public int getAge() {
        return age;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void addToBill(double amount) {
        this.totalBill += amount;
    }

    public String getCity() {
        return city;
    }

    public String getDiseases() {
        return diseases;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }
}
