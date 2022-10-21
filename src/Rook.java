public class Rook extends ChessPiece {

    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        boolean eq = line == toLine && column == toColumn;
        boolean board = toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0;
        boolean rook = line == toLine || column == toColumn;
        if (eq||board)return false;
        else return rook;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
