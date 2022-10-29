import static java.lang.Math.abs;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        for ( int i = 0; i  < board.board.length; i++ ) {
            for (int j = 0; j < board.board[i].length; j++ ) {
                if (board.board[i][j]!= null && !(this.getColor().equals(board.board[i][j].getColor()))&& board.board[i][j].canMoveToPosition(board,i,j,line,column)) return true;
            }
        }
        return false;
    }


    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        int stepL = toLine - line;
        int stepC = toColumn - column;
        boolean sua = chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color);
        boolean eq = (line == toLine && column == toColumn)||(abs(stepL) > 1 || abs(stepC) > 1);
        boolean king = (abs(stepL) == abs(stepC))||(line == toLine || column == toColumn);
        if (eq||sua) return false;
        else return king;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}
