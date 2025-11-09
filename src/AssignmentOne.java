import java.util.Scanner;

/**
 * Main program for the appointment system.
 * Demonstrates creation, conflict handling, and interactive menu.
 */
public class AssignmentOne {

    /** Demo: create sample appointments */
    private static void runDemo(AppointmentManager manager,
                                GeneralPractitioner gp1,
                                GeneralPractitioner gp2,
                                GeneralPractitioner gp3,
                                OtherProfessional sp1,
                                OtherProfessional sp2) {
        System.out.println("=== Part 3 – Using classes and objects ===");
        gp1.printDetails(); System.out.println();
        gp2.printDetails(); System.out.println();
        gp3.printDetails(); System.out.println();
        sp1.printDetails(); System.out.println();
        sp2.printDetails(); System.out.println();

        System.out.println("------------------------------");
        System.out.println("=== Part 5 – Collection of appointments ===");

        // Create valid appointments
        manager.createAppointment("Alice", "0411111111", "09:00", gp1);
        manager.createAppointment("Ben",   "0411111112", "09:30", gp2);
        manager.createAppointment("Carol", "0411111113", "10:00", gp3);
        manager.createAppointment("David", "0411111114", "10:30", sp1);
        manager.createAppointment("Emma",  "0411111115", "11:00", sp2);

        // Invalid / conflict examples
        manager.createAppointment("Frank", "0412ABCD", "11:30", gp1);       // invalid mobile
        manager.createAppointment("George", "0411111111", "09:00", gp1);    // conflict: same doctor & time

        System.out.println("\n-- Print existing appointments --");
        manager.printExistingAppointments();

        System.out.println("\n-- Cancel one appointment (0411111112) --");
        manager.cancelBooking("0411111112");

        System.out.println("\n-- Print after cancellation --");
        manager.printExistingAppointments();

        System.out.println("------------------------------");
    }

    /** Interactive menu for manual appointment management */
    private static void interactiveMenu(AppointmentManager manager,
                                        GeneralPractitioner gp1,
                                        GeneralPractitioner gp2,
                                        GeneralPractitioner gp3,
                                        OtherProfessional sp1,
                                        OtherProfessional sp2) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Appointment Menu (interactive) ===");
            System.out.println("1. Create appointment");
            System.out.println("2. Cancel appointment");
            System.out.println("3. View appointments");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            while (!sc.hasNextInt()) { System.out.print("Please enter a number: "); sc.next(); }
            choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter mobile: ");
                    String mobile = sc.nextLine().trim();
                    System.out.print("Enter time (HH:MM): ");
                    String time = sc.nextLine().trim();

                    System.out.println("Select doctor:");
                    System.out.println("  1) " + gp1.getName());
                    System.out.println("  2) " + gp2.getName());
                    System.out.println("  3) " + gp3.getName());
                    System.out.println("  4) " + sp1.getName());
                    System.out.println("  5) " + sp2.getName());
                    System.out.print("Choose (1-5): ");
                    while (!sc.hasNextInt()) { System.out.print("Please enter a number 1-5: "); sc.next(); }
                    int docChoice = sc.nextInt(); sc.nextLine();

                    HealthProfessional selected;
                    switch (docChoice) {
                        case 1: selected = gp1; break;
                        case 2: selected = gp2; break;
                        case 3: selected = gp3; break;
                        case 4: selected = sp1; break;
                        case 5: selected = sp2; break;
                        default:
                            System.out.println("Invalid doctor choice. Aborting appointment creation.");
                            selected = null;
                    }
                    if (selected != null) manager.createAppointment(name, mobile, time, selected);
                    break;

                case 2:
                    System.out.print("Enter mobile to cancel: ");
                    String mob = sc.nextLine().trim();
                    manager.cancelBooking(mob);
                    break;

                case 3:
                    manager.printExistingAppointments();
                    break;

                case 0:
                    System.out.println("Exiting interactive menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
        sc.close();
    }

    /** Main method */
    public static void main(String[] args) {
        // Create doctors
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Alice", "General Medicine", "Room 1", true);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Bob", "General Medicine", "Room 2", false);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Carol", "General Medicine", "Room 3", true);

        OtherProfessional sp1 = new OtherProfessional(201, "Dr. David", "Cardiology", "Cardiologist");
        OtherProfessional sp2 = new OtherProfessional(202, "Dr. Emma", "Dermatology", "Dermatologist");

        AppointmentManager manager = new AppointmentManager();

        // 1) Deterministic demo for marker
        runDemo(manager, gp1, gp2, gp3, sp1, sp2);

        // 2) Optional interactive menu
        System.out.println("\nDemo finished. Now entering interactive menu (optional).");
        interactiveMenu(manager, gp1, gp2, gp3, sp1, sp2);

        System.out.println("Program terminated. Thank you.");
    }
}
