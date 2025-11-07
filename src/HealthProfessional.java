/**
 * Base class representing a health professional.
 */
public class HealthProfessional {
    private int id;
    private String name;
    private String department;

    public HealthProfessional() {
        this(1, "Unknown", "General");
    }

    public HealthProfessional(int id, String name, String department) {
        setId(id);
        setName(name);
        setDepartment(department);
    }

    public int getId() { return id; }
    public void setId(int id) {
        if (id <= 0) throw new IllegalArgumentException("ID must be positive");
        this.id = id;
    }

    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name required");
        this.name = name.trim();
    }

    public String getDepartment() { return department; }
    public void setDepartment(String department) {
        if (department == null || department.trim().isEmpty()) throw new IllegalArgumentException("Department required");
        this.department = department.trim();
    }

    public void printDetails() {
        System.out.println("The health professional details are:");
        System.out.println("  ID: " + id);
        System.out.println("  Name: " + name);
        System.out.println("  Department: " + department);
    }
}
