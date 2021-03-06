package jdt.gui;

import javax.swing.ImageIcon;
import jdt.data.Project;
import jdt.manager.TaskManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The GUI to add a new task.
 *
 * @author Luke Leppan
 */
public class TaskAdd extends javax.swing.JFrame {

	private final Project project;
	private final ProjectView context;

	/**
	 * Create TaskAdd GUI
	 *
	 * @param project The project to add task to.
	 * @param context The context to refresh.
	 */
	public TaskAdd(Project project, ProjectView context) {
		initComponents();
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.project = project;
		this.context = context;
		ImageIcon icon = new ImageIcon(getClass().getResource("/jdt/images/logo.png"));
		setIconImage(icon.getImage());
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		pnlAddTaskWrapper = new javax.swing.JPanel();
		lblTitle = new javax.swing.JLabel();
		lblTitleText = new javax.swing.JLabel();
		txtTitle = new javax.swing.JTextField();
		lblDescriptionText = new javax.swing.JLabel();
		pnlDescriptionWrapper = new javax.swing.JScrollPane();
		txtaDescription = new javax.swing.JTextArea();
		btnAdd = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		lblTitle.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
		lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		lblTitle.setText("Add a Task");

		lblTitleText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblTitleText.setText("Title");

		lblDescriptionText.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
		lblDescriptionText.setText("Description");

		txtaDescription.setColumns(20);
		txtaDescription.setRows(5);
		pnlDescriptionWrapper.setViewportView(txtaDescription);

		btnAdd.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
		btnAdd.setText("Add");
		btnAdd.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnAddActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout pnlAddTaskWrapperLayout = new javax.swing.GroupLayout(pnlAddTaskWrapper);
		pnlAddTaskWrapper.setLayout(pnlAddTaskWrapperLayout);
		pnlAddTaskWrapperLayout.setHorizontalGroup(pnlAddTaskWrapperLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlAddTaskWrapperLayout.createSequentialGroup()
						.addGroup(pnlAddTaskWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(pnlAddTaskWrapperLayout.createSequentialGroup().addContainerGap().addComponent(lblTitle,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(pnlAddTaskWrapperLayout.createSequentialGroup().addGap(37, 37, 37)
										.addGroup(pnlAddTaskWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
												.addGroup(pnlAddTaskWrapperLayout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
														.addComponent(lblTitleText, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(txtTitle)
														.addComponent(lblDescriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, 96,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(pnlDescriptionWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 323,
																Short.MAX_VALUE))
												.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 132,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGap(0, 30, Short.MAX_VALUE)))
						.addContainerGap()));
		pnlAddTaskWrapperLayout.setVerticalGroup(pnlAddTaskWrapperLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlAddTaskWrapperLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(lblTitleText)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(lblDescriptionText)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(pnlDescriptionWrapper, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(25, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(pnlAddTaskWrapper,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				pnlAddTaskWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.PREFERRED_SIZE));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * Add task
	 *
	 * @param evt
	 */
	private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddActionPerformed
		if (txtTitle.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please Enter the Task Title");
		} else if (txtaDescription.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Please Enter the Task Description");
		} else if (txtTitle.getText().length() > 75) {
			JOptionPane.showMessageDialog(this, "Title is too long");
		} else if (txtaDescription.getText().length() > 500) {
			JOptionPane.showMessageDialog(this, "Desription is too long");
		} else {
			TaskManager taskManager = new TaskManager();
			if (!(taskManager.createTask(this.project.getProjectID(), this.txtTitle.getText(), this.txtaDescription.getText()) <= -1)) {
				context.refreshTaskList();
				context.repaint();
				JOptionPane.showMessageDialog(this, "Task Created.");
			} else {
				JOptionPane.showMessageDialog(this, "Failed to Create Task.");
			}

			this.dispose();
		}
	}// GEN-LAST:event_btnAddActionPerformed

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnAdd;
	private javax.swing.JLabel lblDescriptionText;
	private javax.swing.JLabel lblTitle;
	private javax.swing.JLabel lblTitleText;
	private javax.swing.JPanel pnlAddTaskWrapper;
	private javax.swing.JScrollPane pnlDescriptionWrapper;
	private javax.swing.JTextField txtTitle;
	private javax.swing.JTextArea txtaDescription;
	// End of variables declaration//GEN-END:variables
}
