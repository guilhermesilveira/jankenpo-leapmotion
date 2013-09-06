package br.com.caelum.jokenpo;

import java.awt.BorderLayout;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class Janela implements LeapListener, UI {

	private final JTextArea console = new JTextArea();
	private final LinkedList<String> lines = new LinkedList<String>();
	private final JLabel main = new JLabel();

	public Janela() {
		lines.add("");
		lines.add("");
		lines.add("");
		lines.add("");
		
		JFrame frame = new JFrame("Jo ken po");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		mudouPara(Mao.PEDRA);

		frame.add(main, BorderLayout.CENTER);
		frame.add(console, BorderLayout.SOUTH);
		frame.setSize(1000, 700);
		frame.setVisible(true);
	}

	@Override
	public void mudouPara(Mao mao) {
		main.setIcon(mao.getImage());
	}

	@Override
	public void mostraContagem(int i) {
		mensagem(i + "...");
	}

	@Override
	public void mensagem(String msg) {
		lines.removeFirst();
		lines.add(msg);
		StringBuilder current = new StringBuilder();
		for (String line : lines) {
			current.append(line);
			current.append('\n');
		}
		console.setText(current.toString());
		console.setSelectionStart(current.length());
	}

}
