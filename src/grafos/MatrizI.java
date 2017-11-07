/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author jfwc1
 */
public class MatrizI {
    private int n,nl;

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
    private int inci[][];
    
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
