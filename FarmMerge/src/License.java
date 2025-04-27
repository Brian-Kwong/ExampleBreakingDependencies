import java.util.Date;

public class License{
    Date dateOAcquired;
    Date expiryDate;
    String licenseNumber;
    String name;

    public License(Date dateOAcquired, Date expiryDate, String licenseNumber, String name) {
        this.dateOAcquired = dateOAcquired;
        this.expiryDate = expiryDate;
        this.licenseNumber = licenseNumber;
        this.name = name;
    }

    public boolean validate(){
        Date currentDate = new Date();
        if (currentDate.after(expiryDate)) {
            return false;
        }
        return name != null && !name.isEmpty() && licenseNumber != null && !licenseNumber.isEmpty();
    }
}
