// ESERCITAZIONE 4

/**
 * @see Conto
 * @see ContoAstratto
 * @see ContoCorr
 * @author zorzr
 */

public class ContoWeb extends ContoCorr {
    private String password;
    private boolean firstlogin, loggedin;
    
    public ContoWeb (String ib, String codf) {
        super(ib, codf);
        this.password = "changeme";
        this.firstlogin = true;
        this.loggedin = false;
    }
    
    public boolean login (String pass) {
        if (!pass.equals(this.password) || this.firstlogin)   return false;
        
        this.loggedin = true;
        return true;
    }
    
    public void logout () {
        this.loggedin = false;
    }
    
    public boolean setPassword (String pass, String new_pass) {
        if (!pass.equals(this.password))   return false;
        
        this.password = new_pass;
        if (this.firstlogin)    this.firstlogin = false;
        
        return true;
    }
    
    @Override
    public boolean operazione (double x) {
        if (x < -saldo || !this.loggedin)  return false;
        
        saldo += x;
        return true;
    }
}
