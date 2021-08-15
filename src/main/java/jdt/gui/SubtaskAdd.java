package jdt.gui;

import javax.swing.ImageIcon;
import jdt.data.Task;
import jdt.manager.SubtaskManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * GUI to add a subtask.
 *
 * @author Luke Leppan
 */
public final class SubtaskAdd extends javax.swing.JFrame {

	private final Task task;
	private final SubtaskManager subtaskManager;
	private final TaskView context;

	/**
	 * Create SubtaskAdd GUI
	 *
	 * @param task Task to add subtask to.
	 * @param context Context to refresh subtask list.
	 */
	public SubtaskAdd(Task task, TaskView context) {
		initComponents();
		this.task = task;
		this.subtaskManager = new SubtaskManager();
		this.context = context;
		this.setTitle("Add a Subtask");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ImageIcon icon = new ImageIcon(getClass().getResource("/jdt/images/logo.png"));
		this.setIconImage(icon.getImage());
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeading = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblHeading.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblHeading.setText("Add a Subtask");

        btnAdd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/add.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTitle, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lblHeading)
                        .addGap(0, 182, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * Adds the new subtask.
	 *
	 * @param evt
	 */
	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
		if (!(subtaskManager.createSubtask(task.getTaskID(), txtTitle.getText()) <= -1)) {
			context.refreshSubtaskList();
			context.repaint();
			JOptionPane.showMessageDialog(this, "Subtask Created.");
		} else {
			JOptionPane.showMessageDialog(this, "Failed to Create Subtask.");
		}

		this.dispose();
	}// GEN-LAST:event_btnAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel lblHeading;
    private javax.swing.JTextField txtTitle;
    // End of variables declaration//GEN-END:variables
}
