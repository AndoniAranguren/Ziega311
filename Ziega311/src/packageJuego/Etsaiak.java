package packageJuego;

import java.util.Random;

public class Etsaiak {
	//atributuak
	private String ahultasuna;
	private int strength;
	private double hp;
	private int luck;
	private int speed;
	private double maxhp;

	//eraikitzaileak
	public  Etsaiak(String pIzena,int pMota){
		if(pMota==1||pMota==0){
			this.ahultasuna="goi";
			this.strength=30;
			this.hp=120;
			this.maxhp=120;
			this.luck=7;
			this.speed=7;
		}
		else if(pMota==2){
				this.ahultasuna="behe";
				this.strength=30;
				this.hp=120;
				this.maxhp=120;
				this.luck=7;
				this.speed=7;
			}
		else if(pMota==4){
			this.ahultasuna="behe";
			this.strength=50;
			this.hp=360;
			this.maxhp=360;
			this.luck=12;
			this.speed=11;
		}
		else{
			this.ahultasuna="estoke";
			this.strength=30;
			this.hp=120;
			this.maxhp=120;
			this.luck=7;
			this.speed=7;
		}
		System.out.println("Borroka "+pIzena+"-ren aurka izango da, prepara zaitez!!");
	}



	//gainontzeko metodoak
	
	public void hpEguneratu (double pDamage, String pErasoa){//ahultasuna KONTUAN HARTUTA(ahultasuna=min gehien egiten diona)
		if(pDamage!=0.0){
			if(pDamage>0.0){
				if (this.ahultasuna.equals(pErasoa)){
					this.hp-=(pDamage*1.5);
					System.out.println("Eraso kritikoa!! "+(int)(pDamage*1.5)+" ko mina egin diozu!!");
				}
				else{
					this.hp-=pDamage;
					System.out.println((int)pDamage+" ko mina egin diozu!!");
				}
			}
			else{
				this.hp-=pDamage;
				if(this.hp>this.maxhp){
					this.hp=this.maxhp;
				}
			}
		}
	}
	
	public boolean hildaDago(){
		boolean hilda=false;
		if (this.hp<=0.0){
			hilda=true;
		}
		return hilda;
	}
	
	public double attack(String pEraso,boolean pLehena){
		// Eraso mota kontuan hartu da.
		Random rnd=new Random();
		double damage=0;
		double damMod=0.0;
		if ((int)(rnd.nextDouble()*(5+this.luck)+0)!=0){
			damMod=(rnd.nextDouble()+this.luck/100);
			if(damMod<0.5){//mina txikiegia izatea ekiditzeko
				damMod=0.5;
			}
			if(!pLehena){
				damMod*=0.75;
			}
			if (pEraso=="estoke"){
				damage=this.strength*damMod*0.8;
			}
			else if(pEraso=="behe"){
				damage=this.strength*damMod;
			}
			else if(pEraso=="goi"){
				damage=this.strength*damMod*1.3;
			}
		}
		if (pEraso=="sahies"){
			System.out.println("Txanda honetan etsaia zu sahiesten saiatuko da!");
			System.out.println(" ");
		}
		else if(pEraso=="sendatu"){}
		else if(damage==0.0) {
			System.out.println("Etsaiaren erasoak huts egin du.");
			System.out.println(" ");
		}
		return damage;
	}
	
	protected int getLuck(){
		return this.luck;
	}
	
	
	public String hautatuErasoa(){
		//jokalariaren modura, zer egin hautatzeko, randomez
		String emaitza=null;
		Random rnd=new Random();
		int hautaketa;
		hautaketa=(int)(rnd.nextDouble()*4+1);
		if(hautaketa==1){
			emaitza="goi";
		}
		else if(hautaketa==2){
			emaitza="behe";
		}
		else if(hautaketa==3){
			emaitza="estoke";
		}
		else if(hautaketa==4){
			emaitza="sahies";
		}
		return emaitza;
	}
	
	public void inprimatu(){
		System.out.println("Bizitza: "+(int)this.hp+"/"+(int)this.maxhp);
		System.out.println("Indarra: "+this.strength);
		System.out.println("Abiadura: "+this.speed);
		System.out.println("Zortea: "+this.luck);
		switch (ahultasuna){
		case "goi":
			System.out.println("Ahultasuna: "+"Goi erasoa");
			break;
		case "behe":
			System.out.println("Ahultasuna: "+"Behe erasoa");
			break;
		case "estoke":
			System.out.println("Ahultasuna: "+"Estokada");
			break;
		}
	}
	
	protected void bizitzaBete(){
		this.hp=this.maxhp;
	}
	
	protected void setAhultasuna(String pAhultasuna){
		this.ahultasuna=pAhultasuna;
	}
	
	public void levelUp(int pLvl){
			this.speed*=1+pLvl/4;
			this.maxhp*=1+pLvl/4;
			this.luck*=1+pLvl/4;
			this.strength*=1+pLvl/4;
			this.bizitzaBete();
	}

	protected int getStrength() {
		return strength;
	}

	protected double getHp() {
		return hp;
	}

	protected double getMaxhp() {
		return maxhp;
	}

	public double getSpeed() {
		return speed;
	}



	protected Object getAhultasuna() {
		return ahultasuna;
	}
		
}
