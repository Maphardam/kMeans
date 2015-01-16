package Classifier;

import java.util.ArrayList;

public class YUSoMean implements IClassifier{

	private int k;
	private Trainingset<Integer> centroids;
	
	public YUSoMean(){
		k = 3;
		centroids = new Trainingset<Integer>();
	}
	
	public YUSoMean(int _k){
		k = _k;
		centroids = new Trainingset<Integer>();
	}
	
	@Override
	public String classify(Instance<Integer> i) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void learn(){
		
	}

	
}
