package iterator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test extends JFrame{
	   private static final long serialVersionUID = 1L;
	   private Controller controller = new Controller(new Accelerator());
	   private JLabel label=new JLabel("0 mph");
	   private JButton accelerateButton=new JButton("Accelerate");
	   private JButton deaccelerateButton=new JButton("Deaccelerate");

	   public Test(){
	      accelerateButton.addActionListener(new ButtonHandler());
	      deaccelerateButton.addActionListener(new ButtonHandler());
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      this.setSize(400, 100);
	      this.getContentPane().setLayout(new FlowLayout());
	      this.getContentPane().add(label);
	      this.getContentPane().add(accelerateButton);
	      this.getContentPane().add(deaccelerateButton);
	      this.setVisible(true);
	   }

	   public static void main(String[] args) {
	      new Test();
	   }
	   public class ButtonHandler implements ActionListener{

		      @Override
		      public void actionPerformed(ActionEvent e) {
		         if(e.getActionCommand()=="Accelerate"){
		            label.setText(controller.paddleDown()+ " mph");
		         }else{
		            label.setText(controller.paddleUp()+ " mph");
		         }

		      }

		   }

		
}