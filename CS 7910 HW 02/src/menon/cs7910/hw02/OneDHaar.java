package menon.cs7910.hw02;

import java.util.Arrays;

public class OneDHaar {
	
	private static double[] orderedFastHaarWaveletTransform;
	private static double[] inPlaceFastHaarWaveletTransform;
	private static boolean orderedTransformComplete;
	private static boolean inPlaceTransformComplete;
	
	/**
	 * Initialize class variables
	 */	
	static {
		orderedTransformComplete = false;
		inPlaceTransformComplete = false;
	}
	
	/**
	 * Generate the ordered Haar wavelet transform in an array
	 * @param sample
	 */
	public static void orderedFastHaarWaveletTransform(double[] sample) {
		
		
		
		
		orderedTransformComplete = true;
	} 
	
	/**
	 * Generate the in place Haar wavelet transform in an array
	 * @param sample
	 */
	public static void inPlaceFastHaarWaveletTransform(double[] sample) {
		
		
		inPlaceTransformComplete = true;
	}
	
	public static double[] getOrderedFastHaarWaveletTransform() throws Exception {
		
		if (!orderedTransformComplete) {
			throw new Exception("Ordered Fast Haar Wavelet Transform has not been done yet.");
		}
		
		//Return a copy so as to protect the class variable
		return Arrays.copyOf(orderedFastHaarWaveletTransform, orderedFastHaarWaveletTransform.length);
		
	}
	
	
	public static double[] getInPlaceFastHaarWaveletTransform() throws Exception {
		
		if (!inPlaceTransformComplete) {
			throw new Exception("In Place Fast Haar Wavelet Transform has not been done yet.");
		}
		
		//Return a copy so as to protect the class variable
		return Arrays.copyOf(inPlaceFastHaarWaveletTransform, inPlaceFastHaarWaveletTransform.length);

	}
}