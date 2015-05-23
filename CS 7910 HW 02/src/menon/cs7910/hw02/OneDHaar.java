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
		
		double[] transform = getPaddedArray(sample);
		int numberOfIterations = Double.valueOf(Math.log10(transform.length)/Math.log10(2.0)).intValue(), numberOfTransformCoefficients = 0;
		
		//Do number of iterations equal to the power of 2
		for (int iterationCounter = 0; iterationCounter < numberOfIterations; ++iterationCounter) {
			
			//Do Ordered FHWT on the step coefficients part of the array
			numberOfTransformCoefficients = Double.valueOf(Math.pow(2.0, numberOfIterations - iterationCounter)).intValue();
			double stepCoefficient = 0.0, waveletCoefficient = 0.0;
			double[] currentTransform = new double[numberOfTransformCoefficients];
			int coefficientJumpFactor = currentTransform.length/2;
			for (int transformCoefficientsCounter = 0, currentTransformIndex = 0; transformCoefficientsCounter < numberOfTransformCoefficients; transformCoefficientsCounter += 2, ++currentTransformIndex) {
			
				stepCoefficient = (transform[transformCoefficientsCounter] + transform[transformCoefficientsCounter + 1])/2.0;
				currentTransform[currentTransformIndex] = stepCoefficient;
				
				waveletCoefficient = (transform[transformCoefficientsCounter] - transform[transformCoefficientsCounter + 1])/2.0;
				currentTransform[currentTransformIndex + coefficientJumpFactor] = waveletCoefficient;
				
			}
			
			//Copy the current transform back into main array
			int currentTransformCounter = 0;
			for (double doubleValue : currentTransform) {
				transform[currentTransformCounter++] = doubleValue;
			}
			
		}
		
		orderedFastHaarWaveletTransform = transform;
		orderedTransformComplete = true;
	} 
	
	/**
	 * Generate the in place Haar wavelet transform in an array
	 * @param sample
	 */
	public static void inPlaceFastHaarWaveletTransform(double[] sample) {
		
		double[] paddedSample = getPaddedArray(sample);
		
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
	
	/**
	 * @param sample
	 * @return array that is the next integral multiple of a power of 2. Return the same array if it is already
	 * of size that is a power of 2.
	 */
	private static double[] getPaddedArray(double[] sample) {
		
		int sampleSize = sample.length;
		double sampleSizeLg = Math.log10(sampleSize)/Math.log10(2.0);
		int sampleSizeLgInt = Double.valueOf(sampleSizeLg).intValue();
		
		//Return input if already the size is an integral power of 2
		if (sampleSizeLgInt == sampleSizeLg) {
			return sample;
		}
		
		//Create an array of size the next integral power of 2
		int paddedSize = Double.valueOf(Math.ceil(sampleSizeLg)).intValue();
		double[] returnValue = new double[paddedSize];
		
		//Fill the initial part of the array with the input sample
		int arrayIndex = 0;
		for (double doubleValue : sample) {
			returnValue[arrayIndex++] = doubleValue;
		}
		
		return returnValue;
		
	}
}