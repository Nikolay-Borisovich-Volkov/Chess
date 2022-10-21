import static java.lang.Math.abs;

public class Bishop extends ChessPiece{
    public Bishop(String color) {
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
        boolean eq = line == toLine||column == toColumn;
        boolean board = toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0;
        boolean bishop = abs(stepL) == abs(stepC);
        if (eq||board)return false;
        else return bishop;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
