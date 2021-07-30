package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fmiri on 7/07/2016.
 *
 * @author Ima Miri <fmiri@ebay.com>
 */
public class GraphAdjMatrix extends Graph {

    private int[][] adjMatrix;

    public GraphAdjMatrix() {
        this.adjMatrix = new int[0][0];
    }

    @Override
    public void implementAddVertex() {
        int v = getNumVertices();
        if (v >= adjMatrix.length) {
            int[][] newAdjMatrix = new int[v * 2][v * 2];
            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    newAdjMatrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = newAdjMatrix;
        }
        for (int i = 0; i < adjMatrix[v].length; i++) {
            adjMatrix[v][i] = 0;
        }
    }

    public List<Integer> getNeighbors(int v) {
        List<Integer> neighbors = new ArrayList<Integer>();
        for(int i = 0; i< getNumVertices(); i++){
            if(adjMatrix[v][i] != 0){
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public void setAdjMatrix(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
    }

    public static void main(String[] args) {
        GraphAdjMatrix graphAdjMatrix = new GraphAdjMatrix();
        graphAdjMatrix.implementAddVertex();
        int[][] adjMatrix = graphAdjMatrix.getAdjMatrix();
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                System.out.println(adjMatrix[i][j]);
            }
        }
    }
}
