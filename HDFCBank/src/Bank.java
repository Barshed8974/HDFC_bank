import java.util.ArrayList;
import java.util.HashMap;

public class Bank
{
    public static HashMap<Integer, ArrayList>  hm=new HashMap<>();
    protected void createAcc(Integer a,ArrayList b)

    {
        hm.put(a,b);
    }
    public void withDraw(int a,int am)
    {

    }
}
