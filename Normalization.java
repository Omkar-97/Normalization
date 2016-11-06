
import static java.lang.System.exit;
import java.util.Scanner;

class normal
{
	public int calc_min(int age[])	// To calculate the minimum age from dataset
	{
		int i,j,min = 0;
		min = age[0];
		for(i=1;i<age.length;i++)
		{
			if(age[i] < min )
			{
				min = age[i];
			}
		}
		return min;
	}
	
	public int calc_max(int age[])	// To calculate the maximum age from dataset
	{
		int i,j,max = 0;
		for(i=0;i<age.length;i++)
		{
			max = age[i];
			if(age[i] > max)
			{
				max = age[i];
			}
		}
		return max;
	}
	
	// Function to perform min_max normalization
    public void min_max(int age[],double min,double max)
    {
        double new_min = 0;
        double new_max = 1;
       
        System.out.println("min= "+min+" max= "+max+"\n");
   
        double v1;
        
        for(int i=0;i<age.length;i++)
        {
            v1=(((age[i]-min)/(max-min))*(new_max-new_min))+new_min;
            System.out.println("value v1 for "+age[i]+ "="+v1);
        }
    }
    
    //Function to perform Decimal_Scalling
    public void decimal_scalling(int age[],double min,double max)
    {
        int count;

        for(int i=0;i<age.length;i++)
        {
            int length = (int) Math.log10(max) + 1;
            double v1 = age[i]/Math.pow(10, length);
            System.out.println("Decimal Scalled value of "+age[i]+"="+v1);
        }
    }
}
      
public class Normalization 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the range for age: ");
        int range = in.nextInt();
        
        int[] age = new int[range];
                
        System.out.println("Enter the values for age: ");
        
        for(int i=0;i<range;i++)
        {
            age[i]=in.nextInt();
        }
        
        System.out.println("Values for age are as follows ");
        
        for(int i=0;i<age.length;i++)
        {
            System.out.print(age[i]+" ");
        }
        
        normal nrm = new normal();
        double min = nrm.calc_min(age);
        double max = nrm.calc_max(age);
        
        for(;;)
        {
            System.out.println("\nNormalization");
            System.out.println("1: Min_Max");
            System.out.println("2: Decimal Scaling");
            System.out.println("3: Exit");
            System.out.println("Enter your choice: ");
            int choice = in.nextInt();
        
            switch(choice)
            {
                case 1: nrm.min_max(age,min,max);
                    break;
                case 2: nrm.decimal_scalling(age,min,max);
                    break;
                case 3: exit(0);
            }
        }
    }
}
