import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class SiteStats {
    private String url;
    private int numVisits;

  
    public SiteStats(String url, int numVisits) {
        this.url = url;
        this.numVisits = numVisits;
    }

   
    public int getNumVisits() {
        return this.numVisits;
    }

    public String getUrl() {
        return this.url;
    }

  
    public void setNumVisits(int updatedNumVisits) {
        this.numVisits = updatedNumVisits;
    }

    public String toString() {
        return this.url + " | " + this.numVisits;
    }

}

public class mostVisitedSite {

    private static Queue<SiteStats> sites = new LinkedList<SiteStats>();

    public static SiteStats findMostVisited(Queue<SiteStats> sites, int endIndex) {
      
        int maxVisits = -1;
        SiteStats mostVisited = null;
       
        for (int i = 0; i < sites.size(); i++) {
            SiteStats head = sites.remove();
          
            if ((head.getNumVisits() >= maxVisits) && (i < endIndex)) {
                mostVisited = head;
                maxVisits = head.getNumVisits();
            }
           
            sites.add(head);
        }

        return mostVisited;
        // --------------
    }

    public static void reorder(Queue<SiteStats> sites, SiteStats mostVisited) {
        
        for (int i = 0; i <= sites.size(); i++) {
            SiteStats head = sites.remove();
           
            if (mostVisited != head) {
                sites.add(head);
            }
        }
  
        sites.add(mostVisited);
     
    }

    
    public static void listTopVisitedSites(Queue<SiteStats> sites, int n) {
       
        for (int i = 0; i < sites.size(); i++) {
            SiteStats mostVisited = findMostVisited(sites, sites.size() - i);
            reorder(sites, mostVisited);
        }
     
        System.out.println("Rank | URL | VisitCount");
        for (int i = 0; i < n; i++) {
          
            if (!sites.isEmpty()) {
                System.out.println(Integer.toString(i + 1) + " | " + sites.remove());
            }
        }
       
    }

   
    public static void updateCount(String url) {
        
        Boolean newSite = true;
        SiteStats updated = null;
        int queueSize = sites.size();
        for (int i = 0; i < queueSize; i++) {
            
            SiteStats head = sites.remove();

            if (head.getUrl().equals(url)) {
               
                head.setNumVisits(head.getNumVisits() + 1);
              
                newSite = false;
                
                updated = head;
            }
             else {sites.add(head);}
        }

        if (newSite) {
            sites.add(new SiteStats(url, 1));
        }
        else {
            sites.add(updated);
        }
        // -----------------------
    }

    public static void main(String[] args) {


        String[] visitedSites = { "www.google.co.in", "www.google.co.in", "www.facebook.com", "www.upgrad.com", "www.google.co.in", "www.youtube.com",
                "www.facebook.com", "www.upgrad.com", "www.facebook.com", "www.google.co.in", "www.microsoft.com", "www.9gag.com", "www.netflix.com",
                "www.netflix.com", "www.9gag.com", "www.microsoft.com", "www.amazon.com", "www.amazon.com", "www.uber.com", "www.amazon.com",
                "www.microsoft.com", "www.upgrad.com" };

        for (String url : visitedSites) {
            updateCount(url);
        }
        listTopVisitedSites(sites, 5);

    }

}