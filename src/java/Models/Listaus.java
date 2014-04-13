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
    private int lid;
    private int tid;
    private Object selite;
    private int aid;
    
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
    
    
    

    public List<Askare> listaaAskareet(String tunnus) {
         Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        ArrayList<Askare> lista = new ArrayList();
        try {
            prep = yhteys.prepareStatement("SELECT a.aid, a.nimi, b.selite, c.nimi lnimi FROM ASKARE a, TARKEYS b, LUOKKA c WHERE a.tid=b.tid and a.lid=c.lid ORDER BY b.arvo DESC");
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
    
    
    public Object lisaaLuokka (String nimi, int kid) {
        Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        try {
            prep = yhteys.prepareStatement("INSERT INTO LUOKKA(NIMI, KID) VALUES (?,?) RETURNING LID");
            prep.setString(1, nimi);
            
            
            prep.setInt(2, kid);
            
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

    public Object lisaaTarkeys(String arvo, String selite, int kid) {
         Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        try {
            prep = yhteys.prepareStatement("INSERT INTO TARKEYS(ARVO, SELITE, KID) VALUES (?,?,?) RETURNING TID");
            prep.setString(1, arvo);
                
            prep.setString(2, selite);
            prep.setInt(3, kid);
            
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

    public Object lisaaAskare(String nimi, String selite, String lnimi, int kid) {
        Connection yhteys = luoTietokantaYhteys();
        PreparedStatement prep;
        try {
            prep = yhteys.prepareStatement("INSERT INTO ASKARE(NIMI, TID, LID, KID) VALUES (?,2,1,1) RETURNING AID");
            prep.setString(1, nimi);
                
//            prep.setString(2, selite);
//            prep.setString(3, lnimi);
//            prep.setInt(4, kid);
            
            ResultSet ids = prep.executeQuery();
               
             this.aid = ids.getInt(1);
            
       
            prep.executeUpdate(); 
            prep.close();
            yhteys.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       return nimi + selite + lnimi;
    }

   

   

   
    }

