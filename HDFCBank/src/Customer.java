public class Customer extends Bank{

    public void deposit(int a,int am)
    {
        if(super.hm.containsKey(a))
        {
            int x=(Integer)super.hm.get(a).get(2);
            x=x+am;
            super.hm.get(a).set(2,x);
            System.out.println(x);
        }
    }
    public void withDraw(int a,int am)
    {
            if((Integer)hm.get(a).get(2)>am)
            {
                int x = (Integer) hm.get(a).get(2);
                x = x - am;
                hm.get(a).set(2, x);
                System.out.println("Remaining balance: "+x);
            }
            else
                System.out.println("not enough balance");
    }
    public void Transfer(int a,int b,int am)
    {
        if(hm.containsKey(a)&& hm.containsKey(b))
        {
            if((Integer)hm.get(a).get(2)>am)
            {
                int x = (Integer) hm.get(a).get(2);
                int y = (Integer) hm.get(b).get(2);
                x = x - am;
                y = y+ am;
                hm.get(a).set(2, x);
                hm.get(b).set(2, y);
            }
            else
                System.out.println("not enough balance");
        }
    }
    public void showBal(int a)
    {
        if(hm.containsKey(a))
        {
            System.out.println(hm.get(a).get(2));
        }
    }
}
