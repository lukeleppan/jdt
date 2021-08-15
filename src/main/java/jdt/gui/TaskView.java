package jdt.gui;

import java.awt.Dimension;
import jdt.data.Subtask;
import jdt.data.Task;
import jdt.manager.SubtaskManager;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import jdt.manager.TaskManager;

/**
 *
 *
 * @author Luke Leppan
 */
public final class TaskView extends javax.swing.JFrame {

	private final Task task;
	private final ProjectView context;
	private final TaskManager taskManager;
	private final SubtaskManager subtaskManager;
	private List<Subtask> subtasks;

	public TaskView(Task task, ProjectView context) {
		initComponents();
		String title = task.getTaskTitle().length() > 30 ? task.getTaskTitle().substring(0, 30) + "..."
				: task.getTaskTitle();
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

		this.task = task;
		this.context = context;
		this.taskManager = new TaskManager();
		this.subtaskManager = new SubtaskManager();
		txtTitle.setText(task.getTaskTitle());
		txtaDescription.setText(task.getTaskDescription());
		switch (task.getTaskState()) {
			case "TODO":
				btnToggleTODO.setSelected(true);
				break;
			case "Doing":
				btnToggleDoing.setSelected(true);
				break;
			case "Done":
				btnToggleDone.setSelected(true);
				break;
		}

		ImageIcon icon = new ImageIcon(getClass().getResource("/jdt/images/logo.png"));
		setIconImage(icon.getImage());

		this.pnlLeftPaneScroll.getVerticalScrollBar().setUnitIncrement(16);

		this.tblSubtaskList.getModel().addTableModelListener((TableModelEvent e) -> {
			tableUpdate(e);
		});

		this.refreshSubtaskList();
		this.repaint();
	}

	public void refreshSubtaskList() {
		this.subtasks = subtaskManager.getTaskSubtasks(task);

		DefaultTableModel tableModel = (DefaultTableModel) tblSubtaskList.getModel();
		tableModel.setRowCount(0);
		for (int i = 0; i < subtasks.size(); i++) {
			Object[] rowData = new Object[2];
			rowData[0] = subtasks.get(i).getSubtaskTitle();
			rowData[1] = subtasks.get(i).isSubtaskCompleted();
			tableModel.addRow(rowData);
		}
		tblSubtaskList.setModel(tableModel);

		DefaultTableColumnModel tableColumnModel = (DefaultTableColumnModel) tblSubtaskList.getColumnModel();
		tableColumnModel.getColumn(0).setPreferredWidth(275);
		tableColumnModel.getColumn(1).setPreferredWidth(25);
		tblSubtaskList.setColumnModel(tableColumnModel);
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngState = new javax.swing.ButtonGroup();
        pnlLeftPaneScroll = new javax.swing.JScrollPane();
        pnlLeftPane = new javax.swing.JPanel();
        pnlTaskDetailPane = new javax.swing.JPanel();
        txtTitle = new javax.swing.JTextField();
        pnlScrollWrapper = new javax.swing.JScrollPane();
        txtaDescription = new javax.swing.JTextArea();
        pnlSubtaskList = new javax.swing.JPanel();
        pnlHeaderSubtaskList = new javax.swing.JPanel();
        lblSubtaskTitle = new javax.swing.JLabel();
        btnAddSubtask = new javax.swing.JButton();
        tblSubtaskList = new javax.swing.JTable();
        pnlRightPane = new javax.swing.JPanel();
        btnToggleTODO = new javax.swing.JRadioButton();
        btnToggleDoing = new javax.swing.JRadioButton();
        btnToggleDone = new javax.swing.JRadioButton();
        pnlBottomPane = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

        txtaDescription.setColumns(20);
        txtaDescription.setRows(5);
        pnlScrollWrapper.setViewportView(txtaDescription);

        javax.swing.GroupLayout pnlTaskDetailPaneLayout = new javax.swing.GroupLayout(pnlTaskDetailPane);
        pnlTaskDetailPane.setLayout(pnlTaskDetailPaneLayout);
        pnlTaskDetailPaneLayout.setHorizontalGroup(
            pnlTaskDetailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaskDetailPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTaskDetailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtTitle)
                    .addComponent(pnlScrollWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlTaskDetailPaneLayout.setVerticalGroup(
            pnlTaskDetailPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTaskDetailPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlScrollWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlSubtaskList.setPreferredSize(new java.awt.Dimension(366, 201));

        lblSubtaskTitle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblSubtaskTitle.setText("Subtasks");

        btnAddSubtask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/add.png"))); // NOI18N
        btnAddSubtask.setText("Add a Subtask");
        btnAddSubtask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSubtaskActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlHeaderSubtaskListLayout = new javax.swing.GroupLayout(pnlHeaderSubtaskList);
        pnlHeaderSubtaskList.setLayout(pnlHeaderSubtaskListLayout);
        pnlHeaderSubtaskListLayout.setHorizontalGroup(
            pnlHeaderSubtaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderSubtaskListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSubtaskTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddSubtask)
                .addContainerGap())
        );
        pnlHeaderSubtaskListLayout.setVerticalGroup(
            pnlHeaderSubtaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeaderSubtaskListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlHeaderSubtaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubtaskTitle)
                    .addComponent(btnAddSubtask))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblSubtaskList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subtask", "Done?"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });

        javax.swing.GroupLayout pnlSubtaskListLayout = new javax.swing.GroupLayout(pnlSubtaskList);
        pnlSubtaskList.setLayout(pnlSubtaskListLayout);
        pnlSubtaskListLayout.setHorizontalGroup(
            pnlSubtaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubtaskListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSubtaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlHeaderSubtaskList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlSubtaskListLayout.createSequentialGroup()
                        .addComponent(tblSubtaskList, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))))
        );
        pnlSubtaskListLayout.setVerticalGroup(
            pnlSubtaskListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSubtaskListLayout.createSequentialGroup()
                .addComponent(pnlHeaderSubtaskList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblSubtaskList, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlLeftPaneLayout = new javax.swing.GroupLayout(pnlLeftPane);
        pnlLeftPane.setLayout(pnlLeftPaneLayout);
        pnlLeftPaneLayout.setHorizontalGroup(
            pnlLeftPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftPaneLayout.createSequentialGroup()
                .addGroup(pnlLeftPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlSubtaskList, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTaskDetailPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLeftPaneLayout.setVerticalGroup(
            pnlLeftPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLeftPaneLayout.createSequentialGroup()
                .addComponent(pnlTaskDetailPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlSubtaskList, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                .addContainerGap(255, Short.MAX_VALUE))
        );

        pnlLeftPaneScroll.setViewportView(pnlLeftPane);

        btngState.add(btnToggleTODO);
        btnToggleTODO.setText("TODO");

        btngState.add(btnToggleDoing);
        btnToggleDoing.setText("Doing");

        btngState.add(btnToggleDone);
        btnToggleDone.setText("Done");

        javax.swing.GroupLayout pnlRightPaneLayout = new javax.swing.GroupLayout(pnlRightPane);
        pnlRightPane.setLayout(pnlRightPaneLayout);
        pnlRightPaneLayout.setHorizontalGroup(
            pnlRightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlRightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlRightPaneLayout.createSequentialGroup()
                        .addComponent(btnToggleTODO, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlRightPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlRightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnToggleDoing, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnToggleDone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        pnlRightPaneLayout.setVerticalGroup(
            pnlRightPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRightPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnToggleTODO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnToggleDoing)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnToggleDone)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlBottomPane.setBorder(javax.swing.BorderFactory.createLineBorder(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow")));

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBottomPaneLayout = new javax.swing.GroupLayout(pnlBottomPane);
        pnlBottomPane.setLayout(pnlBottomPaneLayout);
        pnlBottomPaneLayout.setHorizontalGroup(
            pnlBottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBottomPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSave)
                .addContainerGap())
        );
        pnlBottomPaneLayout.setVerticalGroup(
            pnlBottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBottomPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(btnClose)
                    .addComponent(btnDelete))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBottomPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlLeftPaneScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRightPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlLeftPaneScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(pnlRightPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBottomPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
		this.dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
		String taskState = (btnToggleTODO.isSelected() ? "TODO"
				: btnToggleDoing.isSelected() ? "Doing"
				: "Done");

		Task updatedTask = new Task(
				this.task.getTaskID(),
				this.task.getProjectID(),
				txtTitle.getText(),
				txtaDescription.getText(),
				taskState
		);

		if (!(taskManager.updateTask(updatedTask) <= -1)) {
			context.refreshTaskList();
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Failed to Update. Restart program.");
		}
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
		if (!(taskManager.deleteTask(task) <= -1)) {
			context.refreshTaskList();
			context.repaint();
			JOptionPane.showMessageDialog(this, "Task Deleted");

			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Task Failed to Delete");
		}
    }//GEN-LAST:event_btnDeleteActionPerformed

	private void tableUpdate(TableModelEvent e) {
		if (e.getType() == TableModelEvent.UPDATE) {
			DefaultTableModel model = (DefaultTableModel) tblSubtaskList.getModel();
			Subtask oldSubtask = subtasks.get(e.getLastRow());
			Subtask updatedSubtask = new Subtask(
					oldSubtask.getSubtaskID(),
					oldSubtask.getTaskID(),
					oldSubtask.getSubtaskTitle(),
					(boolean) model.getValueAt(e.getLastRow(), 1)
			);
			if (subtaskManager.updateSubtask(updatedSubtask) <= -1) {
				JOptionPane.showMessageDialog(this, "Failed to Update. Restart program.");
			}
		}
	}

	private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_txtTitleActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_txtTitleActionPerformed

	private void btnAddSubtaskActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton1ActionPerformed
		SubtaskAdd addSubtask = new SubtaskAdd(task, this);
		addSubtask.setVisible(true);
	}// GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSubtask;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnSave;
    private javax.swing.JRadioButton btnToggleDoing;
    private javax.swing.JRadioButton btnToggleDone;
    private javax.swing.JRadioButton btnToggleTODO;
    private javax.swing.ButtonGroup btngState;
    private javax.swing.JLabel lblSubtaskTitle;
    private javax.swing.JPanel pnlBottomPane;
    private javax.swing.JPanel pnlHeaderSubtaskList;
    private javax.swing.JPanel pnlLeftPane;
    private javax.swing.JScrollPane pnlLeftPaneScroll;
    private javax.swing.JPanel pnlRightPane;
    private javax.swing.JScrollPane pnlScrollWrapper;
    private javax.swing.JPanel pnlSubtaskList;
    private javax.swing.JPanel pnlTaskDetailPane;
    private javax.swing.JTable tblSubtaskList;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextArea txtaDescription;
    // End of variables declaration//GEN-END:variables
}
