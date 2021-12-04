/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kampusapp.dao;

import java.util.List;
import kampusapp.model.Kas;

/**
 *
 * @author acer
 */
public interface KampusDAO {

    List<Kas> get();

    boolean save(Kas mahasiswa);

    Kas getSinggle(int id);

    boolean update(Kas mahasiswa);

    boolean delete(int id);
}
