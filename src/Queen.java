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
        boolean barrier = false;
        boolean sua = chessBoard.board[toLine][toColumn].getColor().equals(color);
        boolean eq = line == toLine && column == toColumn;
        boolean board = toLine > 7 || toLine < 0 || toColumn > 7 || toColumn < 0;
        boolean queen = (abs(stepL) == abs(stepC))||(line == toLine || column == toColumn);
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

        if(stepC > 1) {
            for (int i = 1; i < stepC; i++){
                if(chessBoard.board[line][column + i]!= null) countBarrier++;
            }
        }

        if(stepC < -1) {
            for (int i = -1; i > stepC; i--){
                if(chessBoard.board[line][column - i]!= null) countBarrier++;
            }
        }

        if(stepL > 1) {
            for (int i = 1; i < stepC; i++){
                if(chessBoard.board[line][column + i]!= null) countBarrier++;
            }
        }

        if(stepL < -1) {
            for (int i = -1; i > stepC; i--){
                if(chessBoard.board[line][column + i]!= null) countBarrier++;
            }
        }

        if (countBarrier !=0) barrier = true;

        if (eq||board||sua||barrier)return false;
        else return queen;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
