/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author jfwc1
 */
public class Grafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         
        try{
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            String[] arr = new String[n];
            arr[0] = in.nextLine();
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextLine();
            }
            
//            Arrays.sort(arr);
//             int result = minimumAbsoluteDifference(n, arr);
//            System.out.println(result);
             MatrizA grafo= new MatrizA(6);
//                    grafo.llenarPrueba();
            grafo.lis(arr, n);
            grafo.mostrar();
            grafo.dfs(1);
            in.close();
        }catch (Exception e) {
            System.out.println("Invalid character input");
        }
        
       
    }
    
    
}
