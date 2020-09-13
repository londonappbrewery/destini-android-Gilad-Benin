package com.londonappbrewery.destini;

public class StoryNode {

    private String text;
    private StoryNode leftNode;
    private StoryNode rightNode;
    private String leftAnswer;
    private String rightAnswer;

    public StoryNode(String text) {
        this(text, null, null, null, null);
    }
//    public StoryNode(String text, StoryNode leftNode, StoryNode roghtNode) {
//        this.text = text;
//        this.leftNode = leftNode;
//        this.rightNode = roghtNode;
//    }

    public StoryNode(String text, String leftAnswer, String rightAnswer, StoryNode leftNode, StoryNode rightNode) {
        this.text = text;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.leftAnswer = leftAnswer;
        this.rightAnswer = rightAnswer;
    }

    public String getText() {
        return text;
    }

    public StoryNode getLeftNode() {
        return leftNode;
    }

    public StoryNode getRightNode() {
        return rightNode;
    }

    public String getLeftAnswer() {
        return leftAnswer;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public boolean isEndOfStory() {
        return leftNode == null && rightNode == null;
    }
}
