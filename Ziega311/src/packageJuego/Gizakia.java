package packageJuego;

public class Gizakia extends Pertsonaia {
	
	public Gizakia() {
		
		super.setHpMax(270);
		super.setHpCurrent(super.getHpMax());
		super.setSpeed(6);
		super.setLuck(5);
		super.setStrength(35);
		super.setPozioKopurua(5);
	}
	
	@Override
	public void hpEguneratu(double pMina, String pErasoa) {
		
		if(pErasoa.equals("estoke")){
			pMina*=1.5;
			System.out.println("Eraso kritikoa!");
		}
		super.hpEguneratu(pMina, pErasoa);
	}
	
	@Override
	public double attack(String pEraso, boolean lehena) {
		
		double mina = super.attack(pEraso, lehena);
		
		if(pEraso.equals("behe")){
			mina*=1.15;
		} else if(pEraso.equals("estoke")){
			mina*=1.15;
		}
		
		return mina;
	}
}
