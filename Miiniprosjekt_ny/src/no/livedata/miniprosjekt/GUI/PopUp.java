package no.livedata.miniprosjekt.GUI;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;

import no.livedata.miniprosjekt.model.TabModel;

public class PopUp extends JPopupMenu {
	static JTable table;
	TabModel dataModel;
	Point openAt;
	
	public PopUp (final Component com, JTable table, final TabModel dataModel) {
		this.table = table;
		this.dataModel = dataModel;
		JMenuItem optItem = new JMenuItem("Egenskaper");
        optItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dataModel.getRow(getRow()).showProp();
            }
        });
        add(optItem);
        
        JMenuItem deleteItem = new JMenuItem("Delete");
        deleteItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dataModel.delete(getRow());
            }
        });
        add(deleteItem);
	}
	
	@Override
    public void show(Component c, int x, int y) {
		openAt = new Point(x,y);
        super.show(c, x, y);
    }
	
	public int getRow() {
		return table.rowAtPoint(openAt);
	}
}
