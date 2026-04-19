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

class Point{
	Vector position = null;
	Vector velocity = new Vector(0, 0, 0, "velocity");
	Vector acceleration = new Vector(0, 0, 0, "acceleration");
	public double mass;
	static double time = 0.0;
	
	public Point(Vector pos){ //Creates point with position vector
		position = pos;
	}
	
	public Point(String pos){ //Creates point with coordinates in a string
		position = new Vector(pos, "position");
	}
	
	public void setPos(Vector pos){ //Sets position
		position = pos;
	}
	
	public void setVel(Vector vel){ //Sets velocity
		velocity = vel;
	}
	
	public void setAcc(Vector acc){ //Sets acceleration
		acceleration = acc;
	}
	
	public void setMass(double m){ //Sets mass (Used in Gravity class)
		mass = m;
	}
	
	public void timeStep(double dt){ //Calculates values after a small amount of time
		velocity.addVector(Vector.multiplyScalar(acceleration, dt)); //Adds acceleration vector multiplied by dt to velocity
		position.addVector(Vector.multiplyScalar(velocity, dt)); //Adds velocity vector multiplied by dt to position
		time += dt; //Modifies time
	}
	public String toString(){
		return "Time (s): " + time + "\nPosition: " + position + "\nVelocity: " + velocity + "\n"; //Displays info about point
	}
	
	public static void main(String[] arguments){
		Point p = new Point("0 0 0");
		p.setAcc(Vector.conv("1 1 1", "acceleration"));
		p.setVel(Vector.conv("-1 -1 -1", "velocity"));
		
		for (int i = 0; i < (int)Math.pow(2, 14); i++){
			p.timeStep(1.0 / 128.0);
			if (i % 128 == 127){
				System.out.println(p);
			}
		};
	}
	
}
