package Models;

/**
 *
 * @author saves
 */
public class Luokka {
    private int lid;
    private String nimi;
    private int kid;
    private String knimi;

    public Luokka(int lid, String nimi, int kid, String knimi) {
        this.lid = lid;
        this.nimi=nimi;
        this.kid=kid;
        this.knimi=knimi;
    }

   
   
    
    public Luokka() {
        
    }
    
    public Luokka(String nimi) {
        this.nimi =nimi;
    }
    
  
   
    
    public Luokka(int lid) {
        this.lid = lid;
    }
   
  
    
    
    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

   
    
     public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
    public int getKid() {
         return kid;
    }
     public void setKid(int kid) {
        this.kid = kid; 
     }
     public String getKnimi() {
        return knimi;
    }

    public void setKnimi(String knimi) {
        this.knimi = knimi;
    }
     
     
}


