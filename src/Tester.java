// ESERCITAZIONE 4

/**
 * @see Banca
 * @see Conto
 * @see Accountable
 * @author zorzr
 */

public class Tester {
    public static void main(String[] args) {
        boolean r;
        Banca ubi = new Banca("UBI BANCA");
        
        Conto conto01, conto02, conto03;
        conto01 = ubi.addConto("CF01", ContoType.CORRENTE);
        check(conto01);
        System.out.println("01) OK!");
        conto02 = ubi.addConto("CF02", ContoType.DEPOSITO);
        check(conto02);
        System.out.println("02) OK!");
        conto03 = ubi.addConto("CF03", ContoType.WEB);
        check(conto03);
        System.out.println("03) OK!\n");
        
        
        r = ubi.operazione(conto01.getIban(), 100.);
        if (r)   System.out.println("01) OK!");
        else    System.out.println("01) Errore: operazione non eseguita");
        r = ubi.operazione(conto02.getIban(), -100.);
        if (r)   System.out.println("02) OK!");
        else    System.out.println("02) Errore: operazione non eseguita");
        r = ubi.operazione(conto01.getIban(), -50.);
        if (r)   System.out.println("03) OK!");
        else    System.out.println("03) Errore: operazione non eseguita");
        r = ubi.operazione(conto03.getIban(), 1000.);
        if (r)   System.out.println("04) OK!");
        else    System.out.println("04) Errore: operazione non eseguita");
        
        r = ubi.changePass(conto03.getIban(), "changeme", "tartellette");
        System.out.println("Cambio password:     " + r);
        r = ubi.login(conto03.getIban(), "tartellette");
        System.out.println("Login:               " + r);
        
        r = ubi.operazione(conto03.getIban(), 1000.);
        if (r)   System.out.println("05) OK!");
        else    System.out.println("05) Errore: operazione non eseguita");
        r = ubi.operazione(conto03.getIban(), -2000.);
        if (r)   System.out.println("06) OK!");
        else    System.out.println("06) Errore: operazione non eseguita");
        r = ubi.operazione(conto02.getIban(), 500.);
        if (r)   System.out.println("07) OK!");
        else    System.out.println("07) Errore: operazione non eseguita");
        
        
        // ACCOUNTABLES
        System.out.println("\nAccountable:");
        ubi.addAccountable(conto01.getIban(), new Sky(60.));
        if (!r)   System.out.println("01) Errore: accountable non aggiunto");
        ubi.addAccountable(conto01.getIban(), new Stipendio(1500.));
        if (!r)   System.out.println("02) Errore: Accountable non aggiunto");
        r = ubi.addAccountable(conto02.getIban(), new Sky(10.));
        if (!r)   System.out.println("03) Errore: accountable non aggiunto");
        r = ubi.addAccountable(conto02.getIban(), new Stipendio(2000.));
        if (!r)   System.out.println("04) Errore: accountable non aggiunto");
        
        ubi.logout(conto03.getIban(), "tartellette");
        r = ubi.addAccountable(conto03.getIban(), new Stipendio(1000.));
        if (!r)   System.out.println("05) Errore: accountable non aggiunto");
        ubi.fineMese();
        
        
        System.exit(0);
    }
    
    private static void check (Conto c) {
        if (c == null) {
            System.out.println("Errore: conto non inserito\n");
            System.exit(-1);
        }
    }
}
