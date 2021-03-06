package a9;

import a9.DynamicArrayAbstract;

public class DynamicArrayCustom<T> extends DynamicArrayAbstract<T>{
	
	@Override
	public T[] growthStrategy(int i) {
		T[] newData;
		if (count == data.length) {
			newData = (T[]) new Object[(data.length * 3) + 1];
		}
		else
			newData = (T[]) data;

		for(int j = 0; j < i; j++) {
			newData[j] = (T) data[j];
		}

		for(int j = i + 1; j <= size(); j++) {
			newData[j] = (T) data[j - 1];
		}
		count++;
		return newData;
	}
	
	@Override
	public T[] shrinkStrategy(int i) {
		T[] newData = (T[]) new Object[data.length - 1];
		count--;
		for(int j = 0; j < i; j++) {
			newData[j] = (T)data[j];
		}

		for(int j = i; j < size(); j++) {
			newData[j] = (T)data[j + 1];
		}

		return newData;
	}

}
