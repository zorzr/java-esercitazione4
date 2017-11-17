// ESERCITAZIONE 4

/**
 * @see Conto
 * @see ContoAstratto
 * @author zorzr
 */
public class ContoDep extends ContoAstratto {
    public ContoDep (String ib, String codf) {
        super(ib, codf);
    }
    
    @Override
    public boolean operazione (double x) {
        if (x < 0)  return false;
        
        saldo += x;
        return true;
    }
    
    // ACCOUNTABLES
    @Override
    public boolean addAccountable (Accountable acc) {
        if (acc.getType().equals(AccountableType.ADDEBITO))  return false;
        
        return accountables.add(acc);
    }
}
