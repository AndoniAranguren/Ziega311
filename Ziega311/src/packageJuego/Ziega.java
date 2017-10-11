package packageJuego;


public class Ziega {
	//atributuak
	private Gela gela;
	private static Ziega nireZiega=null;
	private int kontBoss;
	private int kontPisua;
	private int kontEtsaia;
	private Misioa nireMisioa=null;
	private boolean eginda;
	//Eraikitzailea(k)
	private Ziega(){
		this.gela=new Gela();
		this.kontBoss=0;
		this.kontPisua=0;
		this.kontEtsaia=0;
		this.nireMisioa=new Misioa();
	}
	//gainontzeko metodoak
	public static synchronized Ziega getNireZiega(){
		if (Ziega.nireZiega==null){
			Ziega.nireZiega=new Ziega();
		}
		return nireZiega;
	}
	public void erreseteatu(){
		Ziega.nireZiega=null;
	}
	private boolean misioaEginda(){
		boolean eginda=this.nireMisioa.misioaEginda(this.kontBoss,this.kontEtsaia,this.kontPisua);
		return eginda;
	}
	public void gehituEtsaia(){
		this.kontEtsaia=this.kontEtsaia+1;
		this.eginda=this.misioaEginda();
	}
	public void gehituBoss(){
		this.kontBoss=this.kontBoss+1;
		this.eginda=this.misioaEginda();
	}
	public void gehituPisua(){
		this.kontPisua=this.kontPisua+1;
		this.eginda=this.misioaEginda();
		
	}
	private void partidaHasieratu() {
		ListaObjektuak.getNireListaObjektuak().erreseteatu();
		ListaObjektuak.getNireListaObjektuak().hasieratu();
		ListaMusika.getNireListaMusika().erreseteatu();
		ListaMusika.getNireListaMusika().hasieratu();
		ListaObjektuak.getNireListaObjektuak().erreseteatu();
		ListaObjektuak.getNireListaObjektuak().hasieratu();
		ListaEtsaienIzenak.getNireListaEtsaiak().erreseteatu();
		ListaEtsaienIzenak.getNireListaEtsaiak().hasieratu();
		ListaBoss.getNireListaBoss().erreseteatu();
		ListaBoss.getNireListaBoss().hasieratu();
	}
	public void jokatu() {
		
		this.partidaHasieratu();
//		Musika m1;
//		Musika.getMusika().erreseteatu();
//		m1=Musika.getMusika();
//		m1.musikaJarri();
		Ziega.getNireZiega().erreseteatu();
		Jokalaria.reset();
		Jokalaria.getJokalaria();
		Ziega.getNireZiega();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		this.gela.jokatu();
		
	}
	public boolean eginda(){
		
		return this.eginda;
		
	}
	public int getPisua(){
		return this.kontPisua;
	}
	public void misioaInprimatu(){
		nireMisioa.misioaInprimatu();
	}
}
