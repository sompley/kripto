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
public class Kriptografi {

    /**
     * @param args the command line arguments
     */
    static char[] plaint;
    static char[] chiper = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    static int n;
    static int[] index;
    static int[] index2;
    static int[] index3;
    static char[] stage1;
    static char[] stage2;
    static int[][] mat = {{-2, 3},{-1, 1}};
    static int[][] mat2;
    static int[][] hasilMat = new int[2][2];
    static int[][] pinal;
    static char[] ciper;
    static int kol;
    
    private static void cariIndex(char[] x){
        index = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < chiper.length; j++) {
                if (x[i] == chiper[j]) {
                    index[i] = j;
                }
            }
        }
    }
    
    private static void zig(int[] x){
        index2 = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            if (i%2==0) {
                if (x[i] - 1 < 0) {
                    index2[i] = 25;
                } else {
                    index2[i] = x[i] - 1;
                }
            } else {
                if (x[i] + 1 > 25) {
                    index2[i] = 0;
                } else {
                    index2[i] = x[i] + 1;
                }
            }
        }
    }
    
    private static void stageOne(int[] x){
        stage1 = new char[x.length];
        for (int i = 0; i < stage1.length; i++) {
            stage1[i] = chiper[x[i]];
        }
    }
    
    private static void ambilDuaNilai(int[] x){
        int n = x.length/2;
        kol = n;
        int m = 0;
        mat2 = new int[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                mat2[i][j] = x[m];
                m++;
            }
        }
    }
    
    private static int[][] kali(int[][] x){
        int[][] n = new int[2][1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < 2; k++) {
                    n[i][j] += mat[i][k]*x[k][j];
                }
            }
        }
        return n;
    }
    
    private static void hasil(){
        int[][] n = new int[2][1];
        int[][] hasil;
        pinal = new int[kol][2];
        for (int i = 0; i < kol; i++) {
            for (int j = 0; j < 2; j++) {
                n[j][0] = mat2[j][i];
            }
            hasil = kali(n);
            for (int j = 0; j < 2; j++) {
                pinal[i][j] = hasil[j][0]; 
            }
        } 
    }
    
    private static void masukIndex(int[][] x){
        int m = 0;
        index3 = new int[n];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < 2; j++) {
                index3[m] = Math.abs(x[i][j])%26;
                m++;
            }
        }
    }
    
    private static void cheap(int[] x){
        ciper = new char[x.length];
        for (int i = 0; i < x.length; i++) {
            ciper[i] = chiper[x[i]];
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner masuk = new Scanner(System.in);
        System.out.print("masukkan kata : ");
        String huruf = masuk.next();
        n = huruf.length();
        plaint = new char[n];
        for (int i = 0; i < n; i++) {
            plaint[i] = huruf.charAt(i);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(plaint[i]+"  ");
        }
        System.out.println("");
        cariIndex(plaint);
        zig(index);
        for (int i = 0; i < index.length; i++) {
            System.out.print(index[i]+"  ");
        }
        System.out.println("");
        for (int i = 0; i < index2.length; i++) {
            System.out.print(index2[i]+"  ");
        }
        System.out.println("");
        stageOne(index2);
        for (int i = 0; i < stage1.length; i++) {
            System.out.print(stage1[i]+"  ");
        }
        System.out.println("");
        ambilDuaNilai(index2);
        hasil();
        masukIndex(pinal);
        for (int i = 0; i < index3.length; i++) {
            System.out.print(index3[i]+"  ");
        }
        System.out.println("");
        cheap(index3);
        for (int i = 0; i < ciper.length; i++) {
            System.out.print(ciper[i]+"  ");
        }
    }
    
}
