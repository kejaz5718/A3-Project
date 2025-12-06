public class Professor extends RegisterationInfo
{
    protected String division;
    protected double work_percentage;

    public Professor(String f_name, int r_number, String email, String d, double work_p) {
        this.fullName = f_name;
        this.registrationNumber = r_number;
        this.email = email;
        this.division = d;
        this.work_percentage = work_p;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public double getWork_percentage() {
        return work_percentage;
    }

    public void setWork_percentage(double work_percentage) {
        this.work_percentage = work_percentage;
    }

    public String toString() {
        return "Professor: " + fullName;
    }
}