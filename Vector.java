    /*Mosu Universal Physics Engine v0.1, released 04-10-2026
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
	public double[] crd = new double[3];
	
	Vector(String coords){
		crd[0] = Double.parseDouble(coords.substring(0, coords.indexOf(" ")));
		crd[1] = Double.parseDouble(coords.substring(coords.indexOf(" ") + 1, coords.lastIndexOf(" ")));
		crd[2] = Double.parseDouble(coords.substring(coords.lastIndexOf(" ") + 1));
	};
	Vector(double x, double y, double z){
		crd[0] = x;
		crd[1] = y;
		crd[2] = z;
	};
	public String toString(){
		return crd[0] + " " + crd[1] + " " + crd[2];
	};
	public double scalar(){
		return Math.pow(Math.pow(crd[0], 2) + Math.pow(crd[1], 2) + Math.pow(crd[2], 2), 0.5);
	}
}
