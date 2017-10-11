/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asgteach.sequence;

import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.openide.util.NbBundle;

public final class NumberVisualPanel1 extends JPanel {

    // Create property names for each piece of data that
    // we want to collect
    public static final String PROP_FIRST_NUMBER = "firstNumber";

    /**
     * Creates new form NumberVisualPanel1
     */
    public NumberVisualPanel1() {
        initComponents();
        // add this panel as a document listener
        // to the textfield component
        firstNumber.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                fireChange(de);
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                fireChange(de);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                fireChange(de);
            }

            private void fireChange(DocumentEvent de) {
                if (firstNumber.getDocument() == de.getDocument()) {
                    firePropertyChange(PROP_FIRST_NUMBER, 0, 1);
                }
            }
        });
    }

    @NbBundle.Messages({"CTL_Panel1Name=Provide Sequence Initial Value"})
    @Override
    public String getName() {
        return Bundle.CTL_Panel1Name();
    }

    public String getFirstNumber() {
        return firstNumber.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        firstNumber = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(NumberVisualPanel1.class, "NumberVisualPanel1.jLabel1.text")); // NOI18N

        firstNumber.setText(org.openide.util.NbBundle.getMessage(NumberVisualPanel1.class, "NumberVisualPanel1.firstNumber.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(firstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(firstNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField firstNumber;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}