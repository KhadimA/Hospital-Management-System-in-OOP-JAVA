import java.util.*;

public class Main {
    public static void main(String[] args) {
        HospitalSystem hospitalSystem = new HospitalSystem();
        LaboratoryInventory laboratoryInventory = new LaboratoryInventory();
        StaffManagement staffManagement = new StaffManagement();
        List<String> doctor1TimeSlots = Arrays.asList("9:00 AM - 10:00 AM", "2:00 PM - 4:00 PM");
        Doctor doctor1 = new Doctor("Khadim Ali", "123 Main St", "123-456-7890", "dr.khadimali@example.com", "Cardiologist",
                "MD", doctor1TimeSlots, "Male");

        Doctor doctor2 = new Doctor("Abdul Hassn", "Alif Shah Shaheed ", "03490393306", "dr.abdulhassan@gmail.com",   "Cardiologist", "MD", doctor1TimeSlots, "Male");
        hospitalSystem.addDoctor(doctor1);
        hospitalSystem.addDoctor(doctor2);

        Patient patient1 = new Patient(1, "Majid Ali", "789 Oak St", "111-222-3333", 30, "Shikarpur", "Fever and Cough",
                "Male");
        hospitalSystem.addPatient(patient1);
        MedicineInventory medicineInventory = new MedicineInventory();
        Medicine medicine1 = new Medicine("Medicine1", "Company1", "02/02/2023", 10.0);
        Medicine medicine2 = new Medicine("Medicine2", "Company2", "02/02/2023", 15.0);
        Medicine medicine3 = new Medicine("Medicine3", "Company3", "02/02/2023", 20.0);
        Medicine medicine4 = new Medicine("Medicine4", "Company4", "02/02/2023", 25.0);
        Medicine medicine5 = new Medicine("Medicine5", "Company5", "02/02/2023", 30.0);
        medicineInventory.addMedicine(medicine1);
        medicineInventory.addMedicine(medicine2);
        medicineInventory.addMedicine(medicine3);
        medicineInventory.addMedicine(medicine4);
        medicineInventory.addMedicine(medicine5);

        // Adding Appointments
        doctor1 = hospitalSystem.getDoctors().get(0);
        patient1 = hospitalSystem.getPatients().get(0);
        Appointment appointment1 = new Appointment(1, patient1, doctor1, "09/20/2023", "10:00 AM");
        Appointment appointment2 = new Appointment(2, patient1, doctor1, "09/21/2023", "02:00 PM");
        Appointment appointment3 = new Appointment(3, patient1, doctor1, "09/22/2023", "03:30 PM");
        hospitalSystem.addAppointment(appointment1);
        hospitalSystem.addAppointment(appointment2);
        hospitalSystem.addAppointment(appointment3);

        // Adding Laboratories
        laboratoryInventory = new LaboratoryInventory();
        Laboratory lab1 = new Laboratory("Lab1", "Facilities1", 100.0);
        Laboratory lab2 = new Laboratory("Lab2", "Facilities2", 150.0);
        laboratoryInventory.addLaboratory(lab1);
        laboratoryInventory.addLaboratory(lab2);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("|           Welcome to Hospital Management System By Khadim Ali     |");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("1. Manage Doctors");
            System.out.println("2. Manage Patients");
            System.out.println("3. Manage Appointments");
            System.out.println("4. Manage Medicine");
            System.out.println("5. Manage Laboratory");
            System.out.println("6. Manage Staff");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageDoctors(hospitalSystem, scanner);
                    break;
                case 2:
                    managePatients(hospitalSystem, scanner);
                    break;
                case 3:
                    manageAppointments(hospitalSystem, scanner);
                    break;
                case 4:
                    manageMedicines(hospitalSystem, scanner);
                    break;
                case 5:
                    manageLaboratories(laboratoryInventory, scanner);
                    break;
                case 6:
                    manageStaff(staffManagement, scanner);
                    break;
                case 7:
                    System.out.println("Exiting the system.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageDoctors(HospitalSystem hospitalSystem, Scanner scanner) {
        List<Doctor> doctors = hospitalSystem.getDoctors();

        while (true) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("|                       DOCTOR SECTION                       |");
            System.out.println("-------------------------------------------------------------");
            System.out.println("1. Add Doctor");
            System.out.println("2. Remove Doctor");
            System.out.println("3. List of Doctors");
            System.out.println("4. List of Appointments");
            System.out.println("9. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter doctor's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter doctor's address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter doctor's phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter doctor's email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter doctor's specialization: ");
                    String specialization = scanner.nextLine();
                    System.out.print("Enter doctor's qualification: ");
                    String qualification = scanner.nextLine();

                    // Set available time slots for the doctor
                    System.out.print("Enter available time slots (comma-separated, e.g., 9:00 AM,10:00 AM): ");
                    String timeSlotsInput = scanner.nextLine();
                    List<String> timeSlots = Arrays.asList(timeSlotsInput.split(","));
                    System.out.print("Enter doctor's gender: ");
                    String gender = scanner.nextLine();
                    Doctor doctor = new Doctor(name, address, phone, email, specialization, qualification, timeSlots,
                            gender);
                    hospitalSystem.addDoctor(doctor);
                    System.out.println("Doctor added successfully.");

                    break;
                }
                case 2 -> {
                    removeDoctor(hospitalSystem, scanner);
                    break;
                }
                case 3 -> {
                    System.out.println(
                            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out
                            .println("id \t Name \t Gender \t Specialist \t Availability \t Qualification \t Room No.");
                    System.out.println(
                            "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    for (Doctor d : doctors) {
                        System.out.printf("%d \t %s \t %s \t %s \t %s \t %s \t %s%n",
                                d.getId(), "Dr." + d.getName(), d.getGender(), d.getSpecialization(),
                                d.getAvailableTimeSlots(), d.getQualification(), d.getRoomNumber());
                    }
                    break;
                }
                case 4 -> {
                    cancelAppointment(hospitalSystem, scanner); // Call the new method to cancel an appointment
                    break;
                }
                case 9 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void managePatients(HospitalSystem hospitalSystem, Scanner scanner) {
        List<Patient> patients = hospitalSystem.getPatients();

        while (true) {
            System.out.println("--------------------------------------------");
            System.out.println("|                   Patients                |");
            System.out.println("---------------------------------------------");
            System.out.println("1. Add Patient");
            System.out.println("2. Discharge Patient");
            System.out.println("3. List of Patients");
            System.out.println("9. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter patient's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter patient's address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter patient's city: "); // Prompt for city
                    String city = scanner.nextLine();
                    System.out.print("Enter patient's phone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter patient's age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter patient's diseases: ");
                    String diseases = scanner.nextLine();
                    System.out.print("Enter patient's gender: ");
                    String gender = scanner.nextLine();
                    Patient patient = new Patient(patients.size() + 1, name, address, phone, age, city, diseases,
                            gender);
                    hospitalSystem.addPatient(patient);
                    System.out.println("Patient added successfully.");

                }
                case 2 -> {
                    listPatients(hospitalSystem.getPatients());
                    dischargePatient(patients, scanner);
                }
                case 3 -> {
                    System.out.println("List of Patients:");
                    for (Patient p : patients) {
                        System.out.println(
                                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println("|   ID:" + p.getId() + ", Name: " + p.getName() + ", Gender: "
                                + p.getGender() + ", Age: " + p.getAge() + ", Address: " + p.getAddress() + ", City: "
                                + p.getCity() + ", Diseases: " + p.getDiseases());
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    }
                }
                case 9 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageAppointments(HospitalSystem hospitalSystem, Scanner scanner) {
        while (true) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("                  APPOINTMENT SECTION                        ");
            System.out.println("-------------------------------------------------------------");
            System.out.println("1. Schedule Appointment");
            System.out.println("2. List Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("9. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    scheduleAppointment(hospitalSystem, scanner);
                    break;
                case 2:
                    listAppointments(hospitalSystem.getAppointments());
                    break;
                case 3:
                    cancelAppointment(hospitalSystem, scanner); // Call the new method to cancel an appointment
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void scheduleAppointment(HospitalSystem hospitalSystem, Scanner scanner) {
        List<Patient> patients = hospitalSystem.getPatients();
        List<Doctor> doctors = hospitalSystem.getDoctors();

        listPatients(patients);
        System.out.print("Enter the ID of the patient: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Patient patient = findPatient(patients, patientId);
        if (patient == null) {
            System.out.println("Patient with ID " + patientId + " not found.");
            return;
        }

        listDoctors(doctors);
        System.out.print("Enter the ID of the doctor: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Doctor doctor = findDoctor(doctors, doctorId);
        if (doctor == null) {
            System.out.println("Doctor with ID " + doctorId + " not found.");
            return;
        }

        System.out.print("Enter the date for the appointment (e.g., MM/DD/YYYY): ");
        String date = scanner.nextLine();
        System.out.print("Enter the time for the appointment (e.g., 2:00 PM): ");
        String time = scanner.nextLine();

        // Create a new appointment and add it to the system
        int nextAppointmentId = hospitalSystem.getAppointments().size() + 1;
        Appointment appointment = new Appointment(nextAppointmentId, patient, doctor, date, time);
        hospitalSystem.addAppointment(appointment);

        System.out.println("Appointment scheduled successfully.");
    }

    private static void listAppointments(List<Appointment> appointments) {
        System.out.println("List of Appointments:");
        for (Appointment appointment : appointments) {
            System.out.println("Appointment ID: " + appointment.getAppointmentId() +
                    ", Patient: " + appointment.getPatient().getName() +
                    ", Doctor: " + appointment.getDoctor().getName() +
                    ", Date: " + appointment.getDate() +
                    ", Time: " + appointment.getTime());
        }
    }

    private static void cancelAppointment(HospitalSystem hospitalSystem, Scanner scanner) {
        List<Appointment> appointments = hospitalSystem.getAppointments();
        listAppointments(appointments);

        System.out.print("Enter the ID of the appointment to cancel: ");
        int appointmentId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        System.out.println("Debug: Cancel appointment method entered."); // Debug statement

        Appointment appointmentToCancel = findAppointment(appointments, appointmentId);
        if (appointmentToCancel != null) {
            if (!appointmentToCancel.isCancelled()) {
                System.out.println("Debug: Appointment found and is not canceled."); // Debug statement
                appointmentToCancel.cancelAppointment();
                appointments.remove(appointmentToCancel); // Remove the canceled appointment
                System.out.println("Appointment with ID " + appointmentId + " has been canceled and removed.");
            } else {
                System.out.println("Debug: Appointment is already canceled."); // Debug statement
                System.out.println("Appointment with ID " + appointmentId + " is already canceled.");
            }
        } else {
            System.out.println("Debug: Appointment not found."); // Debug statement
            System.out.println("Appointment with ID " + appointmentId + " not found.");
        }
    }

    private static Appointment findAppointment(List<Appointment> appointments, int appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                return appointment;
            }
        }
        return null;
    }

    private static void listDoctors(List<Doctor> doctors) {
        System.out.println("List of Doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("Doctor ID: " + doctor.getId() + ", Name: " + doctor.getName() + ", Specialization: "
                    + doctor.getSpecialization());
        }
    }

    private static Doctor findDoctor(List<Doctor> doctors, int doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == doctorId) {
                return doctor;
            }
        }
        return null;
    }

    private static void listPatients(List<Patient> patients) {
        System.out.println("List of Patients:");
        for (Patient patient : patients) {
            System.out.println(
                    "Patient ID: " + patient.getId() + ", Name: " + patient.getName() + ", Age: " + patient.getAge());
        }
    }

    private static void removeDoctor(HospitalSystem hospitalSystem, Scanner scanner) {
        List<Doctor> doctors = hospitalSystem.getDoctors();
        listDoctors(doctors);

        if (doctors.isEmpty()) {
            System.out.println("There are no doctors to remove.");
            return;
        }

        System.out.print("Enter the ID of the doctor to remove: ");
        int doctorId = scanner.nextInt();

        Doctor doctorToRemove = findDoctor(doctors, doctorId);
        if (doctorToRemove != null) {
            hospitalSystem.removeDoctor(doctorToRemove);
            System.out.println("Doctor removed successfully.");
        } else {
            System.out.println("Doctor with the given ID not found.");
        }
    }

    private static Patient findPatient(List<Patient> patients, int patientId) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    private static void dischargePatient(List<Patient> patients, Scanner scanner) {
        System.out.print("Enter the ID of the patient to discharge: ");
        int patientId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        Iterator<Patient> iterator = patients.iterator();
        while (iterator.hasNext()) {
            Patient patient = iterator.next();
            if (patient.getId() == patientId) {
                if (patient.getDischargeDate() == null) {
                    // Patient is not already discharged, so we can discharge them now.
                    Date dischargeDate = new Date(); // Get the current date as the discharge date
                    patient.setDischargeDate(dischargeDate);
                    System.out.println(patient.getName() + " has been discharged on " + dischargeDate);
                    iterator.remove(); // Remove the discharged patient from the list
                } else {
                    System.out.println(
                            patient.getName() + " has already been discharged on " + patient.getDischargeDate());
                }
                return;
            }
        }
        System.out.println("Patient with ID " + patientId + " not found.");
    }

    private static void manageMedicines(HospitalSystem hospitalSystem, Scanner scanner) {
        while (true) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("|                   MEDICINE SECTION                         |");
            System.out.println("-------------------------------------------------------------");
            System.out.println("1. Add New Entry");
            System.out.println("2. Remove Medicines");
            System.out.println("3. Existing Medicines List");
            System.out.println("9. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addNewMedicine(hospitalSystem, scanner);
                    break;
                case 2:
                    removeMedicine(hospitalSystem, scanner);
                    break;
                case 3:
                    listMedicines(hospitalSystem.getMedicines());
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addNewMedicine(HospitalSystem hospitalSystem, Scanner scanner) {
        System.out.print("Enter medicine name: ");
        String name = scanner.nextLine();
        System.out.print("Enter company name: ");
        String company = scanner.nextLine();
        System.out.print("Enter expiry date (e.g., MM/DD/YYYY): ");
        String expiryDate = scanner.nextLine();
        System.out.print("Enter cost: ");
        double cost = scanner.nextDouble();

        Medicine medicine = new Medicine(name, company, expiryDate, cost);
        hospitalSystem.addMedicine(medicine);
        System.out.println("Medicine added successfully.");
    }

    private static void removeMedicine(HospitalSystem hospitalSystem, Scanner scanner) {
        listMedicines(hospitalSystem.getMedicines());
        System.out.print("Enter the index of the medicine to remove: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        if (hospitalSystem.removeMedicine(index)) {
            System.out.println("Medicine removed successfully.");
        } else {
            System.out.println("Invalid index. Please try again.");
        }
    }

    private static void listMedicines(List<Medicine> medicines) {
        System.out.println("List of Medicines:");
        System.out.println("Index \t Name \t Company \t Expiry Date \t Cost");
        for (int i = 0; i < medicines.size(); i++) {
            Medicine medicine = medicines.get(i);
            System.out.printf("%d \t %s \t %s \t %s \t %.2f%n",
                    i, medicine.getName(), medicine.getCompany(), medicine.getExpiryDate(), medicine.getCost());
        }
    }

    private static void manageLaboratories(LaboratoryInventory laboratoryInventory, Scanner scanner) {
        List<Laboratory> laboratories = laboratoryInventory.getLaboratories();

        while (true) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("|                   LABORATORY SECTION                      |");
            System.out.println("-------------------------------------------------------------");
            System.out.println("1. Add New Entry");
            System.out.println("2. Remove Entry");
            System.out.println("3. Existing Laboratories List");
            System.out.println("9. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1 -> {
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Enter laboratory name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter facilities: ");
                    String facilities = scanner.nextLine();
                    System.out.print("Enter cost: ");
                    double cost = scanner.nextDouble();
                    Laboratory laboratory = new Laboratory(name, facilities, cost);
                    laboratoryInventory.addLaboratory(laboratory);
                    System.out.println("Laboratory entry added successfully.");
                }
                case 2 -> {
                    listLaboratories(laboratories);
                    removeLaboratory(laboratoryInventory, scanner);
                }
                case 3 -> listLaboratories(laboratories);
                case 9 -> {
                    return;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void listLaboratories(List<Laboratory> laboratories) {
        System.out.println("List of Laboratories:");
        System.out.println("Name\t\tFacilities\t\tCost");
        for (Laboratory lab : laboratories) {
            System.out.printf("%s\t\t%s\t\t%.2f%n", lab.getName(), lab.getFacilities(), lab.getCost());
        }
    }

    private static void removeLaboratory(LaboratoryInventory laboratoryInventory, Scanner scanner) {
        List<Laboratory> laboratories = laboratoryInventory.getLaboratories();
        listLaboratories(laboratories);

        if (laboratories.isEmpty()) {
            System.out.println("There are no laboratories to remove.");
            return;
        }

        System.out.print("Enter the name of the laboratory to remove: ");
        String nameToRemove = scanner.nextLine();

        Laboratory laboratoryToRemove = findLaboratoryByName(laboratories, nameToRemove);
        if (laboratoryToRemove != null) {
            laboratoryInventory.removeLaboratory(laboratoryToRemove);
            System.out.println("Laboratory removed successfully.");
        } else {
            System.out.println("Laboratory with the given name not found.");
        }
    }

    private static Laboratory findLaboratoryByName(List<Laboratory> laboratories, String name) {
        for (Laboratory laboratory : laboratories) {
            if (laboratory.getName().equalsIgnoreCase(name)) {
                return laboratory;
            }
        }
        return null;
    }

    private static void manageStaff(StaffManagement staffManagement, Scanner scanner) {
        while (true) {
            System.out.println("---------------------------------------------------------------------");
            System.out.println("|                     STAFF MANAGEMENT MENU                         |");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("1. Add New Staff");
            System.out.println("2. Remove Staff");
            System.out.println("3. List Existing Nurses");
            System.out.println("4. List Existing Workers");
            System.out.println("5. List Existing Security Staff");
            System.out.println("6. Back to Main Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addNewStaff(staffManagement, scanner);
                    break;
                case 2:
                    removeStaff(staffManagement, scanner);
                    break;
                case 3:
                    listNurses(staffManagement);
                    break;
                case 4:
                    listWorkers(staffManagement);
                    break;
                case 5:
                    listSecurityStaff(staffManagement);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addNewStaff(StaffManagement staffManagement, Scanner scanner) {
        scanner.nextLine(); // Consume newline character
        System.out.print("Enter staff name: ");
        String name = scanner.nextLine();
        System.out.print("Enter staff address: ");
        String address = scanner.nextLine();
        System.out.print("Enter staff phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter staff email: ");
        String email = scanner.nextLine();
        System.out.print("Enter staff gender: ");
        String gender = scanner.nextLine();
        System.out.print("Enter staff salary: ");
        double salary = scanner.nextDouble();

        staffManagement.addStaff(name, address, phone, email, gender, salary);
        System.out.println("Staff added successfully.");
    }

    private static void removeStaff(StaffManagement staffManagement, Scanner scanner) {
        System.out.print("Enter the ID of the staff to remove: ");
        int staffId = scanner.nextInt();

        staffManagement.removeStaff(staffId);
    }

    private static void listNurses(StaffManagement staffManagement) {
        List<Staff> staffList = staffManagement.getStaffList();
        System.out.println("List of Nurses:");
        for (Staff staff : staffList) {
            if (staff != null) {
                System.out.println("ID: " + staff.getId() + ", Name: " + staff.getName() + ", Gender: "
                        + staff.getGender() + ", Salary: " + staff.getSalary());
            }
        }
    }

    private static void listWorkers(StaffManagement staffManagement) {
        List<Staff> staffList = staffManagement.getStaffList();
        System.out.println("List of Workers:");
        for (Staff staff : staffList) {
            if (staff != null) {
                System.out.println("ID: " + staff.getId() + ", Name: " + staff.getName() + ", Gender: "
                        + staff.getGender() + ", Salary: " + staff.getSalary());
            }
        }
    }

    private static void listSecurityStaff(StaffManagement staffManagement) {
        List<Staff> staffList = staffManagement.getStaffList();
        System.out.println("List of Security Staff:");
        for (Staff staff : staffList) {
            if (staff != null) {
                System.out.println("ID: " + staff.getId() + ", Name: " + staff.getName() + ", Gender: "
                        + staff.getGender() + ", Salary: " + staff.getSalary());
            }
        }
    }
}