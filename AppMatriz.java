import model.Graph;
import util.LoadData;

import javax.xml.transform.Source;

import model.matriz.GraphMatriz;

public class AppMatriz {

    public static void main(String[] args) {
        GraphMatriz graphMatriz;

        graphMatriz = LoadData.loadAdj("data/data.txt");
        int[][] pi = graphMatriz.mat;        
        System.out.println("Matriz original:");
        System.out.println(graphMatriz);
        
        //gerando matriz de custos (D)
        graphMatriz.editMatrix(graphMatriz.mat);

        System.out.println("--------------------");
        System.out.println("Matriz de custos:");
        System.out.println(graphMatriz);         

        System.out.println("--------------------");
        //gerando matriz de antecessores (PI)
        GraphMatriz.genPI(graphMatriz.mat, pi);
         
        
        FloydW.floydW(graphMatriz.mat, pi);
        System.out.println("Matriz de antecessores:");
        //printMatrix(pi);
        System.out.println(graphMatriz);      
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