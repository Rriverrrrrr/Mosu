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
import java.util.Scanner;

class Kine{
	public static void kinematics(){
			//Initialize stuff
		Scanner input = new Scanner(System.in);
		Scalar t = new Scalar(0, Dim.tim); //time (seconds)
		String temp;
		
		//Prompt user for variable values
		System.out.println("For velocity and acceleration, enter as a 3-dimensional vector separated by spaces, eg. \"0 0 0\".");
		System.out.print("Initial velocity (m/s): ");
		temp = input.nextLine();
		Vector vi = new Vector(temp, Dim.vel); //Initial velocity
		System.out.print("Time (s): ");
		t.value = input.nextDouble();
		input.nextLine();
		System.out.print("Acceleration (m/s/s): ");
		temp = input.nextLine();
		Vector a = new Vector(temp, Dim.acc); //Acceleration
		
		//Solve final velocity
		Vector vf = solveVf(vi, a, t);
		System.out.println("\nFinal velocity: " + vf.toString());
		
		//Solve change in position
		Vector s = solveDX(vi, a, t);
		System.out.println("Change in position: " + s.toString());
	};
	
	private static Vector solveVf(Vector v0, Vector ac, Scalar time){
		return Vector.addVectors(v0, Vector.multiplyScalar(ac, time)); //Calculates final velocity
	};
	
	private static Vector solveDX(Vector v0, Vector ac, Scalar time){
		return Vector.addVectors(Vector.multiplyScalar(v0, time), Vector.multiplyScalar(Vector.multiplyScalar(ac, 0.5), time.pow(2))); //Solves for final position
	};
}
