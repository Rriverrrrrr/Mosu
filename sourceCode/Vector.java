    /*Mosu Universal Physics Engine v0.2, released 04-19-2026
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

public class Vector{
	public double[] crd = new double[3]; //List of 3 coordinates (x, y, z)
	public String type;
	
	Vector(String coords, String typ){ //Constructs a vector with a string containing 3 coordinates (eg. "1 0 0")
		crd[0] = Double.parseDouble(coords.substring(0, coords.indexOf(" ")));
		crd[1] = Double.parseDouble(coords.substring(coords.indexOf(" ") + 1, coords.lastIndexOf(" ")));
		crd[2] = Double.parseDouble(coords.substring(coords.lastIndexOf(" ") + 1));
		type = typ;
	};
	Vector(double x, double y, double z, String typ){ //Constructs a vector with 3 coordinates as doubles
		crd[0] = x;
		crd[1] = y;
		crd[2] = z;
		type = typ;
		
	};
	public void setType(String t){
		type = t;
	};
	public String toString(){ //Returns coordinates and scalar representation in parentheses (eg. 1 0 0 (1))
		return crd[0] + " " + crd[1] + " " + crd[2] + " (" + scalar() + ")";
	};
	public double scalar(){ //Calculates a scalar representation of the vector using Pythagorean Theorem
		return Math.pow(Math.pow(crd[0], 2) + Math.pow(crd[1], 2) + Math.pow(crd[2], 2), 0.5);
	};
	public static Vector addVectors(Vector v1, Vector v2, String typ){ //Adds two input vectors together
		return new Vector(v1.crd[0] + v2.crd[0], v1.crd[1] + v2.crd[1], v1.crd[2] + v2.crd[2], typ);
	};
	public void addVector(Vector v){ //Adds input vector to reference vector
		crd[0] += v.crd[0];
		crd[1] += v.crd[1];
		crd[2] += v.crd[2];
	};
	public static Vector multiplyScalar(Vector v, double s){ //Multiplies a vector by a scalar
		return new Vector(v.crd[0] * s, v.crd[1] * s, v.crd[2] * s, v.type);
	};
	public static Vector conv(String v, String typ){ //Converts string of 3 numbers into a vector
		return new Vector(v, typ);
	};
	public static Vector getDisp(Vector a, Vector b, String typ){ //Gets vector distance from a to b
		return addVectors(multiplyScalar(a, -1), b, typ);
	};
	public static double getDist(Vector a, Vector b){
		Vector disp = getDisp(a, b, null);
		return disp.scalar();
	};
	public static Vector unitVector(Vector a){
		return multiplyScalar(a, 1.0 / a.scalar());
	};
}
