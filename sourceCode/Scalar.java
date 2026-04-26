import java.util.Arrays;
import java.lang.Math;

class Scalar{
	double value;
	int[] dim;
	
	public Scalar(double v, int[] dims){ //Creates scalar object with value and dimensions
		value = v;
		dim = dims;
	} 
	
	public void add(Scalar s){ //Adds two scalars
		Dim.check(dim, s.dim); //Softlocks if dimensions don't match
		value += s.value;
	}
	
	public static Scalar add(Scalar a, Scalar b){ //Adds two scalars and returns as separate value
		Dim.check(a.dim, b.dim);
		return new Scalar(a.value + b.value, a.dim);
	}
	
	public void mult(Scalar s){ //Multiplies two scalars
		value *= s.value;
		dim = Dim.multiply(dim, s.dim);
	}
	
	public static Scalar mult(Scalar a, Scalar b){ //Multiplies scalars and returns as separate value
		return new Scalar(a.value * b.value, Dim.multiply(a.dim, b.dim));
	}
	
	public Scalar pow(int p){ //Returns scalar raised to power
		int[] powDim = new int[7];
		for (int i = 0; i < 7; i++){
			powDim[i] = dim[i] * p;
		}
		return new Scalar(Math.pow(value, p), powDim);
	}
	
	
	
	
}
