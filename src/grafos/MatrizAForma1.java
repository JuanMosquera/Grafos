/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;


import matrizdispersa.MatrizForma1;
import matrizdispersa.NodoDoble;
import matrizdispersa.Tripleta;

        
/**
 *
 * @author jfwc1
 */
public class MatrizAForma1 {
    private MatrizForma1 mat1;

    public MatrizAForma1(int m,int n) {
        mat1=new MatrizForma1(m,n);
        mat1.construyeNodosCabeza();
    }
    
    public void insertar(int fila,int colum,int dato){
        Tripleta tx;
        NodoDoble x;
        tx = new Tripleta(fila,colum,dato);
        x=new NodoDoble(tx);
        mat1.conectarPorFilas(x);
        mat1.conectarPorColumnas(x);
    }
    
    public void covMAtoLA(int adya[][]){
        int i,j,n;
        n=adya.length;
        Tripleta tx;
        NodoDoble x;
        for (i = 1; i <=n; i++) {
            for (j = 1; j <=n; j++) {
                if (adya[i][j]==1) {
                    tx = new Tripleta(i,j,1);
                    x=new NodoDoble(tx);
                    mat1.conectarPorFilas(x);
                    mat1.conectarPorColumnas(x);
                }
            }
        }
    }
    
}
