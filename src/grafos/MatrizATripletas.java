/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;
import listas.NodoSimple;
import matrizdispersa.Tripleta;
/**
 *
 * @author jfwc1
 */
public class MatrizATripletas {
    private Tripleta matt;
    
    public void covLAtoMAT(NodoSimple v[]){
        int i,j;
        NodoSimple p;
        Tripleta tx;
        for (i = 1; i <=n; i++) {
            p=v[i];
            while (p!=null) {
                j=(Integer)p.getDato();
                tx=new Tripleta(i,j,1);
                matt.insertaTripleta(tx);
                p=p.getLiga();
            }
        }
    }
    
}
