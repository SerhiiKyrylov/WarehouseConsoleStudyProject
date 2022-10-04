public class Bailor {

    private String name;
    private long id;

    public Bailor(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bailor{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
