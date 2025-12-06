import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Student extends RegisterationInfo
{
    protected static int MAX_NUM_MODULES = 5; // maximum number of modules that a student can enrol
    protected List<Module> modules;

    /**
     * Constructor
     * @param f_name Full Name
     * @param r_number Registration Number
     * @param email Email
     */
    public Student(String f_name, int r_number, String email) {
        this.fullName = f_name;
        this.registrationNumber = r_number;
        this.email = email;
        this.modules = new ArrayList<>();
    }
    /**
     * constructor
     * generate a student at random
     * @param rnd
     */
    public Student(Random rnd) {
        final String[] firstNames = {
                "Aiden", "Bella", "Callum", "Daria", "Ewan",
                "Freya", "Gavin", "Holly", "Ishan", "Jade",
                "Kara", "Liam", "Maya", "Noah", "Orla",
                "Priya", "Quinn", "Rory", "Sofia", "Toby"
        };

        final String[] lastNames = {
                "Anderson", "Bennett", "Campbell", "Davies", "Ellis",
                "Foster", "Gray", "Hughes", "Irving", "Johnson",
                "Kerr", "Lewis", "Murray", "Nguyen", "O'Connor",
                "Patel", "Quinn", "Reid", "Stewart", "Turner"
        };

        String f_name = firstNames[rnd.nextInt(firstNames.length)];
        String l_name = lastNames[rnd.nextInt(lastNames.length)];
        int number = 1000000 + rnd.nextInt(899999);

        this.fullName = f_name + " " + l_name;
        this.registrationNumber = number;
        this.email = f_name + "." + l_name + "@stir.ac.uk";
        this.modules = new ArrayList<>();
    }


    /**
     * Add a new module to the list of modules of the student
     * @param m -The new module to be added
     * @return true if the module was added successfully
     */
    public boolean addModule(Module m) {
        if (modules.size() < MAX_NUM_MODULES && !modules.contains(m)) {
            return modules.add(m);
        } else {
            return false;
        }
    }

    /**
     * Remove a module of the list of modules of the student
     * @return true if the customer was removed successfully
     */
    public boolean removeModule(Module m) {
        return modules.remove(m);
    }

    /**
     * Get a description of the Student as a String
     */
    public String toString() {
        return "Student: " + fullName + " - StudentNo: " + registrationNumber;
    }
}