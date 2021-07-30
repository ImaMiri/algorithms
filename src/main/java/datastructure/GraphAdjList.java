package datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by fmiri on 8/07/2016.
 *
 * @author Ima Miri <fmiri@ebay.com>
 */
public class GraphAdjList extends Graph {

    private Map<Integer, ArrayList<Integer>> adjListsMap;

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        ArrayList<Integer> neighbors = new ArrayList<Integer>();
        adjListsMap.put(v, neighbors);
    }

    public void implementAddEdge(int v, int w){
        (adjListsMap.get(v)).add(w);
    }

    @Override
    public List<Integer> getNeighbors(int v) {

        return new ArrayList<Integer>(adjListsMap.get(v));
    }

    
}
