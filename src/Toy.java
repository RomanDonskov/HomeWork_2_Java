import java.util.Objects;

import static java.lang.Integer.compare;

public class Toy  implements Comparable<Toy>{
    private int id;
    private String name;
    private int quan;
    private int weight;

    public Toy(int id, String name, int quan, int weight){
        this.id = id;
        this.name = name;
        this.quan = quan;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getquan() {
        return quan;
    }

    public int getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setquan(int quan) {
        this.quan = quan;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public String getInfToy(){
        return String.format("Id: %d; Name: %s \n", id, name);
    }

    @Override
    public int compareTo(Toy toy) {
        if (toy.weight == this.weight){
            return 0;
        }
        return this.weight<toy.weight ? -1:1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy toy)) return false;
        return Objects.equals(name, toy.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name)*43;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quan=" + quan +
                ", weight=" + weight +
                '}';
    }
}
