public class BailorIndividual extends Bailor {

    private Gender gender;

    public BailorIndividual(String name, long id, Gender gender) {
        super(name, id);
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "BailorIndividual{" +
                "gender=" + gender +
                "} " + super.toString();
    }
}
