
package BinarySearch;
import java.util.Arrays;
public class ChessTournament {
//opposite of allocate pages question

//Chess tournament is going to be organized in Ninjaland. 
//There will be C chess players going to attend the tournament. All the players will be staying in a hotel. 
//The hotel has N free rooms available for the players, where one player will choose one room to live in. 
//The ith room is at position[i] in the hotel. All rooms are in distinct positions.
//Focus level of a chess player is defined as the minimum distance between his room and the room of another player.
//The overall focus of a tournament is defined as the minimum focus level among all players. 
//You as an organizer obviously want the overall focus as high as possible so you assign the rooms to players such that the overall focus is as high as possible.

public static int calcOptimalFocus(int[] pos, int p){
    int ans=0;
    //range of correct ans will lie b/w 1 and max(pos)

    Arrays.sort(pos);

    int max=pos[pos.length-1];

    int l=1;
    int r=max;

    while(l<r){

        int mid=(l+r)/2;

        if(isPossible(pos, p, mid)){
            l=mid;

        }
        else{
            r=mid-1;
        }


    }
    



    return ans;

}

private static boolean isPossible(int[] pos, int p, int mid) {

    int cnt=1;

    //we have to minimize the maximum focus

    //include room only if dist>curr_focus i.e mid

    int prev_room=pos[0];

    for(int i=1; i<pos.length; i++){
        
        if(mid<= pos[i]-prev_room){
            cnt++;
            prev_room=pos[i];
        }
    }

    if(cnt>=p)
    return true;

    return false;
}
    
}
