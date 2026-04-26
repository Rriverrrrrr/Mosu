import java.util.Arrays;

class Comm{
	public static String[] getCommand(String comm){
	
		String[] commandPart = new String[10];
		
		if (comm.contains(" ") == true){ //Gets base of command
		
			commandPart[0] = comm.substring(0, comm.indexOf(" "));
			
		}else{ //If there is only the base of the command
			
			commandPart[0] = comm;
			
		}
		return commandPart;
		
	}
}
