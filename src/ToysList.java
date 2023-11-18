import java.util.ArrayList;

public class ToysList {
    private ArrayList<Toy> toys;
    private int idCount;

    public ArrayList<Toy> getToys() {
        return toys;
    }

    public ToysList(){
        this.toys = new ArrayList<>();
        idCount = 0;

    }
    public boolean addToy(String name, int quan,int weight) {

        Toy t = new Toy(++idCount, name, quan, weight);
        if (!toys.contains(t) || toys.size() == 0) {
            toys.add(t);
            return true;
        }
        else return false;
    }
    public void weigthChange(int id, int weight){
        if (id<toys.size()) {
            toys.get(id).setWeight(weight);
        }
        else {
            System.out.printf("неверный идентефикатор: %d !!!", id);
        }
    }
}
