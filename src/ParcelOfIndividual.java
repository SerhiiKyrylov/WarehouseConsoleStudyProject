public class ParcelOfIndividual {

    private long individualParcelID;
    private BailorIndividual bailorIndividual;
    private ParcelCategories parcelCategory;

    private IndividualStatus individualStatus;
    private String dateOfTransfer;
    private float priceOfDailyStorage;


    public ParcelOfIndividual(long individualParcelID, BailorIndividual bailorIndividual, ParcelCategories parcelCategory,
                              IndividualStatus individualStatus, String dateOfTransfer, float priceOfDailyStorage) {
        this.individualParcelID = individualParcelID;
        this.bailorIndividual = bailorIndividual;
        this.parcelCategory = parcelCategory;
        this.individualStatus = individualStatus;
        this.dateOfTransfer = dateOfTransfer;
        this.priceOfDailyStorage = priceOfDailyStorage;
    }

    public long getIndividualParcelID() {
        return individualParcelID;
    }

    public void setIndividualParcelID(long individualParcelID) {
        this.individualParcelID = individualParcelID;
    }

    public BailorIndividual getBailorIndividual() {
        return bailorIndividual;
    }

    public void setBailorIndividual(BailorIndividual bailorIndividual) {
        this.bailorIndividual = bailorIndividual;
    }

    public ParcelCategories getParcelCategory() {
        return parcelCategory;
    }

    public void setParcelCategory(ParcelCategories parcelCategory) {
        this.parcelCategory = parcelCategory;
    }

    public IndividualStatus getIndividualStatus() {
        return individualStatus;
    }

    public void setIndividualStatus(IndividualStatus individualStatus) {
        this.individualStatus = individualStatus;
    }

    public String getDateOfTransfer() {
        return dateOfTransfer;
    }

    public void setDateOfTransfer(String dateOfTransfer) {
        this.dateOfTransfer = dateOfTransfer;
    }

    public float getPriceOfDailyStorage() {
        return priceOfDailyStorage;
    }

    public void setPriceOfDailyStorage(float priceOfDailyStorage) {
        this.priceOfDailyStorage = priceOfDailyStorage;
    }

    @Override
    public String toString() {
        return "ParcelOfIndividual{" +
                "individualParcelID=" + individualParcelID +
                ", bailorIndividual=" + bailorIndividual +
                ", parcelCategory=" + parcelCategory +
                ", individualStatus=" + individualStatus +
                ", dateOfTransfer='" + dateOfTransfer + '\'' +
                ", priceOfDailyStorage=" + priceOfDailyStorage +
                '}';
    }
}
