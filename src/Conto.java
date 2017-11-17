// ESERCITAZIONE 4

/**
 * @see Banca
 * @see ContoAstratto
 * @author zorzr
 */

public interface Conto {
    public boolean operazione(double x);
    public String getIban();
    public double getSaldo();
    public String getCf();
    
    // ACCOUNTABLES
    public boolean addAccountable(Accountable acc);
    public boolean fineMese();
}
