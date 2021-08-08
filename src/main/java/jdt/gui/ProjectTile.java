/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdt.gui;

import jdt.gui.MainForm;
import jdt.data.Project;
import jdt.manager.ProjectManager;
import jdt.manager.UserManager;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author lukeleppan
 */
public class ProjectTile extends javax.swing.JPanel {

    private Project project;
    private CardLayout cardLayout;
    private CardLayout mainCardLayout;
    private JPanel mainPanel;

    public ProjectTile(Project project, CardLayout mainCardLayout, JPanel mainPanel) {

        initComponents();

        this.project = project;

        this.mainPanel = mainPanel;
        this.mainCardLayout = mainCardLayout;
        cardLayout = (CardLayout) this.pnlMain.getLayout();

        txtaProjectDescriptionTile.setBorder(null);
        txtaProjectDescriptionTile.setBackground(null);
        Color backColor = new Color(UIManager.getColor("RootPane.background").getRGB());
        txtaProjectDescriptionTile.setBackground(backColor);
        lblProjectTitleTile.setText(project.getProjectTitle());
        txtaProjectDescriptionTile.setText(project.getProjectDescription());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlView = new javax.swing.JPanel();
        lblProjectTitleTile = new javax.swing.JLabel();
        txtaProjectDescriptionTile = new javax.swing.JTextArea();
        btnOpen = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        pnlEDIT = new javax.swing.JPanel();
        txtfProjectTitleEdit = new javax.swing.JTextField();
        spProjectDescriptionEdit = new javax.swing.JScrollPane();
        txtaProjectDescriptionEdit = new javax.swing.JTextArea();
        btnSaveEdit = new javax.swing.JButton();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));

        pnlMain.setLayout(new java.awt.CardLayout());

        lblProjectTitleTile.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N

        txtaProjectDescriptionTile.setEditable(false);
        txtaProjectDescriptionTile.setColumns(20);
        txtaProjectDescriptionTile.setLineWrap(true);
        txtaProjectDescriptionTile.setRows(5);
        txtaProjectDescriptionTile.setFocusable(false);
        txtaProjectDescriptionTile.setPreferredSize(new java.awt.Dimension(100, 60));

        btnOpen.setText("Open");
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlViewLayout = new javax.swing.GroupLayout(pnlView);
        pnlView.setLayout(pnlViewLayout);
        pnlViewLayout.setHorizontalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtaProjectDescriptionTile, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProjectTitleTile, javax.swing.GroupLayout.PREFERRED_SIZE, 353, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOpen)
                .addGap(16, 16, 16))
        );
        pnlViewLayout.setVerticalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlViewLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblProjectTitleTile, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtaProjectDescriptionTile, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOpen)
                    .addComponent(btnEdit)
                    .addComponent(btnDelete))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMain.add(pnlView, "card2");

        txtaProjectDescriptionEdit.setColumns(20);
        txtaProjectDescriptionEdit.setRows(5);
        spProjectDescriptionEdit.setViewportView(txtaProjectDescriptionEdit);

        btnSaveEdit.setText("Save");
        btnSaveEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEDITLayout = new javax.swing.GroupLayout(pnlEDIT);
        pnlEDIT.setLayout(pnlEDITLayout);
        pnlEDITLayout.setHorizontalGroup(
            pnlEDITLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEDITLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlEDITLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtfProjectTitleEdit)
                    .addComponent(spProjectDescriptionEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEDITLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSaveEdit)
                .addGap(21, 21, 21))
        );
        pnlEDITLayout.setVerticalGroup(
            pnlEDITLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEDITLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtfProjectTitleEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spProjectDescriptionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSaveEdit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMain.add(pnlEDIT, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

  private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenActionPerformed
        ProjectView projectView = new ProjectView(this.project);
        projectView.setVisible(true);
  }//GEN-LAST:event_btnOpenActionPerformed

  private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        ProjectManager projectManager = new ProjectManager();
        projectManager.DeleteProject(project);

        JOptionPane.showMessageDialog(MainForm.pnlCardPV, "Project Deleted");
  }//GEN-LAST:event_btnDeleteActionPerformed

  private void btnSaveEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEditActionPerformed

  }//GEN-LAST:event_btnSaveEditActionPerformed

        private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        }//GEN-LAST:event_btnEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSaveEdit;
    private javax.swing.JLabel lblProjectTitleTile;
    private javax.swing.JPanel pnlEDIT;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlView;
    private javax.swing.JScrollPane spProjectDescriptionEdit;
    private javax.swing.JTextArea txtaProjectDescriptionEdit;
    private javax.swing.JTextArea txtaProjectDescriptionTile;
    private javax.swing.JTextField txtfProjectTitleEdit;
    // End of variables declaration//GEN-END:variables
}
