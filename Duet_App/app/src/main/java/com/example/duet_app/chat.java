package com.example.duet_app;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class chat extends AppCompatActivity {
    private LinearLayout chatLayout;
    private EditText messageEditText;
    private Button sendButton;
    private boolean firstMessage = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatLayout = findViewById(R.id.chatLayout);
        messageEditText = findViewById(R.id.messageEditText);
        sendButton = findViewById(R.id.sendButton);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = messageEditText.getText().toString().trim();
        if (!message.isEmpty()) {
            // Create a new TextView for the outgoing chat bubble
            TextView textViewOutgoing = new TextView(this);
            textViewOutgoing.setText(message);
            textViewOutgoing.setBackgroundResource(R.drawable.chat_bubble_outgoing);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            if (firstMessage) {
                layoutParams.setMargins(0, convertDpToPx(80), 0, 0); // Set top margin to 120dp for the first message
                firstMessage = false; // Set flag to false after the first message
            } else {
                layoutParams.setMargins(0, 8, 0, 8); // Default margin for consecutive messages
            }
            layoutParams.gravity = Gravity.END; // Align outgoing messages to the right
            textViewOutgoing.setLayoutParams(layoutParams);

            // Add the outgoing chat bubble to the chat layout
            chatLayout.addView(textViewOutgoing);

            // Clear the text input area
            messageEditText.getText().clear();

            // Simulate receiving a response after a delay
            simulateIncomingMessage(message); // Pass the sent message to simulateIncomingMessage
        }
    }

    private void simulateIncomingMessage(final String incomingMessage) {
        // Simulate a response message after a delay
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create a new TextView for the incoming chat bubble
                TextView textViewIncoming = new TextView(chat.this);
                String response = getResponse(incomingMessage); // Pass the incoming message to getResponse
                textViewIncoming.setText(response);
                textViewIncoming.setBackgroundResource(R.drawable.chat_bubble_incoming);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                layoutParams.setMargins(0, 8, 0, 8); // Default margin for incoming messages
                layoutParams.gravity = Gravity.START; // Align incoming messages to the left
                textViewIncoming.setLayoutParams(layoutParams);

                // Add the incoming chat bubble to the chat layout
                chatLayout.addView(textViewIncoming);

                // Clearing the text
                messageEditText.getText().clear();

            }
        }, 1000); // Delay in milliseconds (1 second in this example)
    }

    private String getResponse(String message) {
        Log.d("ChatBot", "Received message: " + message);

        // Remove leading and trailing whitespace from the message
        message = message.trim();

        // Define responses based on incoming messages
        if (message.equalsIgnoreCase("hi")) {
            return "Hello!";
        } else if (message.equalsIgnoreCase("how are you?")) {
            return "I'm fine, thank you!";
        } else if (message.equalsIgnoreCase("what is  your name?")) {
            return "My name is Piya.";
        } else {
            return "Give a valid text";
        }
    }

    // Helper method to convert dp to pixels
    private int convertDpToPx(int dp) {
        float scale = getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}

