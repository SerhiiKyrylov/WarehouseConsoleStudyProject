public class BailorLegalEntity extends Bailor {
    private long vatRegistrationNumber;

    public BailorLegalEntity(String name, long id, long vatRegistrationNumber) {
        super(name, id);
        this.vatRegistrationNumber = vatRegistrationNumber;
    }

    public long getVatRegistrationNumber() {
        return vatRegistrationNumber;
    }

    public void setVatRegistrationNumber(long vatRegistrationNumber) {
        this.vatRegistrationNumber = vatRegistrationNumber;
    }

    @Override
    public String toString() {
        return "BailorLegalEntity{" +
                "vatRegistrationNumber=" + vatRegistrationNumber +
                "} " + super.toString();
    }
}
