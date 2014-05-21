package mx.itam.deiis.utils;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.opencv.core.*;
import org.opencv.features2d.*;
import org.opencv.highgui.*;
import org.opencv.imgproc.*;
import org.opencv.objdetect.CascadeClassifier;

public class SIFTTool {
	public void Run(String imgFile1, String imgFile2) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

		System.out.println("SIFT Tool running...");
		// Load first image
		Mat image01 = Highgui.imread(imgFile1);

		// Load second image
		Mat image02 = Highgui.imread(imgFile2);
		
		if (image01 == null || image02 == null) {
			System.out.println("There was a problem loading the image files");
			System.exit(0);
		}

		//Get filtered image mat
		Mat filteredImg1 = filterImgMat(image01);
		Mat filteredImg2 = filterImgMat(image02);

		//Create SIFT extractor (Detector->Extractor)
		FeatureDetector siftDetector = FeatureDetector.create(FeatureDetector.SIFT);
		DescriptorExtractor siftExtractor = DescriptorExtractor.create(DescriptorExtractor.SIFT);

		//Get keypoints
		MatOfKeyPoint keyPoint01 = new MatOfKeyPoint();
		MatOfKeyPoint keyPoint02 = new MatOfKeyPoint();
		
		siftDetector.detect(filteredImg1, keyPoint01);
		siftDetector.detect(filteredImg2, keyPoint02);

		//Obtain descriptors
		Mat descriptor01 = new Mat(image01.rows(), image01.cols(), image01.type());
		Mat descriptor02 = new Mat(image02.rows(), image02.cols(), image02.type());
		
		siftExtractor.compute(filteredImg1, keyPoint01, descriptor01);
		siftExtractor.compute(filteredImg2, keyPoint02, descriptor02);
		
		//Get matches between images
		MatOfDMatch matches = new MatOfDMatch();
		DescriptorMatcher matcher = DescriptorMatcher.create(DescriptorMatcher.FLANNBASED);
		matcher.match(descriptor01, descriptor02, matches);

		System.out.printf("Img1 has %d descriptor of %d feats\n", descriptor01.rows(), descriptor01.cols());
		System.out.printf("Img2 has %d descriptor of %d feats\n", descriptor02.rows(), descriptor01.cols());

		dumpMatToFile(descriptor01, "img.sift");
		
		//Set down to 50 matches by brute-force
		DMatch[] tmp01 = matches.toArray();
		DMatch[] tmp02 = new DMatch[tmp01.length];
		for (int i=0; i<tmp01.length; i++) {
			tmp02[i] = tmp01[i];
		}
		matches.fromArray(tmp02);
		
		System.out.printf("Found %d matches\n", tmp01.length);

		//Get instant string
		String now = getNowString();
		
		//Draw matched image
		Mat matchedImage = new Mat(image01.rows(), image01.cols()*2, image01.type());
		Features2d.drawMatches(image01, keyPoint01, image02, keyPoint02, matches, matchedImage);
		Highgui.imwrite("E:\\JavaCV\\descriptedImageBySIFT-" + now + ".jpg", matchedImage);
		System.out.printf("E:\\JavaCV\\descriptedImageBySIFT-" + now + ".jpg\n", matchedImage);
	}
	
	/*
	 * This method extracts the SIFT features from an image and saves them
	 * to a file
	 */
	public boolean extractFeatsToFile(String imgFile, String featFile) {
		//Read the image file
		Mat image = Highgui.imread(imgFile);
		if( image == null )
			return false;
		//Get the filtered image to obtain better descriptors
		Mat filteredImg = filterImgMat(image);
		
		//Create the keypoint and SIFT detector
		FeatureDetector siftDetector = FeatureDetector.create(FeatureDetector.SIFT);
		DescriptorExtractor siftExtractor = DescriptorExtractor.create(DescriptorExtractor.SIFT);
		
		//Obtain the keypoints from the image
		MatOfKeyPoint keyPoint = new MatOfKeyPoint();
		siftDetector.detect(filteredImg, keyPoint);
		
		//Get the descriptors defined by the keypoints
		Mat descriptor = new Mat(image.rows(), image.cols(), image.type());
		siftExtractor.compute(filteredImg, keyPoint, descriptor);
		
		//Save to file
		return dumpMatToFile(descriptor, featFile);
	}

	/*
	 * Changes file to grayscale and normalizes the values
	 */
	public Mat filterImgMat(Mat inImg) {
		Mat filteredImg = new Mat(inImg.rows(), inImg.cols(), inImg.type());
		//Set to grayscale to obtain better results
		Imgproc.cvtColor(inImg, filteredImg, Imgproc.COLOR_BGRA2GRAY);
		//Normalize 0-255 the values
		Core.normalize(filteredImg, filteredImg, 0, 255, Core.NORM_MINMAX);
		
		return filteredImg;
	}
	
	/*
	 * Gets the string of the instant with the format:
	 * YYYYMMDDHHMMSS
	 */
	public static String getNowString() {
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int month = Calendar.getInstance().get(Calendar.MONTH) + 1;
		int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		int minute = Calendar.getInstance().get(Calendar.MINUTE);
		int second = Calendar.getInstance().get(Calendar.SECOND);
		
		return (year + "" + month + "" + day + "" + hour + "" + minute + "" + second);
	}
	
	/*
	 * Saves the contents of a Mat to a file
	 * each row is in a line and each col is comma separated
	 */
	public static boolean dumpMatToFile(Mat descriptor, String fileName) {
		String dumpStr = descriptor.dump();
		dumpStr = dumpStr.replaceAll("[\\[\\]\\s]+","");
		dumpStr = dumpStr.replaceAll(";", "\n");
		
		try {
			PrintWriter fileWriter = new PrintWriter(fileName);
			fileWriter.print(dumpStr);
			fileWriter.close();
		} catch(FileNotFoundException exception) {
			System.out.println("Could not write down the feature file");
			return false;
		}
		
		return true;
	}
}
