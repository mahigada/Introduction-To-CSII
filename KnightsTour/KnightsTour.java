
public class KnightsTour {
    public static int xMax = 5;
    public static int yMax = 5;
    public int xStart;
    public int yStart;
    public static int sol[][] = new int[xMax][yMax];

    public KnightsTour(int x, int y){
        xStart = x;
        yStart = y;
    }

    public boolean startTour(){
        if(tour(xStart, yStart, sol)){
            printSolution(sol);
            return true;
        }
        return false;
    }


    private static boolean isSafe(int x, int y) {
        return (x >= 0 && x < xMax && y >= 0 && y < yMax && sol[x][y] == 0);

    }
    private static void printSolution(int sol[][]) {
        for (int x = 0; x < xMax; x++) {
            for (int y = 0; y < yMax; y++)
                System.out.print( " " + sol[x][y] + " ");
            System.out.println();
        }

    }
    private static boolean isFull(int sol[][]){
        for (int x = 0; x < xMax; x++) {
            for (int y = 0; y < yMax; y++)
                if(sol[x][y]==0 ){
                    return false;
                }
        }

        return true;
    }
    private static boolean tour(int x, int y, int sol[][]){
        if(isFull(sol)){
            return true;
        }
        if (isSafe(x,y)){
            sol[x][y]=1;
           // printSolution(sol);
            // System.out.println(" ");
            if(tour(x+2,y+1,sol)){
                return true;
            }
            if(tour(x+2,y-1,sol)){
                return true;
            }
            if(tour(x-2,y+1,sol)){
                return true;
            }
            if(tour(x-2,y-1,sol)){
                return true;
            }
            if(tour(x+1,y+2,sol)){
                return true;
            }
            if(tour(x-1,y+2,sol)){
                return true;
            }
            if(tour(x+1,y-2,sol)){
                return true;
            }
            if(tour(x-1,y-2,sol)){
                return true;
            }
            else{
                sol[x][y]=0;
                return false;
            }

        }
        return false;
    }
   
}


