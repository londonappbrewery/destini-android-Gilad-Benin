package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:

    private StoryNode currNode;

    private TextView storyText;
    private Button leftButton;
    private Button rightButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        currNode = loadStory();
        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        storyText = findViewById(R.id.storyTextView);
        leftButton = findViewById(R.id.buttonTop);
        rightButton = findViewById(R.id.buttonBottom);




        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currNode = currNode.getLeftNode();
                loadStoryNode(currNode);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currNode = currNode.getRightNode();
                loadStoryNode(currNode);
            }
        });

    }

    private void loadStoryNode(StoryNode node) {
        storyText.setText(node.getText());
        if (! node.isEndOfStory()) {
            rightButton.setText(node.getRightAnswer());
            leftButton.setText(node.getLeftAnswer());
        } else {
            leftButton.setVisibility(View.GONE);
            rightButton.setVisibility(View.GONE);
        }
    }

    private StoryNode loadStory() {
        StoryNode t4End = new StoryNode(getString(R.string.T4_End));
        StoryNode t5End = new StoryNode(getString(R.string.T5_End));
        StoryNode t6End = new StoryNode(getString(R.string.T6_End));

        StoryNode t3Node = new StoryNode(getString(R.string.T3_Story),
                getString(R.string.T3_Ans1), getString(R.string.T3_Ans2), t6End, t5End);
        StoryNode t2Node = new StoryNode(getString(R.string.T2_Story),
                getString(R.string.T2_Ans1), getString(R.string.T2_Ans2), t3Node, t4End);
        StoryNode t1Node = new StoryNode(getString(R.string.T1_Story),
                getString(R.string.T1_Ans1), getString(R.string.T1_Ans2), t3Node, t2Node);
        return  t1Node;
    }
}
