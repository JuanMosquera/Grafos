/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author jfwc1
 */
public class MatrizI {
    private int n,nl;
    private int inci[][];
    private int visitado[];

    public MatrizI(int n, int nl) {
        this.n = n;
        this.nl = nl;
        inci=new int[n][nl];
        visitado=new int[n];
        this.iniciar();
    }
    
    public void iniciar(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nl; j++) {
                inci[i][j]=0;
            }
            visitado[i]=0;
        }
    }
    
     public void insert(int v1,int v2,int a){
        inci[v1][a]=1;
        inci[v2][a]=1;
    }
    
    
    public void crear(String[] grap,int ta){
        String dos[]=new String[2];
        int a,b;
        
        for (int i = 0; i < ta; i++) {
            dos=grap[i].split(" ");
            a=Integer.parseInt(dos[0]);
            b=Integer.parseInt(dos[1]);
            
            this.insert(a-1,b-1,i);
        }
        
    }
    
     public  void mostrar(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nl; j++) {
                System.out.print(inci[i][j]);
            }
            System.out.println("");
        }
    }
     
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getNl() {
        return nl;
    }

    public void setNl(int nl) {
        this.nl = nl;
    }

    public int[][] getInci() {
        return inci;
    }

    public void setInci(int[][] inci) {
        this.inci = inci;
    }
    
    public void dfs(int v){
        int i,j;
        System.out.println(v);
        visitado[v-1]=1;
        for (i = 0; i <nl; i++) {
            if (inci[v-1][i]==1) {
                for (j = 0; j <n ; j++) {
                    if (v-1!=j) {
                        if (inci[j][i]==1) {
                            if (visitado[j]==0) {
                                dfs(j+1);
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void bfs(int a){
        int i,j;
        Queue<Integer> cola=new LinkedList();
        visitado[a]=1;
        cola.add(a);
        while (!cola.isEmpty()) {
            a=cola.poll();
            System.out.println(a);
            for (i = 1; i <=nl ; i++) {
                if (inci[a][i]==1) {
                    for (j = 1; j <=n ; j++) {
                        if (a!=j) {
                            if (inci[j][i]==1) {
                                if (visitado[j]==0) {
                                    visitado[j]=1;
                                    cola.add(j);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void covMAtoMI(int adya[][]){
        int i,j,k;
        k=0;
        for (i = 1; i <=n; i++) {
            for (j = i+1; j <=n ; j++) {
                if (adya[i][j]==1) {
                    k=k+1;
                    inci[i][k]=1;
                    inci[j][k]=1;
                }
            }
        }
    }
    
    
    
}
