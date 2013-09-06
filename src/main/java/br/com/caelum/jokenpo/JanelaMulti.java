package br.com.caelum.jokenpo;

import java.awt.BorderLayout;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JanelaMulti {

	private final JTextArea console = new JTextArea();
	private final LinkedList<String> lines = new LinkedList<String>();
	private final JPanel main = new JPanel();
	private final JLabel left = new JLabel();
	private final JLabel right = new JLabel();

	public JanelaMulti() {
		lines.add("");
		lines.add("");
		lines.add("");
		lines.add("");

		JFrame frame = new JFrame("Jo ken po");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mudouPara(null, null);

		main.setLayout(new BorderLayout());
		main.add(left, BorderLayout.WEST);
		main.add(right, BorderLayout.EAST);
		frame.add(main, BorderLayout.CENTER);
		frame.add(console, BorderLayout.SOUTH);
		frame.setSize(1000, 700);
		frame.setVisible(true);
	}

	public void mudouPara(Mao left, Mao right) {
		if (left == null)
			this.left.setIcon(null);
		else
			this.left.setIcon(left.getImage());
		if (right == null)
			this.right.setIcon(null);
		else
			this.right.setIcon(right.getImage());
	}

}
