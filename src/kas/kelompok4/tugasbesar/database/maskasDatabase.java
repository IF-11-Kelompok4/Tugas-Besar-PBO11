/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kas.kelompok4.tugasbesar.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import kas.kelompok4.tugasbesar.impl.IuranDaoImpl;
import kas.kelompok4.tugasbesar.impl.PengeluaranDaoImpl;
import kas.kelompok4.tugasbesar.impl.WargaDaoImpl;
import kas.kelompok4.tugasbesar.service.IuranDao;
import kas.kelompok4.tugasbesar.service.PengeluaranDao;
import kas.kelompok4.tugasbesar.service.WargaDao;

/**
 *
 * @author Star Ramadhan
 */
public class maskasDatabase {

    private static Connection con;
    private static IuranDao iuranDao;
    private static WargaDao wargaDao;
    private static PengeluaranDao pengeluaranDao;

    public static Connection getConnection() throws SQLException {
        if (con == null) {

            MysqlDataSource datasource = new MysqlDataSource();
            datasource.setURL("jdbc:mysql://localhost:3306/db_maskas");
            datasource.setUser("root");
            datasource.setPassword("");
            con = datasource.getConnection();
        }
        return con;
    }

    public static IuranDao getIuranDao() throws SQLException {
        if (iuranDao == null) {
            iuranDao = new IuranDaoImpl(getConnection());
        }
        return iuranDao;
    }

    public static WargaDao getWargaDao() throws SQLException {
        if (wargaDao == null) {
            wargaDao = new WargaDaoImpl(getConnection());
        }
        return wargaDao;
    }

    public static PengeluaranDao getPengeluaranDao() throws SQLException {
        if (pengeluaranDao == null) {
            pengeluaranDao = new PengeluaranDaoImpl(getConnection());
        }
        return pengeluaranDao;
    }
}
