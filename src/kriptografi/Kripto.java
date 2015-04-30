/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptografi;

/**
 *
 * @author root
 */
import java.util.Scanner;
public class Kripto {
    static char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static String plaint;
    static int[] index1;
    static int[] index2;
    static String plaint2;
    static String plaint3;
    static int[] plaintMat;
    static int[] plaintMatDua;
    static int[] plaintIndex;
    static int[][] mat = {{5, 6},{2, 3}};
    static int[][] matDua = {{1, 24},{8, 19}};
    static int[] chiperIndex;
    static String chiper;
    
    private static void getInt(){
        index1 = new int[plaint.length()];
        for (int i = 0; i < index1.length; i++) {
            for (int j = 0; j < alpha.length; j++) {
                if (plaint.charAt(i) == alpha[j]) {
                    index1[i] = j;
                }
            }
        }
    }
    
    private static void getChipInt(){
        chiperIndex = new int[chiper.length()];
        for (int i = 0; i < chiperIndex.length; i++) {
            for (int j = 0; j < alpha.length; j++) {
                if (chiper.charAt(i) == alpha[j]) {
                    chiperIndex[i] = j;
                }
            }
        }
    }
    
    private static void zigZag(){
        index2 = new int[index1.length];
        for (int i = 0; i < index2.length; i++) {
            if (i%2 == 0) {
                if (index1[i]-1 < 0) {
                    index2[i] = 25;
                } else {
                    index2[i] = index1[i] - 1;
                }                
            } else {
                if (index1[i]+1 > 25) {
                    index2[i] = 0;
                } else {
                    index2[i] = index1[i] + 1;
                }  
            }
        }
    }
    
    private static void zigZagDua(){
        plaintIndex = new int[chiper.length()];
        for (int i = 0; i < plaintIndex.length; i++) {
            if (i%2 == 0) {
                if (plaintMatDua[i]+1 > 25) {
                    plaintIndex[i] = 0;
                } else {
                    plaintIndex[i] = plaintMatDua[i] + 1;
                }                
            } else {
                if (plaintMatDua[i]-1 < 0) {
                    plaintIndex[i] = 25;
                } else {
                    plaintIndex[i] = plaintMatDua[i] - 1;
                }  
            }
        }
    }
    
    private static void getPlaint(){
        plaint2 = "";
        for (int i = 0; i < index2.length; i++) {
            plaint2 += alpha[index2[i]];
        }
    }
    
    private static void matrik(){
        plaintMat = new int[index2.length];
        //double a = plaintMat.length;
        int z = plaintMat.length/2;
        int n = 0;
        int m = 0;
        for (int i = 0; i < z; i++) {
            int o;
            for (int j = 0; j < 2; j++) {
                o = m;
                for (int k = 0; k < 2; k++) {
                    plaintMat[n] += mat[j][k] * index2[o];
                    o++;
                }
                n++;
            }
            m+=2;
        }
        if (index2.length%2 == 1) {
            plaintMat[n] = index2[n];
        }
    }
    
    private static void matrikDua(){
        plaintMatDua = new int[chiper.length()];
        //double a = plaintMatDua.length;
        int z = plaintMatDua.length/2;
        int n = 0;
        int m = 0;
        for (int i = 0; i < z; i++) {
            int o;
            for (int j = 0; j < 2; j++) {
                o = m;
                for (int k = 0; k < 2; k++) {
                    plaintMatDua[n] += matDua[j][k] * chiperIndex[o];
                    o++;
                }
                n++;
            }
            m+=2;
        }
        if (plaintMatDua.length%2 == 1) {
            plaintMatDua[n] = chiperIndex[n];
        }
    }
    
    private static void getChipIndex(){
        chiperIndex = new int[plaintMat.length];
        for (int i = 0; i < chiperIndex.length; i++) {
            chiperIndex[i] = Math.abs(plaintMat[i])%26;
        }
    }
    
    private static void getChip(){
        chiper = "";
        for (int i = 0; i < chiperIndex.length; i++) {
            chiper += alpha[chiperIndex[i]];
        }
    }
    
    private static void getPlaintDua(){
        plaint3 = "";
        for (int i = 0; i < plaintMatDua.length; i++) {
            plaint3 += alpha[plaintIndex[i]];
        }
    }
    
    private static void getPlaintIndex(){
        for (int i = 0; i < plaintMatDua.length; i++) {
            plaintMatDua[i] = plaintMatDua[i]%26;
        }
    }
    
    private static void getChiperText(){
        getInt();
        System.out.println(plaint);
        for (int i = 0; i < index1.length; i++) {
            System.out.print(index1[i]+"  ");
        }
        zigZag();
        System.out.println("");
        for (int i = 0; i < index2.length; i++) {
            System.out.print(index2[i]+"  ");
        }
        getPlaint();
        System.out.println("");
        System.out.println(plaint2);
        matrik();        
        getChipIndex();
        for (int i = 0; i < chiperIndex.length; i++) {
            System.out.print(chiperIndex[i]+"  ");
        }
        getChip();
        System.out.println("");
        System.out.println(chiper);
    }
    
    private static void getPlaintText(){
        matrikDua();
        for (int i = 0; i < chiperIndex.length; i++) {
            System.out.print((plaintMatDua[i]%26)+"  ");
        }
        System.out.println("");
        getPlaintIndex();
        zigZagDua();
        for (int i = 0; i < plaintIndex.length; i++) {
            System.out.print(plaintIndex[i]+"  ");
        }
        getPlaintDua();
        System.out.println("");
        System.out.println(plaint3);
    }
    
    public static void main(String[] args) {
        Scanner masuk = new Scanner(System.in);
        
        System.out.print("Masukkan kata : ");
        plaint = masuk.next();
        getChiperText();
        //chiper = "nheztk";
        //getChipInt();
        //getPlaintText();
    }
}
