import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
class HospitalSystem {
    private List<Patient> patients;
    private List<Doctor> doctors;
    private List<Appointment> appointments;
    private List<Medicine> medicines; // Add a list of medicines

    public HospitalSystem() {
        patients = new ArrayList<>();
        doctors = new ArrayList<>();
        appointments = new ArrayList<>();
        medicines = new ArrayList<>(); // Initialize the list of medicines
    }

    public void addMedicine(Medicine medicine) {
        medicines.add(medicine);
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public boolean removeMedicine(int index) {
        if (index >= 0 && index < medicines.size()) {
            medicines.remove(index);
            return true;
        }
        return false;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void removeDoctor(Doctor doctorToRemove) {
        doctors.remove(doctorToRemove);
    }
}