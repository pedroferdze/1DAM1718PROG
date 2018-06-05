import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class MenuEcliseEntregar extends JFrame {

	public MenuEcliseEntregar() {
		super("eclise");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(500, 500));
	
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		ImageIcon save = new ImageIcon(getClass().getResource("/img/save.png"));
		ImageIcon saveall = new ImageIcon(getClass().getResource("/img/saveall.png"));
		ImageIcon open = new ImageIcon(getClass().getResource("/img/folder.png"));
		ImageIcon saveas= new ImageIcon(getClass().getResource("/img/saveas.png"));
		ImageIcon rename= new ImageIcon(getClass().getResource("/img/rename.png"));
		ImageIcon refresh = new ImageIcon(getClass().getResource("/img/refresh.png"));
		ImageIcon print= new ImageIcon(getClass().getResource("/img/print.png"));
		ImageIcon impor= new ImageIcon(getClass().getResource("/img/import.png"));
		ImageIcon export= new ImageIcon(getClass().getResource("/img/export.png"));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menuBar.setEnabled(false);
		JMenu menu;
		
		JMenuItem menuItem;
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_S);
		menuBar.add(menu);
		
				
		AbstractAction a = new AbstractAction("New") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu New","New", JOptionPane.INFORMATION_MESSAGE);
				JMenuItem menuItem;
				JMenu submenu = null;
				menuItem = new JMenuItem("java project");
				submenu.add(menuItem);
				submenu.add(submenu);

			}
		};
		AbstractAction b = new AbstractAction("Open File") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu open file","Open file", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		AbstractAction d = new AbstractAction("Open Projects from File System",open) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu Open project","Open Projects", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		AbstractAction e = new AbstractAction("Close") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu Close","Close", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		
		AbstractAction f = new AbstractAction("Close All") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu Close all","close all", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		AbstractAction g = new AbstractAction("Save",save) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu save","Save ", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		AbstractAction h = new AbstractAction("Save as",saveas) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu save as","Save all", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		AbstractAction i = new AbstractAction("Save all",saveall) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu save all","Save all", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		AbstractAction j = new AbstractAction("Revert") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu Revert","Revert", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		AbstractAction k = new AbstractAction("Move") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu Move","Move", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		AbstractAction l = new AbstractAction("Rename",rename) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu Rename","Rename", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		AbstractAction m = new AbstractAction("Refresh",refresh) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu Refresh","Refresh", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		AbstractAction n = new AbstractAction("Convert  Line Delimite To") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu Convert","Convert", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		AbstractAction ñ = new AbstractAction("Print",print) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu Print","Print", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		AbstractAction o = new AbstractAction("Import",impor) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu Import","Import", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		AbstractAction p = new AbstractAction("Export",export) {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(MenuEcliseEntregar.this, " menu Export","Export", JOptionPane.INFORMATION_MESSAGE);
			}
		};
		
		AbstractAction q = new AbstractAction("Exit") {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
				
			}
		};
		
		menuItem = new JMenuItem(a);
		menu.add(menuItem);
		menuItem = new JMenuItem(b);
		menu.add(menuItem);
		menuItem = new JMenuItem(d);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem(e);
		menu.add(menuItem);
		menuItem = new JMenuItem(f);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem(g);
		menu.add(menuItem);
		menuItem = new JMenuItem(h);
		menu.add(menuItem);
		menuItem = new JMenuItem(i);
		menu.add(menuItem);
		menuItem = new JMenuItem(j);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem(k);
		menu.add(menuItem);
		menuItem = new JMenuItem(l);
		menuItem = new JMenuItem(m);
		menu.add(menuItem);
		menuItem = new JMenuItem(ñ);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem(o);
		menu.add(menuItem);
		menuItem = new JMenuItem(p);
		menu.add(menuItem);
		menu.addSeparator();
		menuItem = new JMenuItem(q);
		menu.add(menuItem);
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.add(a);
	toolBar.add(g);
	toolBar.add(i);
		add(toolBar, BorderLayout.NORTH);
		
		pack();
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(
			new Runnable() {
				@Override
				public void run() {
					new MenuEcliseEntregar().setVisible(true);
				}
			}
		);
	}

}
