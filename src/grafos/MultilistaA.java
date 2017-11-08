/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;
import java.util.Queue;
import matrizdispersa.Tripleta;
import matrizdispersa.matrizEnTripletas;

/**
 *
 * @author jfwc1
 */
public class MultilistaA {
    private int n;
    private NodoMultilista vec[];
    private int visitado[];

    public MultilistaA(int n) {
        this.n = n;
        vec=new NodoMultilista[n];
         visitado=new int[n];
        
        for (int i = 0; i < n; i++) {
            vec[i]=null;
            visitado[i]=0;
        }
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public NodoMultilista[] getVec() {
        return vec;
    }

    public void setVec(NodoMultilista[] vec) {
        this.vec = vec;
    }
    
    
    
    
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
    
    public void insert(int v1,int v2){
        NodoMultilista x = new NodoMultilista(v1,v2);
        
        x.setLv1(vec[v1]);
        vec[v1]=x;
        x.setLv2(vec[v2]);
        vec[v2]=x;
//        NodoMultilista aux;
//        if (vec[v1]==null) {
//            vec[v1]=x;
//        } else {
//            aux=vec[v1];
//            while (aux.getLv1()!=null) {
//                aux=aux.getLv1();
//            }
//            aux.setLv1(x);
//        }
//        
//        if (vec[v2]==null) {
//            vec[v2]=x;
//        } else {
//            aux=vec[v2];
//            while (aux.getLv2()!=null) {
//                aux=aux.getLv2();
//            }
//            aux.setLv2(x);
//        }
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
    
    public void mostrar(){
        NodoMultilista aux;
        int mo[][]=new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mo[i][j]=0;
            }
        }
        for (int i = 0; i < n; i++) {
            aux=vec[i];
            while (aux!=null) {
                if (i==aux.getV1()) {
                    mo[i][aux.getV2()]=1;
                    aux=aux.getLv1();
                } else {
                     mo[i][aux.getV1()]=1;
                    aux=aux.getLv2();
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mo[i][j]);
            }
            System.out.println("");
        }
    }
    
    public void dfs(int v){
        int w;
        NodoMultilista p,q;
        System.out.println(v);
        visitado[v-1]=1;
        p=vec[v-1];
        while (p!=null) {
            w=p.getV1();
            q=p.getLv2();
            if (w==v-1) {
                w=p.getV2();
                q=p.getLv1();
            }
            if (visitado[w]==0) {
                dfs(w+1);
            }
            p=q;
        }
    }
    
    public void bfs(int v){
        int w;
        NodoMultilista p,q;
        Queue<Integer> cola=new LinkedList();
        visitado[v]=1;
        cola.add(v);
        while (!cola.isEmpty()) {
            v=cola.poll();
            System.out.println(v);
            p=vec[v];
            while (p!=null) {
                w=p.getV1();
                q=p.getLv2();
                if (w==v) {
                    w=p.getV2();
                    q=p.getLv1();
                }
                if (visitado[w]==0) {
                    visitado[w]=1;
                    cola.add(w);
                }
                p=q;
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
