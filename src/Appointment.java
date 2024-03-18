import java.util.Date;
class Appointment {

    private int appointmentId;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private String time;
    private boolean isCancelled; // Add a cancellation status
    private Date cancellationDate; // Add a cancellation date

    public Appointment(int appointmentId, Patient patient, Doctor doctor, String date, String time) {
        this.appointmentId = appointmentId;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.isCancelled = false; // Initially, the appointment is not cancelled
        this.cancellationDate = null; // Initially, no cancellation date
    }
    public int getAppointmentId() {
        return appointmentId;
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public boolean isCancelled() {
        return isCancelled;
    }

    public Date getCancellationDate() {
        return cancellationDate;
    }

    public void cancelAppointment() {
        this.isCancelled = true;
        this.cancellationDate = new Date(); // Set the cancellation date to the current date and time
    }
}
