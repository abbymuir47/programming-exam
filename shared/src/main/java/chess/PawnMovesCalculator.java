package chess;

import java.util.ArrayList;
import java.util.Collection;

import static chess.ChessGame.TeamColor.*;
import static chess.ChessPiece.PieceType.*;

public class PawnMovesCalculator implements PieceMovesCalculator{

    @Override
    public Collection<ChessMove> pieceMoves(ChessBoard board, ChessPosition myPosition){
        Collection<ChessMove> moves = new ArrayList<>();

        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        ChessGame.TeamColor myColor = board.getPiece(myPosition).getTeamColor();

        ChessPosition forwardMove;
        ChessPosition moveTwo;
        ChessPosition attackRight;
        ChessPosition attackLeft;

        if(myColor==BLACK){
            forwardMove = new ChessPosition(row-1,col);
            moveTwo = new ChessPosition(row-2,col);
            attackRight = new ChessPosition(row-1,col+1);
            attackLeft = new ChessPosition(row-1,col-1);

            if(row>2){
                if(board.getPiece(forwardMove)==null){
                    moves.add(new ChessMove(myPosition,forwardMove,null));
                    if(row==7){
                        if(board.getPiece(moveTwo)==null) {
                            moves.add(new ChessMove(myPosition, moveTwo, null));
                        }
                    }
                }
                if(col<8) {
                    if (board.getPiece(attackRight) != null && board.getPiece(attackRight).getTeamColor() != myColor) {
                        moves.add(new ChessMove(myPosition, attackRight, null));
                    }
                }
                if(col>1){
                    if(board.getPiece(attackLeft)!= null && board.getPiece(attackLeft).getTeamColor()!=myColor){
                        moves.add(new ChessMove(myPosition, attackLeft,null));
                    }
                }
            }
            if(row==2){
                if(board.getPiece(forwardMove)==null){
                    promote(myPosition, moves, forwardMove);
                }
                if(col<8) {
                    if (board.getPiece(attackRight) != null && board.getPiece(attackRight).getTeamColor() != myColor) {
                        promote(myPosition, moves, attackRight);
                    }
                }
                if(col>1){
                    if(board.getPiece(attackLeft)!= null && board.getPiece(attackLeft).getTeamColor()!=myColor){
                        promote(myPosition,moves,attackLeft);
                    }
                }
            }
        }

        if(myColor==WHITE){
            forwardMove = new ChessPosition(row+1,col);
            moveTwo = new ChessPosition(row+2,col);
            attackRight = new ChessPosition(row+1,col+1);
            attackLeft = new ChessPosition(row+1,col-1);

            if(row<7){
                if(board.getPiece(forwardMove)==null){
                    moves.add(new ChessMove(myPosition,forwardMove,null));
                    if(row==2){
                        if(board.getPiece(moveTwo)==null) {
                            moves.add(new ChessMove(myPosition, moveTwo, null));
                        }
                    }
                }
                if(col<8) {
                    if (board.getPiece(attackRight) != null && board.getPiece(attackRight).getTeamColor() != myColor) {
                        moves.add(new ChessMove(myPosition, attackRight, null));
                    }
                }
                if(col>1){
                    if(board.getPiece(attackLeft)!= null && board.getPiece(attackLeft).getTeamColor()!=myColor){
                        moves.add(new ChessMove(myPosition, attackLeft,null));
                    }
                }
            }
            if(row==7){
                if(board.getPiece(forwardMove)==null){
                    promote(myPosition, moves, forwardMove);
                }
                if(col<8) {
                    if (board.getPiece(attackRight) != null && board.getPiece(attackRight).getTeamColor() != myColor) {
                        promote(myPosition, moves, attackRight);
                    }
                }
                if(col>1){
                    if(board.getPiece(attackLeft)!= null && board.getPiece(attackLeft).getTeamColor()!=myColor){
                        promote(myPosition,moves,attackLeft);
                    }
                }
            }
        }

        return moves;
    }

    private static void promote(ChessPosition myPosition, Collection<ChessMove> moves, ChessPosition move) {
        moves.add(new ChessMove(myPosition, move,ROOK));
        moves.add(new ChessMove(myPosition, move,KNIGHT));
        moves.add(new ChessMove(myPosition, move,QUEEN));
        moves.add(new ChessMove(myPosition, move,BISHOP));
    }
}
