package academy.todot.dao;

import academy.todot.ToDo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoDaoJdbc implements TodoDao{
    private Connection yhteys;


    public ToDoDaoJdbc() throws SQLException, ClassNotFoundException {
        yhteys = DriverManager.getConnection("jdbc:postgresql://localhost:5432/todo", "postgres", " Sovelto1");
        {
            System.out.println("Yhteys saatu"); }
    }

    @Override
    public List<ToDo> naytaKaikki() {
        List<ToDo> haetut = new ArrayList<>();
        try (PreparedStatement pstmt = yhteys.prepareStatement("SELECT * FROM taskit")) {
            for (ResultSet rs = pstmt.executeQuery(); rs.next() ;) {
                ToDo taski = new ToDo();
                taski.setId(rs.getInt("id"));
                taski.setTehtava(rs.getString("tehtava"));
                haetut.add(taski);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return haetut;
    }

    @Override
    public int lisaa(@RequestBody ToDo tehtava) throws SQLException{
        String homma = tehtava.getTehtava();
        PreparedStatement paivitaDB = yhteys.prepareStatement("INSERT into taskit(tehtava) values(?)");
        paivitaDB.setString(1,homma);
        paivitaDB.executeUpdate();
        return 0;
        //lisää poikkeusilmoitus, joka tulee, jos tehtävän lisääminen ei onnistu

    }

    @Override
    public void poista(int id)throws SQLException{
        PreparedStatement paivitaDB = yhteys.prepareStatement("DELETE FROM taskit WHERE (id =?)");
        paivitaDB.setInt(1,id);
        paivitaDB.executeUpdate();
    }
    @Override
    public void tyhjennaLista() throws SQLException {
        PreparedStatement tyhjennaDB = yhteys.prepareStatement("DELETE FROM taskit");
        tyhjennaDB.executeUpdate();
    }
}
