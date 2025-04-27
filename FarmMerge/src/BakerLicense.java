import java.util.Date;

public class BakerLicense extends License {

    int yearsOfExperience;
    String specialization;
    String restrictions;

    public BakerLicense(Date dateOAcquired, Date expiryDate, String licenseNumber, String name, int yearsOfExperience, String specialization, String restrictions) {
        super(dateOAcquired, expiryDate, licenseNumber, name);
    }


    @Override
    public boolean validate() {
        Date currentDate = new Date();
        return currentDate.before(expiryDate);
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }
}
