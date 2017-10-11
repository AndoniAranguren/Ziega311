package packageJuego;

public abstract class Objektua {
	
	//atributuak
	private String izena;
	private int hp;
	private int strength;
	private int luck;
	private int speed;
	//eraikitzaileak
	public Objektua(String pIzena, int pHp, int pStrenght, int pLuck, int pSpeed){
		this.izena=pIzena;
		this.hp=pHp;
		this.strength=pStrenght;
		this.luck=pLuck;
		this.speed=pSpeed;
	}
	//gainontzeko metodoak
	public int getHp(){
		return this.hp;
	}
	public int getStrength(){
		return this.strength;
	}
	public int getLuck(){
		return this.luck;
	}
	public int getSpeed(){
		return this.speed;
	}
	public String getIzena(){
		return this.izena;
	}
	public void aldeaInprimatu(Objektua pBerria){
		System.out.println("Bizitza Maximoa: "+String.valueOf(pBerria.getHp()-this.hp));
		System.out.println("Indarra: "+String.valueOf(pBerria.getStrength()-this.strength));
		System.out.println("Abiadura: "+String.valueOf(pBerria.getSpeed()-this.speed));
		System.out.println("Zortea: "+String.valueOf(pBerria.getLuck()-this.luck));
	}
	public void levelUp(int pLvl){
		this.speed*=1+pLvl;
		this.hp*=1+pLvl;
		this.luck*=1+pLvl;
		this.strength*=1+pLvl;
	}
}
