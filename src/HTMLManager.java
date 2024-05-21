import java.util.*;

// TODO: Add Javadoc here
public class HTMLManager {
    private Queue<HTMLTag> tags;

    // TODO: Add Javadoc here and complete method
    /**
     * This method assigns the html queue reference to the queue instance field
     * @param html is the queue
     */
    public HTMLManager(Queue<HTMLTag> html){

        // TODO: throw exception
        if (tags == null) {
            throw new IllegalArgumentException();
        }
        else {
        // shallow copy
        tags = html;
        }
    }

    //TODO: Add Javadoc here and complete method
    /**
     * Returns the queue of HTMLTags being managed
     * @return the queue tags
     */
    Queue<HTMLTag> getTags(){
        return tags;
    }

    //TODO: Add Javadoc here and complete method
    public void fixHTML(){

    }

    //TODO: Add Javadoc here and complete method
    /**
     * This method creates a string representation for the tags
     * @return the queue in the format
     */
    public String toString(){
        Iterator<String> it = tags.iterator();
        
        while (it.hasNext()) {
            
        }
        return sb.toString();
    }
}

