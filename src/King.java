import static java.lang.Math.abs;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column){
        for ( int i = 0; i  < board.board.length; i++ ){//ChessPiece[]
            for (int j = 0; j < board.board[i].length; j++ ){
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
        boolean eq = (line == toLine && column == toColumn)||(abs(stepL) > 1 || abs(stepC) > 1);
        boolean board = toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0;
        boolean king = (abs(stepL) == abs(stepC))||(line == toLine || column == toColumn);
        if (eq||board) return false;
        else return king;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}