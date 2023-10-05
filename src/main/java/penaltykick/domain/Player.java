package penaltykick.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static penaltykick.utill.Reference.*;


public class Player {
    private final List<Integer> directionList;
    private final List<Character> resultList = new ArrayList<>();
    private int point = 0;
    public Player(List<Integer> list){
            this.directionList = list;
    }
    public void calculatePoint( List<Integer> computerDirection) {
        for(int i = 0 ; i < INPUT_COUNT; i++){
            if(directionList.get(i).equals(computerDirection.get(i))) {
                this.point++;
                this.resultList.add(GOAL_SIGN);
            }else {
                this.resultList.add(NO_GOAL_SIGN);
            }
        }
    }
    public int getPoint(){
        return this.point;
    }
    public String getResultList(){
        return resultList.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
    public List<Integer> getDirectionList(){
        return this.directionList;
    }
}
