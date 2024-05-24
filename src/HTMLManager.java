import java.util.*;
import java.lang.*;

/**
 * This class will check if it is null, get the tags, 
 * fix the text to correct HTML format, and create a toString representation of it.
 *
 * @author: Kevin Nguyen
 */
public class HTMLManager {
    private Queue<HTMLTag> tags;

    /**
     * This method assigns the html queue reference to the queue instance field
     * @param html is the queue
     */
    public HTMLManager(Queue<HTMLTag> html){

        if (html == null) {
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

    /**
     * This method will fix tags to be in the corrected HTML format
     */
    public void fixHTML(){
        Stack<HTMLTag> stack = new Stack<>();

        // loops through original queue size
        for (int i = 0; i < tags.size(); i++) {
            HTMLTag currentTag = tags.remove();

            // Opening tags add to stack AND to back of queue
            if (currentTag.isOpening()) {
                stack.push(currentTag);
                tags.add(currentTag);
            }
            // Closing tags check if the top of stack matches it or not
            else if (currentTag.isClosing()) {
                if (!stack.isEmpty() && stack.peek().matches(currentTag)) {
                    stack.pop();
                    tags.add(currentTag);
                }
                else {
                    if (!stack.isEmpty()) {
                        HTMLTag missingClosingTag = stack.pop().getMatching();
                        tags.add(missingClosingTag);
                    }
                    else {
                        tags.remove();
                    }
                }
            }
            // Self-closing tags add to back of the queue
            else if (currentTag.isSelfClosing()) {
                tags.add(currentTag);
            }
        }
        while (!stack.isEmpty()) {
            HTMLTag missingClosingTag = stack.pop().getMatching();
            tags.add(missingClosingTag);
        }
    }

    /**
     * This method creates a string representation for the tags
     * @return the queue in the format
     */
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (HTMLTag tag : tags) {
            sb.append(" ").append(tag.toString());
        }
        return sb.toString();
    }
}

