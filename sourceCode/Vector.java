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
    
import java.lang.Math;
import java.util.Arrays;

public class Vector{
	public double[] crd = new double[3]; //List of 3 coordinates (x, y, z)
	public int[] dim;
	
	Vector(String coords, int[] dims){ //Constructs a vector with a string containing 3 coordinates (eg. "1 0 0")
		crd[0] = Double.parseDouble(coords.substring(0, coords.indexOf(" ")));
		crd[1] = Double.parseDouble(coords.substring(coords.indexOf(" ") + 1, coords.lastIndexOf(" ")));
		crd[2] = Double.parseDouble(coords.substring(coords.lastIndexOf(" ") + 1));
		dim = dims;
	};
	Vector(double x, double y, double z, int[] dims){ //Constructs a vector with 3 coordinates as doubles
		crd[0] = x;
		crd[1] = y;
		crd[2] = z;
		dim = dims;
		
	};
	public void setDim(int[] dims){
		dim = dims;
	};
	public String toString(){ //Returns coordinates and scalar representation in parentheses (eg. 1 0 0 (1))
		return crd[0] + " " + crd[1] + " " + crd[2] + " (" + scalar().value + ")";
	};
	public Scalar scalar(){ //Calculates a scalar representation of the vector using Pythagorean Theorem
		return new Scalar(Math.pow(Math.pow(crd[0], 2) + Math.pow(crd[1], 2) + Math.pow(crd[2], 2), 0.5), dim);
	};
	public static Vector addVectors(Vector v1, Vector v2){ //Adds two input vectors together
		Dim.check(v1.dim, v2.dim);
		return new Vector(v1.crd[0] + v2.crd[0], v1.crd[1] + v2.crd[1], v1.crd[2] + v2.crd[2], v1.dim);
	};
	public void addVector(Vector v){ //Adds input vector to reference vector
		Dim.check(dim, v.dim);
		crd[0] += v.crd[0];
		crd[1] += v.crd[1];
		crd[2] += v.crd[2];
	};
	public static Vector multiplyScalar(Vector v, Scalar s){ //Multiplies a vector by a scalar
		return new Vector(v.crd[0] * s.value, v.crd[1] * s.value, v.crd[2] * s.value, Dim.multiply(v.dim, s.dim));
	};
	public static Vector multiplyScalar(Vector v, double s){ //Multiplies a vector by a double
		return new Vector(v.crd[0] * s, v.crd[1] * s, v.crd[2] * s, v.dim);
	};
	public static Vector conv(String v, int[] dims){ //Converts string of 3 numbers into a vector
		return new Vector(v, dims);
	};
	public static Vector getDisp(Vector a, Vector b){ //Gets vector distance from a to b
		return addVectors(multiplyScalar(a, -1), b);
	};
	public static Scalar getDist(Vector a, Vector b){ //Gets scalar distance
		Vector disp = getDisp(a, b);
		return disp.scalar();
	};
	public static Vector unitVector(Vector a){ //Gets the unit vector of the direction
		return multiplyScalar(a, a.scalar().pow(-1));
	};
}
