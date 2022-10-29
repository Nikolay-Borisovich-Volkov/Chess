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
        int stepC = toColumn - column;
        boolean sua = chessBoard.board[toLine][toColumn] != null && chessBoard.board[toLine][toColumn].getColor().equals(color);
        boolean eq = line == toLine && column == toColumn;
        boolean pawnW = color.equals("White") && chessBoard.board[toLine][toColumn] == null && ((stepL == 1 && stepC == 0)|| (line == 1 && stepL == 2));
        boolean pawnB = color.equals("Black") && chessBoard.board[toLine][toColumn] == null && ((stepL == -1 && stepC == 0) || (line == 6 && stepL == -2));
        boolean whiteTake = color.equals("White") && stepL == 1 && abs(stepC) == 1 && ((chessBoard.board[toLine][toColumn] != null  && chessBoard.board[toLine][toColumn].getColor().equals("Black")) || (chessBoard.board[toLine][toColumn] == null  && chessBoard.board[toLine - 1][toColumn] != null && chessBoard.board[toLine - 1][toColumn].getSymbol().equals("P") && !chessBoard.board[toLine - 1][toColumn].check));
        boolean blackTake = color.equals("Black") && stepL == -1 && abs(stepC) == 1 && ((chessBoard.board[toLine][toColumn] != null  && chessBoard.board[toLine][toColumn].getColor().equals("White")) || (chessBoard.board[toLine][toColumn] == null  && chessBoard.board[toLine + 1][toColumn] != null && chessBoard.board[toLine + 1][toColumn].getSymbol().equals("P") && !chessBoard.board[toLine + 1][toColumn].check));
        if ((pawnB || pawnW) && abs(stepL) == 2) this.check = false;
        if (eq||sua)return false;
        else return pawnB || pawnW || whiteTake || blackTake;

    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
