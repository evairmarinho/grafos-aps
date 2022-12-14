package model;

import exception.VertexNotFoundException;

public interface Graph {
    boolean adjacent(Vertex u, Vertex v);

    void addVertex(Vertex v) throws VertexNotFoundException;

    boolean removeVertex(Vertex v);

    boolean addEdge(Vertex u, Vertex v, int value);

    boolean removeEdge(Vertex u, Vertex v);

    boolean isDirected();

    void editMatrix(int[][] mat);
}
