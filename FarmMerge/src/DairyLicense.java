import java.io.IOException;
import java.util.Date;

public class DairyLicense extends License{

    Date lastExamDate;
    Character grade;
    String IDFACertifier;
    String restrictions;

    public DairyLicense(Date dateOAcquired, Date expiryDate, String licenseNumber, String name, String IDFACertifier, Date lastExamDate, Character grade, String restrictions) {
        super(dateOAcquired, expiryDate, licenseNumber, name);
        this.IDFACertifier = IDFACertifier;
        this.lastExamDate = lastExamDate;
        this.grade = grade;
        this.restrictions = restrictions;
    }

    public int getYearsOfExperience() {
        Date currentDate = new Date(System.currentTimeMillis());
        long diffInMillSec = currentDate.getTime() - dateOAcquired.getTime();
        long diffInDays = diffInMillSec / (1000 * 60 * 60 * 24);
        return (int) (diffInDays / 365);
    }

    public String getIDFACertifier() {
        return IDFACertifier;
    }

    public boolean hasValidCDFACertification() throws IOException, InterruptedException {
        String[] validCDFACertifiers =  DataRepository.getInstance().getCDFAData();
        for (String certifier : validCDFACertifiers) {
            if (certifier.equals(IDFACertifier)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean validate(){
        return
            (lastExamDate != null && lastExamDate.before(new Date(System.currentTimeMillis()))) &&
            (grade != null && (grade == 'A' || grade == 'B' || grade == 'C')) &&
            (IDFACertifier != null && !IDFACertifier.isEmpty());
    }

}
