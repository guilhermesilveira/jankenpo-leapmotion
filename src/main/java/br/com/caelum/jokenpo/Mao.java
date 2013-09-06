package br.com.caelum.jokenpo;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public enum Mao {
// http://www.flickr.com/photos/jamesrbowe/3708293822/sizes/l/in/photostream/
	//	http://www.flickr.com/photos/rkramer62/6233679473/in/photostream/
//	http://www.flickr.com/photos/alsokaizen/2471871893/
//	http://www.flickr.com/photos/dantaylr/5530488320/in/photostream/
	TESOURA("scissors"), PEDRA("stones"), PAPEL("paper");
	private final ImageIcon image;

	Mao(String name) {
		this.image = new ImageIcon(Mao.class.getResource("/jokenpo_" + name
				+ ".jpg"));
	}
	
	public ImageIcon getImage() {
		return image;
	}

	public String ganheiStringDe(Mao inimigo) {
		if (this == inimigo)
			return "EMPATE";
		if (inimigo == perdePara())
			return "PERDI!";
		return "GANHEI!";
	}

	public Mao perdePara() {
		if (this == TESOURA)
			return PEDRA;
		if (this == PEDRA)
			return PAPEL;
		return TESOURA;
	}
}