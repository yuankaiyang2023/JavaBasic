package 基础知识;
import javax.swing.*;
import java.awt.*;

/**
 * @author Administrator
 *
 */
public class BallGame extends JFrame {
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png");
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	static int a;
	public void paint(Graphics g) {
		System.out.println("被画了一次了");
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, 100, 100, null);
	}

	void launchFrame() {
		setSize(856, 500);
		setLocation(50, 50);
		setVisible(true);
	}

	public static void main(String[] args) {
		
		System.out.println(Math.pow(2, 31));
	}
}
