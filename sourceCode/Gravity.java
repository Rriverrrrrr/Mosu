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
import java.util.Scanner;
import java.util.Arrays;

class Gravity{
	static final double gravConst = 6.6743 * Math.pow(10, -11);
	static Scanner input = new Scanner(System.in);
	static Point[] pts = new Point[2];
	static String temp;
	static int runTime = 1024;
	
	public static void grav(){

		System.out.println("\nMOSU GRAVITY SIMULATOR");
		while(2 > 1){
			System.out.println("Please enter a command: ");
		
			String command = input.nextLine();
			String[] commPart = Mosu.getCommand(command);
		
			if (commPart[0].equals("setPoint0") == true){ //Creates command to create the first point
		
				System.out.println("Enter position vector: ");
				temp = input.nextLine();
				pts[0] = new Point(temp);
			
				System.out.println("Enter initial velocity: ");
				temp = input.nextLine();
				pts[0].setVel(Vector.conv(temp, "velocity"));
			
				System.out.println("Enter mass: ");
				pts[0].mass = input.nextDouble();
			
				System.out.println("Point 0 setup complete.");
			
			}
			if (commPart[0].equals("setPoint1") == true){ //Creates command to create the second point
		
				System.out.println("Enter position vector: ");
				temp = input.nextLine();
				pts[1] = new Point(temp);
				
				System.out.println("Enter initial velocity vector: ");
				temp = input.nextLine();
				pts[1].setVel(Vector.conv(temp, "velocity"));
			
				System.out.println("Enter mass: ");
				pts[1].mass = input.nextDouble();
			
				System.out.println("Point 1 setup complete.");
			
			}
			if (commPart[0].equals("setTime") == true){ //Creates command to input run time
				System.out.println("Enter time in seconds: ");
				double t = input.nextDouble();
				runTime = (int)(t * 1024.0);
			}
			if (commPart[0].equals("runGrav") == true){ //Runs simulation
				runGrav();
			}
			if (commPart[0].equals("exit") == true){ //Exits program
				break;
			}
			input.nextLine();
		}
	}
	
	private static void runGrav(){ //Runs gravity simulation
		if (pts[0] == null || pts[1] == null){ //Failsafe in case user forgot to set up a point
			System.out.println("One or both of the points were not created. Please use both setPoint0 and setPoint1 to create both points.");
		}else{
			System.out.println("All systems go"); //Placeholder to show that the program works
			
			
			for (int i = 0; i <= runTime; i++){
				pts[0].acceleration = calcGAcc(pts[0], pts[1]);
				pts[1].acceleration = calcGAcc(pts[1], pts[0]);
				
				if (i % 1024 == 0 || i == runTime){ //Prints info every second and at end
					System.out.println("Point 0: \n" + pts[0]);
					System.out.println("Point 1: \n" + pts[1]);
					System.out.println("Force: " + calcGForce(pts[0], pts[1]) + "\n");
					System.out.println("Distance: \n" + Vector.getDist(pts[0].position, pts[1].position) + " meters\n\n");
				};
				
				pts[0].timeStep(1.0 / 1024.0);
				pts[1].timeStep(1.0 / 1024.0);
				Point.time -= (1.0 / 1024.0); //Temporary measure to keep time consistent
			}
		}
	}
	
	private static Vector calcGForce(Point a, Point b){ //Calculates the gravitational force that point b exerts on point a
		Vector disp = Vector.getDisp(a.position, b.position, "position"); //Displacement vector between points
		
		double forceMag = gravConst * ((a.mass * b.mass) / Math.pow(disp.scalar(), 2)); //Calculates magnitude of force with gravity formula
		
		Vector gForce = Vector.multiplyScalar(Vector.unitVector(disp), forceMag); //Sets grav force to unit vector times magnitude
		gForce.setType("force");
		return gForce;		
	}
	
	private static Vector calcGAcc(Point a, Point b){ //Calculates gravity acceleration of point a
		Vector gAcc = Vector.multiplyScalar(calcGForce(a, b), 1.0 / a.mass);
		
		gAcc.setType("acceleration");
		return gAcc;
	}
	
	public static void main(String[] arguments){ //Executes gravity command when file launched 
		grav();
	}
}
