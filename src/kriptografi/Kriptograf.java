/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kriptografi;

/**
 *
 * @author sonif
 */
public class Kriptograf extends javax.swing.JFrame {

    /**
     * Creates new form Kriptograf
     */
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
        zigZag();
        getPlaint();
        matrik();        
        getChipIndex();
        getChip();
    }
    
    private static void getPlaintText(){
        getChipInt();
        matrikDua();
        getPlaintIndex();
        zigZagDua();
        getPlaintDua();
    }
    public Kriptograf() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pText = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Plaintext"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pText)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pText, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Ciphertext"));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cText)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cText, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jButton1.setText("Encrypt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Decrypt");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Clear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(76, 76, 76)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        pText.setText("");
        cText.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        plaint = pText.getText();
        getChiperText();
        cText.setText(chiper);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        chiper = cText.getText();
        getPlaintText();
        pText.setText(plaint3);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Kriptograf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kriptograf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kriptograf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kriptograf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kriptograf().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cText;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField pText;
    // End of variables declaration//GEN-END:variables
}
