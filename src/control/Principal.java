
package control;

import java.awt.EventQueue;

/**
 * @author Rafa & David
 */

import javax.swing.JFrame;

import vista.Interfaz;

// TODO: Auto-generated Javadoc
/**
 * The Class Principal.
 *
 * @version 1.0
 */

public class Principal {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		Interfaz i = new Interfaz();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					i.setTitle("I.E.S BARAJAS");
					i.setResizable(false);
					i.setVisible(true);
					i.setBounds(100, 100, 630, 500);
					i.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
