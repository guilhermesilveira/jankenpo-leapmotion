package br.com.caelum.jokenpo;

import java.io.IOException;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.Listener;

public class JoKenPo extends Listener {

	private final Controller controller = new Controller();

	private final UI ui;
	private final Jogo jogo;

	public JoKenPo(UI ui, Jogo jogo) throws IOException {
		this.ui = ui;
		this.jogo = jogo;
		controller.addListener(this);
	}

	public void onFrame(Controller controller) {
		Frame frame = controller.frame();

		int maos = frame.hands().count();
		if (maos < 1)
			return;
		
		Hand primeiraMao = frame.hands().get(0);
		FingerList dedos = primeiraMao.fingers();
		int dedosAMostra = dedos.count();
		if (dedosAMostra < 2) {
			notify(Mao.PEDRA);
		} else if (dedosAMostra > 2) {
			notify(Mao.PAPEL);
		} else {
			notify(Mao.TESOURA);
		}
	}

	private void notify(Mao selecao) {
		ui.mudouPara(selecao);
		jogo.mudouPara(selecao);
	}

	public static void main(String[] args) throws IOException {
		Janela janela = new Janela();
		Jogo jogo = new Jogo();
		new JoKenPo(janela, jogo).roda();
	}

	private void roda() {
		while (true) {
			contagemRegressiva();
			rodaUma();
		}
	}

	private void rodaUma() {
		Rodada rodada = jogo.processa();
		ui.mensagem(rodada.toString());
	}

	private void contagemRegressiva() {
		for (int i = 5; i > 0; i--) {
			ui.mostraContagem(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// ignorando pausa na contagem
			}
		}
	}

}
