package purchase;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class PurchaseHandler extends DefaultHandler {

    StringBuilder currentValue = new StringBuilder();

    @Override
    public void startElement(
            String uri,
            String localName,
            String qName,
            Attributes attributes) {

        currentValue.setLength(0);

        if (qName.equalsIgnoreCase("product")) {
            String id = attributes.getValue("id");
            System.out.printf("%nProduct ID: %s%n", id);
        }

        if (qName.equalsIgnoreCase("price")) {
            String currency = attributes.getValue(0);
            System.out.printf("Currency: %s%n", currency);
        }

        if (qName.equalsIgnoreCase("price")) {
            String currency = attributes.getValue(0);
            System.out.printf("Currency: %s%n", currency);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (qName.equalsIgnoreCase("name")) {
            System.out.printf("Name: %s%n", currentValue.toString());
        }

        if (qName.equalsIgnoreCase("price")) {
            System.out.printf("Price: %s%n", currentValue.toString());
        }
        if (qName.equalsIgnoreCase("quantity")) {
            System.out.printf("Quantity: %s%n", currentValue.toString());
        }

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentValue.append(ch, start, length);
    }
}
