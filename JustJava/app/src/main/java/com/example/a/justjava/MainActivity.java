package com.example.a.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Connection;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        if (quantity == 100) {
            Toast.makeText(this,"You cannot have more than 100 cofee",Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view) {
        if (quantity == 1) {
            Toast.makeText(this,"You cannot have less than 1 cofee",Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity - 1;
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.checkBox_Whipped_cream);
        boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.checkBox_Chocolate);
        boolean hasChocolate = ChocolateCheckBox.isChecked();

        int price = calculatePrice(hasWhippedCream, hasChocolate);
        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @param addWihppedCream is whether or not the user wants whipped cream topping
     * @param addChocolate    is whether or not the user wants chocolate topping
     * @return total price
     */
    private int calculatePrice(boolean addWihppedCream, boolean addChocolate) {
        //Price of cup of coffee
        int basePrice = 5;

        // Add $1 the user wants whipped cream
        if (addWihppedCream) basePrice++;

        // Add $2 the user wants chocolate
        if (addChocolate) basePrice += 2;

        // Calculate the total order price by multiplying
        return quantity * basePrice;
    }

    /*
     * Creat summart of order.
     * @param price of the order
     * @return text summary
     */

    private String createOrderSummary(String name, int price, boolean addWippedCream, boolean addChoco) {
        String summaryMessage;
        summaryMessage = "Name : " + name + "\n";
        summaryMessage += "Add whipped cream? " + addWippedCream + "\n";
        summaryMessage += "Add Chocolate? " + addChoco + "\n";
        summaryMessage += "Quantity : " + quantity + "\n";
        summaryMessage += "Total $" + price + "\n";
        summaryMessage += "Thank you! ";
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