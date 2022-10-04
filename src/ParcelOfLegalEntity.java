public class ParcelOfLegalEntity {

    private long legalEntityParcelID;
    private BailorLegalEntity bailorLegalEntity;
    private ParcelCategories parcelCategory;
    private String dateOfTransfer;
    private float priceOfDailyStorage;

    public ParcelOfLegalEntity(long legalEntityParcelID, BailorLegalEntity bailorLegalEntity,
                               ParcelCategories parcelCategory, String dateOfTransfer, float priceOfDailyStorage) {
        this.legalEntityParcelID = legalEntityParcelID;
        this.bailorLegalEntity = bailorLegalEntity;
        this.parcelCategory = parcelCategory;
        this.dateOfTransfer = dateOfTransfer;
        this.priceOfDailyStorage = priceOfDailyStorage;
    }


    public long getLegalEntityParcelID() {
        return legalEntityParcelID;
    }

    public void setLegalEntityParcelID(long legalEntityParcelID) {
        this.legalEntityParcelID = legalEntityParcelID;
    }

    public BailorLegalEntity getBailorLegalEntity() {
        return bailorLegalEntity;
    }

    public void setBailorLegalEntity(BailorLegalEntity bailorLegalEntity) {
        this.bailorLegalEntity = bailorLegalEntity;
    }

    public ParcelCategories getParcelCategory() {
        return parcelCategory;
    }

    public void setParcelCategory(ParcelCategories parcelCategory) {
        this.parcelCategory = parcelCategory;
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
        return "ParcelOfLegalEntity{" +
                "legalEntityParcelID=" + legalEntityParcelID +
                ", bailorLegalEntity=" + bailorLegalEntity +
                ", parcelCategory=" + parcelCategory +
                ", dateOfTransfer='" + dateOfTransfer + '\'' +
                ", priceOfDailyStorage=" + priceOfDailyStorage +
                '}';
    }
}
