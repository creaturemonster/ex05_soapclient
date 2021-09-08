/**
 *
 */
package com.rf.portal.warehouseclient;

import java.util.List;

import com.rf.portal.catalogclient.CatalogServiceClient;
// TODO: import all classes in the package generated from the web service
//       by wsimport
import com.rf.portal.warehouseclient.generated.*;

/**
 * Simple client for the Stock SOAP Web service.
 */
public class StockWebServiceClient {

    public static void main(String[] args){
        // TODO: create the proxy factory for the Stock service.
        // HINT: add an import statement for the proxy factory class.
    	StockService stockProxyFactory=new StockService();

        // TODO: use the proxy factory to create a Web service proxy
        // HINT: add an import statement for the proxy class.
    	Stock stockProxy=stockProxyFactory.getStockPort();

        // TODO: use the service proxy to get all items with a quantity less than 2
    	StockListType inventoryLessThan=stockProxy.getStockItemsWithQuantityLessThan(2);

        // TODO: print the product ID and quantity of all items found in the previous step
    	System.out.println("\n Items with quantity less than 2");
    	printProductList(inventoryLessThan);

        // TODO: use the service proxy to get all items with a quantity between 2 and 4
    	StockListType inventoryBetween=stockProxy.getStockItemsWithQuantityBetween(2,  4);

        // TODO: print the product ID and quantity of all items found in the previous step
    	System.out.println("\n Items with quantity between 2 and 4");
    	printProductList(inventoryBetween);

        // TODO: use the service proxy to whether the item with product ID 3177 is in stock
        //       and print the result (it should be true)
    	boolean isStockIn=stockProxy.isInStock(3177);
    	System.out.println("\nItem 3177 is " + (isStockIn ? "" : "not "));

        // TODO: use the service proxy to whether the item with product ID 3502 is in stock
        //       and print the result (it should be false)
    	boolean isStockIn2=stockProxy.isInStock(3502);
    	System.out.println("\nItem 3502 is " + (isStockIn2 ? "" : "not "));

        // To redirect requests to soapUI, uncomment the following lines of code
        // and move them before call any methods of the service proxy.
        // Important: Be sure to replace "stockProxy" with the name of your service proxy.
//        ((javax.xml.ws.BindingProvider) stockProxy).getRequestContext().put(
//            javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY,
//            "http://localhost:7777");
    }
    	 private static void printProductList(StockListType inventory) {
    	        List<ProductType> items = inventory.getProduct();
    	        for (ProductType item : items){
    	            System.out.println("\tFound " + item.getProductId() + " " + item.getQuantity());
    	        }
    	    }
    }

