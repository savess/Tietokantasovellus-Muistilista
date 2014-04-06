package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author saves
 */
public class Listaus {
    
    
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/saves";
    static final String tietokantaKayttaja = "saves";
    static final String tietokantaSalasana = "5b785d57346750a2";
    
    public Listaus(){
        
    }
    
     public Connection luoTietokantaYhteys() {

        try {
            Class.forName(JDBC_DRIVER).newInstance();
            return DriverManager.getConnection(DB_URL, tietokantaKayttaja, tietokantaSalasana);
        } catch (Exception e) {
          
            return null;
        }
    } 
     
     private void suljeYhteys(ResultSet resultset, PreparedStatement kysely, Connection conn) throws SQLException {
        resultset.close();
        kysely.close();
        conn.close();
    }
    
    /**
     *
     * @return
     */
    

    public List<Askare> listaaAskareet(String tunnus) {
         Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        ArrayList<Askare> lista = new ArrayList();
        try {
            prep = yhteys.prepareStatement("SELECT a.nimi, b.arvo, c.nimi lnimi FROM ASKARE a, TARKEYS b, LUOKKA c WHERE a.tid=b.tid and a.lid=c.lid ORDER BY b.arvo");
            ResultSet resultset = prep.executeQuery();
            while (resultset.next()) {
                String nimi = resultset.getString("nimi");
                int tarkeys = resultset.getInt("arvo");
                String luokka = resultset.getString("lnimi");
                Askare askare = new Askare(nimi, tarkeys, luokka);
                lista.add(askare);
                
            }
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return lista;
    
    
        
    }

   
    
}
