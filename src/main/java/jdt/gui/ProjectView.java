package jdt.gui;

import jdt.data.Project;
import jdt.data.Task;
import jdt.manager.TaskManager;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class ProjectView extends javax.swing.JFrame {

	private Project project;

	public ProjectView(Project project) {
		initComponents();
		this.setTitle(project.getProjectTitle());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		ImageIcon icon = new ImageIcon(getClass().getResource("/jdt/images/logo.png"));
		this.setIconImage(icon.getImage());

		this.project = project;
		refreshTaskList();

	}

	private void refreshTaskList() {
		pnlScrollWrapper.getVerticalScrollBar().setUnitIncrement(16);

		TaskManager taskManager = new TaskManager();
		List<Task> TODOTasks = taskManager.getProjectTask(project, "TODO");
		List<Task> DoingTasks = taskManager.getProjectTask(project, "Doing");
		List<Task> DoneTasks = taskManager.getProjectTask(project, "Done");

		// TODO List Stuff
		for (int i = 0; i < pnlTODOList.getComponentCount(); i++) {
			if (i > 0) {
				pnlTODOList.remove(i);
			}
		}
		pnlTODOList.invalidate();
		pnlTODOList.validate();
		pnlTODOList.repaint();
		Dimension preferredSizeTODO = new Dimension(242, (70 * TODOTasks.size()) + 50);
		pnlTODOList.setPreferredSize(preferredSizeTODO);
		for (int i = 0; i < TODOTasks.size(); i++) {
			Task task = TODOTasks.get(i);
			TaskTile tile = new TaskTile(task);

			tile.setSize(220, 60);
			tile.setLocation(10, 50 + 70 * i);
			tile.setVisible(true);

			pnlTODOList.add(tile);
		}
		pnlTODOList.invalidate();
		pnlTODOList.validate();
		pnlTODOList.repaint();
		// ----------------------------------------------------------------

		for (int i = 0; i < pnlDoingList.getComponentCount(); i++) {
			if (i > 0) {
				pnlDoingList.remove(i);
			}
		}
		pnlDoingList.invalidate();
		pnlDoingList.validate();
		pnlDoingList.repaint();
		Dimension preferredSizeDoing = new Dimension(242, (70 * DoingTasks.size()) + 50);
		pnlTODOList.setPreferredSize(preferredSizeDoing);

		for (int i = 0; i < pnlDoneList.getComponentCount(); i++) {
			if (i > 0) {
				pnlDoneList.remove(i);
			}
		}
		pnlDoneList.invalidate();
		pnlDoneList.validate();
		pnlDoneList.repaint();

	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlBarWrapper = new javax.swing.JPanel();
        btnAddTask = new javax.swing.JButton();
        btnRefreshTaskList = new javax.swing.JButton();
        pnlScrollWrapper = new javax.swing.JScrollPane();
        pnlProjectViewWrapper = new javax.swing.JPanel();
        pnlTODOList = new javax.swing.JPanel();
        pnlTODOListWrapper = new javax.swing.JPanel();
        lblTODO = new javax.swing.JLabel();
        pnlDoingList = new javax.swing.JPanel();
        pnlDoingListWrapper = new javax.swing.JPanel();
        lblDoing = new javax.swing.JLabel();
        pnlDoneList = new javax.swing.JPanel();
        pnlDoneListWrapper = new javax.swing.JPanel();
        lblDone = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        btnAddTask.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnAddTask.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/add.png"))); // NOI18N
        btnAddTask.setText("Add a Task");
        btnAddTask.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTaskActionPerformed(evt);
            }
        });

        btnRefreshTaskList.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnRefreshTaskList.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/refresh.png"))); // NOI18N
        btnRefreshTaskList.setText("Refresh");
        btnRefreshTaskList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshTaskListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBarWrapperLayout = new javax.swing.GroupLayout(pnlBarWrapper);
        pnlBarWrapper.setLayout(pnlBarWrapperLayout);
        pnlBarWrapperLayout.setHorizontalGroup(
            pnlBarWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRefreshTaskList, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAddTask, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBarWrapperLayout.setVerticalGroup(
            pnlBarWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBarWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBarWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTask, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(btnRefreshTaskList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pnlTODOList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(100, 100, 100), 1, true));

        lblTODO.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTODO.setText("TODO");

        javax.swing.GroupLayout pnlTODOListWrapperLayout = new javax.swing.GroupLayout(pnlTODOListWrapper);
        pnlTODOListWrapper.setLayout(pnlTODOListWrapperLayout);
        pnlTODOListWrapperLayout.setHorizontalGroup(
            pnlTODOListWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTODOListWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTODO, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        pnlTODOListWrapperLayout.setVerticalGroup(
            pnlTODOListWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTODOListWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTODO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlTODOListLayout = new javax.swing.GroupLayout(pnlTODOList);
        pnlTODOList.setLayout(pnlTODOListLayout);
        pnlTODOListLayout.setHorizontalGroup(
            pnlTODOListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTODOListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTODOListWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlTODOListLayout.setVerticalGroup(
            pnlTODOListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTODOListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTODOListWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDoingList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(100, 100, 100), 1, true));

        lblDoing.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDoing.setText("Doing");

        javax.swing.GroupLayout pnlDoingListWrapperLayout = new javax.swing.GroupLayout(pnlDoingListWrapper);
        pnlDoingListWrapper.setLayout(pnlDoingListWrapperLayout);
        pnlDoingListWrapperLayout.setHorizontalGroup(
            pnlDoingListWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoingListWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDoing, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        pnlDoingListWrapperLayout.setVerticalGroup(
            pnlDoingListWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoingListWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDoing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDoingListLayout = new javax.swing.GroupLayout(pnlDoingList);
        pnlDoingList.setLayout(pnlDoingListLayout);
        pnlDoingListLayout.setHorizontalGroup(
            pnlDoingListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoingListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDoingListWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDoingListLayout.setVerticalGroup(
            pnlDoingListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoingListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDoingListWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pnlDoneList.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(100, 100, 100), 1, true));

        lblDone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblDone.setText("Done");

        javax.swing.GroupLayout pnlDoneListWrapperLayout = new javax.swing.GroupLayout(pnlDoneListWrapper);
        pnlDoneListWrapper.setLayout(pnlDoneListWrapperLayout);
        pnlDoneListWrapperLayout.setHorizontalGroup(
            pnlDoneListWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoneListWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDone, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        pnlDoneListWrapperLayout.setVerticalGroup(
            pnlDoneListWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoneListWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblDone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlDoneListLayout = new javax.swing.GroupLayout(pnlDoneList);
        pnlDoneList.setLayout(pnlDoneListLayout);
        pnlDoneListLayout.setHorizontalGroup(
            pnlDoneListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoneListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDoneListWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlDoneListLayout.setVerticalGroup(
            pnlDoneListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDoneListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDoneListWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlProjectViewWrapperLayout = new javax.swing.GroupLayout(pnlProjectViewWrapper);
        pnlProjectViewWrapper.setLayout(pnlProjectViewWrapperLayout);
        pnlProjectViewWrapperLayout.setHorizontalGroup(
            pnlProjectViewWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProjectViewWrapperLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(pnlTODOList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(pnlDoingList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(pnlDoneList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlProjectViewWrapperLayout.setVerticalGroup(
            pnlProjectViewWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProjectViewWrapperLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProjectViewWrapperLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlTODOList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDoingList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDoneList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(441, Short.MAX_VALUE))
        );

        pnlScrollWrapper.setViewportView(pnlProjectViewWrapper);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBarWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlScrollWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBarWrapper, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlScrollWrapper, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddTaskActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTaskActionPerformed
		TaskAdd taskAdd = new TaskAdd(this.project);
		taskAdd.setVisible(true);
    }//GEN-LAST:event_btnAddTaskActionPerformed

    private void btnRefreshTaskListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshTaskListActionPerformed
		refreshTaskList();
    }//GEN-LAST:event_btnRefreshTaskListActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTask;
    private javax.swing.JButton btnRefreshTaskList;
    private javax.swing.JLabel lblDoing;
    private javax.swing.JLabel lblDone;
    private javax.swing.JLabel lblTODO;
    private javax.swing.JPanel pnlBarWrapper;
    private javax.swing.JPanel pnlDoingList;
    private javax.swing.JPanel pnlDoingListWrapper;
    private javax.swing.JPanel pnlDoneList;
    private javax.swing.JPanel pnlDoneListWrapper;
    private javax.swing.JPanel pnlProjectViewWrapper;
    private javax.swing.JScrollPane pnlScrollWrapper;
    private javax.swing.JPanel pnlTODOList;
    private javax.swing.JPanel pnlTODOListWrapper;
    // End of variables declaration//GEN-END:variables

}
