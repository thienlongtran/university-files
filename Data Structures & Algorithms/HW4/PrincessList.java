import java.util.ArrayList;
import java.util.Collections;

public class PrincessList{
    private int currentMultiplicationScale = 0;
    private ArrayList<Princess> princessList;
    private ArrayList<Princess> originalPrincessList;

    /**
     * Setup the ArrayList backing with a bunch of the most popular Disney princesses.
     */
    public PrincessList(){

        ArrayList<Princess> tempPrincessList = new ArrayList<Princess>();

        //Princess Objects
        Princess elsa = new Princess("Elsa" , 100);
        Princess mulan = new Princess("Mulan", 85);
        Princess merida = new Princess("Merida", 81);
        Princess tiana = new Princess("Tiana" , 78);
        Princess rapunzel = new Princess("Rapunzel", 77);
        Princess moana = new Princess("Moana", 75);
        Princess esmerelda = new Princess("Esmerelda", 71);
        Princess pochahontas = new Princess("Pochahontas" , 68);
        Princess jasmine = new Princess("Jasmine" , 63);
        Princess ariel = new Princess("Ariel" , 62);
        Princess anna = new Princess("Anna" , 59);
        Princess belle = new Princess("Belle" , 54);
        Princess cinderella = new Princess("Cinderella" , 52);
        Princess giselle = new Princess("Giselle" , 50);
        Princess aurora = new Princess("Aurora" , 48);

        //Add Princess Objects to ArrayList
        tempPrincessList.add(elsa);
        tempPrincessList.add(mulan);
        tempPrincessList.add(moana);
        tempPrincessList.add(merida);
        tempPrincessList.add(rapunzel);
        tempPrincessList.add(anna);
        tempPrincessList.add(pochahontas);
        tempPrincessList.add(tiana);
        tempPrincessList.add(jasmine);
        tempPrincessList.add(belle);
        tempPrincessList.add(ariel);
        tempPrincessList.add(esmerelda);
        tempPrincessList.add(anna);
        tempPrincessList.add(belle);
        tempPrincessList.add(cinderella);
        tempPrincessList.add(giselle);
        tempPrincessList.add(aurora);

        this.princessList = tempPrincessList;
        
        ArrayList<Princess> originalPrincessList = new ArrayList<Princess>();
        tempPrincessList.forEach(princess -> originalPrincessList.add(princess));
        this.originalPrincessList = originalPrincessList;
        
    }

    /**
     * @return the ArrayList backing.
     */
    public ArrayList<Princess> getList(){
        return this.princessList;
    }

    /**
     * Sorts the list by the strongest princesses first to the weakest last, or from the highest powerlevel to the lowest.
     */
    public void sortPowerLevelOrder(){
        princessList.sort(new PrincessComparator());
    }

    /**
     * Sorts the list by the weakest princesses first to the strongest last, or from the lowest powerlevel to the highest.
     */
    public void sortReversePowerLevelOrder(){
        princessList.sort(new PrincessReverseComparator());
    }

    /**
     * Randomizes the list.
     */
    public void randomize(){
        Collections.shuffle(princessList);
    }

    /**
     * Add a set of duplicate princesses to the list where the next set has a "+step" next to the name, and the powerlevel is multiplied by a factor of 7 with each step.
     */
    public void addPrincessStack(){

        this.originalPrincessList.forEach(
            princess -> this.princessList.add(new Princess(princess.getName()+"_"+(currentMultiplicationScale+1), princess.getPowerLevel()*7*(currentMultiplicationScale+1)))
            );

        currentMultiplicationScale++;

    }
}