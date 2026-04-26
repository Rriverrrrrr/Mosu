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

class Dim{
	//Defines values as arrays of the 7 SI units and their exponents
	//{seconds, meters, kilograms, amperes, kelvins, moles, candelas}
	
	final static public int[] len = {0, 1, 0, 0, 0, 0, 0}; //length
	final static public int[] vel = {-1, 1, 0, 0, 0, 0, 0}; //velocity
	final static public int[] acc = {-2, 1, 0, 0, 0, 0, 0}; //acceleration
	final static public int[] frc = {-2, 1, 1, 0, 0, 0, 0}; //force
	final static public int[] non = {0, 0, 0, 0, 0, 0, 0}; //none (Dimensionless, used for things like angles)
	final static public int[] tim = {1, 0, 0, 0, 0, 0, 0}; //time
	final static public int[] mas = {0, 0, 1, 0, 0, 0, 0}; //mass
	
	public static int[] multiply(int[] a, int[] b){ //Gets dimensions when two vectors or scalars are multiplied
		int [] c = new int[7];
		
		for (int i = 0; i < 7; i++){
			c[i] = a[i] + b[i];
		}
		
		return c;
	}
	
	public static void check(int[] a, int[] b){ //Checks if dimensions are the same; softlocks if not
		if (Arrays.equals(a, b) == false){
			System.out.println("Dimension error, please check code");
			softlock();
		}
	}
	
	public static void softlock(){ //Softlocks program, usually for dimension errors
		while (2 > 1){
			int aa = 1;
		}
	}
}
