package packageJuego;

public class Gnomoa extends Pertsonaia {

	public Gnomoa() {

		super.setHpMax(190);
		super.setHpCurrent(super.getHpMax());
		super.setSpeed(6);
		super.setLuck(8);
		super.setStrength(25);
		super.setPozioKopurua(7);
	}

	@Override
	public void hpEguneratu(double pMina, String pErasoa) {

		double gnomoenDuina = Math.random() + (super.getLuck() / 100);
		if (gnomoenDuina > 0.7) {
			gnomoenDuina = 0.7;
		}
		if (pErasoa.equals("goi")) {
			pMina *= 1.5;
			System.out.println("Eraso kritikoa!");
		}
		pMina*=1-gnomoenDuina;
		super.hpEguneratu(pMina, pErasoa);
	}

	@Override
	public double attack(String pEraso, boolean lehena) {

		double mina = super.attack(pEraso, lehena);

		if (pEraso.equals("behe")) {
			mina *= 1.35;
		} else if (pEraso.equals("estoke")) {
			mina *= 1.1;
		}

		return mina;
	}
}
