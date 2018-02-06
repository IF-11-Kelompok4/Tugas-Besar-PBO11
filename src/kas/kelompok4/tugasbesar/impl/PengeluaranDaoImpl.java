/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kas.kelompok4.tugasbesar.entity.Pengeluaran;
import kas.kelompok4.tugasbesar.error.MaskasException;
import kas.kelompok4.tugasbesar.service.PengeluaranDao;

/**
 *
 * @author Star Ramadhan
 */
public class PengeluaranDaoImpl implements PengeluaranDao {

    private Connection connection;

    private final String insertPengeluaran = "INSERT INTO tablepengeluaran(tahun,tanggal,keperluan,biaya) values"
            + "(?,?,?,?)";

    private final String updatePengeluaran = "UPDATE tablepengeluaran set tahun=?, tanggal=?, keperluan=?, biaya=? where id_pengeluaran=?";

    private final String deletePengeluaran = "DELETE FROM tablepengeluaran where id_pengeluaran=?";

    private final String getById = "Select * FROM tablepengeluaran where id_pengeluaran=?";

    private final String selectAll = "Select * From tablepengeluaran";

    public PengeluaranDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertPengeluaran(Pengeluaran pengeluaran) throws MaskasException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(insertPengeluaran,Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, pengeluaran.getTahun());
            statement.setString(2, pengeluaran.getTanggal());
            statement.setString(3, pengeluaran.getKeperluan());
            statement.setDouble(4, pengeluaran.getBiaya());
            statement.executeUpdate();
            
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()) {
                pengeluaran.setNo_pengeluaran(result.getInt(1));
            }
            
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void updatePengeluaran(Pengeluaran pengeluaran) throws MaskasException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePengeluaran);
            statement.setInt(1, pengeluaran.getTahun());
            statement.setString(2,  pengeluaran.getTanggal());
            statement.setString(3, pengeluaran.getKeperluan());
            statement.setDouble(4, pengeluaran.getBiaya());
            statement.setInt(5, pengeluaran.getNo_pengeluaran());
            statement.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public void deletePengeluaran(Integer no_pengeluaran) throws MaskasException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePengeluaran);
            statement.setInt(1, no_pengeluaran);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public Pengeluaran getPengeluaran(Integer no_pengeluaran) throws MaskasException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(getById);
            statement.setInt(1, no_pengeluaran);
            ResultSet result = statement.executeQuery();
            Pengeluaran pengeluaran = null;
            if (result.next()) {
                pengeluaran = new Pengeluaran();
                pengeluaran.setNo_pengeluaran(result.getInt("id_pengeluaran"));
                pengeluaran.setTahun(result.getInt("tahun"));
                pengeluaran.setTanggal(result.getString("tanggal"));
                pengeluaran.setKeperluan(result.getString("keperluan"));
                pengeluaran.setBiaya(result.getInt("biaya"));
            } else {
                throw new MaskasException("Data Pengeluaran Dengan Nomor " + no_pengeluaran + " Tidak Ditemukan");
            }
            connection.commit();
            return pengeluaran;
        } catch (SQLException e) {
            throw new MaskasException(e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    @Override
    public List<Pengeluaran> selectAllPengeluaran() throws MaskasException {
        Statement statement = null;
        List<Pengeluaran> list = new ArrayList<Pengeluaran>();

        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            Pengeluaran pengeluaran = null;

            while (result.next()) {
                pengeluaran = new Pengeluaran();
                pengeluaran.setNo_pengeluaran(result.getInt("id_pengeluaran"));
                pengeluaran.setTahun(result.getInt("tahun"));
                pengeluaran.setTanggal(result.getString("tanggal"));
                pengeluaran.setKeperluan(result.getString("keperluan"));
                pengeluaran.setBiaya(result.getInt("biaya"));
                list.add(pengeluaran);
            }
            connection.commit();
            return list;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                }
            }
        }
    }

}
