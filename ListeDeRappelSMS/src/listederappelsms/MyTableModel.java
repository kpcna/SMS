/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listederappelsms;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kpcna
 */
public class MyTableModel extends AbstractTableModel 
{
    private String[] columnNames = {"Prenom",
                        "Nom",
                        "# Cell",
                        "# jours travaillés",
                        "Contacter"};
    private Object[][] data = {
    {"Andres", "Osorio",
     "5149192869", new Integer(5), new Boolean(false)},
        {"Fred", "Hanna",
     "5146999333", new Integer(5), new Boolean(false)}
        
};

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

}
