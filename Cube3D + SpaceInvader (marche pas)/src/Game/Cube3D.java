package Game;
import com.jogamp.opengl.GL2;

public class Cube3D extends Shape3D
{
	private double angle;
	protected Color3D color;
	
	public Cube3D(float x, float y, float z, float size)
	{
		this.x = x; this.y = y; this.z = z;
		this.size = size;
		this.angle = 0;
		this.color = new Color3D(1, 1, 1);
	}
	
	public void display(GL2 gl)
	{
		gl.glPushMatrix();
		gl.glTranslatef(x, y, z);
		gl.glScalef(size, size, size);
		gl.glRotated(angle, 1, 1, 1);
		gl.glBegin(GL2.GL_QUADS);
		// Front
		gl.glColor3f(1f,0f,0f); //red color
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, 1, 1);
		gl.glVertex3d(-1, 1, 1);
		// Rear
		gl.glColor3f( 0f,1f,0f ); //green color
		gl.glVertex3d(-1, -1, -1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(1, 1, -1);
		gl.glVertex3d(-1, 1, -1);
		// Left
		gl.glColor3f( 0f,0f,1f ); //blue color
		gl.glVertex3d(-1, -1, -1);
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(-1, 1,  1);
		gl.glVertex3d(-1, 1, -1);
		// Right
		gl.glColor3f( 1f,1f,0f ); //yellow (red + green)
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, 1,  1);
		gl.glVertex3d(1, 1, -1);
		// Bottom
		gl.glColor3f( 1f,0f,1f ); //purple (red + green)
		gl.glVertex3d(-1, -1, 1);
		gl.glVertex3d(1, -1, 1);
		gl.glVertex3d(1, -1, -1);
		gl.glVertex3d(-1, -1, -1);
		// Up
		 gl.glColor3f( 0f,1f, 1f ); //sky blue (blue +green);
		gl.glVertex3d(-1, 1, 1);
		gl.glVertex3d(1, 1, 1);
		gl.glVertex3d(1, 1, -1);
		gl.glVertex3d(-1, 1, -1);
		gl.glEnd();	
		gl.glPopMatrix();
		
		this.angle += 0.5;
	}
}
