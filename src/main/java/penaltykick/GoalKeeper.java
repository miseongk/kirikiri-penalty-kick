package penaltykick;

public class GoalKeeper { // Computer
    private int[] computer = new int[5];

    public GoalKeeper(){
        for (int i = 0; i < 5; i++) {
            computer[i] = (int)(Math.random()*2)+1;
        }
    }

    int goalKeeperGoal(int index){
        return computer[index];
    }

}
