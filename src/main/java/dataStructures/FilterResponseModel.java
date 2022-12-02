package dataStructures;

import java.util.List;

public class FilterResponseModel {

    public List<Quartet> quartets;

    public FilterResponseModel(List<Quartet> quartets){
        this.quartets = quartets;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Quartet q : quartets){
            sb.append("COURSE " + i + ": " + q.toString() + '\n');
            i += 1;
        }
        return sb.toString();
    }
}
