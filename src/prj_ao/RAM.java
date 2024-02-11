package prj_ao;

import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class RAM extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static DefaultTableModel model = new DefaultTableModel();
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RAM frame = new RAM();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RAM() {
		setTitle("RAM");
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 212, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setLayout(new BorderLayout(0, 0));
		
		

		model.addColumn("Address");
        model.addColumn("Data");
        
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);
    	for (int i = 0; i < 1024; i++) {
                String address = intToHex(i); // Convert decimal to hexadecimal
                model.addRow(new Object[]{address, "00"});
            }
	}
	public static void setData(String t, int i) {
		model.setValueAt(t,i,1);
	}
	
	public static Object getData(String adresse) {
		int ligne=hextoInt(adresse);
		return model.getValueAt(ligne, 1);
	}

	private static int hextoInt(String hexValue) {
		while (hexValue.length() < 5) {
	        hexValue = "0" + hexValue;
	    }

	    // Convert hexadecimal to integer
	    int intValue = Integer.parseInt(hexValue, 16);

	    return intValue;
	}
	private static String intToHex(int value) {
        // Convert to hexadecimal
        String hexValue = Integer.toHexString(value).toUpperCase();

        // Pad with leading zeros to ensure a fixed width of 4 characters
        while (hexValue.length() < 4) {
            hexValue = "0" + hexValue;
        }

        return hexValue;
    }

	public static Object getDatapre(String adresse) {
		int ligne=hextoInt(adresse);
		ligne++;
		return model.getValueAt(ligne, 1);
	}
}
