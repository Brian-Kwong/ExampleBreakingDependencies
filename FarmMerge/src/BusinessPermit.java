import java.util.Date;

public class BusinessPermit extends License {

    String businessName;
    int taxId;
    String description;
    Boolean isActive;
    String address;
    String city;
    String state;
    String notes;

    public BusinessPermit(Date dateOAcquired, Date expiryDate, String licenseNumber, String name, String businessName, int taxId, String description, Boolean isActive, String address, String city, String state, String notes) {
        super(dateOAcquired, expiryDate, licenseNumber, name);
        this.businessName = businessName;
        this.taxId = taxId;
        this.description = description;
        this.isActive =  new Date().before(expiryDate);
        this.address = address;
        this.city = city;
        this.state = state;
        this.notes = notes;
    }

    private boolean validateBusinessPermit(){
        return businessName != null && !businessName.isEmpty() &&
                taxId > 0 &&
                description != null && !description.isEmpty() &&
                isActive &&
                address != null && !address.isEmpty() &&
                city != null && !city.isEmpty() &&
                state != null && !state.isEmpty() &&
                notes != null && !notes.isEmpty();
    }

    public boolean validate(License accompaniedLicense) {
        return switch (accompaniedLicense) {
            case DairyLicense dairyLicense -> validateBusinessPermit() && dairyLicense.getYearsOfExperience() > 2;
            case BakerLicense bakerLicense -> validateBusinessPermit() && bakerLicense.getYearsOfExperience() > 2;
            case null, default -> validateBusinessPermit();
        };
    }
}
