import java.util.Arrays;

public class Holder<E>{
	  private int size = 0;
      private static final int DEFAULT_CAPACITY = 10;
      private Object elements[];
      
	  public Holder()
	  {
		  elements = new Object[DEFAULT_CAPACITY];
	  }
	  
	  private void isFit() {
	        int newSize = elements.length * 2;
	        elements = Arrays.copyOf(elements, newSize);
	    }
	
	  public String toString() {	//DONE  повертає вміст контейнера у вигляді рядка
		  /*String str = "";
		  for(int i = 0; i < elements.length; i++) {
			  
		  }*/
		  return elements.toString();
	  }
	  
	  void add(E string) {		//DONE додає вказаний елемент до кінця контейнеру
		  if (size == elements.length) {
	            isFit();
	        }
	        elements[size++] = string; 
	  }
	  void clear() { 				//DONE видаляє всі елементи з контейнеру
		  for(int i = 0; i < size; i++) {
			  elements[i] = null;
		  }
	  }
	  private void fastRemove(int index) {

          int numMoved = size - index - 1;

          if (numMoved > 0) {
              System.arraycopy(elements, index + 1, elements, index, numMoved);
          }

          elements[--size] = null;
      }
	  boolean remove(Object o) {//DONE видаляє перший випадок вказаного елемента з контейнера
		  if (o == null) {

	            for (int index = 0; index < size; index++) {
	                if (elements[index] == null) {
	                    fastRemove(index);
	                    return true;
	                }
	            }

	        } else {

	            for (int index = 0; index < size; index++){
	                if (o.equals(elements[index])) {
	                    fastRemove(index);
	                    return true;
	                }
	            }
	        }

	        return false;
	  }
	  
	  public boolean removeAt(int index){
	        if (index <= size && index >= 0) {

	            fastRemove(index);
	            return true;
	        }

	        return false;
	    }
	  
	  String[] toArray() {			//DONE повертає масив, що містить всі елементи у  контейнері	
		  String[] str = new String[size];
		  for(int i = 0; i < size; i++) {
			  str[i] = elements[i].toString();
		  }
		  return str;
	  }
	  
	  int size() {
		  return size;
	  }
	  
	  @SuppressWarnings("unchecked")
	    public E get(int i) {
	        if (i >= size || i < 0) {
	            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
	        }
	        return (E) elements[i];
	    }
	  
	  boolean contains(String string) {	//DONE повертає true , якщо контейнер містить  вказаний елемент
		  for(int i = 0; i < size; i++) 
		  {
			  if(elements[i] == string ) 
			  {
				  return true;
			  }
		  }
		  return false;
	  }
	  public int indexOf(Object o) {

	        if (o == null) {
	            for (int i = 0; i < size; i++)
	                if (elements[i]==null)
	                    return i;
	            } else {
	            for (int i = 0; i < size; i++)
	                if (o.equals(elements[i]))
	                    return i;
	            }

	            return -1;
	    }
	  
	  public boolean contains(Object o) {//повертає true , якщо контейнер містить всі елементи з зазначеного у параметрах
	        return indexOf(o) >= 0;
	    }
	  
	 
	  
	  
}
