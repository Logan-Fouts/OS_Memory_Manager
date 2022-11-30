package App;

import java.util.ArrayList;

import Algorithms.bestfit;
import Algorithms.firstfit;
import Algorithms.worstfit;

public class memmanger {
    
    public void manageMemory(ArrayList<commands> instructions) {
        bestfit bestfit = new bestfit();
        firstfit firstfit = new firstfit();
        worstfit worstfit = new worstfit();

        firstfit.doAlgorithm(instructions);
        bestfit.doAlgorithm(instructions);
        worstfit.doAlgorithm(instructions);
    }
}
