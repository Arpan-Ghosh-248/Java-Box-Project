import java.io.*;
import java.util.*;
public class Box1
{
    public static void main(String[] args)
    {
        ArrayList<Double> xyz = new ArrayList<>();
        String in_data;
        try
        {

            ArrayList<String> values = new ArrayList<>();
            File myObj = new File("/Users/musubimanagement/IdeaProjects/Box1/src/input.txt");
            Scanner sc = new Scanner(myObj);
            while(sc.hasNextLine()) {
                in_data = sc.nextLine();
                values.add(in_data);
                String[] data = in_data.split(" ");
                double l = Double.parseDouble(data[0]);
                double b = Double.parseDouble(data[1]);
                double h = Double.parseDouble(data[2]);
                // lab3_Box_Canales box1 = new lab3_Box_Canales();
                Box box1 = new Box();
                xyz.add(box1.getSurfaceArea(l, b, h));
            }

            double average =0;
            for(double i : xyz)
            {
                average += i;
            }
            average = average/xyz.size();
            System.out.println("Average surface area of boxes = " + average);
            int small=0 , large =0;
            for(int i=0;i< xyz.size();i++)
            {
                if(xyz.get(i) > average)
                    System.out.println("Box Indices larger than average surface area: "+i);
                if(xyz.get(i)< average)
                {
                    small ++;
                }
                if(xyz.get(i)> average)
                {
                    large++;
                }
            }
            double max= xyz.get(0);
            int j=0;
            for(int i=0;i< xyz.size();i++)
            {
                if(xyz.get(i)> max)
                {
                    max=xyz.get(i);
                    j=i;

                }

            }
            System.out.println("Greatest surface area = " + max +" Index = " + j + " Dimensions = " +values.get(j));
            System.out.println("Number of boxes with larger than average surface area: " + large);
            System.out.println("Number of boxes with smaller than average surface area: " + small);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("error file not opened");
        }
    }
}

class Box
{
    static double sa;
    static  ArrayList <Box1> abc = new ArrayList<Box1>();
    //private static double length , width , height;
    public static double getSurfaceArea(double length , double width , double height)
    {
        sa = 2*(length*width+ length*height+width*height);
        return sa;
    }
}
