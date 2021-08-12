package jdt.gui;

import jdt.data.Task;

public class TaskTile extends javax.swing.JPanel {

	private Task task;

	public TaskTile(Task task) {
		initComponents();
		this.txtaTitle.setText(task.getTaskTitle());
		this.task = task;
	}

	private void openTask() {
		TaskView taskView = new TaskView(this.task);
		taskView.setVisible(true);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		txtaTitle = new javax.swing.JTextArea();

		setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				formMouseClicked(evt);
			}
		});

		txtaTitle.setEditable(false);
		txtaTitle.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.background"));
		txtaTitle.setColumns(20);
		txtaTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
		txtaTitle.setLineWrap(true);
		txtaTitle.setRows(5);
		txtaTitle.setWrapStyleWord(true);
		txtaTitle.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				txtaTitleMouseClicked(evt);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
						.addComponent(txtaTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE).addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				layout.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtaTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));
	}// </editor-fold>//GEN-END:initComponents

	private void formMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_formMouseClicked
		this.openTask();
	}// GEN-LAST:event_formMouseClicked

	private void txtaTitleMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_txtaTitleMouseClicked
		this.openTask();
	}// GEN-LAST:event_txtaTitleMouseClicked

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JTextArea txtaTitle;
	// End of variables declaration//GEN-END:variables
}
