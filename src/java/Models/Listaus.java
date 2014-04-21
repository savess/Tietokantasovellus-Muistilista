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

// tietokanta yhteys ja sen sulkeminen sekä tietokannan muokkaukset, poistot ja lisäykset

public class Listaus {
    
    
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/saves";
    static final String tietokantaKayttaja = "saves";
    static final String tietokantaSalasana = "5b785d57346750a2";
    private int lid;
    private int tid;
    private Object selite;
    private int aid;
    private int id;
    
    public Listaus(){
        
    }
   
    // lue tietokanta yhteyden
    
     public Connection luoTietokantaYhteys() {

        try {
            Class.forName(JDBC_DRIVER).newInstance();
            return DriverManager.getConnection(DB_URL, tietokantaKayttaja, tietokantaSalasana);
        } catch (Exception e) {
          
            return null;
        }
    } 
     
     // sulkee tietokanta yhteyden
     
     private void suljeYhteys(ResultSet resultset, PreparedStatement kysely, Connection conn) throws SQLException {
        resultset.close();
        kysely.close();
        conn.close();
    }
    
    
    
     // listaa kaikki kayttajan askareet
     
    public List<Askare> listaaAskareet(String tunnus) {
        Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        ArrayList<Askare> lista = new ArrayList();
        try {
            prep = yhteys.prepareStatement("SELECT a.aid, a.nimi, b.selite, c.nimi lnimi FROM ASKARE a, TARKEYS b, LUOKKA c WHERE a.kid = (select kid from kayttaja where tunnus =?) and  a.tid=b.tid and a.lid=c.lid ORDER BY b.arvo DESC");
           prep.setString(1, tunnus);
           ResultSet resultset = prep.executeQuery();
            while (resultset.next()) {
                
                int aid = resultset.getInt("aid");
                String nimi = resultset.getString("nimi");
                String tarkeys = resultset.getString("selite");
                String luokka = resultset.getString("lnimi");
                
                Askare askare = new Askare(aid, nimi, tarkeys, luokka);
                lista.add(askare);
                
            }
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return lista;
    
    
        
    }

   // palauttaa tietyn askareen tiedot
    
    public ArrayList<Askare> etsiAskare(int id) {
         Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep=null;
        ArrayList<Askare> lista = new ArrayList();
        try {
            prep = yhteys.prepareStatement("SELECT a.aid, a.nimi, b.selite, c.nimi lnimi FROM ASKARE a, TARKEYS b, LUOKKA c WHERE a.aid=? and a.tid=b.tid and a.lid=c.lid ORDER BY b.arvo LIMIT 1");
            prep.setInt(1, id);
            ResultSet resultset = prep.executeQuery();
            while (resultset.next()) {
                int aid = resultset.getInt("aid");
                String nimi = resultset.getString("nimi");
                String tarkeys = resultset.getString("selite");
                String luokka = resultset.getString("lnimi");
                Askare askare = new Askare(aid, nimi, tarkeys, luokka);
                lista.add(askare);
                
            }
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return lista;
    
    
       
        
    }
    
    // listaa kaikki luokat
    
      public List<Luokka> listaaLuokat(String tunnus) {
         Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        ArrayList<Luokka> lista = new ArrayList();
        try {
            prep = yhteys.prepareStatement("SELECT a.lid, a.nimi, a.kid, b.tunnus, b.nimi knimi FROM LUOKKA a, KAYTTAJA b WHERE a.kid=b.kid ORDER BY a.nimi");
            ResultSet resultset = prep.executeQuery();
            while (resultset.next()) {
                int lid = resultset.getInt("lid");
                String nimi = resultset.getString("nimi");
                int kid = resultset.getInt("kid");
                String knimi = resultset.getString("knimi");
                
                Luokka luokka = new Luokka(lid, nimi, kid, knimi);
                lista.add(luokka);
                
            }
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return lista;
    
    
        
    }

   // palauttaa tietyn luokan tiedot
      
    public ArrayList<Luokka> etsiLuokka(int id) {
         Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep=null;
        ArrayList<Luokka> lista = new ArrayList();
        try {
            prep = yhteys.prepareStatement("SELECT a.lid, a.nimi, a.kid, b.tunnus, b.nimi knimi FROM LUOKKA a, KAYTTAJA b WHERE a.lid=? and a.kid=b.kid ORDER BY a.nimi LIMIT 1");
            prep.setInt(1, id);
            ResultSet resultset = prep.executeQuery();
            while (resultset.next()) {
                int lid = resultset.getInt("lid");
                String nimi = resultset.getString("nimi");
                int kid = resultset.getInt("kid");
                String knimi = resultset.getString("knimi");
                
                Luokka luokka = new Luokka(lid, nimi, kid, knimi);
                lista.add(luokka);
                
            }
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return lista;
    
    
       
        
    }
    
    // listaa kaikki tärkeydet
    
    public List<Tarkeys> listaaTarkeys(String tunnus) {
         Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        ArrayList<Tarkeys> lista = new ArrayList();
        try {
            prep = yhteys.prepareStatement("SELECT a.tid, a.arvo, a.selite, b.tunnus, b.nimi knimi, b.kid FROM TARKEYS a, KAYTTAJA b WHERE a.kid=b.kid ORDER BY a.arvo");
            ResultSet resultset = prep.executeQuery();
            while (resultset.next()) {
                String arvo = resultset.getString("arvo");
                String selite = resultset.getString("selite");
                int tid = resultset.getInt("tid");
                String knimi = resultset.getString("knimi");
                int kid = resultset.getInt("kid");
                
                Tarkeys tarkeys = new Tarkeys(selite, arvo, knimi, tid, kid);
                lista.add(tarkeys);
                
            }
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return lista;
    
    
        
    }

   // palauttaa tietyn tärkyden tiedot
    
    public ArrayList<Tarkeys> etsiTarkeys(int id) {
         Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep=null;
        ArrayList<Tarkeys> lista = new ArrayList();
        try {
            prep = yhteys.prepareStatement("SELECT a.tid, a.arvo, a.selite, b.tunnus, b.nimi knimi, b.kid FROM TARKEYS a, KAYTTAJA b WHERE a.tid=? and a.kid=b.kid ORDER BY a.tid LIMIT 1");
            prep.setInt(1, id);
            ResultSet resultset = prep.executeQuery();
            while (resultset.next()) {
                String arvo = resultset.getString("arvo");
                String selite = resultset.getString("selite");
                int tid = resultset.getInt("tid");
                String knimi = resultset.getString("knimi");
                int kid = resultset.getInt("kid");
                
                Tarkeys tarkeys = new Tarkeys(selite, arvo, knimi, tid, kid);
                lista.add(tarkeys);
                
            }
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return lista;
    
    
       
        
    }
    
    // lisää luokan 
    
    public Object lisaaLuokka (String nimi, String tunnus) {
        Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        try {
            prep = yhteys.prepareStatement("INSERT INTO LUOKKA(NIMI, KID) VALUES (?,(select kid from kayttaja where tunnus = ? limit 1)) RETURNING LID");
            prep.setString(1, nimi);
            
            
            prep.setString(2, tunnus);
            
            ResultSet ids = prep.executeQuery();
               

 
                   this.lid = ids.getInt(1);
            
            
            prep.executeUpdate(); 
            prep.close();
            yhteys.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return nimi;
    }
    
    
   
    //muokkaa luokkaa
    
    public Object muokkaaLuokkaa(String nimi, int id) {
        
        Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep=null;
       
        try {
            prep = yhteys.prepareStatement("UPDATE LUOKKA SET NIMI=? WHERE LID=? ");
            prep.setString(1, nimi);
            prep.setInt(2, id);
            ResultSet resultset = prep.executeQuery();
            
            prep.executeUpdate();
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return nimi;
        
    }
    
    // poistaa luokan
    
    public Object poistaLuokka(int id) {
        
        Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep=null;
       
        try {
            prep = yhteys.prepareStatement("DELETE FROM LUOKKA WHERE lid=? ");
            
            prep.setInt(1, id);
            ResultSet resultset = prep.executeQuery();
            
            prep.executeUpdate();
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return id;
        
    }
    
    // lisää tärkyden

    public Object lisaaTarkeys(String arvo, String selite, String tunnus) {
         Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        try {
            prep = yhteys.prepareStatement("INSERT INTO TARKEYS(ARVO, SELITE, KID) VALUES (?,?,(select kid from kayttaja where tunnus=?)) RETURNING TID");
            prep.setString(1, arvo);
                
            prep.setString(2, selite);
            prep.setString(3, tunnus);
            
            ResultSet ids = prep.executeQuery();
               
                   this.tid = ids.getInt(1);
            
       
            prep.executeUpdate(); 
            prep.close();
            yhteys.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       return arvo + selite;
    }
    
    // poistaa tärkyden

    public Object poistaTarkeys(int id) {
          Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep=null;
       
        try {
            prep = yhteys.prepareStatement("DELETE FROM TARKEYS WHERE tid=? ");
            
            prep.setInt(1, id);
            ResultSet resultset = prep.executeQuery();
            
            prep.executeUpdate();
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return id;
        
    }
    
    // muokkaa tärkeyttä

    public Object muokkaaTarkeytta(String arvo, String selite, int id) {
       Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep=null;
       
        try {
            prep = yhteys.prepareStatement("UPDATE TARKEYS SET ARVO=?, SELITE=? WHERE TID=? ");
            prep.setString(1, arvo);
            prep.setString(2, selite);
            prep.setInt(3, id);
            ResultSet resultset = prep.executeQuery();
            
            prep.executeUpdate();
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return arvo + selite;
        
    }
    
    // poistaa askareen

    public Object poistaAskare(int id) {
    Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep=null;
       
        try {
            prep = yhteys.prepareStatement("DELETE FROM ASKARE WHERE aid=? ");
            
            prep.setInt(1, id);
            ResultSet resultset = prep.executeQuery();
            
            prep.executeUpdate();
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
         }
        return id;
        
    }
    
    // lisää askareen 

    public Object lisaaAskare(String nimi, int tarkeysid, int luokkaid, String tunnus) {
        Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        try {
            prep = yhteys.prepareStatement("INSERT INTO ASKARE(NIMI, TID, LID, KID) VALUES (?,?,?,(select kid from kayttaja where tunnus = ?)) RETURNING AID");
            prep.setString(1, nimi);
                
           prep.setInt(2, tarkeysid);
            prep.setInt(3, luokkaid);
           prep.setString(4, tunnus);
            
            ResultSet ids = prep.executeQuery();
               
             this.aid = ids.getInt(1);
            
       
            prep.executeUpdate(); 
            prep.close();
            yhteys.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       return nimi + tarkeysid + luokkaid;
    }
    
    // lisää askareen

    public Object lisaaAskare(String nimi, String tarkeysselite, String luokkanimi, int i) {
         Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        try {
            prep = yhteys.prepareStatement("INSERT INTO ASKARE(NIMI, TID, LID, KID) VALUES (?,(select tid from tarkeys where selite =? ),(select lid from luokka where nimi = ?),1) RETURNING AID");
            prep.setString(1, nimi);
                
           prep.setString(2, tarkeysselite);
            prep.setString(3, luokkanimi);
         
            
            ResultSet ids = prep.executeQuery();
               
             this.aid = ids.getInt(1);
            
       
            prep.executeUpdate(); 
            prep.close();
            yhteys.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       return nimi + tarkeysselite + luokkanimi;
    }

    // muokkaa askaretta
    
    public Object muokkaaAskaretta(String nimi, int tarkeysid, int luokkaid, int id) {
        Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep=null;
       
        try {
            prep = yhteys.prepareStatement("UPDATE ASKARE SET NIMI=?, tid=?, lid=? WHERE AID=? ");
            prep.setString(1, nimi);
            prep.setInt(2, tarkeysid);
            prep.setInt(3, luokkaid);
            prep.setInt(4, id);
            ResultSet resultset = prep.executeQuery();
            
            prep.executeUpdate();
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return nimi;
        
    }
    
    // palauttaa tietyn käyttäjän tiedot

    public Object etsiKayttaja(String ktunnus) {
        Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep=null;
        ArrayList<Kayttaja> lista = new ArrayList();
        try {
            prep = yhteys.prepareStatement("select a.tunnus, a.salasana, a.nimi, a.kid, count(b.aid) acount from kayttaja a, askare b where tunnus = ? and a.kid=b.kid group by 1,2,3,4");
            prep.setString(1, ktunnus);
            ResultSet resultset = prep.executeQuery();
            while (resultset.next()) {
                
                String tunnus = resultset.getString("tunnus");
                String nimi = resultset.getString("nimi");
                 String salasana = resultset.getString("salasana");
                  int kid = resultset.getInt("kid");
                   int acount  = resultset.getInt("acount");
                
               Kayttaja kayttaja = new Kayttaja(tunnus, salasana, nimi, kid, acount);
                lista.add(kayttaja);
                
            }
            suljeYhteys(resultset, prep, yhteys);
        } catch (SQLException ex) {
        }
        return lista;
    }
    }
    

