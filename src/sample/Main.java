package sample;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Main extends Thread
{
    JFrame window = new JFrame();

    JPanel hours = new JPanel();
    JPanel hours1 = new JPanel();

    JPanel min = new JPanel();
    JPanel min1 = new JPanel();

    JPanel seconds = new JPanel();
    JPanel seconds1 = new JPanel();

    ArrayList< ArrayList< JCheckBox > > checksH = new ArrayList<>() ;
    ArrayList< ArrayList< JCheckBox > > checksH1 = new ArrayList<>() ;

    ArrayList< ArrayList< JCheckBox > > checksM = new ArrayList<>() ;
    ArrayList< ArrayList< JCheckBox > > checksM1 = new ArrayList<>() ;

    ArrayList< ArrayList< JCheckBox > > checksS = new ArrayList<>() ;
    ArrayList< ArrayList< JCheckBox > > checksS1 = new ArrayList<>() ;

    int [] n0 = {1,2,3,8,10,15,17,22,24,29,30,31};
    int [] n1 = {2,8,9,16,23,29,30,31};
    int [] n2 = {1,2,3,10,15,16,17,22,29,30,31};
    int [] n3 = {1,2,3,10,15,16,17,24,29,30,31};
    int [] n4 = {1,3,8,10,15,16,17,24,31};
    int [] n5 = {1,2,3,8,15,16,17,24,29,30,31};
    int [] n6 = {1,2,3,8,15,16,17,22,24,29,30,31};
    int [] n7 = {1,2,3,10,16,17,18,24,31};
    int [] n8 = {1,2,3,8,10,15,16,17,22,24,29,30,31};
    int [] n9 = {1,2,3,8,10,15,16,17,24,29,30,31};
    int [] dots = {5,6,12,13,26,27,33,34};

    int [] [] nums = {n0,n1,n2,n3,n4,n5,n6,n7,n8,n9};

    public void run()
    {
       while (true)
        {
            try
            {
                Thread.sleep(1000);
            }

            catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            dotsFalse(checksH);
            dotsFalse(checksH1);
            dotsFalse(checksM);
            dotsFalse(checksM1);
            dotsFalse(checksS);
            dotsFalse(checksS1);

            dotsTrue(checksH1, dots);
            dotsTrue(checksM1, dots);

            getHour();
        }
    }

    public Main ()
    {

        window.setTitle("Reloj");
        window.setLocationRelativeTo(null);
        window.setLayout(new GridLayout(0,6));
        window.setSize(700,180);

        hours.setLayout(new GridLayout(5,5));
        checksH = createClock(hours);

        hours1.setLayout(new GridLayout(5,5));
        checksH1 = createClock(hours1);

        min.setLayout(new GridLayout(5,5));
        checksM = createClock(min);

        min1.setLayout(new GridLayout(5,5));
        checksM1 = createClock(min1);

        seconds.setLayout(new GridLayout(5,5));
        checksS = createClock(seconds);

        seconds1.setLayout(new GridLayout(5,5));
        checksS1 = createClock(seconds1);

        window.add(hours);
        window.add(hours1);

        window.add(min);
        window.add(min1);

        window.add(seconds);
        window.add(seconds1);

        window.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        Main m = new Main();
        m.start();

    }

    private static ArrayList< ArrayList< JCheckBox > > createClock(JPanel content)

    {
        ArrayList< ArrayList< JCheckBox > > checkboxes = new ArrayList<>();
        for (int i =0; i < 1; i++)
        {
            checkboxes.add( new ArrayList<>() ) ;
            for (int x = 0; x < 35; x++)
            {
                JCheckBox cb = new JCheckBox();
                cb.setVisible(false);
                checkboxes.get(i).add(cb);

                content.add(cb);
            }
        }

        return checkboxes;
    }

    private void dotsFalse ( ArrayList< ArrayList< JCheckBox > > checks)
    {

        for (int i = 0; i < 1; i++)
        {
            for (int x = 0; x < 35; x++)
            {
                checks.get(0).get(x).setSelected(false);
                checks.get(0).get(x).setVisible(false);
            }
        }

    }

    private void change(ArrayList< ArrayList< JCheckBox > > checks, int [] num)
    {

        for (int i = 0; i < 1; i++)
        {
            for (int x = 0; x < num.length; x++)
            {
                checks.get(0).get(num[x]).setSelected(true);
                checks.get(0).get(num[x]).setVisible(true);
            }
        }
    }

    private void dotsTrue(ArrayList< ArrayList< JCheckBox > > checks, int [] num)
    {

        for (int i = 0; i < 1; i++)
        {
            for (int x = 0; x < num.length; x++)
            {
                checks.get(0).get(num[x]).setSelected(true);
                checks.get(0).get(num[x]).setVisible(true);
            }
        }
    }

        private void getHour ()
    {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR) / 10;
        int hour1 = calendar.get(Calendar.HOUR) % 10;

        int min = calendar.get(Calendar.MINUTE) / 10;
        int min1 = calendar.get(Calendar.MINUTE) % 10;

       int second = calendar.get(Calendar.SECOND) / 10;
       int second1 = calendar.get(Calendar.SECOND) % 10;

        change(checksH,nums[hour]);
        change(checksH1,nums[hour1]);
        change(checksM,nums[min]);
        change(checksM1,nums[min1]);
        change(checksS,nums[second]);
        change(checksS1,nums[second1]);


        }

}