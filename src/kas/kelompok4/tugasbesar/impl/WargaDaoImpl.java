/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kas.kelompok4.tugasbesar.entity.Warga;
import kas.kelompok4.tugasbesar.error.MaskasException;
import kas.kelompok4.tugasbesar.service.WargaDao;

/**
 *
 * @author Star Ramadhan
 */
public class WargaDaoImpl implements WargaDao {

    private Connection Con;

    private final String insertWarga = "INSERT INTO tablewarga (no_rumah,"
            + "nama,pendapatan,status) VALUES(?,?,?,?)";

    private final String updateWarga = "UPDATE tablewarga set nama=?, "
            + "pendapatan=?, status=? WHERE no_rumah=?";

    private final String deleteWarga = "DELETE FROM tablewarga where no_rumah=?";

    private final String getById = "SELECT * FROM tablewarga WHERE no_rumah=?";

    private final String selectAll = "SELECT * FROM tablewarga";

    public WargaDaoImpl(Connection con) {
        this.Con = con;
    }

    @Override
    public void insertWarga(Warga warga) throws MaskasException {
        PreparedStatement statement = null;
        try {
            Con.setAutoCommit(false);

            statement = Con.prepareStatement(insertWarga);
            statement.setString(1, warga.getId_warga());
            statement.setString(2, warga.getNama());
            statement.setString(3, warga.getPendapatan());
            statement.setString(4, warga.getStatus());
            statement.executeUpdate();

            Con.commit();
        } catch (SQLException e) {
            try {
                Con.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                Con.setAutoCommit(true);
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
    public void updateWarga(Warga warga) throws MaskasException {
        PreparedStatement statement = null;
        try {
            Con.setAutoCommit(false);
            statement = Con.prepareStatement(updateWarga);
            statement.setString(1, warga.getNama());
            statement.setString(2, warga.getPendapatan());
            statement.setString(3, warga.getStatus());
            statement.setString(4, warga.getId_warga());
            statement.executeUpdate();
            Con.commit();
        } catch (SQLException e) {
            try {
                Con.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                Con.setAutoCommit(true);
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
    public void deleteWarga(String id_warga) throws MaskasException {
        PreparedStatement statement = null;
        try {
            Con.setAutoCommit(false);
            statement = Con.prepareStatement(deleteWarga);
            statement.setString(1, id_warga);
            statement.executeUpdate();
            Con.commit();
        } catch (SQLException e) {
            try {
                Con.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                Con.setAutoCommit(true);
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
    public Warga getWarga(String id_warga) throws MaskasException {
        PreparedStatement statement = null;
        try {
            Con.setAutoCommit(false);
            statement = Con.prepareStatement(getById);
            statement.setString(1, id_warga);
            ResultSet result = statement.executeQuery();
            Warga warga = null;
            if (result.next()) {
                warga = new Warga();
                warga.setId_warga(result.getString("no_rumah"));
                warga.setNama(result.getString("nama"));
                warga.setPendapatan(result.getString("pendapatan"));
                warga.setStatus(result.getString("status"));
            } else {
                throw new MaskasException("No Rumah " + id_warga + " Sedang Tidak ditempati");
            }
            Con.commit();
            return warga;
        } catch (SQLException e) {
            try {
                Con.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                Con.setAutoCommit(true);
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
    public List<Warga> SelectAllWarga() throws MaskasException {
        Statement statement = null;
        List<Warga> list = new ArrayList<Warga>();

        try {
            Con.setAutoCommit(false);
            statement = Con.createStatement();

            ResultSet result = statement.executeQuery(selectAll);
            Warga warga = null;

            while (result.next()) {
                warga = new Warga();
                warga.setId_warga(result.getString("no_rumah"));
                warga.setNama(result.getString("nama"));
                warga.setPendapatan(result.getString("pendapatan"));
                warga.setStatus(result.getString("status"));
                list.add(warga);
            }
            Con.commit();
            return list;
        } catch (SQLException e) {
            try {
                Con.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                Con.setAutoCommit(true);
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
