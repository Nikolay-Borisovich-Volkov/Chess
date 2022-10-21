import static java.lang.Math.abs;

public class Horse extends ChessPiece {

    public Horse(String color) {
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
        boolean horse = abs(stepL) == 2 && abs(stepC) == 1||abs(stepL) == 1 && abs(stepC) == 2;
        if (eq||board)return false;
        else return horse;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
