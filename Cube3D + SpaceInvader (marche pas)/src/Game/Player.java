package Game;
import com.jogamp.opengl.GL2;

public class Player extends Cube3D {
	private final static float translate = 0.03f;
	
	public Player(float x, float y, float z, float size)
	{
		super(x, y, z, size);
	}
	
	public void display(GL2 gl)
	{
		super.display(gl);
	}
	
	public void moveRight() {
		this.x += Player.translate;
	}
	
	public void moveLeft() {
		this.x -= Player.translate;
	}
	
	public void moveTop() {
		this.y += Player.translate;
	}
	
	public void moveBottom() {
		this.y -= Player.translate;
	}
}
