package fill;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	class pair {
		private int x;
	    private int y;
	    pair(int w, int h){
	        x = w;
	        y = h;
	    }
	}
    public void solve(char[][] board) {
        if(board == null){
            return;
        }
        Queue<pair> queue = new LinkedList<pair>();
        for(int i = 0; i < board[0].length; ++i){
            if(board[i][0] == 'O')
                queue.add(new pair(i, 0));
            if(board[i][board.length-1] == 'O')
                queue.add(new pair(i, board.length-1));
        }
        for(int j = 0; j < board[0].length; ++j){
            if(board[0][j] == 'O')
                queue.add(new pair(0, j));
            if(board[board.length-1][j] == 'O')
                queue.add(new pair(board.length-1, j));
        }
        bfs(queue, board);
        for(int i = 0; i < board.length; ++i){
            for(int j = 0; j < board[0].length; ++j){
                if(board[i][j] == '#')
                    board[i][j] = 'O';
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }
    public void bfs(Queue<pair> queue, char[][] board){
        while(!queue.isEmpty()){
            pair p = queue.poll();
            int x = p.x;
            int y = p.y;
            if(x >= 0 && x < board.length && y >= 0 && y < board[0].length && board[x][y] == 'O'){
                board[x][y] = '#';
                queue.add(new pair(x-1 ,y));
                queue.add(new pair(x+1 ,y));
                queue.add(new pair(x ,y-1));
                queue.add(new pair(x ,y+1));
            }
        }
    }
    public static void main(String[] args){
    	char[][] board = {{'O','X'}, {'O', 'X'}};
    	Solution S = new Solution();
    	S.solve(board);
    	System.out.println(board);
    }
}
