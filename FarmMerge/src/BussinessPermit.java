import java.util.Date;

public class BussinessPermit extends License {

    String bussinessName;
    int taxId;
    String description;
    Boolean isActive;
    String address;
    String city;
    String state;
    String notes;

    public BussinessPermit(Date dateOAcquired, Date expiryDate, String licenseNumber, String name, String bussinessName, int taxId, String description, Boolean isActive, String address, String city, String state, String notes) {
        super(dateOAcquired, expiryDate, licenseNumber, name);
        this.bussinessName = bussinessName;
        this.taxId = taxId;
        this.description = description;
        this.isActive =  new Date().before(expiryDate);
        this.address = address;
        this.city = city;
        this.state = state;
        this.notes = notes;
    }

    private boolean validateBussinessPermit(){
        return bussinessName != null && !bussinessName.isEmpty() &&
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
            case DairyLicense dairyLicense -> validateBussinessPermit() && dairyLicense.getYearsOfExperience() > 2;
            case BakerLicense bakerLicense -> validateBussinessPermit() && bakerLicense.getYearsOfExperience() > 2;
            case null, default -> validateBussinessPermit();
        };
    }
}
