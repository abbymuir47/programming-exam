package chess;

import java.util.ArrayList;
import java.util.Collection;

public class KnightMovesCalculator implements PieceMovesCalculator{

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition){
        Collection<ChessMove> moves = new ArrayList<>();

        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessGame.TeamColor myColor = board.getPiece(myPosition).getTeamColor();

        int[][] combinations = {
                {2,1},{2,-1},
                {1,2},{1,-2},
                {-1,2},{-1,-2},
                {-2,1},{-2,-1}
        };

        int newRow;
        int newCol;

        for(int i=0;i<combinations.length;i++){
            newRow = row + combinations[i][0];
            newCol = col + combinations[i][1];

            if(newRow>0 && newRow <9 && newCol>0 && newCol<9){
                ChessPosition newPos = new ChessPosition(newRow, newCol);

                if(board.getPiece(newPos)==null){
                    moves.add(new ChessMove(myPosition,newPos,null));
                }
                if(board.getPiece(newPos)!=null && board.getPiece(newPos).getTeamColor()!=myColor){
                    moves.add(new ChessMove(myPosition,newPos,null));
                }
            }
        }

        return moves;
    }
}