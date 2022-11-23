public class FloydW {
    public static void floydW(int d[][], int pi[][]){
        int n = d[0].length;
        for(int k = 0; k < n; k++){        
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(d[i][k] + d[k][j] < d[i][j]){
                        d[i][j] = d[i][k] + d[k][j];
                        pi[i][j] = pi[i][k];
                    }
                }
            }
        }
    }
}
