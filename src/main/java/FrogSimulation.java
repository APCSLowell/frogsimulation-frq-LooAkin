public class FrogSimulation
{
	private int goalDistance;
	private int maxHops;
	
	public FrogSimulation(int dist, int numHops)
	{
		goalDistance = dist;
		maxHops = numHops;
		maxHopsHolder = numHops;  //ignore this, it's used for testing
	}
	
	//private int hopDistance() 
	//implementation is below, but not important
	
	public boolean simulate()
	{ 
		int count = 0;
		int distanceHopped = 0;
		while(count < maxHops){
			distanceHopped = distanceHopped + hopDistance();
			if(distanceHopped >= goalDistance)
				return true;
			if(distanceHopped < 0)
				return false;
			count++;
		}
	return false;
	}
	
	public double runSimulations(int num)
	{ 
		int wins = 0;
		int numSims = 0;
		while(numSims < num){
			if(simulate() == true)
				wins++;
			numSims++;
		}
		return (double) wins/num;
	}
	
	
	//ignore the code below this line
	//-------------------------------------------------------------------------------------
	private int[] hopValues;
	private int hopIndex = 0;
	
	private int[][] hopValuesMatrix;
	private int row=0;
	private int col=0;
	
	
	private int maxHopsHolder;
	private String part; 
	
	
	private int hopDistance()
	{ 
		if( this.part.equals("A") )
		{
			int value = 0;
			if( hopValues != null && hopIndex < hopValues.length )
			{
				value = hopValues[hopIndex];
				hopIndex++;
			}
			
			return value;
		}
		else if (this.part.equals("B"))
		{
			int value = 0;
			if( hopValuesMatrix != null && row < hopValuesMatrix.length )
			{
				value = hopValuesMatrix[row][col];
				
				col++;
				
				if( col == hopValuesMatrix[row].length ){
					col = 0;
					row++;
				}
			}
			
			return value;
		} else {
			return 0;
		}
	}
	
	public void setPart(String letter ){
		this.part = letter;
	}
	
	public void setHopValues(int[] hopValues)
	{
		this.hopValues = hopValues;
		this.hopIndex = 0;
		this.maxHops = maxHopsHolder;
	}
	
	public void setMultipleHopValues(int[][] hopValuesMatrix){
		this.hopValuesMatrix = hopValuesMatrix;
		this.row = 0;
		this.col = 0;
	}
	
	
	
	
} 
