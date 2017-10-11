package packageJuego;

public class Elfoa extends Pertsonaia {
	
	public Elfoa() {
		
		super.setHpMax(240);
		super.setHpCurrent(super.getHpMax());
		super.setSpeed(9);
		super.setLuck(4);
		super.setStrength(30);
		super.setPozioKopurua(5);
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
	public double attack(String pEraso, boolean pLehena) {
		
		double mina = super.attack(pEraso, pLehena);
		
		if(pEraso.equals("goi")){
			mina*=1.25;
		} else if(pEraso.equals("estoke")){
			mina*=1.15;
		}
		
		return mina;
	}
}
