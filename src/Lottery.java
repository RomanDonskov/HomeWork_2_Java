import java.util.PriorityQueue;
import java.util.Random;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Lottery {
    public ToysList toys;
    public PriorityQueue<Toy> prizes;

    public Lottery(ToysList t) {
        this.toys = t;


    }

//    public PriorityQueue<Toy> getPrizes() {
//        return prizes;
//    }

    public Toy getPrize(){
        return prizes.poll();
    }
    public void raffle(){
        this.prizes = new PriorityQueue<>();
        Random rnd = new Random();
        for( Toy toy: toys.getToys()) {
            if  (toy.getquan()>0) {
                for (int i = 0; i < toy.getWeight(); i++) {
                    Toy temp = new Toy(toy.getId(), toy.getName(), toy.getquan(), rnd.nextInt(1, 10));
                    prizes.add(temp);
                }
            }
        }
        Toy prize = getPrize();
        System.out.println("выигрыш: " + prize.getName());
        saveResult(prize.getInfToy());
        for(Toy t: toys.getToys()){
            if (prize.getId() == t.getId()){
               t.setquan(t.getquan()-1);
            }
        }


    }
    private void saveResult(String text) {
        File file = new File("Prizes.txt");
        try {
            file.createNewFile();
        } catch (Exception ignored) {
            throw new RuntimeException();
        }
        try (FileWriter fw = new FileWriter("Prizes.txt", true)) {
            fw.write(text + "\n");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}