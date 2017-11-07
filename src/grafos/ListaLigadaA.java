/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import listas.NodoSimple;
import matrizdispersa.Tripleta;
import matrizdispersa.matrizEnTripletas;

/**
 *
 * @author jfwc1
 */
public class ListaLigadaA {
    private int n;
    private NodoSimple v[];

    public ListaLigadaA(int n) {
        this.n = n;
        v=new NodoSimple[n];
    }
    
    
    public void covMAtoLA(int adya[][]){
        int i,j;
        NodoSimple x;
        for (i = 1; i <=n; i++) {
            for (j = 1; j <=n; j++) {
                if (adya[i][j]==1) {
                    x=new NodoSimple(j);
                    x.setLiga(v[i]);
                    v[i]=x;
                }
            }
        }
    }
    
    //revisar
    public void covMATtoLA(matrizEnTripletas matt){
        int i,f,c,nt;
        Tripleta t;
        NodoSimple x;
        nt= matt.retornaNumeroTripletas();
        for (i = 0; i < nt; i++) {
            t=(Tripleta)matt.getTripleta(i);
            f=t.getFila();
            c=t.getColumna();
            x=new NodoSimple(c);
            x.setLiga(v[f]);
            v[f]=x;
        }
    }
}
