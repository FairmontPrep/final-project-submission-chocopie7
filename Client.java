import java.util.ArrayList;
import java.util.Arrays;


public class Client{
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> test_array_2 = new ArrayList<>();
        test_array_2.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 0, 0, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 1, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(9, 0, 0, 1, 0, 0, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 0, 0, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(0, 0, 0, 1, 2, 0, 0, 0 )));
        test_array_2.add(new ArrayList<>(Arrays.asList(1, 0, 0, 1, 1, 1, 1, 1 )));
        for (ArrayList<Integer> row : test_array_2) {
            System.out.println(row);
        }

    }
    public ArrayList<int[]> findStart(ArrayList<ArrayList<Integer>> input){
        int row = input.get(0).size();
        int column = input.size();
        ArrayList<int[]> returnarray = new ArrayList<int[]>();
        for(int i=0;i<row;i+=row-1){
            for(int j=0;j<column;j+=column-1){
                if(input.get(i).get(j)==1){
                    returnarray.add(new int[] {i,j});
                }
            }
        }
        return returnarray;
    }
    public ArrayList<int[]> findroute(ArrayList<int[]> start){
        for (int[] pos:start){
            ArrayList<int[]> path = new ArrayList<>();
            while (path(pos)){
                path.add(pos);
                pos=
            }
        else return findroute(
            (input)->{return {input[0]+1, input[1]}, input})||findroute(input+1)
    public int[] next(int[]){
        int
    }