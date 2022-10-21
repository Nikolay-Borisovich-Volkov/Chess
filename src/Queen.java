import static java.lang.Math.abs;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int stepL = toLine - line;
        int stepC = toColumn - column;
        boolean  sua = chessBoard.board[toLine][toColumn].getColor().equals(this.color);
        boolean eq = line == toLine && column == toColumn;
        boolean board = toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0;
        boolean queen = (abs(stepL) == abs(stepC))||(line == toLine || column == toColumn);
        if (eq||board||sua)return false;
        else return queen;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
