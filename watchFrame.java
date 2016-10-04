
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shishir
 */
class Hour extends Thread{
    JTextField hour;
    boolean flag=false;
    Hour(JTextField micro){
        this.hour=micro;
        start();
    }
    public void run(){
              int i=0;
              while(true){
                  final int count =i;
                  SwingUtilities.invokeLater(
                          () -> {
                              hour.setText(""+count);
                  });
                  try{
                      Thread.sleep(3599000);
                      synchronized(this){
                          if(flag)
                              wait();
                      }
                      } catch (InterruptedException ex) {
                      ex.printStackTrace();
                  }
                  i++;
                  }
              }
    public boolean setSuspend(){
        flag=true;
        return flag;
    }
    synchronized public void setResume(){
        flag=false;
        notify();
    }
}
class Minute extends Thread{
    JTextField minute;
    boolean flag=false;
    Minute(JTextField micro){
        this.minute=micro;
        start();
    }
    public void run(){
              int i=0;
              while(true){
                  if(i>60)
                      i=0;
                  final int count =i;
                  SwingUtilities.invokeLater(
                          () -> {
                              minute.setText(""+count);
                  });
                  i++;
                  try{
                      Thread.sleep(59999);
                      synchronized(this){
                          if(flag)
                              wait();
                      }
                      } catch (InterruptedException ex) {
                      ex.printStackTrace();
                  }
                  }
              }
    public boolean setSuspend(){
        flag=true;
        return flag;
    }
    synchronized public void setResume(){
        flag=false;
        notify();
    }
}
class Second extends Thread{
    JTextField second;
    boolean flag=false;
    Second(JTextField micro){
        this.second=micro;
        start();
    }
    public void run(){
              int i=0;
              while(true){
                  if(i>59)
                      i=0;
                  final int count =i;
                  SwingUtilities.invokeLater(
                          () -> {
                              second.setText(""+count);
                  });
                  i++;
                  try{
                      Thread.sleep(999);
                      synchronized(this){
                          if(flag)
                              wait();
                      }
                      } catch (InterruptedException ex) {
                      ex.printStackTrace();
                  }
                  }
              }
    public boolean setSuspend(){
        flag=true;
        return flag;
    }
    synchronized public void setResume(){
        flag=false;
        notify();
    }
}
class Micro extends Thread{
    JTextField micro;
    boolean flag=false;
    Micro(JTextField micro){
        this.micro=micro;
        start();
    }
    public void run(){
              int i=1;
              while(true){
                  if(i>99)
                      i=1;
                  final int count =i;
                  SwingUtilities.invokeLater(
                          () -> {
                              micro.setText(""+count);
                  });
                  try{
                      Thread.sleep(5);
                      synchronized(this){
                          if(flag)
                              wait();
                      }
                      } catch (InterruptedException ex) {
                      ex.printStackTrace();
                  }
                  i++;
                  }
              }
    public boolean setSuspend(){
        flag=true;
        return flag;
    }
    synchronized public void setResume(){
        flag=false;
        notify();
    }
}
public class watchFrame extends javax.swing.JFrame {

    /**
     * Creates new form watchFrame
     */
    Micro m;
    Second s;
    Minute min;
    Hour h;
    boolean flag;
    public watchFrame() {
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

        hourTF = new javax.swing.JTextField();
        minuteTF = new javax.swing.JTextField();
        secondTF = new javax.swing.JTextField();
        microTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        start_but = new javax.swing.JButton();
        stop_but = new javax.swing.JButton();
        reset_but = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stop Watch\n");

        hourTF.setEditable(false);
        hourTF.setFont(hourTF.getFont().deriveFont(hourTF.getFont().getSize()+60f));
        hourTF.setText("00");
        hourTF.setBorder(null);

        minuteTF.setEditable(false);
        minuteTF.setFont(minuteTF.getFont().deriveFont(minuteTF.getFont().getSize()+60f));
        minuteTF.setText("00");
        minuteTF.setBorder(null);

        secondTF.setEditable(false);
        secondTF.setFont(secondTF.getFont().deriveFont(secondTF.getFont().getSize()+60f));
        secondTF.setText("00");
        secondTF.setBorder(null);

        microTF.setEditable(false);
        microTF.setFont(microTF.getFont().deriveFont(microTF.getFont().getSize()+60f));
        microTF.setText("00");
        microTF.setBorder(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText(":");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel2.setText(":");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText(":");

        start_but.setText("Start");
        start_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                start_butActionPerformed(evt);
            }
        });

        stop_but.setText("Stop");
        stop_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stop_butActionPerformed(evt);
            }
        });

        reset_but.setText("Reset");
        reset_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset_butActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Pristina", 0, 48)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.activeCaption);
        jLabel4.setText("Stop Watch");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reset_but, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(hourTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minuteTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addComponent(start_but, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 2, Short.MAX_VALUE)
                                .addComponent(secondTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(microTF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(stop_but, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hourTF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minuteTF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secondTF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(microTF, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(64, 64, 64))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(65, 65, 65))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(67, 67, 67)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start_but, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stop_but, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(reset_but)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reset_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset_butActionPerformed
        flag=false;
        microTF.setText("00");
        secondTF.setText("00");
        minuteTF.setText("00");
        hourTF.setText("00");
    }//GEN-LAST:event_reset_butActionPerformed

    private void stop_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stop_butActionPerformed
        reset_but.setEnabled(true);
        flag=m.setSuspend();
        flag=s.setSuspend();
        flag=min.setSuspend();
        flag=h.setSuspend();
    }//GEN-LAST:event_stop_butActionPerformed

    private void start_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_start_butActionPerformed
        reset_but.setEnabled(false);
        if(flag){
            m.setResume();
            s.setResume();
            min.setResume();
            h.setResume();
        }
        else{
            m=new Micro(microTF);
            s=new Second(secondTF);
            min=new Minute(minuteTF);
            h=new Hour(hourTF);
        }
    }//GEN-LAST:event_start_butActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(watchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(watchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(watchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(watchFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new watchFrame().setVisible(true);
                start_but.requestFocusInWindow();
                reset_but.setEnabled(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField hourTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public javax.swing.JTextField microTF;
    public javax.swing.JTextField minuteTF;
    private static javax.swing.JButton reset_but;
    public javax.swing.JTextField secondTF;
    private static javax.swing.JButton start_but;
    private javax.swing.JButton stop_but;
    // End of variables declaration//GEN-END:variables
}
