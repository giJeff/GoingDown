package controller;

public class PuzzleRoom extends Room {
	
	private String question;
	private String answerOne;
	private String answerTwo;
	private String answerThree;
	private String answerFour;
	private int correctAnswerIndex;
	private int questionPointValue;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswerOne() {
		return answerOne;
	}
	public void setAnswerOne(String answerOne) {
		this.answerOne = answerOne;
	}
	public String getAnswerTwo() {
		return answerTwo;
	}
	public void setAnswerTwo(String answerTwo) {
		this.answerTwo = answerTwo;
	}
	public String getAnswerThree() {
		return answerThree;
	}
	public void setAnswerThree(String answerThree) {
		this.answerThree = answerThree;
	}
	public String getAnswerFour() {
		return answerFour;
	}
	public void setAnswerFour(String answerFour) {
		this.answerFour = answerFour;
	}
	public int getCorrectAnswerIndex() {
		return correctAnswerIndex;
	}
	public void setCorrectAnswerIndex(int correctAnswerIndex) {
		this.correctAnswerIndex = correctAnswerIndex;
	}
	public int getQuestionPointValue() {
		return questionPointValue;
	}
	public void setQuestionPointValue(int questionPointValue) {
		this.questionPointValue = questionPointValue;
	}
	
}
