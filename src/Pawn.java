import static java.lang.Math.abs;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        int stepL = toLine - line;
        boolean eq = line == toLine || column != toColumn;
        boolean board = toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0;
        boolean pawnW = color.equals("White") && (stepL == 1 ||(line == 1 && stepL == 2));
        boolean pawnB = color.equals("Black") && (stepL == -1 ||(line == 6 && stepL == -2));
        if (eq||board)return false;
        else return pawnB || pawnW;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}