public class third {
	public static void main(String[] args) {
		int[] array = {30, 2, 10, 4, 6};
		int length = array.length;

        int swap = 0;
        for(int i = 0; i < length; i++)
        {
            for(int j = 1; j < (length-i); j++)
            {
                if(array[j-1] > array[j])
                {
                    swap = array[j-1];
                    array[j-1] = array[j];
                    array[j] = swap;
                }
            }
        }

		for (int i = 0; i < length; i++) {
			System.out.print(array[i] + " ");
		}
	}
}