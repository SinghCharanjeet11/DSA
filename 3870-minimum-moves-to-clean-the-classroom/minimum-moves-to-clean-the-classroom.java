class Solution {
    static class State{
        int row;
        int col;
        int energy;
        int mask;
        State(int row, int col, int energy, int mask){
            this.row=row;
            this.col=col;
            this.energy=energy;
            this.mask=mask;
        }
    }
    public int minMoves(String[] classroom, int energy) {
        int m=classroom.length;
        int n=classroom[0].length();

        int startRow=0;
        int startCol=0;
        int totalLitter=0;

        int[][] litterNumber=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                litterNumber[i][j]=-1;
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                char c=classroom[i].charAt(j);
                if(c=='S'){
                    startRow=i;
                    startCol=j;
                }
                if(c=='L'){
                    litterNumber[i][j]=totalLitter;
                    totalLitter++;
                }
            }
        }
        int allAllocated= (1<<totalLitter)-1;

        Queue<State>q= new  LinkedList<>();
        q.offer(new State(startRow, startCol,energy,0));

        boolean[][][][] visited= new boolean[m][n][energy+1][1<<totalLitter];

        visited[startRow][startCol][energy][0]=true;

        int moves=0;
        int[][] directions= {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while(!q.isEmpty()){
            int size=q.size();

            while(size -->0){
                State curr=q.poll();
                if(curr.mask==allAllocated){
                    return moves;
                }
                if(curr.energy==0){
                    continue;
                }
                for(int[] direction: directions){
                    int newRow= curr.row + direction[0];
                    int newCol= curr.col + direction[1];
                    
                    if(newRow<0 || newRow>=m ||
                    newCol<0 || newCol >=n){
                        continue;
                    }
                    if(classroom[newRow].charAt(newCol)=='X'){
                        continue;
                    }
                    int newEnergy= curr.energy -1;
                    int newMask= curr.mask;
                    
                    char cell= classroom[newRow].charAt(newCol);
                    if(cell=='L'){
                        int litterNumberAtCell =litterNumber[newRow][newCol];

                        newMask |= (1<<litterNumberAtCell);
                    }
                    if(cell=='R'){
                        newEnergy =energy;
                    }
                    if(visited[newRow][newCol][newEnergy][newMask]){
                        continue;
                    }
                    visited[newRow][newCol][newEnergy][newMask]=true;
                    q.offer(new State(newRow, newCol, newEnergy, newMask));
                }
            }
            moves++;
        }

    return -1;
    }
}