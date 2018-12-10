import java.util.Timer;
import java.util.TimerTask;

public class Food {

	private boolean isFresh;
	private int posX; 
	private int posY;
	private boolean exist;
	

	public Food()
	{
	}
	public Food(int X,int Y)
	{
		exist=true;
		isFresh=true;
		posX=X;
		posY=Y; 
		
		// Permet de faire vieillir la nourriture
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				isRotten();
			}
		};
		timer.schedule(task, 1450); 
	}

	
	public boolean isFresh()
	{
		return isFresh;
	}


	public boolean exist()
	{
		return exist;
	}

	
	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}

	
	public synchronized void isEaten(int i)
	{
		exist=false;
		System.out.println("Nourriture mangée par le pigeon "+i);
	}

	
	public void isRotten()
	{
		isFresh=false;
	}

}