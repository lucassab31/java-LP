package Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class UserKeyboard implements KeyListener, MouseListener
{
	
	private GLHandler events;
	
	public UserKeyboard(GLHandler events)
	{
		this.events = events;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		
		if (e.getKeyChar() == 'q')
			this.events.playerLeft(true);
		if (e.getKeyChar() == 'd')
			this.events.playerRight(true);
		if (e.getKeyChar() == 'z')
			this.events.playerTop(true);
		if (e.getKeyChar() == 's')
			this.events.playerBottom(true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() == 'q')
			this.events.playerLeft(false);
		if (e.getKeyChar() == 'd')
			this.events.playerRight(false);
		if (e.getKeyChar() == 'z')
			this.events.playerTop(false);
		if (e.getKeyChar() == 's')
			this.events.playerBottom(false);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		/*
		int x = e.getX();
		int y = e.getY();
		this.events.clickPosition(x,y);
		*/
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	
}