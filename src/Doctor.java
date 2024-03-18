import java.util.List;
class Doctor extends Person {
    private String specialization;
    private String qualification;
    private String roomNumber;
    private List<String> availableTimeSlots;
    private static int doctorCount = 0;
    private String gender;

    public Doctor(String name, String address, String phone, String email, String specialization, String qualification,
                  List<String> availableTimeSlots, String gender) {
        super(++doctorCount, name, address, phone, email, gender);
        this.specialization = specialization;
        this.qualification = qualification;
        this.roomNumber = "Room " + doctorCount;
        this.availableTimeSlots = availableTimeSlots;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getQualification() {
        return qualification;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public List<String> getAvailableTimeSlots() {
        return availableTimeSlots;
    }
}
