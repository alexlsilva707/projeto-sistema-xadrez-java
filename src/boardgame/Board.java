package boardgame;

import javafx.geometry.Pos;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if(rows < 1 || columns < 1){
            throw new BoardException("Erro ao criar o tabuleiro: tem que ter pelo menos 1 linha e 1 coluna");
        }
        this.rows = rows;
        this.columns = columns;
        this.pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    //Retorna uma Piece do Board pela Linha/Coluna
    public Piece piece(int row, int column){
        if(!positionExists(row,column)){
            throw new BoardException("Posição não está no tabuleiro");
        }
        return pieces[row][column];
    }

    //Retorna uma Piece do Board pela Position
    public Piece piece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição não está no tabuleiro");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    //Coloca peças no Board
    public void placePiece(Piece piece, Position position){
        if(thereIsAPiece(position)){
            throw new BoardException("Já existe uma peça nessa posicao" + position);
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    //Verifica se a posicao existe

    public boolean positionExists(Position position){
        return position.getRow() >=0 && position.getRow() < this.rows && position.getColumn() >= 0 && position.getColumn() < this.columns;
    }

    //Verifica se a posicao existe pela linha/coluna
    private boolean positionExists(int row, int column){
        return row >=0 && row < this.rows && column >= 0 && column < this.columns;
    }

    //Verifica se tem peca na posicao indicada
    public boolean thereIsAPiece(Position position){
        if(!positionExists(position)){
            throw new BoardException("Posição não está no tabuleiro");
        }
        return piece(position) != null;
    }
}
