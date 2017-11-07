/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import matrizdispersa.Tripleta;
import matrizdispersa.matrizEnTripletas;

/**
 *
 * @author jfwc1
 */
public class MultilistaA {
    private int n;
    private NodoMultilista vec[];
    
    
    
    
    //revisar
    public void covMAtoMLA(int adya[][]){
        int i,j;
        NodoMultilista x;
        for (i = 1; i <=n ; i++) {
            for ( j = i+1; j <=n; j++) {
                if (adya[i][j]==1) {
                    x=new NodoMultilista(i,j);
                    x.setLv1(vec[i]);
                    vec[i]=x;
                    x.setLv2(vec[j]);
                    vec[j]=x;
                }
            }
        }
    }
    
    public void covMItoLA(int inci[][]){
         int i,j=0,k;
        NodoMultilista x;
        //esto es provicional
        int nl=inci.length;
        for (i = 1; i <=nl; i++) {
            j=1;
            while (inci[j][i]==0) {
                j=j+1;
            }
            k=j+1;
            while (inci[k][i]==0) {
                k=k+1;
            }
            x=new NodoMultilista(j,k);
            x.setLv1(vec[j]);
            vec[j]=x;
            
            x.setLv2(vec[k]);
            vec[k]=x;
        }
    }
    
    public void covMITtoMLA(matrizEnTripletas mattInci){
        int i,f,c,nt;
        Tripleta t;
        NodoMultilista x;
        matrizEnTripletas aux;
        aux=mattInci.traspuestaRapida();
        nt=aux.retornaNumeroTripletas();
        i=1;
        while (i<nt) {
            t=aux.getTripleta(i);
            f=t.getColumna();
            i=i+1;
            t=aux.getTripleta(i);
            c=t.getColumna();
            x=new NodoMultilista(f,c);
            x.setLv1(vec[f]);
            vec[f]=x;
            x.setLv2(vec[c]);
            vec[c]=x;
            i=i+1;
        }
    }
    
}
