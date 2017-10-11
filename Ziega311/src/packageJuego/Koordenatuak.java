package packageJuego;


public class Koordenatuak {
	
	//atributuak
	private int posX,posY; //posY balio errealaren negatiboa da, beraz operazioak hemen ez dira zuzenki logikoak
	
	//eraikitzailea
	public Koordenatuak()
	{
		posX=0;
		posY=0;
	}

	//metodoak
	public void setPos(int pPosX,int pPosY)
	{
		posX=pPosX;
		posY=pPosY;
	}
	public void mugituW()
	{
		posY--;
	}
	public void mugituS()
	{
		posY++;
	}
	public void mugituA()
	{
		posX--;
	}
	public void mugituD()
	{
		posX++;
	}
	public int getPosX()
	{
		return posX;
	}
	public int getPosY()
	{
		return posY;
	}
	public void printKoor()
	{
		System.out.print(posX);
		System.out.print(posY*(-1));
	}
}
