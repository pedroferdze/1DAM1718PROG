

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;



public class Luna extends JFrame{
private JLabel l;
private JButton anterior;
private JButton siguiente;
private ImageIcon[] imagen=new ImageIcon[8];// ararid para guardar las imagens de la posicion de la luna
private String[] frases= {"Luna nueva","Luna Creciente","Cuarto Creciente", "Quinto Octante","Luna Llena",	"Tercer Octante", "Cuarto Menguante", "Luna Menguante"};//arrray y inicializacion del texto de la luna
private int posi;//posicon del array 

public Luna() {
	super("Fases de luna");
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	for (int i = 0; i < imagen.length; i++) {//recorree el array de iamgenes 
	
		imagen[i]=new ImageIcon(getClass().getResource("/img/"+i+ ".png"));
	}
	Container c=getContentPane();

	c.setBackground(Color.BLACK);//color al contenedor al contendor 
	c.setLayout(new BoxLayout(c,BoxLayout.Y_AXIS));
	c.add(l=new JLabel(frases[posi],imagen[posi],JLabel.CENTER));//alladir al contendor  el array con las frasys y imagenes , jpanel del l
	
    l.setAlignmentX(JLabel.CENTER_ALIGNMENT);
	l.setHorizontalTextPosition(JLabel.CENTER);//centrado  texto l
	l.setVerticalTextPosition(JLabel.BOTTOM);
	l.setForeground(Color.WHITE);//color de texto l 
	l.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	JPanel p=new JPanel();
	p.add(anterior=new JButton("Anterior", new ImageIcon(getClass().getResource("/img/left-arrow.png"))));//añadir el boton anteriro y imagen al panel 
anterior.setMnemonic('a');//subrallado de la letra
anterior.setEnabled(false);
anterior.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		if (posi > 0) {
			posi--;
			l.setIcon(imagen[posi]);
			l.setText(frases[posi]);
			if (posi == 0)
				anterior.setEnabled(false);
			if (!siguiente.isEnabled())
			siguiente.setEnabled(true);
		}
	}
}
);
p.add(siguiente=new JButton("Siguientes",new ImageIcon(getClass().getResource("/img/right-arrow.png"))));
siguiente.setHorizontalTextPosition(JButton.LEFT);
siguiente.setMnemonic('s');
siguiente.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (posi <7) {
			posi++;
			l.setIcon(imagen[posi]);
			l.setText(frases[posi]);
			if (posi == 7)
				siguiente.setEnabled(false);
			if (!anterior.isEnabled())
			anterior.setEnabled(true);
		}
	}
});
c.add(p);//añadimos el panel  al contenedor 
pack();
}
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Luna().setVisible(true);
			}
		});
	}
	}