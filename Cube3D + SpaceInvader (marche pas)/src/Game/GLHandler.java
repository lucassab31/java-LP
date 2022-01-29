package Game;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

public class GLHandler implements GLEventListener
{
	// Used to end the game properly
	private JFrame frame;
	private FPSAnimator animator;
	// Needed for OpenGL
	private GLU glu;
	private ArrayList<Block> blocks;
	private Player player;
	
	private boolean playerTop;
	private boolean playerBottom;
	private boolean playerLeft;
	private boolean playerRight;
	

	public GLHandler(JFrame frame, FPSAnimator animator)
	{
		this.frame = frame;
		this.animator = animator;
		this.glu = new GLU();
		this.blocks = new ArrayList<Block>(); 
		
		for (int i = 0; i < 4; i++) {
			this.blocks.add(new Block(-2 + (0.5f * i), 2 - (0.5f * i), -5, 0.2f, true, this));
		}
		
		this.player = new Player(0, -1.0f, -5, 0.18f);
	}

	@Override
	public void init(GLAutoDrawable draw) {
		GL2 gl = draw.getGL().getGL2();
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
	}
	
	@Override
	public void reshape(GLAutoDrawable draw, int x, int y, int width, int height) {
		GL2 gl = draw.getGL().getGL2();
		float aspect = (float)width / height;
		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		gl.glOrtho(0.0, 500.0, 0.0, 0.0, -1.0, 1.0);
		this.glu.gluPerspective(45.0, aspect, 0.1, 100);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	@Override
	public void display(GLAutoDrawable draw) 
	{
		GL2 gl = draw.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		
		// Move player
		if (this.playerLeft) {
			this.goLeft();
		}
		
		if (this.playerRight) {
			this.goRight();
		}
		
		if (this.playerTop) {
			this.goTop();
		}
		
		if (this.playerBottom) {
			this.goBottom();
		}
		
		// Display entities
		this.player.display(gl);
		
		for (Block e : this.blocks)
			e.display(gl);
		
		for (int j = 0; j < this.blocks.size(); j++) {
			Block e = this.blocks.get(j);
			
			if ((this.player.getX() >= e.getX() - e.getSize()/2 && this.player.getX() <= e.getX() + e.getSize()/2) && (this.player.getY() >= e.getY() - e.getSize()/2 && this.player.getY() <= e.getY() + e.getSize()/2)) {
				this.blocks.remove(j);
			}
		}
		

		if (this.blocks.size() == 0) {
			System.out.println("Vous avez gagné!");
			this.frame.dispose();
			this.animator.stop();
			System.exit(0);
		}
	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
	}
	
	public void goRight() {
		this.player.moveRight();
	}
	
	public void goLeft() {
		this.player.moveLeft();
	}
	
	public void goTop() {
		this.player.moveTop();
	}
	
	public void goBottom() {
		this.player.moveBottom();
	}

	public void playerLeft(boolean playerLeft) {
		this.playerLeft = playerLeft;
	}

	public void playerRight(boolean playerRight) {
		this.playerRight = playerRight;
	}

	public void playerTop(boolean playerTop) {
		this.playerTop = playerTop;
	}

	public void playerBottom(boolean playerBottom) {
		this.playerBottom = playerBottom;
	}
	
}
