//import model.Graph;
import util.LoadData;

import javax.xml.transform.Source;

import model.matriz.GraphMatriz;

public class AppMatriz {

    public static void main(String[] args) {
        GraphMatriz graphMatriz;

        graphMatriz = LoadData.loadAdj("data/data.txt");
        int[][] pi = graphMatriz.mat;
        GraphMatriz.genPI(graphMatriz.mat, pi);
        System.out.println("Matriz:");
        System.out.println(graphMatriz);

        // Graph lisGraph = LoadData.loadList("data/data.txt");

        // System.out.println("Lista:");
        // System.out.println(lisGraph);
        // System.out.println();



        graphMatriz.editMatrix(graphMatriz.mat);
        System.out.println();
        System.out.println(graphMatriz);
        
        FloydW.floydW(graphMatriz.mat, pi);
        System.out.println("-----Matriz PI-------");
        printMatrix(pi);

       
    }

    public static void printMatrix(int x[][]){
        for(int i=0; i<x[0].length; i++){            
            for(int j=0; j<x[0].length; j++){
                System.out.print(x[i][j] + "\t");
            }
            System.out.println();            
        }
    }
}