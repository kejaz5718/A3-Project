public class RegisterationInfo {
    String fullName;
    int registrationNumber;
    String email;

    /**
     * Constructor
     * @param f_name Full name
     * @param r_number Registration number
     * @param email Email id
     */
    public RegisterationInfo(String f_name, int r_number, String email)
    {
        this.fullName = f_name;
        this.registrationNumber = r_number;
        this.email = email;
    }

    public RegisterationInfo() {
    }

    //Getter methods for Encapsulation

    /**
     * @return prints the registration no.
     */
    public int getRegistrationNumber()
    {
        return registrationNumber;
    }

    /**
     * @return prints the full name
     */
    public String getFullName()
    {
        return fullName;
    }


    /**
     * @return prints the email id
     */

    public String getEmail()
    {
        return email;
    }

    /**
     * standard string description
     */

}
