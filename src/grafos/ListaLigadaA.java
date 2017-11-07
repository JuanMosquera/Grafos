/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import listas.NodoSimple;
import matrizdispersa.MatrizForma1;
import matrizdispersa.MatrizForma2;
import matrizdispersa.NodoDoble;
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
    
    public void covMF1toLA(MatrizForma1 mat1){
        NodoDoble p,q;
        NodoSimple x;
        int f,c;
        Tripleta t;
        p=mat1.primerNodo();
        while (!mat1.finDeRecorrido(p)) {
            q=p.getLd();
            while (q!=p) {
                t=(Tripleta) q.getDato();
                f=t.getFila();
                c=t.getColumna();
                x=new NodoSimple(c);
                x.setLiga(v[f]);
                v[f]=x;
                q=q.getLd();
                
            }
            t=(Tripleta) p.getDato();
            p=(NodoDoble) t.getValor();
        }
    
    }
    
    public void covMF2toLA(MatrizForma2 mat2){
        NodoDoble p,cab;
        NodoSimple x;
        Tripleta t;
        int f,c;
        cab=mat2.nodoCabeza();
        p=mat2.primerNodo();
        while (p!=cab) {
            t=(Tripleta) p.getDato();
            f=t.getFila();
            c=t.getColumna();
            x=new NodoSimple(c);
            x.setLiga(v[f]);
            v[f]=x;
            p=p.getLd();
        }
    }
    
    public void covMItoLA(int inci[][]){
        int i,j=0,k;
        NodoSimple x;
        //esto es provicional
        int nl=inci.length;
        for (i = 1; i <=nl; i++) {
            while (inci[j][i]==0) {
                j=j+1;
            }
            k=j+1;
            while (inci[k][i]==0) {
                k=k+1;
            }
            x=new NodoSimple(j);
            x.setLiga(v[k]);
            v[k]=x;
            x=new NodoSimple(k);
            x.setLiga(v[j]);
            v[j]=x;
        }
    }
    
    public void covMIF1toLA(MatrizForma1 mat1Inci){
    
        NodoDoble p,q;
        NodoSimple x;
        int f,c;
        Tripleta t;
        p=mat1Inci.primerNodo();
        while (!mat1Inci.finDeRecorrido(p)) {
            q=p.getLi();
            t=(Tripleta) q.getDato();
            f=t.getFila();
            q=q.getLi();
            t=(Tripleta) q.getDato();
            c=t.getFila();
            x=new NodoSimple(c);
            x.setLiga(v[f]);
            v[f]=x;
            x=new NodoSimple(f);
            x.setLiga(v[c]);
            v[c]=x;
            t=(Tripleta) p.getDato();
            p=(NodoDoble) t.getValor();
        }
    }
    
}
