/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asgteach.personeditor;

import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//com.asgteach.personeditor//Person//EN",
autostore = false)
@TopComponent.Description(preferredID = "PersonTopComponent",
iconBase = "com/asgteach/personeditor/personIcon.png",
persistenceType = TopComponent.PERSISTENCE_ONLY_OPENED)
@TopComponent.Registration(mode = "editor", openAtStartup = false)
@Messages({
    "CTL_PersonAction=Person",
    "CTL_PersonTopComponent=Person Window",
    "HINT_PersonTopComponent=This is a Person window"
})
public final class PersonTopComponent extends TopComponent {

    public PersonTopComponent() {
        initComponents();
        setName(Bundle.CTL_PersonTopComponent());
        setToolTipText(Bundle.HINT_PersonTopComponent());

    }
       

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nameTextField = new javax.swing.JTextField();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(PersonTopComponent.class, "PersonTopComponent.jLabel1.text")); // NOI18N

        nameTextField.setText(org.openide.util.NbBundle.getMessage(PersonTopComponent.class, "PersonTopComponent.nameTextField.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(250, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField nameTextField;
    // End of variables declaration//GEN-END:variables
    @Override
    public void componentOpened() {
        System.out.println(nameTextField.getText() + " opened");
    }

    @Override
    public void componentClosed() {
        System.out.println(nameTextField.getText() + " closed");
    }

    @Override
    public boolean canClose() {
        return !nameTextField.getText().toLowerCase().endsWith("guru");
    }

    @Override
    protected void componentActivated() {
        super.componentActivated();
        System.out.println(nameTextField.getText() + " activated");
    }

    @Override
    protected void componentDeactivated() {
        super.componentDeactivated();
        System.out.println(nameTextField.getText() + " deactivated");
    }

    @Override
    protected void componentHidden() {
        super.componentHidden();
        System.out.println(nameTextField.getText() + " hidden");
    }

    @Override
    protected void componentShowing() {
        super.componentShowing();
        System.out.println(nameTextField.getText() + " showing");
    }

    void writeProperties(java.util.Properties p) {
        System.out.println("writeProperties");
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        p.setProperty("name", nameTextField.getText());
    }

    void readProperties(java.util.Properties p) {
        System.out.println("readProperties");
        String version = p.getProperty("version");
        nameTextField.setText(p.getProperty("name"));    
    }
}