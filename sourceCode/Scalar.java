    /*Mosu Universal Physics Engine v0.2.1, released 04-25-2026
    Copyright (C) 2026 River Olsen

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.*/

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
