/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kas.kelompok4.tugasbesar.entity.Warga;

/**
 *
 * @author Star Ramadhan
 */
public class TableWargaModel extends AbstractTableModel {

    private List<Warga> list = new ArrayList<Warga>();

    public void setList(List<Warga> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    public boolean add(Warga e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public Warga get(int index) {
        return list.get(index);
    }

    public Warga set(int index, Warga element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Warga remove(int index) {
        try {
        return list.remove(index);            
        } finally {
            fireTableRowsDeleted(index, index);
        }

    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "No Rumah";
            case 1:
                return "Nama";
            case 2:
                return "Pendapatan";
            case 3:
                return "Status";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getId_warga();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getPendapatan();
            case 3:
                return list.get(rowIndex).getStatus();
            default:
                return null;

        }
    }

}
