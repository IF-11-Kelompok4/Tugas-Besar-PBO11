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
import kas.kelompok4.tugasbesar.entity.Iuran;
import kas.kelompok4.tugasbesar.error.MaskasException;
import kas.kelompok4.tugasbesar.service.IuranDao;
import kas.kelompok4.tugasbesar.view.iuranPanel;

/**
 *
 * @author Star Ramadhan
 */
public class IuranDaoImpl implements IuranDao {

    private Connection con;

    private final String insertIuran = "INSERT INTO tableiuran (no_rumah,tahun,jan,feb,mar,apr,mei,jun,jul,ags,sept,okt,nov,des,jumlah)"
            + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,(jan+feb+mar+apr+mei+jun+jul+ags+sept+okt+nov+des))";

    private final String updateIuran = "UPDATE tableiuran set jan=?,feb=?,"
            + "mar=?,apr=?,mei=?,jun=?,jul=?,ags=?,sept=?,okt=?,nov=?,des=?,jumlah=(jan+feb+mar+apr+mei+jun+jul+ags+sept+okt+nov+des) Where no_iuran=?";

//    private final String updateJan = "Update tableiuran set jan=? where no_iuran=?";
//    private final String updateFeb = "Update tableiuran set feb=? where no_iuran=?";
//    private final String updatemar = "Update tableiuran set mar=? where no_iuran=?";
//    private final String updateApr = "Update tableiuran set apr=? where no_iuran=?";
//    private final String updateMei = "Update tableiuran set mei=? where no_iuran=?";
//    private final String updateJun = "Update tableiuran set jun=? where no_iuran=?";
//    private final String updateJul = "Update tableiuran set jul=? where no_iuran=?";
//    private final String updateAgs = "Update tableiuran set ags=? where no_iuran=?";
//    private final String updateSept = "Update tableiuran set sept=? where no_iuran=?";
//    private final String updateOkt = "Update tableiuran set okt=? where no_iuran=?";
//    private final String updateNov = "Update tableiuran set nov=? where no_iuran=?";
//    private final String updateDes = "Update tableiuran set des=? where no_iuran=?";

    private final String deleteIuran = "DELETE from tableiuran where no_iuran=?";

    private final String getById = "Select * from tableiuran where no_iuran=?";

    private final String selectAll = "Select * from tableiuran ORDER by no_rumah ASC";

    public IuranDaoImpl(Connection con) {
        this.con = con;
    }

    @Override
    public void insertIuran(Iuran iuran) throws MaskasException {
        PreparedStatement statement = null;
        try {
            con.setAutoCommit(false);
            statement = con.prepareStatement(insertIuran, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, iuran.getNo_rumah());
            statement.setInt(2, iuran.getTahun());
            statement.setInt(3, iuran.getJan());
            statement.setInt(4, iuran.getFeb());
            statement.setInt(5, iuran.getMar());
            statement.setInt(6, iuran.getApr());
            statement.setInt(7, iuran.getMei());
            statement.setInt(8, iuran.getJun());
            statement.setInt(9, iuran.getJul());
            statement.setInt(10, iuran.getAgs());
            statement.setInt(11, iuran.getSept());
            statement.setInt(12, iuran.getOkt());
            statement.setInt(13, iuran.getNov());
            statement.setInt(14, iuran.getDes());
            statement.executeUpdate();
            ResultSet result = statement.getGeneratedKeys();

            if (result.next()) {
                iuran.setNo_iuran(result.getInt(1));
            }

            con.commit();

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                con.setAutoCommit(true);
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
    public void updateIuran(Iuran iuran) throws MaskasException {
        PreparedStatement statement = null;
        try {
            con.setAutoCommit(false);
            statement = con.prepareStatement(updateIuran);
            statement.setInt(1, iuran.getJan());
            statement.setInt(2, iuran.getFeb());
            statement.setInt(3, iuran.getMar());
            statement.setInt(4, iuran.getApr());
            statement.setInt(5, iuran.getMei());
            statement.setInt(6, iuran.getJun());
            statement.setInt(7, iuran.getJul());
            statement.setInt(8, iuran.getAgs());
            statement.setInt(9, iuran.getSept());
            statement.setInt(10, iuran.getOkt());
            statement.setInt(11, iuran.getNov());
            statement.setInt(12, iuran.getDes());
            statement.setInt(13, iuran.getNo_iuran());
            statement.executeUpdate();
            con.commit();

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException("Data No rumah dengan Tahun Ini Sudah Ada!");
        } finally {
            try {
                con.setAutoCommit(true);
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
    public void deleteIuran(Integer no_iuran) throws MaskasException {
        PreparedStatement statement = null;
        try {
            con.setAutoCommit(false);
            statement = con.prepareStatement(deleteIuran);
            statement.setInt(1, no_iuran);
            statement.executeUpdate();
            con.commit();

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                con.setAutoCommit(true);
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
    public Iuran getIuran(Integer no_iuran) throws MaskasException {
        PreparedStatement statement = null;
        try {
            con.setAutoCommit(false);
            statement = con.prepareStatement(getById);
            statement.setInt(1, no_iuran);

            ResultSet result = statement.executeQuery();
            Iuran iuran = null;

            if (result.next()) {
                iuran = new Iuran();;
                iuran.setNo_iuran(result.getInt("no_iuran"));
                iuran.setNo_rumah(result.getString("no_rumah"));
                iuran.setTahun(result.getInt("tahun"));
                iuran.setJan(result.getInt("jan"));
                iuran.setFeb(result.getInt("feb"));
                iuran.setMar(result.getInt("mar"));
                iuran.setApr(result.getInt("apr"));
                iuran.setMei(result.getInt("mei"));
                iuran.setJun(result.getInt("jun"));
                iuran.setJul(result.getInt("jul"));
                iuran.setAgs(result.getInt("ags"));
                iuran.setSept(result.getInt("sept"));
                iuran.setOkt(result.getInt("okt"));
                iuran.setNov(result.getInt("nov"));
                iuran.setDes(result.getInt("des"));
                iuran.setJml(result.getInt("jumlah"));
            } else {
                throw new MaskasException("Iuran Dengan Nomor " + no_iuran + " Tidak Ditemukan");
            }
            con.commit();
            return iuran;

        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
            }
            throw new MaskasException(e.getMessage());
        } finally {
            try {
                con.setAutoCommit(true);
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
    public List<Iuran> selecAllIuran() throws MaskasException {
        Statement statement = null;
        List<Iuran> list = new ArrayList<Iuran>();

        try {
            con.setAutoCommit(false);
            statement = con.createStatement();
            ResultSet result = statement.executeQuery(selectAll);
            Iuran iuran = null;
            while (result.next()) {
                iuran = new Iuran();
                iuran.setNo_iuran(result.getInt("no_iuran"));
                iuran.setNo_rumah(result.getString("no_rumah"));
                iuran.setTahun(result.getInt("tahun"));
                iuran.setJan(result.getInt("jan"));
                iuran.setFeb(result.getInt("feb"));
                iuran.setMar(result.getInt("mar"));
                iuran.setApr(result.getInt("apr"));
                iuran.setMei(result.getInt("mei"));
                iuran.setJun(result.getInt("jun"));
                iuran.setJul(result.getInt("jul"));
                iuran.setAgs(result.getInt("ags"));
                iuran.setSept(result.getInt("sept"));
                iuran.setOkt(result.getInt("okt"));
                iuran.setNov(result.getInt("nov"));
                iuran.setDes(result.getInt("des"));
                iuran.setJml(result.getInt("jumlah"));
                list.add(iuran);
            }
            con.commit();
            return list;
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

//    @Override
//    public void updateJan(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updateJan);
//            statement.setInt(1, iuran.getJan());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException(e.getMessage());
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//
//    @Override
//    public void updateFeb(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updateFeb);
//            statement.setInt(1, iuran.getFeb());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException("Data Sudah Ada!");
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//
//    @Override
//    public void updateMar(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updatemar);
//            statement.setInt(1, iuran.getMar());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException("Data Sudah Ada!");
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//
//    @Override
//    public void updateApr(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updateApr);
//            statement.setInt(1, iuran.getApr());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException("Data Sudah Ada!");
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//
//    @Override
//    public void updateMei(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updateMei);
//            statement.setInt(1, iuran.getMei());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException("Data Sudah Ada!");
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//
//    @Override
//    public void updateJun(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updateJun);
//            statement.setInt(1, iuran.getJun());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException("Data Sudah Ada!");
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//
//    @Override
//    public void updateJul(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updateJul);
//            statement.setInt(1, iuran.getJul());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException("Data Sudah Ada!");
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//
//    @Override
//    public void updateAgs(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updateAgs);
//            statement.setInt(1, iuran.getAgs());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException("Data Sudah Ada!");
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//
//    @Override
//    public void updateSept(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updateSept);
//            statement.setInt(1, iuran.getSept());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException("Data Sudah Ada!");
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//
//    @Override
//    public void updateOkt(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updateOkt);
//            statement.setInt(1, iuran.getOkt());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException("Data Sudah Ada!");
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//
//    @Override
//    public void updateNov(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updateNov);
//            statement.setInt(1, iuran.getNov());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException("Data Sudah Ada!");
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }
//
//    @Override
//    public void updateDes(Iuran iuran) throws MaskasException {
//        PreparedStatement statement = null;
//        try {
//            con.setAutoCommit(false);
//            statement = con.prepareStatement(updateDes);
//            statement.setInt(1, iuran.getDes());
//            statement.setInt(2, iuran.getNo_iuran());
//            statement.executeUpdate();
//            con.commit();
//        } catch (SQLException e) {
//            try {
//                con.rollback();
//            } catch (SQLException ex) {
//            }
//            throw new MaskasException("Data Sudah Ada!");
//        } finally {
//            try {
//                con.setAutoCommit(true);
//            } catch (SQLException ex) {
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                }
//            }
//        }
//    }

}
