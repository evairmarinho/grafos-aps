package model.list;

import model.Vertex;

public class Edge {
    private Vertex vertex;
    private int value;

    public Edge(Vertex vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    public Vertex getVertex() {
        return vertex;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return " [to " + vertex + ", " + value + "]";
    }

}
