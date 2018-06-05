import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Frame extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1L;
	Dimension max;
	Dimension min;
	JTable tabla;
	JButton agregar;
	JButton eliminar;
	JButton limpiar;
	JButton guardar;
	JTextField modelo;
	JTextField potencia;
	JComboBox<String> marca;
	JComboBox<String> motor;
	JLabel mar;
	JLabel mode;
	JLabel moto;
	JLabel pote;
	

	public Frame() {
		super("Lista Vehiculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

		mar = new JLabel("Marca: ");
		p.add(mar);;//añadir etiqueta  marca

		marca = new JComboBox<String>();
		max = marca.getMaximumSize();
		min = marca.getMinimumSize();
		marca.setMaximumSize(new Dimension(max.width, min.height));
		marca.addActionListener(this);
		marca.setActionCommand("marca");
		marca.setEditable(false);//no puede escribir no es editable
		marca.setFocusable(true);
		p.add(marca);//añadir al panel

		
		mode = new JLabel("Modelo: ");
		p.add(mode);

		modelo = new JTextField(" ");
		modelo.setEditable(true);
		max = modelo.getMaximumSize();
		min = modelo.getMinimumSize();
		modelo.setMaximumSize(new Dimension(max.width, min.height));
		p.add(modelo);

		moto = new JLabel("Motor: ");
		p.add(moto);
		motor = new JComboBox<String>();
		max = motor.getMaximumSize();
		min = motor.getMinimumSize();
		motor.setMaximumSize(new Dimension(max.width, min.height));
		motor.addActionListener(this);
		motor.setActionCommand("motor");
		motor.setEditable(false);
		motor.addItem("Gasolina");//añadir a la lisa
		motor.addItem("Diesel");
		motor.addItem("Hibrido");
		motor.addItem("Eléctrico");
		p.add(motor);

		pote = new JLabel("Potencia: ");
		p.add(pote);

		potencia = new JTextField( );
		potencia.setEditable(true);
		max = potencia.getMaximumSize();
		min = potencia.getMinimumSize();
		potencia.setMaximumSize(new Dimension(max.width, min.height));
		p.add(potencia);

		JPanel q = new JPanel();
		q.setLayout(new BoxLayout(q, BoxLayout.X_AXIS));

		agregar = new JButton("Agregar");
		agregar.addActionListener(this);
		agregar.setActionCommand("agregar");
		agregar.setFocusable(false);
		q.add(agregar);

		eliminar = new JButton("Eliminar");
		eliminar.addActionListener(this);
		eliminar.setActionCommand("eliminar");
		eliminar.setFocusable(false);
		q.add(eliminar);

		limpiar = new JButton("Limpiar");
		limpiar.addActionListener(this);
		limpiar.setActionCommand("limpiar");
		limpiar.setFocusable(false);
		q.add(limpiar);

		guardar = new JButton("Guardar");
		guardar.addActionListener(this);
		guardar.setActionCommand("guardar");
		guardar.setFocusable(false);
		q.add(guardar);

		tabla = new JTable(new DefaultTableModel(new String[] { "Marca", "Modelo", "Motor", "Potencia" }, 0));
		tabla.setFillsViewportHeight(true);
		c.add(p);//añadir el panel al contendor
		c.add(q);
		c.add(new JScrollPane(tabla));
		leerFichero();
		pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("agregar")) {
			if(!modelo.getText().trim().equals("") && !potencia.getText().trim().equals("")) {
			Object[] row= {marca.getSelectedItem(),modelo.getText(),motor.getSelectedItem(),potencia.getText()};
			((DefaultTableModel)tabla.getModel()).addRow(row);
			}else {
				JOptionPane.showMessageDialog(null, " añadadir campos","mensaje",JOptionPane.ERROR_MESSAGE);
			}
		} else if (actionCommand.equals("eliminar")) {
			if(tabla.getSelectedRow()>=0) {
				((DefaultTableModel)tabla.getModel()).removeRow(tabla.getSelectedRow());
			}else {
				JOptionPane.showMessageDialog(null, " seleccione una columna","mensaje",JOptionPane.WARNING_MESSAGE);
			}

		} else if (actionCommand.equals("limpiar")) {
			if(!modelo.getText().trim().equals("") && !potencia.getText().trim().equals("")) {
				modelo.setText(null);
				potencia.setText(null);
				
			}else {
				JOptionPane.showMessageDialog(null, "  limpiar","mensaje",JOptionPane.WARNING_MESSAGE);
			}

		} else if (actionCommand.equals("guardar")) {
			guardarLista();
		}
	}
	
	
	private void guardarLista() {
		JFileChooser gl = new JFileChooser();
		int resultado = gl.showSaveDialog(this);
		if (resultado == JFileChooser.APPROVE_OPTION) {
			BufferedOutputStream out = null;
			try {
				out =  new BufferedOutputStream(new FileOutputStream("Tabla.txt"));
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}finally {
				if (out != null)
					try {
						out.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
		}
	}
	

	private void leerFichero() {
		BufferedReader ler = null;

		try {
			ler = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/marcas.txt")));

			System.out.println(" marcas.txt");
			String linea;
			while ((linea = ler.readLine()) != null)
				marca.addItem(linea);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != ler) {
					ler.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
