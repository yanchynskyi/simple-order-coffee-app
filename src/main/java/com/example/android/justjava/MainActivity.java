/**
 * IMPORTANT: Make sure you are using the correct package name. 
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.android.justjava;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    private String messageAfterOrder = "Order accepted:)";
    private int priceOfCupOfCoffee = 25;
    private int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        displayOrderStatus();
    }

    /**
     *This method is called when the add button is clicked.
     */
    public void addQuantity(View view) {
        quantity++;
        displayQuantity(quantity);
        displayPrice();
    }

    /**
     *This method is called when the subtract button is clicked.
     */
    public void subtractQuantity(View view) {
        if (quantity > 0) {
            quantity--;
        }
        displayQuantity(quantity);
        displayPrice();
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayOrderStatus() {
        TextView orderStatusTextView = (TextView) findViewById(R.id.order_status_textView);
        orderStatusTextView.setText(messageAfterOrder);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int quantity) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + quantity);
    }

    /**
     * This method displays the total price on the screen.
     */
    private void displayPrice() {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance(new Locale("ua", "UA")).format(quantity * priceOfCupOfCoffee));
    }
}