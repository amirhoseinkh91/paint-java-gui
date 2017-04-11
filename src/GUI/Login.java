package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Person.Person;
import entityManagers.PersonManager;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUsername;
	private JPasswordField textFieldPassword;

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 234);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("ورود");
		contentPane.setLayout(null);

		final JLabel lblErrorlogin = new JLabel("نام کاربری و یا رمز عبور اشتباه است");
		lblErrorlogin.setForeground(Color.RED);
		lblErrorlogin.setVisible(false);
		lblErrorlogin.setBounds(59, 132, 239, 15);
		contentPane.add(lblErrorlogin);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setBounds(67, 46, 114, 19);
		contentPane.add(textFieldUsername);
		textFieldUsername.setColumns(10);

		textFieldPassword = new JPasswordField();
		textFieldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10) {
					String username = textFieldUsername.getText();
					String password = textFieldPassword.getText();
					final int idPerson = PersonManager.login(username, password);
					if (idPerson >= 0) {
						textFieldPassword.setText("");
						textFieldUsername.setText("");
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Paint paint = new Paint(idPerson);
									paint.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						dispose();
					} else {
						lblErrorlogin.setVisible(true);
						textFieldPassword.setText("");
					}
				}
			}
		});
		textFieldPassword.setBounds(69, 77, 112, 19);
		contentPane.add(textFieldPassword);

		

		final JLabel lblUserexist = new JLabel("این کاربر قبلا ثبت شده است");
		lblUserexist.setForeground(Color.DARK_GRAY);
		lblUserexist.setHorizontalAlignment(SwingConstants.CENTER);
		lblUserexist.setBounds(79, 108, 183, 15);
		lblUserexist.setVisible(false);
		contentPane.add(lblUserexist);

		JButton btnAddUser = new JButton("اضافه کردن کاربر");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textFieldUsername.getText();
				String password = textFieldPassword.getText();
				int isUser = PersonManager.login(username, password);
				if (isUser == -1) {
					Person p = new Person(username, password);
					PersonManager.addPerson(p);
				} else {
					lblUserexist.setVisible(true);
				}
				textFieldPassword.setText("");
				textFieldUsername.setText("");
			}
		});
		btnAddUser.setBounds(173, 159, 139, 25);
		contentPane.add(btnAddUser);

		JLabel lblUsername = new JLabel("نام کاربری");
		lblUsername.setBounds(216, 48, 82, 15);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("رمز عبور");
		lblPassword.setBounds(226, 79, 70, 15);
		contentPane.add(lblPassword);

		JLabel lblEnterUsernameAnd = new JLabel("نام کاربری و رمز عبور خود را وارد نمایید");
		lblEnterUsernameAnd.setForeground(Color.BLUE);
		lblEnterUsernameAnd.setBounds(47, 12, 251, 15);
		contentPane.add(lblEnterUsernameAnd);

		JButton btnLogin = new JButton("ورود");

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username = textFieldUsername.getText();
				String password = textFieldPassword.getText();
				final int idPerson = PersonManager.login(username, password);
				if (idPerson >= 0) {
					textFieldPassword.setText("");
					textFieldUsername.setText("");
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								Paint paint = new Paint(idPerson);
								paint.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					dispose();
				} else {
					lblErrorlogin.setVisible(true);
					textFieldPassword.setText("");
				}
			}
		});
		btnLogin.setBounds(49, 159, 114, 25);
		contentPane.add(btnLogin);

	}
}
