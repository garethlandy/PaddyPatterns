package templateMethod;

public class Test 
{

	   public static void main(String[] args) 
	   {
	      int[] data = { 45, 23, 89, 3423, 77, 33, 78, 322 };
	      SortingAlgorithm s1 = new AlgorithmType1();
	      s1.sortingTemplate(data);
	      
	      
	      SortingAlgorithm s2 = new AlgorithmType2();
	      s2.sortingTemplate(data);
	   }
}

