package menon.cs7910.hw02;

public class OneDHaarClient {
	
	public static final String ORIGINAL_SAMPLE_LABEL = "Original sample: ";
	public static final String ORDERED_FHWT_LABEL = "Ordered FHWT: ";
	public static final String IN_PLACE_FHWT_LABEL = "InPlace FHWT: ";
	public static final String NEW_LINE = "\n";
	
	public static void testOrderedFHWT(double[] sample) {
		
		//Print the input sample
		System.out.println(NEW_LINE + ORIGINAL_SAMPLE_LABEL);
		for (double doubleValue : sample) {
			System.out.print(doubleValue + " ");
		}
		
		//Run the transform
		OneDHaar.orderedFastHaarWaveletTransform(sample);
		
		try {
			
			//Get the transform
			double[] transform = OneDHaar.getOrderedFastHaarWaveletTransform();
			
			//Print the transform values
			System.out.print(NEW_LINE + ORDERED_FHWT_LABEL);
			for (double doubleValue : transform) {
				System.out.print(doubleValue + " ");
			}
			
		} catch (Exception e) {
			System.err.println("Error while calling OneDHaar.getOrderedFastHaarWaveletTransform()");
			e.printStackTrace();
		}
		
	}
	
	
	public static void testInPlaceFHWT(double[] sample) {
		
		//Print the input sample
		System.out.println(NEW_LINE + ORIGINAL_SAMPLE_LABEL);
		for (double doubleValue : sample) {
			System.out.print(doubleValue + " ");
		}
		
		//Run the transform
		OneDHaar.inPlaceFastHaarWaveletTransform(sample);
		
		try {
			
			//Get the transform
			double[] transform = OneDHaar.getInPlaceFastHaarWaveletTransform();
			
			//Print the transform values
			System.out.print(NEW_LINE + IN_PLACE_FHWT_LABEL);
			for (double doubleValue : transform) {
				System.out.print(doubleValue + " ");
			}
			
		} catch (Exception e) {
			System.err.println("Error while calling OneDHaar.getInPlaceFastHaarWaveletTransform()");
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
        double[] sample_00 = {5, 1, 2, 8};
        double[] sample_01 = {3, 1, 0, 4, 8, 6, 9, 9};
        
        testOrderedFHWT(sample_00);
        testOrderedFHWT(sample_01);
        testInPlaceFHWT(sample_00);
        testInPlaceFHWT(sample_01);

	}

}