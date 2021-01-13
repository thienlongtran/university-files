import java.util.ArrayList;

public class SortersRunner {

    public static void main(String[] args) {

        ArrayList<Dog> pack = new ArrayList<Dog>();
        pack.add(new Dog("Josie", 74));
        pack.add(new Dog("Beatrice", 118));
        pack.add(new Dog("Watson", 39));
        pack.add(new Dog("Brutus", 102));
        pack.add(new Dog("Phineas", 57));
        pack.add(new Dog("Hamlet", 76));
        pack.add(new Dog("Amadeus", 125));
        pack.add(new Dog("Sansa", 48));
        pack.add(new Dog("Nutmeg", 68));
        pack.add(new Dog("Copernicus", 87));

        Sorters2120.mergeSort(pack);

        for(Dog i : pack){
            System.out.println(i);
        }
    }


}
