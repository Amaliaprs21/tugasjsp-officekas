/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampusapp.dao;

;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import kampusapp.model.DatabaseConfig;
import kampusapp.model.Kas;

/**
 *
 * @author acer
 */


public class kampusDAOProses implements KampusDAO {

    Connection connection = null;
    ResultSet resultSet = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;

    @Override
    public List<Kas> get() {
        List<Kas> list = new ArrayList<Kas>();
        try {
            //list=new ArrayList<Mahasiswa>();
            String sql = "Select * from tbofficekas";
            connection = DatabaseConfig.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Kas mhs = new Kas();
                mhs.setId(resultSet.getInt("id"));
                mhs.setNim(resultSet.getString("nim"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setBulan(resultSet.getString("bulan"));
                mhs.setBayar(resultSet.getString("bayar"));
                list.add(mhs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean save(Kas mahasiswa) {
        boolean flag = false;
        try {
            String sql = "Insert Into tbofficekas(nama,nim,bayar,bulan) values(?,?,?,?)";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mahasiswa.getNama());
            preparedStatement.setString(2, mahasiswa.getNim());
            preparedStatement.setString(3, mahasiswa.getBayar());
            preparedStatement.setString(4, mahasiswa.getBulan());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public Kas getSinggle(int id) {
        Kas mhs = null;
        try {
            String sql = "select * from tbofficekas where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mhs = new Kas();
                mhs.setId(resultSet.getInt("id"));
                mhs.setNim(resultSet.getString("nim"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setBayar(resultSet.getString("bayar"));
                mhs.setBulan(resultSet.getString("bulan"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mhs;
    }

    @Override
    public boolean update(Kas mahasiswa) {
        boolean flag = false;
        try {
            String sql = "update tbofficekas set nama=?,nim=?,bulan=?,bayar=? where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, mahasiswa.getNama());
            preparedStatement.setString(2, mahasiswa.getNim());
            preparedStatement.setString(3, mahasiswa.getBulan());
            preparedStatement.setString(4, mahasiswa.getBayar());
            preparedStatement.setInt(5, mahasiswa.getId());
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "delete from tbofficekas where id=?";
            connection = DatabaseConfig.openConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            flag = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return flag;
    }
}
