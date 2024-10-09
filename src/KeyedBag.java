import edu.colorado.geometry.Location;

public class KeyedBag {

    private String[ ] entry;
    private int[] key;
    private int manyItems;

   
    public KeyedBag(){
        
        final int INITIAL_CAPACITY = 10;
        manyItems = 0;
        entry = new String[INITIAL_CAPACITY];
        key = new int[INITIAL_CAPACITY];

    }

    public KeyedBag(int initialCapacity)
    {
       if (initialCapacity < 0)
          throw new IllegalArgumentException
          ("The initialCapacity is negative: " + initialCapacity);
       entry = new String[initialCapacity];
       key = new int[initialCapacity];
       manyItems = 0;

    }
public void insert(String element, int keyelement){
      if (manyItems == entry.length && manyItems == key.length)
      {  
         ensureCapacity((manyItems + 1)*2);
      }

      if(checkKey(keyelement)){
        System.out.println("Rejected key already paired");
      }
      else{      
        entry[manyItems] = element;
        key[manyItems] = keyelement;
        manyItems++;
        }
   }
   public KeyedBag clone( )
   {  // Clone an IntArrayBag object.
      KeyedBag answer;
      
      try
      {
         answer = (KeyedBag) super.clone( );
      }
      catch (CloneNotSupportedException e)
      {  // This exception should not occur. But if it does, it would probably
         // indicate a programming error that made super.clone unavailable.
         // The most common error would be forgetting the "Implements Cloneable"
         // clause at the start of this class.
         throw new RuntimeException
         ("This class does not implement Cloneable");
      }
      
      answer.entry = entry.clone();
      answer.key = key.clone();

      
      return answer;
   }

   public void ensureCapacity(int minimumCapacity)
   {
      String[ ] biggerArray;
      int[] keyBiggerArray;
      
      if (entry.length < minimumCapacity || key.length <minimumCapacity)
      {
         biggerArray = new String[minimumCapacity];
         keyBiggerArray = new int[minimumCapacity];

         System.arraycopy(entry, 0, biggerArray, 0, manyItems);
         System.arraycopy(key, 0, keyBiggerArray, 0, manyItems);
         entry = biggerArray;
         key = keyBiggerArray;


      }
   }


    public int getCapacity( )
   {
      return key.length;
   }


    public int[] remove(int target)
   {
    int index = -1;
    for (int i = 0; i < key.length; i++) {
        if (key[i] == target) {
            index = i;
            break;
        }
    }

    if (index != -1) {
        int[] newArray = new int[key.length - 1];
        System.arraycopy(key, 0, newArray, 0, index);
        System.arraycopy(key, index + 1, newArray, index, key.length - index - 1);
        key = newArray;
    }
    manyItems--;
    return key;
}
   

   public int size( )
   {
      return manyItems;
   }

   public int countOccurrences(String target)
   {
      int answer;
      int index;
      
      answer = 0;
      for (index = 0; index < manyItems; index++)
         if (target.equals(entry[index]))
            answer++;
      return answer;
   }
   public int countKeyOccurrences(int target)
   {
      int answer;
      int index;
      
      answer = 0;
      for (index = 0; index < manyItems; index++)
         if (target == key[index])
            answer++;
      return answer;
   }
   public boolean checkKey(int targetKey){
        for(int i = 0; i < key.length; i++){
            if(targetKey == key[i]){
                return true;  
            }
        }
        return false;
        
    
        
   }
   public void addMany(String... elements)
   {
      if (manyItems + elements.length > entry.length)
      {  // Ensure twice as much space as we need.
         ensureCapacity((manyItems + elements.length)*2);
      }

      System.arraycopy(elements, 0, entry, manyItems, elements.length);
      manyItems += elements.length;

      if (manyItems + elements.length > key.length)
      {  // Ensure twice as much space as we need.
         ensureCapacity((manyItems + elements.length)*2);
      }

      System.arraycopy(elements, 0, key, manyItems, elements.length);
      manyItems += elements.length;

      
   }

   public void addAll(KeyedBag addend)
   {
      // If addend is null, then a NullPointerException is thrown.
      // In the case that the total number of items is beyond
      // Integer.MAX_VALUE, there will be an arithmetic overflow and
      // the bag will fail.
      ensureCapacity(manyItems + addend.manyItems);
         
            System.arraycopy(addend.entry, 0, entry, manyItems, addend.manyItems);
            System.arraycopy(addend.key, 0, key, manyItems, addend.manyItems);
      
            manyItems += addend.manyItems;
      
            for (int i = 0; i < key.length; i++) {
                int occurrences = countKeyOccurrences(i);
                while (occurrences > 1) {
                    remove(key[i]);
                    occurrences--;
                }
            }
      


      


   }   

   public String check(int specifiedkey){

        for(int i = 0; i < key.length; i++){
            if(specifiedkey == key[i]){
                return entry[i];
            }
        }
        return "No identified item";
    
   }

   public void print(){

    for(int i = 0 ; i < key.length ; i++){
        System.out.println(key[i]);
    }
    
}

public static KeyedBag union(KeyedBag b1, KeyedBag b2)
{
   // If either b1 or b2 is null, then a NullPointerException is thrown. 
   // In the case that the total number of items is beyond
   // Integer.MAX_VALUE, there will be an arithmetic overflow and
   // the bag will fail.   
   KeyedBag answer = new KeyedBag(b1.getCapacity( ) + b2.getCapacity( ));
   
   System.arraycopy(b1.entry, 0, answer.entry, 0, b1.manyItems);
   System.arraycopy(b2.entry, 0, answer.entry, b1.manyItems, b2.manyItems);
   System.arraycopy(b1.key, 0, answer.key, 0, b1.manyItems);
   System.arraycopy(b2.key, 0, answer.key, b1.manyItems, b2.manyItems);
   answer.manyItems = b1.manyItems + b2.manyItems;

   
   return answer;

   

}
}


