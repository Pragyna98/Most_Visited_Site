
import java.util.Stack;
import java.util.Scanner;

public class webBrowser {

    private static Stack<String> hist = new Stack<String>();

    public static Boolean isBrowsingHistoryEmpty() {
       
        return hist.isEmpty();
    }

    public static String mostRecentlyVisitedSite() {
       
        if (!hist.isEmpty()) {
            return hist.peek();
        } else {
            return "Browsing history is empty";
        }

    }

    public static void addSiteToHistory(String url) {
        
    	hist.push(url);
    }

    public static void goBackInTime(int n) {
      
        for (int i = 0; (i < n && !hist.isEmpty()); i++) {
        	hist.pop();
        }
    }

    public static void printBrowsingHistory() {
        
        if (!hist.isEmpty()) {
            System.out.println(hist);
        } else {
            System.out.print("Browsing History is empty");
        }
    }

    public static void main(String[] args) {
        System.out.println(isBrowsingHistoryEmpty()); 
        addSiteToHistory("www.google.co.in");
        addSiteToHistory("www.facebook.com"); 
        addSiteToHistory("www.upgrad.com");
        System.out.println(isBrowsingHistoryEmpty()); 
        System.out.println(mostRecentlyVisitedSite()); 
        addSiteToHistory("www.youtube.com");
        goBackInTime(2); 
        addSiteToHistory("www.yahoo.com"); 
        System.out.println(mostRecentlyVisitedSite()); 
        printBrowsingHistory(); 

    }
}