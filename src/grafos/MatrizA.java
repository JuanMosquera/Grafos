/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;
import listas.NodoSimple;
/**
 *
 * @author jfwc1
 */
public class MatrizA {
    private int n;
    private int adya[][];
    private int visitado[];

    

    public MatrizA(int n) {
        this.n = n;
        adya=new int[n][n];
        visitado=new int[n];
        this.iniciar();
    }
       
    public int[] getVisitado() {
        return visitado;
    }

    public void setVisitado(int[] visitado) {
        this.visitado = visitado;
    }
    
    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[][] getAdya() {
        return adya;
    }

    public void setAdya(int[][] adya) {
        this.adya = adya;
    }
    
    public void iniciar(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adya[i][j]=0;
            }
            visitado[i]=0;
        }
    }
    
    public  void mostrar(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adya[i][j]);
            }
            System.out.println("");
        }
    }
    
    
    public void dfs(int v){
        System.out.println(v);
        visitado[v-1]=1;
        for (int i = 0; i < n; i++) {
            if(adya[v-1][i]==1){
                if (visitado[i]==0) {
                    dfs(i+1);
                }
            }
        }
    }
    
    public void bfs(int v){
        
    }
    
    public void insert(int v1,int v2){
        adya[v1][v2]=1;
        adya[v2][v1]=1;
    }
    
    
    public void crear(String[] grap,int ta){
        String dos[]=new String[2];
        int a,b;
        
        for (int i = 0; i < ta; i++) {
            dos=grap[i].split(" ");
            a=Integer.parseInt(dos[0]);
            b=Integer.parseInt(dos[1]);
            
            this.insert(a-1,b-1);
        }
        
    }
    
    public void covMItoMA(int inci[][]){
        int j,k,ta;
        ta=inci.length;
        for (int i = 1; i <=ta; i++) {
            j=1;
            while (inci[j][i]==0) {
                j=j+1;
            }
            k=j+1;
            while (inci[k][i]==0) {
                k=k+1;
            }
            adya[j][k]=1;
            adya[k][j]=1;
        }
    }
    
//    public void covMItoMA(int inci[][]){
//        int i,j,k;
//        for (i = 1; i <=nl; i++) {
//            j=1;
//            while (inci[j][i]==0) {
//                j=j+1;
//            }
//            k=j+1;
//            while (inci[k][i]==0) {
//                k=k+1;
//            }
//            adya[j][k]=1;
//            adya[k][j]=1;
//        }
//    }
    
    
    
}
    

