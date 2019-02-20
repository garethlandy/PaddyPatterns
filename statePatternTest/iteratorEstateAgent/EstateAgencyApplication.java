package iteratorEstateAgent;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


import net.miginfocom.swing.MigLayout;

import java.text.NumberFormat;
import java.util.*;

public class EstateAgencyApplication extends JFrame {

	ArrayList<House> houseList = new ArrayList<House>();
	House[] houseArray = new House[5];
	LinkedList<House> houseChain = new LinkedList<House>();

	int structureType = -1;
	
	

	JMenuBar menuBar;
	JMenu listMenu, closeMenu;
	JMenuItem firstItem, nextItem, prevItem, lastItem, closeApp;
	JButton firstItemButton, nextItemButton, prevItemButton, lastItemButton;
	JLabel houseImageLabel, idLabel, streetLabel, cityLabel, bedroomsLabel, bathroomsLabel, priceLabel, contactNoLabel;
	JTextField idTextField, streetTextField, cityTextField, bedroomsTextField, bathroomsTextField, priceTextField, contactNoTextField;
	String[][] records = { {"113 The Maltings", "Dublin 8", "2", "1", "155500.00", "House1.jpg", "(087) 9011135"},
			{"78 Newington Lodge", "Dublin 14", "3", "2", "310000.00", "House2.jpg", "(087) 9010580"},
			{"62 Bohernabreena Road", "Dublin 24", "3", "1", "220000.00", "House3.jpg", "(087) 6023159"},
			{"18 Castledevitt Park", "Dublin 15", "3", "3", "325000.00", "House4.jpg", "(087) 9010580"},
			{"40 Dunsawny Road", "Swords", "3", "19", "245000.00", "House5.jpg", "(087) 9011135"}
	};
	int currentPosition;

	public EstateAgencyApplication() {
		super("Estate Agent Application");
		loadItems();
		currentPosition = 0;
		initComponents();	
	}

	private void loadItems() {
		String[] options = new String[] {"Array", "Array List", "Linked List"};
		structureType = JOptionPane.showOptionDialog(null, "Choose a data storage structure", "Start Up",
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
		if (structureType == 0) {
			for (int i = 0; i < records.length; i++) {
				houseArray[i] = new House(records[i][0], records[i][1], Integer.parseInt(records[i][2]), 
						Integer.parseInt(records[i][3]), Double.parseDouble(records[i][4]), records[i][5], records[i][6]);
			}		
		}
		if (structureType == 1)  {
			for (int i = 0; i < records.length; i++) {
				houseList.add(new House(records[i][0], records[i][1], Integer.parseInt(records[i][2]), 
						Integer.parseInt(records[i][3]), Double.parseDouble(records[i][4]), records[i][5], records[i][6]));
			}		
		}
		if (structureType == 2) {
			for (int i = 0; i < records.length; i++) {
				houseChain.add(new House(records[i][0], records[i][1], Integer.parseInt(records[i][2]), 
						Integer.parseInt(records[i][3]), Double.parseDouble(records[i][4]), records[i][5], records[i][6]));
			}		
		}
	}

	public void initComponents() {
		setLayout(new BorderLayout());
		JPanel displayPanel = new JPanel(new MigLayout());

		// Ensures that image is centred in label
		houseImageLabel = new JLabel(new ImageIcon(), SwingConstants.CENTER);
		displayPanel.add(houseImageLabel, "push, grow, span 2, wrap");

		idLabel = new JLabel("House ID: ");
		idTextField = new JTextField(3);
		idTextField.setEditable(false);

		displayPanel.add(idLabel, "growx, pushx");
		displayPanel.add(idTextField, "growx, pushx, wrap");

		streetLabel = new JLabel("Address Line 1: ");
		streetTextField = new JTextField(15);
		streetTextField.setEditable(false);

		displayPanel.add(streetLabel, "growx, pushx");
		displayPanel.add(streetTextField, "growx, pushx, wrap");

		cityLabel = new JLabel("Address Line 2: ");
		cityTextField = new JTextField(15);
		cityTextField.setEditable(false);

		displayPanel.add(cityLabel, "growx, pushx");
		displayPanel.add(cityTextField, "growx, pushx, wrap");

		bedroomsLabel = new JLabel("Number of bedrooms: ");
		bedroomsTextField = new JTextField(3);
		bedroomsTextField.setEditable(false);

		displayPanel.add(bedroomsLabel, "growx, pushx");
		displayPanel.add(bedroomsTextField, "growx, pushx, wrap");

		bathroomsLabel = new JLabel("Number of bathrooms: ");
		bathroomsTextField = new JTextField(3);
		bathroomsTextField.setEditable(false);

		displayPanel.add(bathroomsLabel, "growx, pushx");
		displayPanel.add(bathroomsTextField, "growx, pushx, wrap");

		priceLabel = new JLabel("Price: ");
		priceTextField = new JTextField(10);
		priceTextField.setEditable(false);

		displayPanel.add(priceLabel, "growx, pushx");
		displayPanel.add(priceTextField, "growx, pushx, wrap");

		contactNoLabel = new JLabel("Contact number: ");
		contactNoTextField = new JTextField(15);
		contactNoTextField.setEditable(false);

		displayPanel.add(contactNoLabel, "growx, pushx");
		displayPanel.add(contactNoTextField, "growx, pushx, wrap");
		add(displayPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel(new GridLayout(1, 4));

		firstItemButton = new JButton(new ImageIcon("first.png"));
		nextItemButton = new JButton(new ImageIcon("next.png"));
		prevItemButton = new JButton(new ImageIcon("prev.png"));
		lastItemButton = new JButton(new ImageIcon("last.png"));

		buttonPanel.add(firstItemButton);
		buttonPanel.add(prevItemButton);
		buttonPanel.add(nextItemButton);
		buttonPanel.add(lastItemButton);

		JPanel bottomPanel = new JPanel();
		bottomPanel.add(buttonPanel);

		add(bottomPanel, BorderLayout.SOUTH);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		listMenu = new JMenu("Display");
		firstItem = new JMenuItem("First");
		prevItem = new JMenuItem("Previous");
		nextItem = new JMenuItem("Next");
		lastItem = new JMenuItem("Last");

		listMenu.add(firstItem);
		listMenu.add(prevItem);
		listMenu.add(nextItem);
		listMenu.add(lastItem);

		menuBar.add(listMenu);

		closeMenu = new JMenu("Exit");
		closeApp = new JMenuItem("Close");

		closeMenu.add(closeApp);

		menuBar.add(closeMenu);

		if (structureType == 0) {
			displayDetails(houseArray[0]);
		}
		if (structureType == 1) {
			displayDetails(houseList.get(0));
		}
		if (structureType == 2) {
			displayDetails(houseChain.get(0));					
		}

		// Because each pair of corresponding buttons and menu items have the same functionality, instead
		// of repeating the same code in two locations, we can define an ActionListener object that both
		// components will share by having it added as their action listener.

		ActionListener first = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (structureType == 0) {
					displayDetails(houseArray[0]);
				}
				if (structureType == 1) {
					displayDetails(houseList.get(0));
				}
				if (structureType == 2) {
					displayDetails(houseChain.get(0));					
				}
			}
		};

		ActionListener next = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// No next if at end of list
				if (structureType == 0) {
					if (currentPosition != (houseArray.length - 1)) {
						currentPosition++;
						displayDetails(houseArray[currentPosition]);
					}
				}
				if (structureType == 1) {
					if (currentPosition != (houseList.size() - 1)) {
						currentPosition++;
						displayDetails(houseList.get(currentPosition));
					}
				}
				if (structureType == 2) {
					if (currentPosition != (houseChain.size() - 1)) {
						currentPosition++;
						displayDetails(houseChain.get(currentPosition));
					}					
				}
			}
		};

		ActionListener prev = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// No previous if at beginning of list
				if (structureType == 0) {
					if (currentPosition != 0) {
						currentPosition--;
						displayDetails(houseArray[currentPosition]);
					}
				}
				if (structureType == 1) {
					if (currentPosition != 0) {
						currentPosition--;
						displayDetails(houseList.get(currentPosition));					
					}
				}
				if (structureType == 2) {
					if (currentPosition != 0) {
						currentPosition--;
						displayDetails(houseChain.get(currentPosition));					
					}
				}
			}
		};

		ActionListener last = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (structureType == 1) {
					currentPosition = houseArray.length - 1;
					displayDetails(houseArray[currentPosition]);
				}
				if (structureType == 1) {
					currentPosition = houseList.size() - 1;
					displayDetails(houseList.get(currentPosition));
				}
				if (structureType == 2) {
					currentPosition = houseChain.size() - 1;
					displayDetails(houseChain.get(currentPosition));
				}
			}
		};

		firstItemButton.addActionListener(first);
		firstItem.addActionListener(first);

		nextItemButton.addActionListener(next);
		nextItem.addActionListener(next);

		prevItemButton.addActionListener(prev);
		prevItem.addActionListener(prev);

		lastItemButton.addActionListener(last);
		lastItem.addActionListener(last);

		closeApp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});	
	}

	public void displayDetails(House currentHouse) {
		houseImageLabel.setIcon(new ImageIcon(currentHouse.getImageLocation()));
		idTextField.setText(currentHouse.getId() + "");
		streetTextField.setText(currentHouse.getStreet());
		cityTextField.setText(currentHouse.getCity());
		bedroomsTextField.setText(currentHouse.getBedrooms() + "");
		bathroomsTextField.setText(currentHouse.getBathrooms() + "");
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		priceTextField.setText(nf.format(currentHouse.getPrice()));
		contactNoTextField.setText(currentHouse.getContactNo());
	}


	public static void main(String[] args) {
		EstateAgencyApplication ea = new EstateAgencyApplication();
		ea.pack();
		ea.setSize(400, 550);
		ea.setVisible(true);
	}

}
