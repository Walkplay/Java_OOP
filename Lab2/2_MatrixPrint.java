public class second {
	public static void main(String args[]) {
    	int size = 5;
        
        for (int i = 0; i < size; i++)
        {
        	for (int j = 0; j < size; j++)
        	{
        		int num = size * i + j + 1;
        		
        		if (j == i || j == size - 1 - i)
        		{
        			System.out.print(' ');
        			System.out.print('*');
        		}
        		else
        		{
        			if (num < 10)
        				System.out.print(' ');
        			System.out.print(num);
        		}
        			
        		System.out.print(' ');
        	}
      		System.out.println();
        }
    }
}