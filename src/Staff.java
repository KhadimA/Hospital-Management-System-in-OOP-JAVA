import java.util.*;

class Staff extends Person {
    private double salary;

    public Staff(int id, String name, String address, String phone, String email, String gender, double salary) {
        super(id, name, address, phone, email, gender);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }
}

class StaffManagement {
    private List<Staff> staffList;
    private int staffIdCounter;

    public StaffManagement() {
        staffList = new ArrayList<>();
        staffIdCounter = 1;
    }

    public void addStaff(String name, String address, String phone, String email, String gender, double salary) {
        Staff staff = new Staff(staffIdCounter, name, address, phone, email, gender, salary);
        staffList.add(staff);
        staffIdCounter++;
    }

    public void removeStaff(int staffId) {
        Staff staffToRemove = findStaffById(staffId);
        if (staffToRemove != null) {
            staffList.remove(staffToRemove);
        } else {
            System.out.println("Staff with ID " + staffId + " not found.");
        }
    }

    public List<Staff> getStaffList() {
        return staffList;
    }

    private Staff findStaffById(int staffId) {
        for (Staff staff : staffList) {
            if (staff.getId() == staffId) {
                return staff;
            }
        }
        return null;
    }
}