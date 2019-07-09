package academy.todot.dao;
import academy.todot.ToDo;

import java.sql.SQLException;
import java.util.List;

public interface TodoDao {

    List<ToDo> naytaKaikki();
    int lisaa(ToDo tehtava) throws SQLException;
    void poista(int id)throws SQLException;

}
