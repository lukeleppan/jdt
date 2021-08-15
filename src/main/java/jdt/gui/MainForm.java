package jdt.gui;

import jdt.data.Project;
import jdt.data.User;
import jdt.data.UserCreds;
import jdt.manager.ProjectManager;
import jdt.manager.UserManager;
import jdt.manager.Validator;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.DarculaTheme;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.ImageIcon;

/**
 * Main GUI form of the application.
 *
 * @author Luke Leppan
 */
public final class MainForm extends javax.swing.JFrame {

	private final CardLayout cardLayoutMain;
	private final CardLayout cardLayoutPV;

	private User currentUser;
	private String currentUsername;

	/**
	 * Create the form.
	 */
	public MainForm() {
		initComponents();

		this.setLocationRelativeTo(null); // Set to Center

		ImageIcon icon = new ImageIcon(getClass().getResource("/jdt/images/logo.png"));
		setIconImage(icon.getImage());

		cardLayoutMain = (CardLayout) (pnlMain.getLayout()); // Get Main card layout
		cardLayoutPV = (CardLayout) (pnlCardPV.getLayout());  // Get PV card layout
	}

	/**
	 * Loads Project Components for Project View
	 */
	public void refreshProjectView() {
		pnlProjectListMain.removeAll();
		pnlProjectListMain.invalidate();
		pnlProjectListMain.validate();
		pnlProjectListMain.repaint();
		ProjectManager projectManager = new ProjectManager();
		List<Project> projects = projectManager.getUserProjects(currentUser);
		Dimension preferredSize = new Dimension(818, 210 * projects.size() + 10);
		pnlProjectListMain.setPreferredSize(preferredSize);
		pnlProjectListScroll.getVerticalScrollBar().setUnitIncrement(16);
		pnlProjectListScroll.getVerticalScrollBar().setAutoscrolls(false);

		for (int i = 0; i < projects.size(); i++) {
			Project project = projects.get(i);
			ProjectTile projectTile = new ProjectTile(project, this);

			projectTile.setSize(395, 202);
			projectTile.setLocation(140, 206 * i + 5);
			projectTile.setVisible(true);

			pnlProjectListMain.add(projectTile);
		}

		pnlProjectListMain.invalidate();
		pnlProjectListMain.validate();
		pnlProjectListMain.repaint();
	}

	/**
	 * Sets the current users details
	 */
	private void setAccountDetails() {
		lblAccountName.setText(currentUser.getUserFirstName() + " " + currentUser.getUserSurname());
		lblAccountUsername.setText(currentUsername);
	}

	/**
	 * Calculates the password strength
	 *
	 * @param password The password entered
	 * @return the strength
	 */
	private int calcPassScore(String password) {
		int score = 0;

		//Calc Score
		Pattern upperRegex = Pattern.compile("[A-Z]");
		Pattern lowerRegex = Pattern.compile("[a-z]");
		Pattern numberRegex = Pattern.compile("[0-9]");
		Pattern specialRegex = Pattern.compile(".[!,@,#,$,%,^,&,*,?,_,~,-,£,(,)]");
		int minLength = 8;

		Matcher matcher1 = upperRegex.matcher(password);
		if (matcher1.find()) {
			score++;
		}

		Matcher matcher2 = lowerRegex.matcher(password);
		if (matcher2.find()) {
			score++;
		}

		Matcher matcher3 = numberRegex.matcher(password);
		if (matcher3.find()) {
			score++;
		}

		Matcher matcher4 = specialRegex.matcher(password);
		if (matcher4.find()) {
			score++;
		}

		if (score < 3) {
			score--;
		}

		if (password.length() > minLength) {
			score += Math.floor((password.length() - minLength) / 2);
		}

		if (password.length() < minLength) {
			score = 0;
		}

		return score;
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlInitial = new javax.swing.JPanel();
        pnlInitialContainer = new javax.swing.JPanel();
        pnlTitleContainer = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblSubtitle = new javax.swing.JLabel();
        pnlButtonContainer = new javax.swing.JPanel();
        btnSignUp = new javax.swing.JButton();
        btnSignIn = new javax.swing.JButton();
        btnInitialHelp = new javax.swing.JButton();
        pnlSignIn = new javax.swing.JPanel();
        pnlSignInContainer = new javax.swing.JPanel();
        lblUsernameSignIn = new javax.swing.JLabel();
        txtUsernameSignIn = new javax.swing.JTextField();
        lblPasswordSignIn = new javax.swing.JLabel();
        btnSignInSignIn = new javax.swing.JButton();
        txtPasswordSignIn = new javax.swing.JPasswordField();
        lblErrorText = new javax.swing.JLabel();
        btnSignUpInsteadSignIn = new javax.swing.JButton();
        btnSignInHelp = new javax.swing.JButton();
        pnlSignUp = new javax.swing.JPanel();
        pnlSignUpContainer = new javax.swing.JPanel();
        lblFirstNameSignUp = new javax.swing.JLabel();
        txtFirstNameSignUp = new javax.swing.JTextField();
        lblSurnameSignUp = new javax.swing.JLabel();
        txtSurnameSignUp = new javax.swing.JTextField();
        lblUsernameSignUp = new javax.swing.JLabel();
        txtUsernameSignUp = new javax.swing.JTextField();
        lblEmailSignUp = new javax.swing.JLabel();
        txtEmailSignUp = new javax.swing.JTextField();
        lblDOBSignUP = new javax.swing.JLabel();
        lblPasswordSignUp = new javax.swing.JLabel();
        txtPasswordSignUp = new javax.swing.JPasswordField();
        lblPasswordStrengthSignUp = new javax.swing.JLabel();
        pbarPasswordStrengthSignUp = new javax.swing.JProgressBar();
        lblConfirmPasswordSignUp = new javax.swing.JLabel();
        txtConfirmPasswordSignUp = new javax.swing.JPasswordField();
        lblErrorSignUp = new javax.swing.JLabel();
        btnSignUpInsteadSignUp = new javax.swing.JButton();
        btnSignUpSignUp = new javax.swing.JButton();
        dcDOBSignUp = new com.toedter.calendar.JDateChooser();
        btnSignupHelp = new javax.swing.JButton();
        pnlProjectList = new javax.swing.JPanel();
        pnlMainSplit = new javax.swing.JSplitPane();
        pnlSidePane = new javax.swing.JPanel();
        pnlAccount = new javax.swing.JPanel();
        lblAccountName = new javax.swing.JLabel();
        lblAccountUsername = new javax.swing.JLabel();
        btnAccountSettings = new javax.swing.JButton();
        lblAccountIcon = new javax.swing.JLabel();
        btnMainViewHelp = new javax.swing.JButton();
        pnlCardPV = new javax.swing.JPanel();
        pnlProjectListCard = new javax.swing.JPanel();
        pnlProjectListToolBar = new javax.swing.JPanel();
        btnNewProjectToolbar = new javax.swing.JButton();
        btnRefreshToolBar = new javax.swing.JButton();
        pnlProjectListScroll = new javax.swing.JScrollPane();
        pnlProjectListMain = new javax.swing.JPanel();
        pnlNewProjectView = new javax.swing.JPanel();
        pnlNewProjectDetails = new javax.swing.JPanel();
        lblNewProjectTitle = new javax.swing.JLabel();
        txtNewProjectTitle = new javax.swing.JTextField();
        lblNewProjectDescription = new javax.swing.JLabel();
        txtaNewProjectDescriptionScroll = new javax.swing.JScrollPane();
        txtaNewProjectDesriptionMain = new javax.swing.JTextArea();
        btnNewProjectCreate = new javax.swing.JButton();
        lblErrorTextNewProject = new javax.swing.JLabel();
        pnlNewProjectViewToolBar = new javax.swing.JPanel();
        btnNewProjectViewBack = new javax.swing.JButton();
        sepNewProjectView = new javax.swing.JSeparator();
        pnlAccountSettings = new javax.swing.JPanel();
        pnlAccountSettingToolBar = new javax.swing.JPanel();
        btnAccountSettingsBack = new javax.swing.JToggleButton();
        lblAccountSettings = new javax.swing.JLabel();
        sepAccountSetttings = new javax.swing.JSeparator();
        pnlAccountSettingsMain = new javax.swing.JPanel();
        btnDeleteAccount = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Just Do It");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        pnlMain.setLayout(new java.awt.CardLayout());

        lblTitle.setFont(new java.awt.Font("Fredoka One", 1, 36)); // NOI18N
        lblTitle.setText("Just Do It");

        lblSubtitle.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lblSubtitle.setText("Project Manager");

        javax.swing.GroupLayout pnlTitleContainerLayout = new javax.swing.GroupLayout(pnlTitleContainer);
        pnlTitleContainer.setLayout(pnlTitleContainerLayout);
        pnlTitleContainerLayout.setHorizontalGroup(
            pnlTitleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleContainerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTitleContainerLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(lblSubtitle)
                .addGap(47, 47, 47))
        );
        pnlTitleContainerLayout.setVerticalGroup(
            pnlTitleContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTitleContainerLayout.createSequentialGroup()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSubtitle)
                .addContainerGap())
        );

        btnSignUp.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/add_user.png"))); // NOI18N
        btnSignUp.setText("Sign up");
        btnSignUp.setToolTipText("Click To Sign up");
        btnSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpActionPerformed(evt);
            }
        });

        btnSignIn.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/login.png"))); // NOI18N
        btnSignIn.setText("Sign in");
        btnSignIn.setToolTipText("Click To Sign in");
        btnSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlButtonContainerLayout = new javax.swing.GroupLayout(pnlButtonContainer);
        pnlButtonContainer.setLayout(pnlButtonContainerLayout);
        pnlButtonContainerLayout.setHorizontalGroup(
            pnlButtonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonContainerLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(pnlButtonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                    .addComponent(btnSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(73, 73, 73))
        );
        pnlButtonContainerLayout.setVerticalGroup(
            pnlButtonContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlButtonContainerLayout.createSequentialGroup()
                .addComponent(btnSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlInitialContainerLayout = new javax.swing.GroupLayout(pnlInitialContainer);
        pnlInitialContainer.setLayout(pnlInitialContainerLayout);
        pnlInitialContainerLayout.setHorizontalGroup(
            pnlInitialContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInitialContainerLayout.createSequentialGroup()
                .addGroup(pnlInitialContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInitialContainerLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(pnlTitleContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInitialContainerLayout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(pnlButtonContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        pnlInitialContainerLayout.setVerticalGroup(
            pnlInitialContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInitialContainerLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pnlTitleContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlButtonContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        btnInitialHelp.setText("Help");
        btnInitialHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInitialHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlInitialLayout = new javax.swing.GroupLayout(pnlInitial);
        pnlInitial.setLayout(pnlInitialLayout);
        pnlInitialLayout.setHorizontalGroup(
            pnlInitialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInitialLayout.createSequentialGroup()
                .addGroup(pnlInitialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInitialLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(pnlInitialContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlInitialLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnInitialHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(238, Short.MAX_VALUE))
        );
        pnlInitialLayout.setVerticalGroup(
            pnlInitialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInitialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInitialHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(pnlInitialContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );

        pnlMain.add(pnlInitial, "InitialPanel");

        pnlSignInContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sign In", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 20))); // NOI18N

        lblUsernameSignIn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblUsernameSignIn.setText("Username");

        txtUsernameSignIn.setToolTipText("Enter your Username");

        lblPasswordSignIn.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblPasswordSignIn.setText("Password");

        btnSignInSignIn.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnSignInSignIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/login.png"))); // NOI18N
        btnSignInSignIn.setText("Sign in");
        btnSignInSignIn.setToolTipText("Click To Sign in");
        btnSignInSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInSignInActionPerformed(evt);
            }
        });

        txtPasswordSignIn.setToolTipText("Enter Password");

        lblErrorText.setForeground(new java.awt.Color(255, 0, 51));

        btnSignUpInsteadSignIn.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnSignUpInsteadSignIn.setText("Sign Up Instead");
        btnSignUpInsteadSignIn.setToolTipText("Click to Sign Up");
        btnSignUpInsteadSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpInsteadSignInActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSignInContainerLayout = new javax.swing.GroupLayout(pnlSignInContainer);
        pnlSignInContainer.setLayout(pnlSignInContainerLayout);
        pnlSignInContainerLayout.setHorizontalGroup(
            pnlSignInContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSignInContainerLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lblErrorText, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSignInContainerLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlSignInContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtPasswordSignIn)
                    .addComponent(txtUsernameSignIn)
                    .addGroup(pnlSignInContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlSignInContainerLayout.createSequentialGroup()
                            .addComponent(btnSignUpInsteadSignIn)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnSignInSignIn))
                        .addComponent(lblPasswordSignIn, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblUsernameSignIn, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(39, 39, 39))
        );
        pnlSignInContainerLayout.setVerticalGroup(
            pnlSignInContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSignInContainerLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblUsernameSignIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUsernameSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPasswordSignIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPasswordSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSignInContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSignInSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSignUpInsteadSignIn, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(266, 266, 266)
                .addComponent(lblErrorText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSignInHelp.setText("Help");
        btnSignInHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignInHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSignInLayout = new javax.swing.GroupLayout(pnlSignIn);
        pnlSignIn.setLayout(pnlSignInLayout);
        pnlSignInLayout.setHorizontalGroup(
            pnlSignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSignInLayout.createSequentialGroup()
                .addContainerGap(243, Short.MAX_VALUE)
                .addComponent(pnlSignInContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(230, 230, 230))
            .addGroup(pnlSignInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSignInHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSignInLayout.setVerticalGroup(
            pnlSignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSignInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSignInHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(pnlSignInContainer, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(212, Short.MAX_VALUE))
        );

        pnlMain.add(pnlSignIn, "LoginPanel");

        pnlSignUpContainer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sign Up", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 20))); // NOI18N
        pnlSignUpContainer.setNextFocusableComponent(txtUsernameSignUp);

        lblFirstNameSignUp.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblFirstNameSignUp.setLabelFor(txtFirstNameSignUp);
        lblFirstNameSignUp.setText("First Name");

        txtFirstNameSignUp.setToolTipText("Enter First Name");
        txtFirstNameSignUp.setNextFocusableComponent(txtSurnameSignUp);

        lblSurnameSignUp.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblSurnameSignUp.setLabelFor(txtSurnameSignUp);
        lblSurnameSignUp.setText("Surname");

        txtSurnameSignUp.setToolTipText("Enter Surname");
        txtSurnameSignUp.setNextFocusableComponent(txtUsernameSignUp);

        lblUsernameSignUp.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblUsernameSignUp.setLabelFor(txtUsernameSignIn);
        lblUsernameSignUp.setText("Username");

        txtUsernameSignUp.setToolTipText("Enter Username");
        txtUsernameSignUp.setNextFocusableComponent(txtEmailSignUp);

        lblEmailSignUp.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblEmailSignUp.setLabelFor(txtEmailSignUp);
        lblEmailSignUp.setText("Email");

        txtEmailSignUp.setToolTipText("Enter Email");

        lblDOBSignUP.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblDOBSignUP.setText("Date Of Birth");

        lblPasswordSignUp.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblPasswordSignUp.setLabelFor(txtPasswordSignUp);
        lblPasswordSignUp.setText("Password");

        txtPasswordSignUp.setToolTipText("Enter Password");
        txtPasswordSignUp.setNextFocusableComponent(txtConfirmPasswordSignUp);
        txtPasswordSignUp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPasswordSignUpKeyTyped(evt);
            }
        });

        lblPasswordStrengthSignUp.setLabelFor(pbarPasswordStrengthSignUp);
        lblPasswordStrengthSignUp.setText("Password Strength");

        lblConfirmPasswordSignUp.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblConfirmPasswordSignUp.setLabelFor(txtConfirmPasswordSignUp);
        lblConfirmPasswordSignUp.setText("Confirm Password");

        txtConfirmPasswordSignUp.setToolTipText("Renter Password");
        txtConfirmPasswordSignUp.setNextFocusableComponent(btnSignUpSignUp);
        txtConfirmPasswordSignUp.setOpaque(false);

        lblErrorSignUp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblErrorSignUp.setForeground(new java.awt.Color(255, 0, 51));
        lblErrorSignUp.setAutoscrolls(true);
        lblErrorSignUp.setFocusable(false);

        btnSignUpInsteadSignUp.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnSignUpInsteadSignUp.setText("Sign In Instead");
        btnSignUpInsteadSignUp.setToolTipText("Click to switch to Login");
        btnSignUpInsteadSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpInsteadSignUpActionPerformed(evt);
            }
        });

        btnSignUpSignUp.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        btnSignUpSignUp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/add_user.png"))); // NOI18N
        btnSignUpSignUp.setText("Sign up");
        btnSignUpSignUp.setToolTipText("Click To Sign up");
        btnSignUpSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignUpSignUpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSignUpContainerLayout = new javax.swing.GroupLayout(pnlSignUpContainer);
        pnlSignUpContainer.setLayout(pnlSignUpContainerLayout);
        pnlSignUpContainerLayout.setHorizontalGroup(
            pnlSignUpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSignUpContainerLayout.createSequentialGroup()
                .addGroup(pnlSignUpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSignUpContainerLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(btnSignUpInsteadSignUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSignUpSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSignUpContainerLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(pnlSignUpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErrorSignUp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(pnlSignUpContainerLayout.createSequentialGroup()
                                .addGroup(pnlSignUpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblEmailSignUp)
                                    .addComponent(lblUsernameSignUp)
                                    .addComponent(lblSurnameSignUp)
                                    .addComponent(lblFirstNameSignUp)
                                    .addComponent(txtUsernameSignUp)
                                    .addComponent(txtSurnameSignUp)
                                    .addComponent(txtFirstNameSignUp)
                                    .addComponent(txtEmailSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(pnlSignUpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblConfirmPasswordSignUp)
                                    .addComponent(lblPasswordSignUp)
                                    .addComponent(lblDOBSignUP)
                                    .addComponent(txtPasswordSignUp)
                                    .addComponent(txtConfirmPasswordSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(pbarPasswordStrengthSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
                                    .addComponent(lblPasswordStrengthSignUp)
                                    .addComponent(dcDOBSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        pnlSignUpContainerLayout.setVerticalGroup(
            pnlSignUpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSignUpContainerLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(pnlSignUpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSignUpContainerLayout.createSequentialGroup()
                        .addComponent(lblFirstNameSignUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFirstNameSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSurnameSignUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSurnameSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblUsernameSignUp))
                    .addGroup(pnlSignUpContainerLayout.createSequentialGroup()
                        .addComponent(lblDOBSignUP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcDOBSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblPasswordSignUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPasswordSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPasswordStrengthSignUp)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlSignUpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlSignUpContainerLayout.createSequentialGroup()
                        .addComponent(txtUsernameSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lblEmailSignUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmailSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSignUpContainerLayout.createSequentialGroup()
                        .addComponent(pbarPasswordStrengthSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblConfirmPasswordSignUp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtConfirmPasswordSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lblErrorSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlSignUpContainerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSignUpInsteadSignUp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSignUpSignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        btnSignupHelp.setText("Help");
        btnSignupHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignupHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSignUpLayout = new javax.swing.GroupLayout(pnlSignUp);
        pnlSignUp.setLayout(pnlSignUpLayout);
        pnlSignUpLayout.setHorizontalGroup(
            pnlSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSignUpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSignupHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(pnlSignUpContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        pnlSignUpLayout.setVerticalGroup(
            pnlSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSignUpLayout.createSequentialGroup()
                .addGroup(pnlSignUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSignUpLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(pnlSignUpContainer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlSignUpLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSignupHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        pnlMain.add(pnlSignUp, "RegisterPanel");

        pnlMainSplit.setDividerSize(2);

        pnlSidePane.setEnabled(false);
        pnlSidePane.setPreferredSize(new java.awt.Dimension(200, 0));

        lblAccountName.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblAccountName.setText("John Doe");
        lblAccountName.setMaximumSize(new java.awt.Dimension(73, 15));
        lblAccountName.setMinimumSize(new java.awt.Dimension(73, 15));
        lblAccountName.setPreferredSize(new java.awt.Dimension(73, 15));

        lblAccountUsername.setText("johndoe");

        btnAccountSettings.setText("Account Settings");
        btnAccountSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountSettingsActionPerformed(evt);
            }
        });

        lblAccountIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/account.png"))); // NOI18N

        javax.swing.GroupLayout pnlAccountLayout = new javax.swing.GroupLayout(pnlAccount);
        pnlAccount.setLayout(pnlAccountLayout);
        pnlAccountLayout.setHorizontalGroup(
            pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountLayout.createSequentialGroup()
                .addComponent(lblAccountIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAccountName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblAccountUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(pnlAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAccountSettings)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlAccountLayout.setVerticalGroup(
            pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlAccountLayout.createSequentialGroup()
                        .addComponent(lblAccountName, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAccountUsername))
                    .addComponent(lblAccountIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAccountSettings)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnMainViewHelp.setText("Help");
        btnMainViewHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainViewHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSidePaneLayout = new javax.swing.GroupLayout(pnlSidePane);
        pnlSidePane.setLayout(pnlSidePaneLayout);
        pnlSidePaneLayout.setHorizontalGroup(
            pnlSidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlSidePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMainViewHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSidePaneLayout.setVerticalGroup(
            pnlSidePaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSidePaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMainViewHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 478, Short.MAX_VALUE)
                .addComponent(pnlAccount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlMainSplit.setLeftComponent(pnlSidePane);

        pnlCardPV.setPreferredSize(new java.awt.Dimension(670, 578));
        pnlCardPV.setLayout(new java.awt.CardLayout());

        pnlProjectListCard.setPreferredSize(new java.awt.Dimension(620, 578));

        btnNewProjectToolbar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/add.png"))); // NOI18N
        btnNewProjectToolbar.setText("New Project");
        btnNewProjectToolbar.setToolTipText("Click to create new project");
        btnNewProjectToolbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProjectToolbarActionPerformed(evt);
            }
        });

        btnRefreshToolBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/refresh.png"))); // NOI18N
        btnRefreshToolBar.setText("Refresh");
        btnRefreshToolBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshToolBarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlProjectListToolBarLayout = new javax.swing.GroupLayout(pnlProjectListToolBar);
        pnlProjectListToolBar.setLayout(pnlProjectListToolBarLayout);
        pnlProjectListToolBarLayout.setHorizontalGroup(
            pnlProjectListToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProjectListToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewProjectToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefreshToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlProjectListToolBarLayout.setVerticalGroup(
            pnlProjectListToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProjectListToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProjectListToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNewProjectToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRefreshToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pnlProjectListScroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        pnlProjectListScroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        javax.swing.GroupLayout pnlProjectListMainLayout = new javax.swing.GroupLayout(pnlProjectListMain);
        pnlProjectListMain.setLayout(pnlProjectListMainLayout);
        pnlProjectListMainLayout.setHorizontalGroup(
            pnlProjectListMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );
        pnlProjectListMainLayout.setVerticalGroup(
            pnlProjectListMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        pnlProjectListScroll.setViewportView(pnlProjectListMain);

        javax.swing.GroupLayout pnlProjectListCardLayout = new javax.swing.GroupLayout(pnlProjectListCard);
        pnlProjectListCard.setLayout(pnlProjectListCardLayout);
        pnlProjectListCardLayout.setHorizontalGroup(
            pnlProjectListCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProjectListCardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlProjectListCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlProjectListScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 663, Short.MAX_VALUE)
                    .addGroup(pnlProjectListCardLayout.createSequentialGroup()
                        .addComponent(pnlProjectListToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        pnlProjectListCardLayout.setVerticalGroup(
            pnlProjectListCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProjectListCardLayout.createSequentialGroup()
                .addComponent(pnlProjectListToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlProjectListScroll))
        );

        pnlCardPV.add(pnlProjectListCard, "ProjectViewPV");

        pnlNewProjectDetails.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Create New Project", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 16))); // NOI18N

        lblNewProjectTitle.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblNewProjectTitle.setText("Project Title");

        lblNewProjectDescription.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblNewProjectDescription.setText("Project Description");

        txtaNewProjectDesriptionMain.setColumns(20);
        txtaNewProjectDesriptionMain.setLineWrap(true);
        txtaNewProjectDesriptionMain.setRows(5);
        txtaNewProjectDescriptionScroll.setViewportView(txtaNewProjectDesriptionMain);

        btnNewProjectCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/add.png"))); // NOI18N
        btnNewProjectCreate.setText("Create");
        btnNewProjectCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProjectCreateActionPerformed(evt);
            }
        });

        lblErrorTextNewProject.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        lblErrorTextNewProject.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout pnlNewProjectDetailsLayout = new javax.swing.GroupLayout(pnlNewProjectDetails);
        pnlNewProjectDetails.setLayout(pnlNewProjectDetailsLayout);
        pnlNewProjectDetailsLayout.setHorizontalGroup(
            pnlNewProjectDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNewProjectDetailsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNewProjectCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(pnlNewProjectDetailsLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlNewProjectDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblNewProjectDescription)
                    .addComponent(lblNewProjectTitle)
                    .addGroup(pnlNewProjectDetailsLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblErrorTextNewProject, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNewProjectTitle)
                    .addComponent(txtaNewProjectDescriptionScroll))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        pnlNewProjectDetailsLayout.setVerticalGroup(
            pnlNewProjectDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewProjectDetailsLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblNewProjectTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewProjectTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblNewProjectDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtaNewProjectDescriptionScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErrorTextNewProject, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(btnNewProjectCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        btnNewProjectViewBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/back_green.png"))); // NOI18N
        btnNewProjectViewBack.setText("Back");
        btnNewProjectViewBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewProjectViewBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNewProjectViewToolBarLayout = new javax.swing.GroupLayout(pnlNewProjectViewToolBar);
        pnlNewProjectViewToolBar.setLayout(pnlNewProjectViewToolBarLayout);
        pnlNewProjectViewToolBarLayout.setHorizontalGroup(
            pnlNewProjectViewToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewProjectViewToolBarLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnNewProjectViewBack)
                .addContainerGap(570, Short.MAX_VALUE))
            .addGroup(pnlNewProjectViewToolBarLayout.createSequentialGroup()
                .addComponent(sepNewProjectView)
                .addContainerGap())
        );
        pnlNewProjectViewToolBarLayout.setVerticalGroup(
            pnlNewProjectViewToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNewProjectViewToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNewProjectViewBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepNewProjectView, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlNewProjectViewLayout = new javax.swing.GroupLayout(pnlNewProjectView);
        pnlNewProjectView.setLayout(pnlNewProjectViewLayout);
        pnlNewProjectViewLayout.setHorizontalGroup(
            pnlNewProjectViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlNewProjectViewToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlNewProjectViewLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(pnlNewProjectDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNewProjectViewLayout.setVerticalGroup(
            pnlNewProjectViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNewProjectViewLayout.createSequentialGroup()
                .addComponent(pnlNewProjectViewToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(pnlNewProjectDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        pnlCardPV.add(pnlNewProjectView, "NewProject");

        btnAccountSettingsBack.setText("Back");
        btnAccountSettingsBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountSettingsBackActionPerformed(evt);
            }
        });

        lblAccountSettings.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        lblAccountSettings.setText("Account Settings");

        javax.swing.GroupLayout pnlAccountSettingToolBarLayout = new javax.swing.GroupLayout(pnlAccountSettingToolBar);
        pnlAccountSettingToolBar.setLayout(pnlAccountSettingToolBarLayout);
        pnlAccountSettingToolBarLayout.setHorizontalGroup(
            pnlAccountSettingToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountSettingToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAccountSettingsBack, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(164, 164, 164)
                .addComponent(lblAccountSettings)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(sepAccountSetttings, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        pnlAccountSettingToolBarLayout.setVerticalGroup(
            pnlAccountSettingToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAccountSettingToolBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAccountSettingToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccountSettingsBack, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(lblAccountSettings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addComponent(sepAccountSetttings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnDeleteAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/delete.png"))); // NOI18N
        btnDeleteAccount.setText("Delete Account");
        btnDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAccountActionPerformed(evt);
            }
        });

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/jdt/images/back.png"))); // NOI18N
        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAccountSettingsMainLayout = new javax.swing.GroupLayout(pnlAccountSettingsMain);
        pnlAccountSettingsMain.setLayout(pnlAccountSettingsMainLayout);
        pnlAccountSettingsMainLayout.setHorizontalGroup(
            pnlAccountSettingsMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAccountSettingsMainLayout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addGroup(pnlAccountSettingsMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeleteAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                .addGap(249, 249, 249))
        );
        pnlAccountSettingsMainLayout.setVerticalGroup(
            pnlAccountSettingsMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAccountSettingsMainLayout.createSequentialGroup()
                .addGap(349, 349, 349)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addGap(64, 64, 64))
        );

        javax.swing.GroupLayout pnlAccountSettingsLayout = new javax.swing.GroupLayout(pnlAccountSettings);
        pnlAccountSettings.setLayout(pnlAccountSettingsLayout);
        pnlAccountSettingsLayout.setHorizontalGroup(
            pnlAccountSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlAccountSettingToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnlAccountSettingsMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlAccountSettingsLayout.setVerticalGroup(
            pnlAccountSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAccountSettingsLayout.createSequentialGroup()
                .addComponent(pnlAccountSettingToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAccountSettingsMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCardPV.add(pnlAccountSettings, "AccountSettings");

        pnlMainSplit.setRightComponent(pnlCardPV);

        javax.swing.GroupLayout pnlProjectListLayout = new javax.swing.GroupLayout(pnlProjectList);
        pnlProjectList.setLayout(pnlProjectListLayout);
        pnlProjectListLayout.setHorizontalGroup(
            pnlProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainSplit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE)
        );
        pnlProjectListLayout.setVerticalGroup(
            pnlProjectListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMainSplit, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pnlMain.add(pnlProjectList, "ProjectList");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpActionPerformed
		cardLayoutMain.show(pnlMain, "RegisterPanel");  // Switch to Register View
    }//GEN-LAST:event_btnSignUpActionPerformed

    private void btnSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInActionPerformed
		cardLayoutMain.show(pnlMain, "LoginPanel");  // Switch to Login View
    }//GEN-LAST:event_btnSignInActionPerformed

	/**
	 * Handles Sign In
	 *
	 * @param evt
	 */
        private void btnSignInSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInSignInActionPerformed

		UserManager userManager = new UserManager();
		if (userManager.loginUser(txtUsernameSignIn.getText(), new String(txtPasswordSignIn.getPassword()))) {
			currentUsername = txtUsernameSignIn.getText();
			currentUser = userManager.getUser(currentUsername);
			cardLayoutMain.show(pnlMain, "ProjectList");
			refreshProjectView();
			setAccountDetails();
			txtUsernameSignIn.setText("");
			txtPasswordSignIn.setText("");
			JOptionPane.showMessageDialog(this,
					"✔ Successful Login"
					+ "\nWelcome " + currentUser.getUserFirstName()
			);
		} else {
			JOptionPane.showMessageDialog(this,
					"❌ Username or Password is Incorrect"
					+ "\nPlease Try Again"
			);
		}
        }//GEN-LAST:event_btnSignInSignInActionPerformed

        private void btnSignUpInsteadSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpInsteadSignInActionPerformed
		cardLayoutMain.show(pnlMain, "RegisterPanel"); //Switch to Register Panel
        }//GEN-LAST:event_btnSignUpInsteadSignInActionPerformed

	/**
	 * Handles SignUp
	 *
	 * @param evt
	 */
        private void btnSignUpSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpSignUpActionPerformed
		lblErrorSignUp.setText("");
		String firstname = txtFirstNameSignUp.getText();
		String surname = txtSurnameSignUp.getText();
		String username = txtUsernameSignUp.getText();
		String email = txtEmailSignUp.getText();
		LocalDate DOB = dcDOBSignUp.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		char[] password = txtPasswordSignUp.getPassword();
		char[] repeatPassword = txtConfirmPasswordSignUp.getPassword();

		char[] tempPassword = txtPasswordSignUp.getPassword();
		String passwordStr = "";

		User user = new User(0, email, DOB, firstname, surname);
		UserCreds userCreds = new UserCreds(0, username, new String(password));

		for (int i = 0; i < tempPassword.length; i++) {
			passwordStr = passwordStr + tempPassword[i];
		}

		int passScore = calcPassScore(passwordStr);

		Validator validator = new Validator(firstname, surname, username, email, DOB, password, repeatPassword, passScore);
		String errorText = "";

		UserManager userManager = new UserManager();

		// Use Validator
		if (!validator.validateFirstname()) {
			errorText = "Please Enter your First Name.";
		} else if (!validator.validateFirstnameLength()) {
			errorText = "First Name is too long. Must be 100 or less characters.";
		} else if (!validator.validateSurname()) {
			errorText = "Please Enter your Surname.";
		} else if (!validator.validateSurnameLength()) {
			errorText = "Surname is too long. Must be 100 or less characters.";
		} else if (!validator.validateUsername()) {
			errorText = "Username does not follow correct format. Check the help for more information.";
		} else if (!validator.validateUsernameLength()) {
			errorText = "Username is too long. Must be 25 or less characters.";
		} else if (!validator.validateEmail()) {
			errorText = "Not a valid Email";
		} else if (!validator.validateEmailLength()) {
			errorText = "Email is too long. Must be 255 or less characters.";
		} else if (!validator.validateDOB()) {
			errorText = "Please Select your date of Birth.";
		} else if (!validator.validateDOBLogic()) {
			errorText = "Date of birth is in the future.";
		} else if (!validator.validatePasswordMatch()) {
			errorText = "Passwords do not match.";
		} else if (!validator.validatePasswordLength()) {
			errorText = "Password is too short. Must be greater than 8 characters.";
		} else if (!validator.validatePasswordStrength()) {
			errorText = "Your password is not strong enough. Try adding numbers or special charaters.";
		} else if (userManager.checkForUser(username)) {
			errorText = "Username is already taken.";
		} else if (userManager.registerUser(user, userCreds)) {
			cardLayoutMain.show(pnlMain, "LoginPanel");
			txtUsernameSignUp.setText("");
			txtFirstNameSignUp.setText("");
			txtSurnameSignUp.setText("");
			txtEmailSignUp.setText("");
			txtPasswordSignUp.setText("");
			txtConfirmPasswordSignUp.setText("");
			JOptionPane.showMessageDialog(this,
					"Successfully Registered ✔"
					+ "\nPlease Login"
			);
		}

		lblErrorSignUp.setText(errorText);

        }//GEN-LAST:event_btnSignUpSignUpActionPerformed

        private void btnSignUpInsteadSignUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignUpInsteadSignUpActionPerformed
		cardLayoutMain.show(pnlMain, "LoginPanel"); // Switch to Login Panel
        }//GEN-LAST:event_btnSignUpInsteadSignUpActionPerformed

  private void txtPasswordSignUpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordSignUpKeyTyped
		char[] tempPassword = txtPasswordSignUp.getPassword();
		String password = "";

		for (int i = 0; i < tempPassword.length; i++) {
			password = password + tempPassword[i];
		}

		password = password + evt.getKeyChar();

		int score = calcPassScore(password);

		if (score == 0) {
			pbarPasswordStrengthSignUp.setValue(5);
		} else if (score < 3) {
			pbarPasswordStrengthSignUp.setValue(20);
		} else if (score < 4) {
			pbarPasswordStrengthSignUp.setValue(50);
		} else if (score < 6) {
			pbarPasswordStrengthSignUp.setValue(70);
		} else {
			pbarPasswordStrengthSignUp.setValue(100);
		}

  }//GEN-LAST:event_txtPasswordSignUpKeyTyped

  private void btnNewProjectToolbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProjectToolbarActionPerformed
		cardLayoutPV.show(pnlCardPV, "NewProject");
  }//GEN-LAST:event_btnNewProjectToolbarActionPerformed

  private void btnNewProjectCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProjectCreateActionPerformed
		ProjectManager projectManager = new ProjectManager();

		if (txtNewProjectTitle.getText().equals("")) {
			lblErrorTextNewProject.setText("Please Enter the Project Title");
		} else if (lblNewProjectDescription.getText().equals("")) {
			lblErrorTextNewProject.setText("Please Enter the Project Description");
		} else if (txtNewProjectTitle.getText().length() > 100) {
			lblErrorTextNewProject.setText("Title is too long");
		} else if (lblNewProjectDescription.getText().length() > 300) {
			lblErrorTextNewProject.setText("Desription is too long");
		} else if (!(projectManager.createProject(txtNewProjectTitle.getText(), txtaNewProjectDesriptionMain.getText(), currentUser) <= -1)) {
			cardLayoutPV.show(pnlCardPV, "ProjectViewPV");
			refreshProjectView();
			JOptionPane.showMessageDialog(this,
					"Successfully Created Project ✔"
					+ "\nClick Refresh to see it"
			);
		}
  }//GEN-LAST:event_btnNewProjectCreateActionPerformed

  private void btnRefreshToolBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshToolBarActionPerformed
		pnlCardPV.repaint();
		refreshProjectView();
		pnlCardPV.repaint();
  }//GEN-LAST:event_btnRefreshToolBarActionPerformed

  private void btnNewProjectViewBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewProjectViewBackActionPerformed
		cardLayoutPV.show(pnlCardPV, "NewProject");
		refreshProjectView();
		cardLayoutPV.show(pnlCardPV, "ProjectViewPV");
  }//GEN-LAST:event_btnNewProjectViewBackActionPerformed

  private void btnAccountSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountSettingsActionPerformed
		cardLayoutPV.show(pnlCardPV, "AccountSettings");
  }//GEN-LAST:event_btnAccountSettingsActionPerformed

  private void btnDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAccountActionPerformed
		UserManager userManager = new UserManager();
		if (!(userManager.deleteAccount(currentUsername) <= -1)) {
			this.currentUser = null;
			this.currentUsername = "";
			cardLayoutMain.show(pnlMain, "InitialPanel");
			JOptionPane.showMessageDialog(this, "User Deleted");
		} else {
			JOptionPane.showMessageDialog(this, "Failed to delete User");
		}

  }//GEN-LAST:event_btnDeleteAccountActionPerformed

  private void btnAccountSettingsBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountSettingsBackActionPerformed
		refreshProjectView();
		cardLayoutPV.show(pnlCardPV, "ProjectViewPV");
  }//GEN-LAST:event_btnAccountSettingsBackActionPerformed

    private void btnInitialHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInitialHelpActionPerformed
		new Help().setVisible(true);
    }//GEN-LAST:event_btnInitialHelpActionPerformed

    private void btnMainViewHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainViewHelpActionPerformed
		new Help().setVisible(true);
    }//GEN-LAST:event_btnMainViewHelpActionPerformed

    private void btnSignupHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignupHelpActionPerformed
		new Help().setVisible(true);
    }//GEN-LAST:event_btnSignupHelpActionPerformed

    private void btnSignInHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignInHelpActionPerformed
		new Help().setVisible(true);
    }//GEN-LAST:event_btnSignInHelpActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
		this.currentUser = null;
		cardLayoutMain.show(pnlMain, "InitialPanel");
    }//GEN-LAST:event_btnLogoutActionPerformed

	/**
	 * The main method to initialize the program.
	 *
	 * @param args the command line arguments.
	 */
	public static void main(String args[]) {
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				// Set Look and Feel Settings
				LafManager.enableLogging(true);
				LafManager.setTheme(new DarculaTheme());
				LafManager.install();

				// Form Creation
				new MainForm().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccountSettings;
    private javax.swing.JToggleButton btnAccountSettingsBack;
    private javax.swing.JButton btnDeleteAccount;
    private javax.swing.JButton btnInitialHelp;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnMainViewHelp;
    private javax.swing.JButton btnNewProjectCreate;
    private javax.swing.JButton btnNewProjectToolbar;
    private javax.swing.JButton btnNewProjectViewBack;
    private javax.swing.JButton btnRefreshToolBar;
    private javax.swing.JButton btnSignIn;
    private javax.swing.JButton btnSignInHelp;
    private javax.swing.JButton btnSignInSignIn;
    private javax.swing.JButton btnSignUp;
    private javax.swing.JButton btnSignUpInsteadSignIn;
    private javax.swing.JButton btnSignUpInsteadSignUp;
    private javax.swing.JButton btnSignUpSignUp;
    private javax.swing.JButton btnSignupHelp;
    private com.toedter.calendar.JDateChooser dcDOBSignUp;
    private javax.swing.JLabel lblAccountIcon;
    private javax.swing.JLabel lblAccountName;
    private javax.swing.JLabel lblAccountSettings;
    private javax.swing.JLabel lblAccountUsername;
    private javax.swing.JLabel lblConfirmPasswordSignUp;
    private javax.swing.JLabel lblDOBSignUP;
    private javax.swing.JLabel lblEmailSignUp;
    private javax.swing.JLabel lblErrorSignUp;
    private javax.swing.JLabel lblErrorText;
    private javax.swing.JLabel lblErrorTextNewProject;
    private javax.swing.JLabel lblFirstNameSignUp;
    private javax.swing.JLabel lblNewProjectDescription;
    private javax.swing.JLabel lblNewProjectTitle;
    private javax.swing.JLabel lblPasswordSignIn;
    private javax.swing.JLabel lblPasswordSignUp;
    private javax.swing.JLabel lblPasswordStrengthSignUp;
    private javax.swing.JLabel lblSubtitle;
    private javax.swing.JLabel lblSurnameSignUp;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUsernameSignIn;
    private javax.swing.JLabel lblUsernameSignUp;
    private javax.swing.JProgressBar pbarPasswordStrengthSignUp;
    private javax.swing.JPanel pnlAccount;
    private javax.swing.JPanel pnlAccountSettingToolBar;
    private javax.swing.JPanel pnlAccountSettings;
    private javax.swing.JPanel pnlAccountSettingsMain;
    private javax.swing.JPanel pnlButtonContainer;
    public static javax.swing.JPanel pnlCardPV;
    private javax.swing.JPanel pnlInitial;
    private javax.swing.JPanel pnlInitialContainer;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JSplitPane pnlMainSplit;
    private javax.swing.JPanel pnlNewProjectDetails;
    private javax.swing.JPanel pnlNewProjectView;
    private javax.swing.JPanel pnlNewProjectViewToolBar;
    private javax.swing.JPanel pnlProjectList;
    private javax.swing.JPanel pnlProjectListCard;
    private javax.swing.JPanel pnlProjectListMain;
    private javax.swing.JScrollPane pnlProjectListScroll;
    private javax.swing.JPanel pnlProjectListToolBar;
    private javax.swing.JPanel pnlSidePane;
    private javax.swing.JPanel pnlSignIn;
    private javax.swing.JPanel pnlSignInContainer;
    private javax.swing.JPanel pnlSignUp;
    private javax.swing.JPanel pnlSignUpContainer;
    private javax.swing.JPanel pnlTitleContainer;
    private javax.swing.JSeparator sepAccountSetttings;
    private javax.swing.JSeparator sepNewProjectView;
    private javax.swing.JPasswordField txtConfirmPasswordSignUp;
    private javax.swing.JTextField txtEmailSignUp;
    private javax.swing.JTextField txtFirstNameSignUp;
    private javax.swing.JTextField txtNewProjectTitle;
    private javax.swing.JPasswordField txtPasswordSignIn;
    private javax.swing.JPasswordField txtPasswordSignUp;
    private javax.swing.JTextField txtSurnameSignUp;
    private javax.swing.JTextField txtUsernameSignIn;
    private javax.swing.JTextField txtUsernameSignUp;
    private javax.swing.JScrollPane txtaNewProjectDescriptionScroll;
    private javax.swing.JTextArea txtaNewProjectDesriptionMain;
    // End of variables declaration//GEN-END:variables
}
