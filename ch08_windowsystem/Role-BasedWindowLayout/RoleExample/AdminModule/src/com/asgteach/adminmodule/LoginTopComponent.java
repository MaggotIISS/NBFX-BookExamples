/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asgteach.adminmodule;

import com.asgteach.rolemodel.api.User;
import com.asgteach.rolemodel.api.UserRole;
import org.netbeans.api.settings.ConvertAsProperties;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.util.Lookup;
import org.openide.util.NbBundle.Messages;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//com.asgteach.adminmodule//Login//EN",
autostore = false)
@TopComponent.Description(preferredID = "LoginTopComponent",
iconBase = "com/asgteach/adminmodule/personIcon.png",
persistenceType = TopComponent.PERSISTENCE_ALWAYS)
@TopComponent.Registration(mode = "editor", openAtStartup = true)
@ActionID(category = "Window", id = "com.asgteach.adminmodule.LoginTopComponent")
@ActionReference(path = "Menu/Window" /*
 * , position = 333
 */)
@TopComponent.OpenActionRegistration(displayName = "#CTL_LoginAction",
preferredID = "LoginTopComponent")
@Messages({
    "CTL_LoginAction=Login",
    "CTL_LoginTopComponent=Login Window",
    "HINT_LoginTopComponent=This is a Login window",
    "ERROR_IncorrectLogin=Incorrect login for user "    
})
public final class LoginTopComponent extends TopComponent {

    public LoginTopComponent() {
        initComponents();
        setName(Bundle.CTL_LoginTopComponent());
        setToolTipText(Bundle.HINT_LoginTopComponent());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(LoginTopComponent.class, "LoginTopComponent.jLabel1.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(LoginTopComponent.class, "LoginTopComponent.jLabel2.text")); // NOI18N

        usernameTextField.setText(org.openide.util.NbBundle.getMessage(LoginTopComponent.class, "LoginTopComponent.usernameTextField.text")); // NOI18N

        passwordField.setText(org.openide.util.NbBundle.getMessage(LoginTopComponent.class, "LoginTopComponent.passwordField.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(loginButton, org.openide.util.NbBundle.getMessage(LoginTopComponent.class, "LoginTopComponent.loginButton.text")); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(errorLabel, org.openide.util.NbBundle.getMessage(LoginTopComponent.class, "LoginTopComponent.errorLabel.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(loginButton)
                        .addComponent(usernameTextField)
                        .addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE))
                    .addComponent(errorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(loginButton)
                .addGap(31, 31, 31)
                .addComponent(errorLabel)
                .addContainerGap(115, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        errorLabel.setText("");
        UserRole userRole = Lookup.getDefault().lookup(UserRole.class);
        if (userRole != null) {
            User thisUser = userRole.findUser(usernameTextField.getText(), 
                    new String(passwordField.getPassword()));
            WindowManager wm = WindowManager.getDefault();
            if (thisUser != null) {
                // switch to new role
                wm.setRole(thisUser.getRole());
            } else {
                errorLabel.setText(Bundle.ERROR_IncorrectLogin() + usernameTextField.getText());
                if (wm.getRole() != null) {
                    // put it back to the default role
                    wm.setRole(null);
                }
            }

        } 
    }//GEN-LAST:event_loginButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    void readProperties(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }
}