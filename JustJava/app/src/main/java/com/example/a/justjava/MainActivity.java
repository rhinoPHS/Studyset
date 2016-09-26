package com.example.a.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        quantity = quantity -1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.checkBox_Whipped_cream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        int price = calculatePrice();
        String priceMessage = createOrderSummary(price,hasWhippedCream);
        displayMessage(priceMessage);

    }
    /**
     * Calculates the price of the order.
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return  price;
    }

    /*
     * Creat summart of order.
     * @param price of the order
     * @return text summary
     */

    private String createOrderSummary(int price, boolean addWippedCream){
        String summaryMessage;
        summaryMessage = "Name : Kaptain Kunal\n";
        summaryMessage += "Add whipped cream? " + addWippedCream + "\n";
        summaryMessage += "Quantity : "+quantity + "\n";
        summaryMessage +=  "Total $" + price + "\n";
        summaryMessage +=  "Thank you! ";
        return summaryMessage;
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView ordersummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        ordersummaryTextView.setText(message);
    }
}