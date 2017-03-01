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

    int [] n0 = {0,1,2,3,6,9,12,12,15,18,21,24,27,30,31,32,33};
    int [] n1 = {1,6,7,13,19,25,30,31,32};
    int [] n2 = {0,1,2,3,4,10,12,13,14,15,16,18,24,30,31,32,33,34};
    int [] n3 = {0,1,2,3,9,12,13,14,15,21,27,30,31,32,33};
    int [] n4 = {0,3,6,9,12,13,14,15,21,27,33};
    int [] n5 = {1,2,3,4,7,13,14,15,16,22,28,31,32,33,34};
    int [] n6 = {1,2,3,4,7,13,14,15,16,19,22,25,28,31,32,33,34};
    int [] n7 = {0,1,2,3,9,15,21,27,33};
    int [] n8 = {0,1,2,3,6,9,12,13,14,15,18,19,20,21,24,27,30,31,32,33};
    int [] n9 = {0,1,2,3,6,9,12,13,14,15,21,27,33};

    int [] [] nums = {n0,n1,n2,n3,n4,n5,n6,n7,n8,n9};

    public void run()
    {
        /*while (true)
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

            getHour();
        }*/

    }

    public Main ()
    {

        window.setTitle("Reloj");
        window.setLocationRelativeTo(null);
        window.setLayout(new GridLayout(0,6));
        window.setSize(700,180);

        hours.setLayout(new GridLayout(6,6));
        checksH = createClock(hours);

        hours1.setLayout(new GridLayout(6,6));
        checksH1 = createClock(hours1);

        min.setLayout(new GridLayout(6,6));
        checksM = createClock(min);

        min1.setLayout(new GridLayout(6,6));
        checksM1 = createClock(min1);

        seconds.setLayout(new GridLayout(6,6));
        checksS = createClock(seconds);

        seconds1.setLayout(new GridLayout(6,6));
        checksS1 = createClock(seconds1);

        window.add(hours);
        window.add(hours1);

        window.add(min);
        window.add(min1);

        window.add(seconds);
        window.add(seconds1);

        //getHour();

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
            for (int x = 0; x < 36; x++)
            {
                JCheckBox cb = new JCheckBox("x" +x);
                cb.setVisible(true);
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
            for (int x = 0; x < 20; x++)
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