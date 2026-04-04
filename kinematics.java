    /*Mosu Universal Physics Engine v0.0, released 04-04-2026
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

class Kine{
	public static double solveVf(double vi, double a, double t){
		return vi + (a * t); //Solves for final velocity
	}
	
	public static double solveDX(double vi, double a, double t){
		return (vi * t) + (0.5 * a * Math.pow(t, 2)); //Solves for final position
	};
}
