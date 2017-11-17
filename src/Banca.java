// ESERCITAZIONE 4
import java.util.HashMap;

/**
 * @see Conto
 * @see Accountable
 * @see ContoType
 * @author zorzr
 */

public class Banca {
    private final String nome, rad_iban;
    private HashMap<String,Conto> conti;
    private int n;
    
    public Banca(String nome_banca) {
        this.nome = nome_banca;
        this.rad_iban = "IBAN000";
        this.conti = new HashMap<>();
        this.n = 0;
    }
    
    public Conto addConto (String codf, ContoType type) {
        String iban = rad_iban + n;
        n++;
        
        if (conti.containsKey(iban))   return null;
        
        switch (type) {
            case CORRENTE:
                conti.put(iban, new ContoCorr(iban, codf));
                break;
            case DEPOSITO:
                conti.put(iban, new ContoDep(iban, codf));
                break;
            case WEB:
                conti.put(iban, new ContoWeb(iban, codf));
                break;
            default:
                break;
        }
        
        Conto c = conti.get(iban);
        return c;
    }
    
    public boolean operazione (String iban, double val) {
        if (!conti.containsKey(iban))   return false;
        
        Conto c = conti.get(iban);
        return c.operazione(val);
    }
    
    public boolean login (String iban, String pass) {
        if (!conti.containsKey(iban))   return false;
        
        Conto c = conti.get(iban);
        
        if (c instanceof ContoWeb) {
            ContoWeb web = (ContoWeb) c;
            return web.login(pass);
        }
        return false;
    }
    
    public boolean logout (String iban, String pass) {
        if (!conti.containsKey(iban))   return false;
        
        Conto c = conti.get(iban);
        
        if (c instanceof ContoWeb) {
            ContoWeb web = (ContoWeb) c;
            web.logout();
            return true;
        }
        return false;
    }
    
    public boolean changePass (String iban, String pass, String new_pass) {
        if (!conti.containsKey(iban))   return false;
        
        Conto c = conti.get(iban);
        
        if (c instanceof ContoWeb) {
            ContoWeb web = (ContoWeb) c;
            return web.setPassword(pass, new_pass);
        }
        return false;
    }
    
    public void stampa_dati (String iban) {
        if (conti.containsKey(iban)) {
            Conto c = conti.get(iban);
            System.out.println(c.getCf() + "  " + c.getIban() + "  " + c.getSaldo());
        }
    }
    
    // ACCOUNTABLES
    public boolean addAccountable (String iban, Accountable acc) {
        if (!conti.containsKey(iban))   return false;
        
        Conto c = conti.get(iban);
        return c.addAccountable(acc);
    }
    
    public boolean fineMese () {
        boolean r;
        Conto c;
        
        for (String iban : conti.keySet()) {
            c = conti.get(iban);
            r = c.fineMese();
            
            if (!r)  {
                System.out.println("Errore nel pagamento degli accountable per il conto:  " + iban);
                //return false;   // non voglio interrompere i pagamenti di tutti a causa di uno solo
            }
        }
        return true;
    }
}
