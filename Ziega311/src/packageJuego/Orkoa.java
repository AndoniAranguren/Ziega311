package packageJuego;

public class Orkoa extends Pertsonaia {


	public Orkoa() {
		
		super.setHpMax(290);
		super.setHpCurrent(super.getHpMax());
		super.setSpeed(4);
		super.setLuck(4);
		super.setStrength(45);
		super.setPozioKopurua(3);
	}
	
	@Override
	public void hpEguneratu(double pMina, String pErasoa) {
	
		if(pErasoa.equals("behe")){
			pMina*=1.5;
			System.out.println("Eraso kritikoa!");
		}
		super.hpEguneratu(pMina, pErasoa);
	}

	@Override
	public double attack(String pEraso, boolean lehena) {
		
		double mina = super.attack(pEraso, lehena);
		
		if(pEraso.equals("goi")){
			mina*=1.25;
		}
		
		return mina;
	}
	
	
}
