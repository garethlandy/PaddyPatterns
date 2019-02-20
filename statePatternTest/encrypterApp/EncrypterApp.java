package encrypterApp;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;

import javax.swing.*;

public class EncrypterApp extends JFrame {
	
	private JTextArea plainTextArea, cipherTextArea;
	private JButton encryptButton, clearButton;
	private JRadioButton simpleButton, substitutionButton, rotationButton;
	private ButtonGroup buttons;

	public EncrypterApp() {
		
		super("Encryption Example");
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2, 1));
		plainTextArea = new JTextArea(20, 20);
		JScrollPane sp1 = new JScrollPane(plainTextArea);
		cipherTextArea = new JTextArea(20, 20);
		JScrollPane sp2 = new JScrollPane(cipherTextArea);
		leftPanel.add(sp1);
		leftPanel.add(sp2);
		c.add(leftPanel, BorderLayout.WEST);
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		JPanel radioButtonPanel = new JPanel();
		radioButtonPanel.setLayout(new GridLayout(6, 1));
		JLabel encryptLabel = new JLabel("Encryption Method");
		radioButtonPanel.add(encryptLabel);
		simpleButton = new JRadioButton("Simple");
		simpleButton.setActionCommand("Simple");
		simpleButton.setSelected(true);
		buttons = new ButtonGroup();
		buttons.add(simpleButton);
		radioButtonPanel.add(simpleButton);
		substitutionButton = new JRadioButton("Substitution");
		substitutionButton.setActionCommand("Substitution");
		buttons.add(substitutionButton);
		radioButtonPanel.add(substitutionButton);
		rotationButton = new JRadioButton("Rotation");
		rotationButton.setActionCommand("Rotation");
		buttons.add(rotationButton);
		radioButtonPanel.add(rotationButton);
		encryptButton = new JButton("Encrypt!");
		radioButtonPanel.add(encryptButton);
		clearButton = new JButton("Clear!");
		radioButtonPanel.add(clearButton);
		rightPanel.add(radioButtonPanel, BorderLayout.NORTH);
		c.add(rightPanel, BorderLayout.CENTER);
		
		encryptButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String plainText = plainTextArea.getText();
				
				String selection = new String();
				
				for (Enumeration<AbstractButton> options = buttons.getElements(); options.hasMoreElements();) {
		            AbstractButton button = options.nextElement();
		            if (button.isSelected()) {
		                selection = button.getText();
		            }
		        }
				
				switch (selection) {
				
					case "Simple" :
					    char[] chars = plainText.toCharArray();
					    for (int i = 0; i < chars.length; i++) {
					      char c = chars[i];
					      if (c == 'z') {
					        c = 'a';
					      }
					      if ((c >= 'a') && (c < 'z')) {
					        ++c;
					      }
					      chars[i] = c;
					    }
						cipherTextArea.setText(new String(chars));
						break;
						
					case "Substitution" :
						char[] source = {'a','b','c','d','e','f','g','h','i','j','k',
				                   'l','m','n','o','p','q','r','s','t','u','v',
				                   'w','x','y','z'};
						char[] destination = {'q','w','e','r','t','y','u','i','o','p','a',
				                 's','d','f','g','h','j','k','l','z','x','c',
				                 'v','b','n','m'};
						char[] chars1 = plainText.toCharArray();
					    for (int i = 0; i < chars1.length; i++) {
					      char c = chars1[i];
					      for (int j = 0; j < source.length; j++) {
					        if (source[j] == chars1[i]) {
					          c = destination[j];
					        }
					      }
					      chars1[i] = c;
					    }
					    cipherTextArea.setText(new String(chars1));
						break;
						
					case "Rotation" :
						char[] chars2 = plainText.toCharArray();
				        for (int i = 0; i < plainText.length(); i++) {
				            char c = plainText.charAt(i);
				            if       (c >= 'a' && c <= 'm') c += 13;
				            else if  (c >= 'A' && c <= 'M') c += 13;
				            else if  (c >= 'n' && c <= 'z') c -= 13;
				            else if  (c >= 'N' && c <= 'Z') c -= 13;
				            chars2[i] = c;
				        }
				        cipherTextArea.setText(new String(chars2));
						break;
				
				}
			}
		});
		
		clearButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				plainTextArea.setText("");
				cipherTextArea.setText("");
			}
		});
	}


	public static void main(String[] args) {

		EncrypterApp ea = new EncrypterApp();
		ea.pack();
		ea.setSize(400, 800);
		ea.setVisible(true);

	}

}