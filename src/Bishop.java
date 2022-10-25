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
        boolean barrier = false;
        boolean sua = chessBoard.board[toLine][toColumn].getColor().equals(color);
        boolean eqd = line == toLine||column == toColumn;
        boolean board = toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0;
        boolean bishop = abs(stepL) == abs(stepC);
        int countBarrier = 0;
        if(stepC > 1 && stepL > 1) {
            for (int i = 1; i < stepC || i < stepL; i++) {
                    if (chessBoard.board[line + i][column + i] != null) countBarrier++;
            }
        }
        if(stepC < -1 && stepL < -1) {
            for (int i = - 1; i > stepC || i > stepL; i--){
                if(chessBoard.board[line + i][column + i]!= null) countBarrier++;
            }
        }

        if(stepL > 1 && stepC < -1) {
            for (int i = 1; i < stepL; i++) {
                if(chessBoard.board[line + i][column - i]!= null) countBarrier++;
            }
        }

        if(stepC > 1 && stepL < -1 ) {
            for (int i = 1; i < stepC; i++) {
                if(chessBoard.board[line - i][column + i]!= null) countBarrier++;
            }
        }

        if (countBarrier !=0) barrier = true;
        if (eqd||board||sua||barrier)return false;
        else return bishop;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
