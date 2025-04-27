import java.io.IOException;
import java.util.Date;

public class DairyLicense extends License{

    Date lastExamDate;
    Character grade;
    String CDFACertifer;
    String restrictions;

    public DairyLicense(Date dateOAcquired, Date expiryDate, String licenseNumber, String name, String CDFACertifer, Date lastExamDate, Character grade, String restrictions) {
        super(dateOAcquired, expiryDate, licenseNumber, name);
        this.CDFACertifer = CDFACertifer;
        this.lastExamDate = lastExamDate;
        this.grade = grade;
        this.restrictions = restrictions;
    }

    public int getYearsOfExperience() {
        Date currentDate = new Date(System.currentTimeMillis());
        long diffInMillies = currentDate.getTime() - dateOAcquired.getTime();
        long diffInDays = diffInMillies / (1000 * 60 * 60 * 24);
        return (int) (diffInDays / 365);
    }

    public String getCDFACertifer() {
        return CDFACertifer;
    }

    public boolean hasValidCDFACertification() throws IOException, InterruptedException {
        String[] validCDFACertifiers =  DataRepository.getInstance().getCDFAData();
        for (String certifier : validCDFACertifiers) {
            if (certifier.equals(CDFACertifer)) {
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
            (CDFACertifer != null && !CDFACertifer.isEmpty());
    }

}
