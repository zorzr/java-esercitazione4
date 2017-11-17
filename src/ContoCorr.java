// ESERCITAZIONE 4

/**
 * @see Conto
 * @see ContoAstratto
 * @author zorzr
 */
public class ContoCorr extends ContoAstratto {
    public ContoCorr (String ib, String codf) {
        super(ib, codf);
    }
    
    @Override
    public boolean operazione (double x) {
        if (x < -saldo)  return false;
        
        saldo += x;
        return true;
    }
}
