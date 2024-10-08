/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package schedulerComponents;

//import com.mycompany.process.Queue;
//import com.mycompany.process.QueueGenerator;

import com.mycompany.processFinal.QueuesFinal;
import com.mycompany.processFinal.QueueGenerator;
import java.util.ArrayDeque;

import java.util.ArrayList;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author LENOVO
 */
public class mlfqConfig extends javax.swing.JPanel {
	public List<queuePanel> queueList = new ArrayList();
	public List<QueuesFinal> queues = new ArrayList<>();

    /**
     * Creates new form mlfqConfig1
     */
    public mlfqConfig() {
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

                jLabel2 = new javax.swing.JLabel();
                jTextArea1 = new javax.swing.JTextArea();
                jTextField1 = new javax.swing.JTextField();
                jPanel1 = new javax.swing.JPanel();
                Queues = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                generateQueues = new javax.swing.JButton();
                clearQueues = new javax.swing.JButton();
                queueObjectPane = new javax.swing.JScrollPane();
                queueObjectsPanel = new javax.swing.JPanel();
                jLabel3 = new javax.swing.JLabel();
                priorityPolicy = new javax.swing.JComboBox<>();
                jLabel4 = new javax.swing.JLabel();
                entryQueueNo = new javax.swing.JTextField();
                nQueueInput = new javax.swing.JTextField();
                jLabel5 = new javax.swing.JLabel();
                jSeparator1 = new javax.swing.JSeparator();
                jLabel6 = new javax.swing.JLabel();
                jSeparator2 = new javax.swing.JSeparator();
                jLabel7 = new javax.swing.JLabel();

                jLabel2.setText("jLabel2");

                jTextArea1.setColumns(20);
                jTextArea1.setRows(5);

                jTextField1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
                );
                jPanel1Layout.setVerticalGroup(
                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
                );

                Queues.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
                Queues.setText("Queues");

                jLabel1.setText("No. of Queues");

                generateQueues.setText("Generate");
                generateQueues.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                generateQueuesActionPerformed(evt);
                        }
                });

                clearQueues.setText("Clear");
                clearQueues.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                clearQueuesActionPerformed(evt);
                        }
                });

                queueObjectPane.setHorizontalScrollBar(null);

                queueObjectsPanel.setLayout(new javax.swing.BoxLayout(queueObjectsPanel, javax.swing.BoxLayout.Y_AXIS));
                queueObjectPane.setViewportView(queueObjectsPanel);

                jLabel3.setText("Priority Policy");

                priorityPolicy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Higher Before Lower", "Fixed Time Slots"}));
                priorityPolicy.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                priorityPolicyActionPerformed(evt);
                        }
                });

                jLabel4.setText("Entry Queue");

                entryQueueNo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                entryQueueNoActionPerformed(evt);
                        }
                });

                nQueueInput.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                nQueueInputActionPerformed(evt);
                        }
                });

                jLabel5.setText("Queue ID");

                jLabel6.setText("Scheduling Algorithm");

                jLabel7.setText("Quantum");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(queueObjectPane, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap())
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(6, 6, 6)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel6)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addGap(37, 37, 37))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(nQueueInput, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(generateQueues)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(clearQueues))
                                                        .addComponent(Queues)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(priorityPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(entryQueueNo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Queues)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(clearQueues, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel1)
                                                .addComponent(nQueueInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(generateQueues)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(queueObjectPane, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(priorityPolicy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)
                                        .addComponent(entryQueueNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );

                queueObjectPane.getAccessibleContext().setAccessibleName("queuesGenPane");
        }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void generateQueuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generateQueuesActionPerformed
	    queueList.clear();
	    queues.clear();
	    queueObjectsPanel.removeAll();
	    queueObjectsPanel.repaint();
	    String inputText = nQueueInput.getText();
	    int numberOfQueues;

	    try{
		    numberOfQueues = Integer.parseInt(inputText);
		    if (numberOfQueues < 1 || numberOfQueues > 3) {
			    throw new NumberFormatException("Number out of range");
			}
	    } catch (NumberFormatException e){
		    JOptionPane.showMessageDialog(this, "Invalid number of queues. Please inoput an integer.", "Error", JOptionPane.ERROR_MESSAGE); 
		    return;
	    }
	    QueueGenerator queueGenerator = new QueueGenerator();
	    queues = queueGenerator.generateQueues(numberOfQueues);
            QueuesFinal.initializeQueues(numberOfQueues);
	    StringBuilder queueInfo = new StringBuilder();
	    for (QueuesFinal queue: queues){
		    queueInfo.append(queue.toString()).append("\n");
		    queuePanel newQueue = new queuePanel();
		    newQueue.queueID.setText(Integer.toString(queue.getQueueIndex()));
		    queueList.add(newQueue);
                    
                    System.out.println(queue.getQueueIndex());
//                    QueuesFinal.queue[queue.getQueueIndex()] = new ArrayDeque<>();
                    QueuesFinal.systemQueues[queue.getQueueIndex()-1] = new QueuesFinal(queue.getQueueIndex()-1, 1, (int) Math.pow(2, queue.getQueueIndex()+1));
                     		    
	    }
	    System.out.println(queueInfo);
	    // displaying queues
	    for(queuePanel panel: queueList){
		    queueObjectsPanel.add(panel);
		    queueObjectsPanel.revalidate();
	    }
	    queueObjectPane.revalidate();
    }//GEN-LAST:event_generateQueuesActionPerformed

    private void clearQueuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearQueuesActionPerformed
	    nQueueInput.setText("");
	    queueList.clear();
	    queues.clear();
	    queueObjectsPanel.removeAll();
	    queueObjectsPanel.revalidate();
	    queueObjectsPanel.repaint();
    }//GEN-LAST:event_clearQueuesActionPerformed

    private void priorityPolicyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priorityPolicyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priorityPolicyActionPerformed

    private void entryQueueNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entryQueueNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_entryQueueNoActionPerformed

        private void nQueueInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nQueueInputActionPerformed
		nQueueInputActionPerformed(evt);
		
        }//GEN-LAST:event_nQueueInputActionPerformed
	public List<QueuesFinal> getQueueList(){
		return queues;
	}


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JLabel Queues;
        private javax.swing.JButton clearQueues;
        public javax.swing.JTextField entryQueueNo;
        private javax.swing.JButton generateQueues;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JSeparator jSeparator1;
        private javax.swing.JSeparator jSeparator2;
        private javax.swing.JTextArea jTextArea1;
        private javax.swing.JTextField jTextField1;
        private javax.swing.JTextField nQueueInput;
        public javax.swing.JComboBox<String> priorityPolicy;
        private javax.swing.JScrollPane queueObjectPane;
        public javax.swing.JPanel queueObjectsPanel;
        // End of variables declaration//GEN-END:variables
}
