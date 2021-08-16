package jdt.gui;

import jdt.data.Project;
import jdt.manager.ProjectManager;
import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Project Tile panel allow users to open, edit and delete projects.
 *
 * @author lukeleppan
 */
public class ProjectTile extends javax.swing.JPanel {

	private CardLayout cardLayout;
	private Project project;
	private MainForm context;
	private final ProjectManager projectManager;

	/**
	 * Creates Project tile.
	 *
	 * @param project project data.
	 * @param context context to refresh view.
	 */
	public ProjectTile(Project project, MainForm context) {

		initComponents();

		this.projectManager = new ProjectManager();

		cardLayout = (CardLayout) (pnlMain.getLayout());

		this.project = project;
		this.context = context;

		txtaProjectDescriptionTile.setBorder(null);
		txtaProjectDescriptionTile.setBackground(null);
		Color backColor = new Color(UIManager.getColor("RootPane.background").getRGB());
		txtaProjectDescriptionTile.setBackground(backColor);
		lblProjectTitleTile.setText(project.getProjectTitle());
		txtaProjectDescriptionTile.setText(project.getProjectDescription());
		txtfProjectTitleEdit.setText(project.getProjectTitle());
		txtaProjectDescriptionEdit.setText(project.getProjectDescription());
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
        pnlEdit = new javax.swing.JPanel();
        txtfProjectTitleEdit = new javax.swing.JTextField();
        spProjectDescriptionEdit = new javax.swing.JScrollPane();
        txtaProjectDescriptionEdit = new javax.swing.JTextArea();
        btnSaveEdit = new javax.swing.JButton();
        btnCancelEdit = new javax.swing.JButton();

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

        pnlMain.add(pnlView, "pnlView");

        txtaProjectDescriptionEdit.setColumns(20);
        txtaProjectDescriptionEdit.setRows(5);
        spProjectDescriptionEdit.setViewportView(txtaProjectDescriptionEdit);

        btnSaveEdit.setText("Save");
        btnSaveEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEditActionPerformed(evt);
            }
        });

        btnCancelEdit.setText("Cancel");
        btnCancelEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelEditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEditLayout = new javax.swing.GroupLayout(pnlEdit);
        pnlEdit.setLayout(pnlEditLayout);
        pnlEditLayout.setHorizontalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtfProjectTitleEdit)
                    .addComponent(spProjectDescriptionEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSaveEdit)
                .addGap(21, 21, 21))
        );
        pnlEditLayout.setVerticalGroup(
            pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(txtfProjectTitleEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spProjectDescriptionEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveEdit)
                    .addComponent(btnCancelEdit))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlMain.add(pnlEdit, "pnlEdit");

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

	/**
	 * Cancels project edit
	 *
	 * @param evt
	 */
    private void btnCancelEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelEditActionPerformed
		cardLayout.show(pnlMain, "pnlView");
		txtfProjectTitleEdit.setText(project.getProjectTitle());
		txtaProjectDescriptionEdit.setText(project.getProjectDescription());
    }//GEN-LAST:event_btnCancelEditActionPerformed

	/**
	 * Opens project
	 *
	 * @param evt
	 */
	private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnOpenActionPerformed
		ProjectView projectView = new ProjectView(this.project);
		projectView.setVisible(true);
	}// GEN-LAST:event_btnOpenActionPerformed

	/**
	 * Deletes project
	 *
	 * @param evt
	 */
	private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteActionPerformed
		if (!(projectManager.deleteProject(project) <= -1)) {
			context.refreshProjectView();
			context.repaint();
			JOptionPane.showMessageDialog(MainForm.pnlCardPV, "Project Deleted");
		} else {
			JOptionPane.showMessageDialog(MainForm.pnlCardPV, "Project Failed to Update");
		}

	}// GEN-LAST:event_btnDeleteActionPerformed

	/**
	 * Saves project edit
	 *
	 * @param evt
	 */
	private void btnSaveEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveEditActionPerformed
		if (txtfProjectTitleEdit.getText().length() < 1
				|| txtfProjectTitleEdit.getText().length() > 50) {
			JOptionPane.showMessageDialog(this, "Title has Incorrect Length");
		} else if (txtaProjectDescriptionEdit.getText().length() < 1
				|| txtaProjectDescriptionTile.getText().length() > 350) {
			JOptionPane.showMessageDialog(this, "Description has Incorrect Length");
		} else {

			Project newProject = new Project(
					project.getProjectID(),
					project.getUserID(),
					txtfProjectTitleEdit.getText(),
					txtaProjectDescriptionEdit.getText()
			);

			if (!(projectManager.updateProject(newProject) <= -1)) {
				context.refreshProjectView();
				context.repaint();
				JOptionPane.showMessageDialog(MainForm.pnlCardPV, "Project Updated");
			} else {
				JOptionPane.showMessageDialog(MainForm.pnlCardPV, "Project Failed to Update");
			}
		}
	}// GEN-LAST:event_btnSaveEditActionPerformed

	/**
	 * Opens project edit
	 *
	 * @param evt
	 */
	private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditActionPerformed
		cardLayout.show(pnlMain, "pnlEdit");
	}// GEN-LAST:event_btnEditActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelEdit;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnOpen;
    private javax.swing.JButton btnSaveEdit;
    private javax.swing.JLabel lblProjectTitleTile;
    private javax.swing.JPanel pnlEdit;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlView;
    private javax.swing.JScrollPane spProjectDescriptionEdit;
    private javax.swing.JTextArea txtaProjectDescriptionEdit;
    private javax.swing.JTextArea txtaProjectDescriptionTile;
    private javax.swing.JTextField txtfProjectTitleEdit;
    // End of variables declaration//GEN-END:variables
}
