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
    
import java.util.Scanner;
import java.util.Arrays;

class Mosu{
	public static void main(String[] arguments){
		//Print GNU license boiler plate
		System.out.println("MOSU UNIVERSAL PHYSICS ENGINE v0.2.1, RELEASED 04-25-2026");
		System.out.println("COPYRIGHT (C) 2026 RIVER OLSEN\n");
		System.out.println("    This program is free software: you can redistribute it and/or modify it under the terms of the GNU Affero General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.\n");
		System.out.println("    This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Affero General Public License for more details.\n");
		System.out.println("    You should have received a copy of the GNU Affero General Public License along with this program.  If not, see <https://www.gnu.org/licenses/>.\n\n");
		
		//Create scanner object called input
		Scanner input = new Scanner(System.in);
		
		//Command prompt
		System.out.println("Please enter a command: ");
		String command = input.nextLine();
		String[] commPart = Comm.getCommand(command);

		if (commPart[0].equals("kinematics")){
			Kine.kinematics();
		}
		if (commPart[0].equals("gravity")){
			Gravity.grav();
		}
	}
}
