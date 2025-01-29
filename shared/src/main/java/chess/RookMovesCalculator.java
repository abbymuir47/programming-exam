package chess;

import java.util.ArrayList;
import java.util.Collection;

public class RookMovesCalculator implements PieceMovesCalculator{

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition){
        Collection<ChessMove> moves = new ArrayList<>();

        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessGame.TeamColor myColor = board.getPiece(myPosition).getTeamColor();

        int[][] combinations = {
                {1,0},
                {0,1},{0,-1},
                {-1,0}
        };

        int newRow;
        int newCol;

        for(int i=0;i<combinations.length;i++){
            newRow = row + combinations[i][0];
            newCol = col + combinations[i][1];

            while(newRow>0 && newRow <9 && newCol>0 && newCol<9){
                ChessPosition newPos = new ChessPosition(newRow, newCol);

                if(board.getPiece(newPos)==null){
                    moves.add(new ChessMove(myPosition,newPos,null));
                }
                if(board.getPiece(newPos)!=null && board.getPiece(newPos).getTeamColor()!=myColor){
                    moves.add(new ChessMove(myPosition,newPos,null));
                    break;
                }
                if(board.getPiece(newPos)!=null && board.getPiece(newPos).getTeamColor()==myColor){
                    break;
                }

                newRow += combinations[i][0];
                newCol += combinations[i][1];
            }
        }

        return moves;
    }
}
