//package packageJuego;
//
//import javazoom.jlgui.basicplayer.*;
//
//import java.io.File;
//
//public class Musika {
//	//atributuak
//	private BasicPlayer musika;
//	private static Musika nireMusika;
//
//	//Eraikitzailea(k)
//	private Musika(){
//		musika=new BasicPlayer();
//	}
//	//gainontzeko metodoak
//	public static synchronized Musika getMusika(){
//		if(nireMusika==null){
//			nireMusika=new Musika();
//		}
//		return nireMusika;
//	}
//	public void erreseteatu(){
//		nireMusika=null;
//	}
//	public void musikaAukeratu(String helbidea){
//		boolean denaOndo=false;
//		while(!denaOndo){
//			try{
//				this.musika.open(new File(helbidea));
//				if(this.musika!=null){
//					denaOndo=true;
//				}
//			}
//			catch(Exception e){
//				System.out.println("Ezin izan da musika aurkitu...");
//				helbidea=ListaMusika.getNireListaMusika().helbideaAukeratu();
//			}
//		}
//			
//	}
//	public void musikaHasieratu(){
//		boolean denaOndo=false;
//		while(!denaOndo){
//			try{
//				this.musika.play();	
//				denaOndo=true;
//			}
//			catch(Exception e){
//				System.out.println("Ezin izan da musika hasieratu!");
//			}
//		}
//	}
//	
//	public void musikaAmaitu(){
//		boolean denaOndo=false;
//		while(!denaOndo){
//			try{
//				this.musika.stop();	
//				denaOndo=true;
//			}
//			catch(Exception e){
//				System.out.println("Ezin izan da musika gelditu!");
//			}
//		}
//	}
//	public void musikaJarri(){
//		String helbidea=ListaMusika.getNireListaMusika().helbideaAukeratu();
//		boolean jarri=true;
//		try{
//			this.musikaAukeratu(helbidea);
//			}
//		catch(Exception e){
//			System.out.println("Ez dago abesti hori");
//			jarri=false;
//		}
//		if(jarri){
//			try{this.musikaHasieratu();}
//			catch(Exception e){
//				System.out.println("Ezin da musika jarri");
//			}
//		}
//		
//	}
//	public void musikaJarraitu(){
//		if(this.musika.getStatus()==2){	
//			String helbidea=ListaMusika.getNireListaMusika().helbideaAukeratu();
//			boolean jarri=true;;
//			try{
//				this.musikaAukeratu(helbidea);
//				}
//			catch(Exception e){
//				System.out.println("Ez dago abesti hori");
//				jarri=false;
//			}
//			if(jarri){
//				try{this.musikaHasieratu();}
//				catch(Exception e){
//					System.out.println("Ezin da musika jarri");
//				}
//			}
//	}
//
//	}
//}
//	