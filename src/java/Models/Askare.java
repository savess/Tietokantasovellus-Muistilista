package Models;

/**
 *
 * @author saves
 */

// Askareen konstruktorit ja getterit sekä setterit

public class Askare {
    
    private int aid;
    private String nimi;
    private String tarkeys;
    private String luokka;

    public Askare(int aid, String nimi, String tarkeys, String luokka) {
        this.aid = aid;
        this.nimi = nimi;
        this.tarkeys = tarkeys;
        this.luokka = luokka;
    }

   
   
    
    public Askare() {
        
    }
    
    public Askare(String nimi) {
        this.nimi =nimi;
    }

    
    public Askare(int aid) {
        this.aid = aid;
    }
   
  
    
    
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

   
    
     public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public String getTarkeys() {
         return tarkeys;
    }
     public void setTarkeys(String tarkeys) {
        this.tarkeys = tarkeys; 
     }
     
     public String getLuokka() {
         return luokka;
    }
     public void setLuokka(String luokka) {
        this.luokka = luokka; 
     }
     
     
}








