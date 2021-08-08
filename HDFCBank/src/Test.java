import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[]args) {
        Bank bank=new Bank();
        ArrayList c1 = new ArrayList();
        ArrayList c2 = new ArrayList();
        c1.add("Nrupul");
        c1.add("nru123");
        c1.add(1000);
        c1.add("customer");
        c2.add("Aman");
        c2.add("Aman123");
        c2.add(1000);
        c2.add("Employee");
        bank.createAcc(1234,c1);
        bank.createAcc(2345,c2);
        int a = Choice();
        while (true)
        {
            if (a == 1)
            {
                a=Signup();
            }
            if(a==2)
            {
                a=Signin();
            }
            else if(a==3)
            {System.out.println("Thank You, visit again");
                System.exit(0);}
        }

    }

    private static int Signin() {
        int a=1;
        Bank bank=new Bank();
        Scanner sc=new Scanner(System.in);

        System.out.println("enter Account number");
        Integer x= sc.nextInt();

        Customer cus=new Customer();
        Admin ad = new Admin();
        System.out.println(bank.hm.containsKey(x));
        if(bank.hm.containsKey(x))
        {
            System.out.println("enter your password");
            String s= sc.next();
            System.out.println(bank.hm.get(x).get(1));
            for(Map.Entry<Integer, ArrayList> entry: bank.hm.entrySet())
            {
                if(bank.hm.get(x).get(1).equals(s))
                {

                    if(entry.getValue().get(3).equals("Customer")||entry.getValue().get(3).equals("customer")) {
                        boolean t = true;
                        while (t) {
                            System.out.println("You are an HDFC customer");
                            System.out.println("Please enter your choice");
                            System.out.println("1> Deposit");
                            System.out.println("2> Withdraw money");
                            System.out.println("3> Transfer");
                            System.out.println("4> Show balance");
                            System.out.println("5> Exit");
                            int choice = sc.nextInt();
                            if (choice == 1) {
                                System.out.println("Enter Amount");
                                int d = sc.nextInt();
                                cus.deposit(x, d);
                            } else if (choice == 2) {
                                System.out.println("Enter amount");
                                int d = sc.nextInt();
                                cus.withDraw(x, d);
                            } else if (choice == 3) {
                                System.out.println("Enter amount");
                                int d = sc.nextInt();
                                System.out.println("To Which account: ");
                                int acc = sc.nextInt();
                                cus.Transfer(x, acc, d);
                            } else if (choice == 4) {
                                cus.showBal(x);

                            } else if (choice == 5)
                            {
                                System.out.println("Thank You, visit again");
                                a=Choice();
                                return a;
                            }
                        }
                    }
                    else if(entry.getValue().get(3).equals("Employee")||entry.getValue().get(3).equals("employee")) {
                        boolean t = true;
                        while (t) {
                            System.out.println("You are an HDFC Employee");
                            System.out.println("Please enter your choice");
                            System.out.println("1> Show total number of accounts in the bank.");
                            System.out.println("2> Search an account");
                            System.out.println("3> Show Total balance in the bank");
                            System.out.println("4> Exit");
                            int choice = sc.nextInt();
                            if (choice == 1) {
                                ad.totalAcc();
                            }
                            else if (choice == 2)
                            {
                                System.out.println("Enter account number");
                                int d = sc.nextInt();
                                ad.accDetails(d);
                            }
                            else if (choice == 3)
                            {
                                ad.balance();
                            }
                            else if (choice == 4)
                            {
                                System.out.println("Thank You, visit again");
                                a=Choice();
                                break;
                            }
                        }
                    }
                }
                else {
                    System.out.println(ANSI_RED+"You entered incorrect password"+ANSI_RESET);
                    a=Choice();
                    break;
                }
            }
        }
        else {
            System.out.println(ANSI_RED + "Account does not exist"+ANSI_RESET);
            a=Choice();
            return a;
        }
        return a;
    }

    private static int Signup() {
        Bank bank=new Bank();
        Scanner sc=new Scanner(System.in);
        ArrayList c = new ArrayList();
        System.out.println("Enter your name");
        String name = sc.next();
        c.add(name);
        System.out.println("Enter new password");
        String pass = sc.next();
        c.add(pass);
        System.out.println("Enter account number");
        Integer acc = sc.nextInt();
        System.out.println("Enter Stating balance");
        int bal = sc.nextInt();
        c.add(bal);
        System.out.println("Enter the role");
        String role = sc.next();
        c.add(role);
        bank.createAcc(acc,c);
        System.out.println("Now login");
        return 2;
    }

    private static int Choice() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Press 1. for Signup");
        System.out.println("Press 2. for Login");
        System.out.println("Press 3. for Exit");
        int choice=sc.nextInt();
        return choice;
    }
}
