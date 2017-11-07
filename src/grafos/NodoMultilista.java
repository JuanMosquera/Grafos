/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

/**
 *
 * @author jfernando.mosquera
 */
public class NodoMultilista {
    private int v1,v2,sw;
    private NodoMultilista lv1,lv2;

    public NodoMultilista() {
        
    }

    public NodoMultilista(int v1, int v2, int sw, NodoMultilista lv1, NodoMultilista lv2) {
        this.v1 = v1;
        this.v2 = v2;
        this.sw = sw;
        this.lv1 = lv1;
        this.lv2 = lv2;
    }

    NodoMultilista(int i, int j) {
        this.v1=i;
        this.v2=j;
    }
        
    public int getV1() {
        return v1;
    }

    public void setV1(int v1) {
        this.v1 = v1;
    }

    public int getV2() {
        return v2;
    }

    public void setV2(int v2) {
        this.v2 = v2;
    }

    public int getSw() {
        return sw;
    }

    public void setSw(int sw) {
        this.sw = sw;
    }

    public NodoMultilista getLv1() {
        return lv1;
    }

    public void setLv1(NodoMultilista lv1) {
        this.lv1 = lv1;
    }

    public NodoMultilista getLv2() {
        return lv2;
    }

    public void setLv2(NodoMultilista lv2) {
        this.lv2 = lv2;
    }
    
    
}
