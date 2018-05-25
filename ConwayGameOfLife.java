
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConwayGameOfLife {
	
	ConwayGameOfLife(){
	}
	
	int[][] calculateNextState(int[][] initial){
		int[][] nextState = new int[initial.length][initial[0].length];
		
		for(int i = 0 ; i<nextState.length ; i++){
			for(int j = 0 ; j < nextState[i].length ; j++){
				boolean live = updateState(initial, i, j);
				nextState[i][j] = live ? 1 : 0;
			}
		}
		
		return nextState;
	}
	
	boolean updateState(int[][] initial, int i, int j){
		int liveCount = 0;
		for(int checki = i-1; checki <= i+ 1 ; checki++){
			for(int checkj = j-1 ; checkj <= j+1; checkj++){
				if(checki < 0 || checkj < 0 || checki >= initial.length || checkj >= initial[i].length || (checki == i && checkj == j))
					continue;
				
				liveCount += initial[checki][checkj];
			}
		}
		
		if(initial[i][j] == 1){
			//initial state was live
			return liveCount == 2 || liveCount == 3;
		}
		
		//initial state was dead
		return liveCount == 3;
	}
	
	int[][] findKthState(int k, int[][] initial){
		int[][] state = new int[initial.length][initial[0].length];
		
		int stateCount = 1;
		while(k-- > 0){
			state = calculateNextState(initial);
			System.out.println("# State " + stateCount++);
			printState(state);
			initial = state;
		}
		return state;
	}
	
	void printState(int[][] state){
		for(int i = 0; i< state.length ; i++){
			for(int j = 0 ; j< state[i].length ; j++){
				System.out.print(state[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	static int[][] makeInput(String fileName){
		int[][] initial = null;
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(fileName));
			
			String currentLine = br.readLine();
			String[] size = currentLine.split(" ");
			initial = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
			
			int row = 0 ; 
			
			while((currentLine = br.readLine()) != null){
				String[] line = currentLine.split(" ");
				int col = 0;
				for(String str : line){
					if(str.equals("0"))
						initial[row][col++] = 0;
					else if(str.equals("1"))
						initial[row][col++] = 1;
					else continue;
				}
				row++;
			}
			
		} catch (IOException e) {
			System.out.println("Exception happened while opening input file..." + e.getMessage());
			e.printStackTrace();
		} finally{
			if(br != null)
				try {
					br.close();
				} catch (IOException e) {
					System.out.println("Exception happened while closing input file..." + e.getMessage());
					e.printStackTrace();
				}
		}
		
		return initial;
	} 
	
	
	public static void main(String[] args){
		
		ConwayGameOfLife gameOfLife = new ConwayGameOfLife();
		int[][] initial = makeInput(args[0]);
		System.out.println("Initial State: ");
		gameOfLife.printState(initial);
		
		System.out.println("Next State after initial State: ");
		int[][] nextState = gameOfLife.calculateNextState(initial);
		gameOfLife.printState(nextState);
		
		int k = 4;
		System.out.println("Now printing k ("+ k + ") states after initial State: ");
		gameOfLife.findKthState(k, initial);
	}

}
