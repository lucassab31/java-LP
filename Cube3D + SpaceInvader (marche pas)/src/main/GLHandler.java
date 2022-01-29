package main;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;

public class GLHandler implements GLEventListener
{
	
	private GLU glu;
	private float angle;
	private float posX, posY;
	private ArrayList<Shape3D> items3D;
	
	public GLHandler()
	{
		this.glu = new GLU();
		this.angle = 0;
		this.items3D = new ArrayList<Shape3D>();
		this.items3D.add(new Cube3D(0, 0, -5, 0.5f));
		this.items3D.add(new Cube3D(0, 3, -5, 0.3f));
		this.items3D.add(new Cube3D(1, -2, -2, 0.1f));
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
		gl.glTranslatef(this.posX, this.posY, -0.01f);
		for (Shape3D s : this.items3D) {
			s.display(gl);
		}
		this.angle += 0.5;
	}

	public void goRight() { this.posX += 0.1f; }
	public void goLeft() { this.posX -= 0.1f; }
	public void goDown() { this.posY -= 0.1f; }
	public void goUp() { this.posY += 0.1f; }

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub
	}
}