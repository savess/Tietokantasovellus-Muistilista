package Models;

/**
 *
 * @author saves
 */
public class Askare {
    
    private String nimi;
    private int tarkeys;
    private String luokka;

    public Askare(String nimi, int tarkeys, String luokka) {
        this.nimi = nimi;
        this.tarkeys = tarkeys;
        this.luokka = luokka;
    }

   
   
    
    public Askare() {
        
    }
    
    public Askare(String nimi) {
        this.nimi =nimi;
    }

    
  

    
   

    
    
    

   
    
     public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public int getTarkeys() {
         return tarkeys;
    }
     public void setTarkeys(int tarkeys) {
        this.tarkeys = tarkeys; 
     }
     
     public String getLuokka() {
         return luokka;
    }
     public void setLuokka(String luokka) {
        this.luokka = luokka; 
     }
}








