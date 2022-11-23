package model.matriz;

import java.util.HashMap;

import exception.VertexNotFoundException;
import model.Graph;
import model.Vertex;

public class GraphMatriz implements Graph {
    public int[][] mat;
    private boolean isDirected;
    private HashMap<String, Integer> names;
    private int currentNumVertex;

    public GraphMatriz(int numVertex, boolean directed) {
        mat = new int[numVertex][numVertex];
        this.names = new HashMap<>();
        this.isDirected = directed;
    }

    public boolean addEdge(Vertex u, Vertex v, int value) {
        Integer line = names.get(u.getName());
        Integer column = names.get(v.getName());
        if (line == null || column == null) {
            return false;
        }
        mat[line][column] = value;
        if (!isDirected) {
            mat[column][line] = value;
        }
        return true;
    }

    @Override
    public void addVertex(Vertex v) throws VertexNotFoundException {
        if (v.getName() == null) {
            throw new VertexNotFoundException("Vértice " + v.getName() + " não encontrado.");
        }
        names.put(v.getName(), currentNumVertex);
        currentNumVertex++;
    }

    @Override
    public String toString() {
        String out = "";
        for (int[] linha : mat) {
            for (int valor : linha) {
                out += (valor + " ");
            }
            out += "\n";
        }
        return out;
    }

    @Override
    public boolean adjacent(Vertex u, Vertex v) {
        Integer line = names.get(u.getName());
        Integer column = names.get(v.getName());
        if (line == null || column == null) {
            return false;
        }
        return mat[line][column] == 1;
    }

    @Override
    public boolean removeVertex(Vertex v) {
        // can't remove
        return false;
    }

    @Override
    public boolean removeEdge(Vertex u, Vertex v) {
        Integer line = names.get(u.getName());
        Integer column = names.get(v.getName());
        if (line == null || column == null) {
            return false;
        }
        mat[line][column] = 0;
        mat[column][line] = 0;
        return true;
    }

    @Override
    public boolean isDirected() {
        return isDirected;
    }

    public boolean notDirected() {
        return !isDirected;
    }

    public void editMatrix(int[][] mat) {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat.length; j++) {
                if(i == j) {
                    mat[i][j] = 0;
                }
                else{
                    if(i != j && mat[i][j] == 0) {
                        mat[i][j] = Integer.MAX_VALUE/2;
                    }
                }                
            }
        }
    }

    public static void genPI(int[][] d, int[][] pi){
        for(int i = 0; i < d.length; i++) {
            for(int j = 0; j < d.length; j++) {
                if(d[i][j] < Integer.MAX_VALUE/2) {
                    pi[i][j] = j;
                }
                else{
                    pi[i][j] = 0;
                }	

            }

        }
    }
}


