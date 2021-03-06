package Models;

/**
 *
 * @author saves
 */
// Käyttäjän konstruktorit ja getterit sekä setteri

public class Kayttaja {
    
       
    private String tunnus;
    private String salasana;
    private String nimi;
    private int kid;
    private int acount;

    public Kayttaja() {
    }

    public Kayttaja(String tunnus, String salasana) {
        this.tunnus = tunnus;
        this.salasana = salasana;
    }
    

    public Kayttaja(String tunnus, String salasana, String nimi, int kid) {
        this.tunnus = tunnus;
        this.salasana = salasana;
        this.nimi = nimi;
        this.kid = kid;
        
    }

       public Kayttaja(String tunnus, String salasana, String nimi, int kid, int acount) {
        this.tunnus = tunnus;
        this.salasana = salasana;
        this.nimi = nimi;
        this.kid = kid;
        this.acount = acount;
        
    }
    

    

    public String getKayttajatunnus() {
        return tunnus;
    }
    
     public String getSalasana() {
        return salasana;
    }
     
     public String getNimi() {
        return nimi;
    }
     
     public int getKid() {
        return kid;
    }
     
         
     public int getAcount() {
        return acount;
    }

    public void setKayttajatunnus(String tunnus) {
        this.tunnus = tunnus;
    }

  

    public void setSalasana(String salasana) {
        this.salasana = salasana;
    }

    

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }
    
     public void setKid(int kid) {
        this.kid = kid;
    }
    
    
   
    }