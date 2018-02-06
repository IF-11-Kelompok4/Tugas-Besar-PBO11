/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import kas.kelompok4.tugasbesar.entity.Iuran;

/**
 *
 * @author Star Ramadhan
 */
public class TableIuranModel extends AbstractTableModel {

    private List<Iuran> list = new ArrayList<Iuran>();

    public void setList(List<Iuran> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {

        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 15;
    }

    public boolean add(Iuran e) {
        try {
            return list.add(e);
        } finally {
            fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
        }
    }

    public Iuran get(int index) {
        return list.get(index);
    }

    public Iuran set(int index, Iuran element) {
        try {
            return list.set(index, element);
        } finally {
            fireTableRowsUpdated(index, index);
        }
    }

    public Iuran remove(int index) {
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
                return "No Iuran";
            case 1:
                return "Alamat";
            case 2:
                return "THN";
            case 3:
                return "JAN";
            case 4:
                return "FEB";
            case 5:
                return "MAR";
            case 6:
                return "APR";
            case 7:
                return "MEI";
            case 8:
                return "JUN";
            case 9:
                return "JUL";
            case 10:
                return "AGS";
            case 11:
                return "SEPT";
            case 12:
                return "OKT";
            case 13:
                return "NOV";
            case 14:
                return "DES";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getNo_iuran();
            case 1:
                return list.get(rowIndex).getNo_rumah();
            case 2:
                return list.get(rowIndex).getTahun();
            case 3:
                return list.get(rowIndex).getJan();
            case 4:
                return list.get(rowIndex).getFeb();
            case 5:
                return list.get(rowIndex).getMar();
            case 6:
                return list.get(rowIndex).getApr();
            case 7:
                return list.get(rowIndex).getMei();
            case 8:
                return list.get(rowIndex).getJun();
            case 9:
                return list.get(rowIndex).getJul();
            case 10:
                return list.get(rowIndex).getAgs();
            case 11:
                return list.get(rowIndex).getSept();
            case 12:
                return list.get(rowIndex).getOkt();
            case 13:
                return list.get(rowIndex).getNov();
            case 14:
                return list.get(rowIndex).getDes();
            default:
                return null;
        }
    }

}
