/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kas.kelompok4.tugasbesar.entity.Pengeluaran;

/**
 *
 * @author Star Ramadhan
 */
public class TablePengeluaranModel extends AbstractTableModel {

    private List<Pengeluaran> list = new ArrayList<Pengeluaran>();

    public void setList(List<Pengeluaran>list) {
        this.list=list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    public boolean add(Pengeluaran e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public Pengeluaran get(int index) {
        return list.get(index);
    }

    public Pengeluaran set(int index, Pengeluaran element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Pengeluaran remove(int index) {
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
                return "Nomor";
            case 1:
                return "Tahun";
            case 2:
                return "Tanggal";
            case 3:
                return "Keperluan";
            case 4:
                return "Biaya";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNo_pengeluaran();
            case 1:
                return list.get(rowIndex).getTahun();
            case 2:
                return list.get(rowIndex).getTanggal();
            case 3:
                return list.get(rowIndex).getKeperluan();
            case 4:
                return list.get(rowIndex).getBiaya();
            default:
                return null;
        }
    }

}
