import java.util.*;

// TODO: Add Javadoc here
public class HTMLManager {
    private Queue<HTMLTag> tags;

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

    /**
     * This method gets and returns the queue of HTMLTags being managed
     * @return the queue tags
     */
    Queue<HTMLTag> getTags(){
        return tags;
    }

    //TODO: Add Javadoc here and complete method
    /**
     * This method will fix tags to be in the corrected HTML format
     */
    public void fixHTML(){
        Stack<String> stack = new Stack<>();

        while(!tags.isEmpty()) {
            // Opening tags add to stack AND to back of queue
            if (!tags.peek().contains("/")) {
                String removeHead(tags.remove());
                stack.push(removeHead);
                tag.add(removeHead);
            }
            // Closing tags check if to
            else if (!tag.peek().contains("/>")) {
                String check = tag.peek().substring(0, tag.peek.size()-2);
                if (check == stack.peek()) {
                    tags.add((tags.remove()));
                    stack.pop();
                }
                else {
                    String closingTag = stack.pop();
                    tags.add(addCharToString(closingTag, "/", 1);
                }
            }
            // Self-closing tags add to back of the queue
            else if (tag.peek().contains("/>")) {
                tag.add(tag.remove());

            }
        }
        
    }

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

