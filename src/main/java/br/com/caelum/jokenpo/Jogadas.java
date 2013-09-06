package br.com.caelum.jokenpo;

import java.util.Arrays;

public class Jogadas {

	private final int[][][] jogadas = new int[3][3][4];
	private Rodada ultima;

	public void joga(Rodada atual) {
		if (ultima != null) {
			int ultimaEu = ultima.getEu().ordinal();
			int ultimaInimigo = ultima.getInimigo().ordinal();
			int posicao = atual.getEu().ordinal();
			for (int i = posicao; i <= 3; i++)
				jogadas[ultimaEu][ultimaInimigo][i]++;
		}
		this.ultima = atual;
	}

	public Mao escolheDoInimigo() {
		// if(ultima == null) {
		int robo = (int) (Math.random() * 3);
		Mao inimigo = Mao.values()[robo];
		return inimigo;
		// }
		// return jogadaOrdinalPara(ultima).perdePara();
	}

	int[] jogadasPara(Rodada jogada) {
		return jogadas[jogada.getEu().ordinal()][jogada.getInimigo().ordinal()];
	}

	public Mao jogadaOrdinalPara(Rodada jogada) {
		int eu = jogada.getEu().ordinal();
		int inimigo = jogada.getInimigo().ordinal();
		int escolha = (int) (Math.random() * jogadas[eu][inimigo][3]);
		int previous = 0;
		for (int i = 0; i < 2; i++) {
			if (escolha >= previous && escolha < jogadas[eu][inimigo][i])
				return Mao.values()[i];
			previous = jogadas[eu][inimigo][i];
		}
		return Mao.values()[2];
	}

	@Override
	public String toString() {
		return Arrays.deepToString(this.jogadas);
	}

}
