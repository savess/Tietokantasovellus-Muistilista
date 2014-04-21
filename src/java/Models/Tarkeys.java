
package Models;
/**
 *
 * @author saves
 */
// tärkeyden kontruktorit ja getterit sekä setterit


public class Tarkeys{
    private String selite;
    private String arvo;
    private String knimi; 
    private int tid;
    private int kid;

    public Tarkeys(String selite, String arvo, String knimi, int tid, int kid) {
        this.selite = selite;
        this.arvo = arvo;
        this.knimi = knimi;
        this.tid=tid;
        this.kid=kid;
        
    }
    
    
   
    
    public Tarkeys() {
        
    }
    
    public Tarkeys(String selite) {
        this.selite =selite;
    }
    
  
   
    
   
   
  
    
    
    public String getArvo() {
        return arvo;
    }

    public void setArvo(String arvo) {
        this.arvo = arvo;
    }

   
    
     public String getSelite() {
        return selite;
    }

    public void setSelite(String selite) {
        this.selite= selite;
    }
    
    public int getTid() {
         return tid;
    }
     public void setTid(int tid) {
        this.tid = tid; 
     }
     public String getKnimi() {
        return knimi;
    }

    public void setKnimi(String knimi) {
        this.knimi = knimi;
    }
     public int getKid() {
         return kid;
    }
     public void setKid(int kid) {
        this.kid = kid; 
     }


}

    



