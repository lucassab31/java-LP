package Game;
import com.jogamp.opengl.GL2;

public class Block extends Cube3D {
	private GLHandler events;
	private float posX;
	private float posY;
	private boolean moveTop;
	private boolean moveRight;
	private final static float translate = 0.01f;
	
	public Block(float x, float y, float z, float size, boolean moveRight, GLHandler events)
	{
		super(x, y, z, size);
		this.events = events;
		
		this.posY = y;
		
		if (moveRight) {
			this.posX = 2;
		} else {
			this.posX = -2;
		}
		
		this.moveTop = true;
		this.moveRight = moveRight;
	}
	
	public void display(GL2 gl)
	{
		super.display(gl);
		
		if ( this.y <= this.posY ) {
			if ( this.x <= this.posX ) {
				if ( this.moveTop && !this.moveRight ) {
					this.posY -= 0.5f;
					this.moveTop = false;
				} else {
					this.x += Block.translate;
				}
			} else if ( this.x >= this.posX ) {
				if ( this.moveTop && this.moveRight ) {
					this.posY -= 0.5f;
					this.moveTop = false;
				} else {
					this.x -= Block.translate;
				}
			}
		} else if ( this.y >= this.posY ) {
			this.y -= Block.translate;
			
			if (this.y <= posY && !this.moveTop ) {
				this.posX = -this.posX;
				this.moveTop = true;
				this.moveRight = !this.moveRight;
			}
		}
		
		if (this.y <= -1.7f) {
			System.out.println("Vous avez perdu !");
			this.events.endGame();
		}
	}
}
