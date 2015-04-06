package com.kamaia.cupsyballs.pieces;

public class Cup {
	private String symbol;
	private int cupSize;
	private float posX;
	private float posY;
	private float speed;
	private boolean movingLeft;
	
	public Cup(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
		cupSize = 7;
		symbol = "|";
		for(int i = 0; i < cupSize; i++){
			symbol += "_";
		}
		symbol += "|";
		speed = .25f;
	}
	
	
	public void toggleLeft(){
		movingLeft = !movingLeft;
	}
	
	public void updateX(int level){
		if(!movingLeft){
			posX -= speed * level;
		}
		else{
			posX +=speed * level;
		}
	}
	public float getPosX(){
		return posX;
	}
	public float getPosY(){
		return posY ;
	}
	public String getSymbol(){
		return symbol;
	}
	public void updateY(int newY){
		posY = newY;
	}
	
	public int getCupSize(){
		return cupSize;
	}
	
	public void modCupSize(int cupMod){
		cupSize += cupMod;
		symbol = "|";
		for(int i = 0; i < cupSize; i++){
			symbol += "_";
		}
		symbol += "|";
	}

}
