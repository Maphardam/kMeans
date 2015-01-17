package Classifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class YUSoMean implements IClassifier{

	private int k;
	//TODO maybe there is a way to store centroids as an array, not an arraylist
	private ArrayList<Instance<Integer>> centroids;
	
	public YUSoMean(){
		k = 3;
		centroids = new ArrayList<Instance<Integer>>();
	}
	
	public YUSoMean(int _k){
		k = _k;
		centroids = new ArrayList<Instance<Integer>>();
	}
	
	@Override
	public String classify(Instance<Integer> i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void learn(Trainingset<Integer> t){
		initializeCentroids(t);
		int[] oldClassification = new int[t.size()];
		int[] newClassification = new int[t.size()];
		
		// while kMeans has not converged, do this
		do {
			oldClassification = newClassification.clone();
			newClassification = new int[t.size()];
			
			// iterate over all instances in the given trainingset
			for (int i = 0; i < t.size(); i++) {
				Instance<Integer> instance = t.getInstance(i);

				// compute distance to centroids
				int minDistance = Integer.MAX_VALUE;
				int minCentroidIndex = -1;
				for (int cIndex = 0; cIndex < centroids.size(); cIndex++) {
					int dist = distance(instance, centroids.get(cIndex));
					if (dist < minDistance) {
						minDistance = dist;
						minCentroidIndex = cIndex;
					}
				}
				newClassification[i] = minCentroidIndex;
			}
			
			// compute new centroids
			centroids = new ArrayList<Instance<Integer>>();
			for (int i = 0; i < k; i++) {
				ArrayList<Integer> features = new ArrayList<Integer>();
				for (int fIndex = 0; fIndex < t.getFeatureCount(); fIndex++){
					
				}
			}
		} while (!Arrays.equals(oldClassification, newClassification));
	}

	private void initializeCentroids(Trainingset<Integer> t){
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> features = new ArrayList<Integer>();
			Random rand = new Random();
			for (int fIndex = 0; fIndex < t.getFeatureCount(); fIndex++){
				// compute a random feature value in between the feature space given by the trainingset
				List<Integer> list = Arrays.asList(t.getDomain(fIndex).values);
				features.add(rand.nextInt((Collections.max(list) - Collections.min(list) + 1) + Collections.min(list)));
			}
			centroids.add(new Instance<Integer>(features, "-"));
		}
	}
	
	private int distance(Instance<Integer> i, Instance<Integer> j){
		
		int distance = 0;
		for (int m = 0; m < i.getDimension(); m++) {
			distance += Math.abs(i.getFeature(m) - j.getFeature(m));
		}
		
		return distance;
	}
}
