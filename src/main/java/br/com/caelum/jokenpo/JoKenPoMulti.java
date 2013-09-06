package br.com.caelum.jokenpo;

import java.io.IOException;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Listener;

public class JoKenPoMulti extends Listener {

	private final Controller controller = new Controller();

	private final JanelaMulti ui;

	public JoKenPoMulti(JanelaMulti ui) throws IOException {
		this.ui = ui;
		controller.addListener(this);
	}

	public void onFrame(Controller controller) {
		Frame frame = controller.frame();

		int maos = frame.hands().count();
		if (maos != 2) {
			notify(null, null);
			return;
		}

		int left = frame.hands().leftmost().fingers().count();
		int right = frame.hands().rightmost().fingers().count();
		notify(selectFor(left), selectFor(right));
	}

	private Mao selectFor(int dedosAMostra) {
		if (dedosAMostra < 2)
			return Mao.PEDRA;
		else if (dedosAMostra > 2)
			return (Mao.PAPEL);
		return (Mao.TESOURA);
	}

	private void notify(Mao esquerda, Mao direita) {
		ui.mudouPara(esquerda, direita);
	}

	public static void main(String[] args) throws IOException {
		JanelaMulti janela = new JanelaMulti();
		new JoKenPoMulti(janela).roda();
	}

	private void roda() {
		while (true) {
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
