package Model;

public class National {
    int nationalId;
    String nationalName;

    public National(int nationalId, String nationalName) {
        this.nationalId = nationalId;
        this.nationalName = nationalName;
    }

    public National() {
    }

    public int getNationalId() {
        return nationalId;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }
}
