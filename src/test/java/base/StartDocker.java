package base;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class StartDocker {

    public void startFile() throws IOException, InterruptedException
    {

        boolean flag=false;
        Runtime runtime= Runtime.getRuntime();
        runtime.exec("cmd /c start dockerUp.bat");

        String f ="output.txt";

        Calendar cal=Calendar.getInstance();//2:44 15th second
        cal.add(Calendar.SECOND, 45);//2:44   45seconds
        long stopnow=cal.getTimeInMillis();
        Thread.sleep(1000);

        while(System.currentTimeMillis()<stopnow)
        {
            if(flag)
            {
                break;
            }

            BufferedReader reader=new BufferedReader(new FileReader(f));
            String currentLine=reader.readLine();
            while(currentLine!=null && !flag)

            {

                if(currentLine.contains("registered to the hub and ready to use"))
                {
                    System.out.println("found my text");
                    flag=true;//14th seconds
                    break;
                }

                currentLine=reader.readLine();
            }
            reader.close();

        }

        Assert.assertTrue(flag);
        runtime.exec("cmd /c start dockerScale.bat");
        Thread.sleep(7000);
        System.out.println("New instances of Chrome added");

    }

}
