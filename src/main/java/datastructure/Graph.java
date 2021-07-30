package datastructure;

import java.util.List;

/**
 * Created by Ima Miri on 9/06/2016.
 *
 * @author Ima Miri <ima.miri11@gmail.com>
 */
public abstract class Graph {

    private int numVertices;
    private int numEdges;

    public Graph() {
        this.numVertices = 0;
        this.numEdges = 0;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void setNumEdges(int numEdges) {
        this.numEdges = numEdges;
    }

    public void addVertex() {
        implementAddVertex();
        numVertices++;
    }

    public abstract void implementAddVertex();

    public abstract List<Integer> getNeighbors(int v);
}
