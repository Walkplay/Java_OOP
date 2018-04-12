public class fourth {
	
	      public static void main(String[] args) {

	    	   int data[] = { 3, 6, 7, 10, 34, 56, 60 };
	           int numberToFind = 10;
	      
	      int len, first, last, middle;
	      
	      len = data.length;
	      
	      first = 0;
	      last = len - 1;

	      while(true)    	
	      {
	    	  middle = first + (first + last) / 2;
	    	  
	         if ( data[middle] < numberToFind )
	           first = middle + 1;
	         else if ( data[middle] == numberToFind)
	         {
	           System.out.print(middle);
	           break;
	         }
	         else
	         {
	             last = middle - 1;
	         }
	         
	         middle = (first + last) / 2;
	   
		      if (last == first)
		  	  {
		    	  if (data[last] == numberToFind)
		  		System.out.println(last);
		  			
		  	  else
		  		System.out.println(-1);
		  	  }
	  	  }

	   }

}