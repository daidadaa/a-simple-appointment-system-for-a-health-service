public class AssignmentOne {
    public static void main(String[] args) {
        System.out.println("=== Part 3 – Using classes and objects ===");

        // 创建医生和其他健康专业人员对象（带参数构造）
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Alice", "General", "Room 1", true);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Bob", "General", "Room 2", false);
        OtherProfessional op1 = new OtherProfessional(201, "Dr. Chen", "Cardiology", "Heart", "ECG Machine");

        // 打印每位健康专业人员的详细信息
        gp1.printDetails();
        System.out.println("-------------------");
        gp2.printDetails();
        System.out.println("-------------------");
        op1.printDetails();
        System.out.println("-------------------");

        // Part 5 – 创建和管理预约
        System.out.println("=== Part 5 – Collection of appointments ===");
        AppointmentManager manager = new AppointmentManager();

        // 创建预约对象
        Appointment a1 = new Appointment("Alice", "0411111111", "09:00", gp1);
        Appointment a2 = new Appointment("Bob", "0422222222", "10:00", gp2);
        Appointment a3 = new Appointment("Chris", "0433333333", "11:00", op1);

        // 添加预约
        manager.createAppointment(a1);
        manager.createAppointment(a2);
        manager.createAppointment(a3);

        // 打印所有预约
        manager.printExistingAppointments();

        // 取消一个预约
        manager.cancelBooking("0411111111");

        // 打印剩余预约
        manager.printExistingAppointments();
    }
}
