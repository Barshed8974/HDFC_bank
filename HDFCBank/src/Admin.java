import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Admin extends Bank{
   // HashMap<Integer,ArrayList> hm=new HashMap<>();

    public void totalAcc()
    {
        System.out.println("Total number of accounts: "+super.hm.size());
    }
    public void accDetails(int acc)
    {
        System.out.println("Account holder: "+super.hm.get(acc).get(0));
        System.out.println("Account balance: "+super.hm.get(acc).get(2));
        System.out.println("Role: "+super.hm.get(acc).get(3));
    }
    public void balance()
    {
        double d=0.0;
        double c;
        for(Map.Entry<Integer, ArrayList> entry: super.hm.entrySet())
        {
            c=(Integer)(entry.getValue().get(2));
            d=d+c;
        }
        System.out.println("Total balance in bank: "+d);
    }
}
