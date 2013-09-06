package br.com.caelum.jokenpo;

class Rodada {

	private Mao eu;
	private Mao inimigo;

	public Rodada(Mao eu, Mao inimigo) {
		this.eu = eu;
		this.inimigo = inimigo;
	}

	@Override
	public String toString() {
		String content = eu + " x " + inimigo + "\n";
		return content + eu.ganheiStringDe(inimigo);
	}

	public Mao getEu() {
		return eu;
	}

	public Mao getInimigo() {
		return inimigo;
	}

}
