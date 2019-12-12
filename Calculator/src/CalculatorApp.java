import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class CalculatorApp {
	private JFrame frmHesapMakinesi;
	private JTextField textField;
	private Calculator calc = new Calculator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorApp window = new CalculatorApp();
					window.frmHesapMakinesi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CalculatorApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHesapMakinesi = new JFrame();
		frmHesapMakinesi.setForeground(Color.RED);
		frmHesapMakinesi.setFont(new Font("Dialog", Font.BOLD, 25));
		frmHesapMakinesi.setTitle("Hesap Makinesi");
		frmHesapMakinesi.setBounds(100, 100, 515, 559);
		frmHesapMakinesi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHesapMakinesi.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmHesapMakinesi.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(10, 10));

		textField = new JTextField();
		textField.setEditable(false);
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(textField);
		textField.setColumns(40);

		JPanel panel_1 = new JPanel();
		frmHesapMakinesi.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(5, 5, 5, 5));

		JButton btnNewButton_1 = new JButton("%");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setKosul(true);
				calc.setSecenek('%');
				textField.setText(textField.getText());
				try {
					calc.setSayi1((Double.parseDouble(textField.getText())));
					textField.setText(calc.equal());
				} catch (NumberFormatException e1) {

					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}

			}
		});
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("\u2642");
		btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("C");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				calc.setKosul(true);
				calc.setSayi1(0);
				calc.setSayi2(0);
				calc.setSonuc(0);
			}
		});
		btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("\u20EA");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setKosul(true);
				textField.setText(textField.getText());
				try {
					textField.setText(calc.getDeletedText(Double.parseDouble(textField.getText())));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}

			}
		});
		btnNewButton_4.setFont(new Font("Segoe UI Symbol", Font.BOLD, 30));
		panel_1.add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("\u00F7");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				calc.setKosul(true);
				calc.setSecenek('/');
				textField.setText(textField.getText());
				try {
					calc.setSayi1(Double.parseDouble(textField.getText()));
					textField.setText(null);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}

			}
		});
		btnNewButton_5.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("\u221A");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setKosul(true);
				calc.setSecenek('k');
				textField.setText(textField.getText());
				try {
					calc.setSayi1(Math.sqrt((Double.parseDouble(textField.getText()))));
					textField.setText(calc.getFormattedText(calc.getSayi1()));
				} catch (Exception e1) {
					
				}

			}
		});
		btnNewButton_6.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_6);

		JButton btnNewButton = new JButton("7");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calc.getSecenek() == 'x' || calc.getSecenek() == '#' || calc.getSecenek() == '%'
						 || calc.getSecenek() == 'k' ) {
					calc.setSecenek(' ');
					textField.setText(null);
				}
				textField.setText(textField.getText() + 7);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton);

		JButton btnNewButton_8 = new JButton("8");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calc.getSecenek() == 'x' || calc.getSecenek() == '#' || calc.getSecenek() == '%'
						 || calc.getSecenek() == 'k' ) {
					calc.setSecenek(' ');
					textField.setText(null);
				}
				textField.setText(textField.getText() + 8);
			}
		});
		btnNewButton_8.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_8);

		JButton btnNewButton_7 = new JButton("9");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calc.getSecenek() == 'x' || calc.getSecenek() == '#' || calc.getSecenek() == '%'
						 || calc.getSecenek() == 'k' ) {
					calc.setSecenek(' ');
					textField.setText(null);
				}
				textField.setText(textField.getText() + 9);
			}
		});
		btnNewButton_7.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_7);

		JButton btnNewButton_10 = new JButton("x");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setKosul(true);
				calc.setSecenek('*');
				textField.setText(textField.getText());
				try {
					calc.setSayi1(Double.parseDouble(textField.getText()));
					textField.setText(null);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}
			}
		});
		btnNewButton_10.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_10);

		JButton btnNewButton_9 = new JButton("x\u00B3");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setKosul(true);
				calc.setSecenek('x');
				textField.setText(textField.getText());
				try {
					calc.setSayi1(Math.pow(((Double.parseDouble(textField.getText()))), 3));
					textField.setText(calc.equal());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}

			}
		});
		btnNewButton_9.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_9);

		JButton btnNewButton_12 = new JButton("4");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calc.getSecenek() == 'x' || calc.getSecenek() == '#' || calc.getSecenek() == '%'
						 || calc.getSecenek() == 'k' ) {
					calc.setSecenek(' ');
					textField.setText(null);
				}
				textField.setText(textField.getText() + 4);
			}
		});
		btnNewButton_12.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_12);

		JButton btnNewButton_11 = new JButton("5");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calc.getSecenek() == 'x' || calc.getSecenek() == '#' || calc.getSecenek() == '%'
						 || calc.getSecenek() == 'k' ) {
					calc.setSecenek(' ');
					textField.setText(null);
				}
				textField.setText(textField.getText() + 5);
			}
		});
		btnNewButton_11.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_11);

		JButton btnNewButton_13 = new JButton("6");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calc.getSecenek() == 'x' || calc.getSecenek() == '#' || calc.getSecenek() == '%'
						 || calc.getSecenek() == 'k' ) {
					calc.setSecenek(' ');
					textField.setText(null);
				}
				textField.setText(textField.getText() + 6);
			}
		});
		btnNewButton_13.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_13);

		JButton btnNewButton_16 = new JButton("-");
		btnNewButton_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setKosul(true);
				calc.setSecenek('-');
				textField.setText(textField.getText());
				try {
					calc.setSayi1(Double.parseDouble(textField.getText()));
					textField.setText(null);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}
			}
		});
		btnNewButton_16.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_16);

		JButton btnNewButton_20 = new JButton("x\u00B2");
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setKosul(true);
				calc.setSecenek('x');
				textField.setText(textField.getText());
				try {
					calc.setSayi1(Math.pow(((Double.parseDouble(textField.getText()))), 2));
					textField.setText(calc.equal());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}
			}
		});
		btnNewButton_20.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_20);

		JButton btnNewButton_18 = new JButton("1");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calc.getSecenek() == 'x' || calc.getSecenek() == '#' || calc.getSecenek() == '%'
						 || calc.getSecenek() == 'k' ) {
					calc.setSecenek(' ');
					textField.setText(null);
				}
				textField.setText(textField.getText() + 1);
			}
		});
		btnNewButton_18.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_18);

		JButton btnNewButton_15 = new JButton("2");
		btnNewButton_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calc.getSecenek() == 'x' || calc.getSecenek() == '#' || calc.getSecenek() == '%'
						 || calc.getSecenek() == 'k' ) {
					calc.setSecenek(' ');
					textField.setText(null);
				}
				textField.setText(textField.getText() + 2);
			}
		});
		btnNewButton_15.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_15);

		JButton btnNewButton_17 = new JButton("3");
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calc.getSecenek() == 'x' || calc.getSecenek() == '#' || calc.getSecenek() == '%'
						 || calc.getSecenek() == 'k' ) {
					calc.setSecenek(' ');
					textField.setText(null);
				}
				textField.setText(textField.getText() + 3);
			}
		});
		btnNewButton_17.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_17);

		JButton btnNewButton_14 = new JButton("+");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setKosul(true);
				calc.setSecenek('+');
				textField.setText(textField.getText());
				try {
					calc.setSayi1(Double.parseDouble(textField.getText()));
					textField.setText(null);
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}

			}
		});
		btnNewButton_14.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_14);

		JButton btnNewButton_19 = new JButton("1/x");
		btnNewButton_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setKosul(true);
				calc.setSecenek('#');
				textField.setText(textField.getText());
				try {
					calc.setSayi1(Double.parseDouble(textField.getText()));
					textField.setText(calc.equal());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}

			}
		});
		btnNewButton_19.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_19);

		JButton btnNewButton_21 = new JButton("\u2213");
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textField.setText(calc.getMinusFormattedText(Double.parseDouble(textField.getText())));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}

			}
		});
		btnNewButton_21.setFont(new Font("Segoe UI Symbol", Font.BOLD, 16));
		panel_1.add(btnNewButton_21);

		JButton btnNewButton_22 = new JButton("0");
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calc.getSecenek() == 'x' || calc.getSecenek() == '#' || calc.getSecenek() == '%'
						 || calc.getSecenek() == 'k' ) {
					calc.setSecenek(' ');
					textField.setText(null);
				}
				textField.setText(textField.getText() + 0);
			}
		});
		btnNewButton_22.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_22);

		JButton btnNewButton_23 = new JButton(".");
		btnNewButton_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					textField.setText(calc.getDotFormattedText(Double.parseDouble(textField.getText())));
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}
					
				

			}
		});
		btnNewButton_23.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(btnNewButton_23);

		JButton button = new JButton("=");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calc.setKosul(false);
				try {
					calc.setSayi2(Double.parseDouble(textField.getText()));
					textField.setText(calc.equal());
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Sayý giriniz");
				}

			}
		});
		button.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(button);
	}

}
