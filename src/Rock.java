import java.util.Timer;
import java.util.TimerTask;

public class Rock {

	//Positions et indicateur sur l'existence de la perturbation
	private int posX; 
	private int posY;
	private boolean exist;

	//Constructors
	public Rock(int x, int y)
	{
		exist=true;
		posX=x;
		posY=y;
		// Permet de faire vieillir la pierre
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				disappear();
			}
		};
		timer.schedule(task, 2000); 
	}
	
	//Getters et Setters
	public boolean exist(){
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

	
	//Mise à false de l'existence de la pierre
	public void disappear()
	{
		exist=false;
	}

}