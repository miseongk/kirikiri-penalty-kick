package penaltykick.domain;

import java.util.List;

import static penaltykick.utill.Reference.*;


public class Player {
    private  List<Integer> directionList;
    private String resultList = "";
    private int point = 0;
    public Player(List<Integer> list){
            this.directionList = list;
    }
    public void calculatePoint( List<Integer> computerDirection) {
        for(int i = 0 ; i < INPUT_COUNT; i++){
            if(directionList.get(i) != computerDirection.get(i)) {
                this.point++;
                this.resultList += GOAL_SIGN;
            }else if(directionList.get(i) == computerDirection.get(i)) {
                this.resultList+=NO_GOAL_SIGN;
            }
        }
    }
    public int getPoint(){
        return this.point;
    }
    public String getResultList(){
        return this.resultList;
    }
    public List<Integer> getDirectionList(){
        return this.directionList;
    }
}
