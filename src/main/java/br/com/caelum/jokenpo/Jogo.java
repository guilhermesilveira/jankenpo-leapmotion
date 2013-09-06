package br.com.caelum.jokenpo;

public class Jogo implements LeapListener {

	private Mao selecao = Mao.PEDRA;
	
	@Override
	public void mudouPara(Mao mao) {
		this.selecao = mao;
	}

	public Rodada processa() {
		int robo = (int) (Math.random() * 3);
		Mao inimigo = Mao.values()[robo];
		Mao eu = selecao;
		return new Rodada(eu, inimigo);
	}

}
