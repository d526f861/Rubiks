public class Hamming{

	public int getDistance(Cube cube){

		int distance = 0;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				if(cube.getFaces()[i][j] != i)
					distance++;

		return distance;
	}

	public int mostFit(Cube[] options){

		int most = 0;
		int fitness = getDistance(options[0]);

		for(int i = 1; i < options.length; i++)
			if(getDistance(options[i]) <= fitness){

				fitness = getDistance(options[i]);
				most = i;
			}

		return most;
	}

	public int getDistanceToGoal(Cube cube, int[][] goal){

		int distance = 0;

		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 9; j++)
				if(goal[i][j] != -1 && goal[i][j] != cube.getFaces()[i][j])
					distance++;

		return distance;
	}

	public int mostFitToGoal(Cube[] options, int[][] goal){

		int most = 0;
		int fitness = getDistanceToGoal(options[0], goal);

		for(int i = 1; i < options.length; i++)
			if(getDistanceToGoal(options[i], goal) <= fitness){

				fitness = getDistanceToGoal(options[i], goal);
				most = i;
			}

		return most;
	}
}