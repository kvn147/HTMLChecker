
// Instructor-provided code.
// This program tests your HTML manager object


import java.util.*;
import java.io.*;

/**
 * This class validates whether the HTMLManager class is correctly identifying any tag mismatches
 * and also whether the HTML Manager class is appropriately fixing the html tags
 */
public class HTMLChecker {

    public static final String HTML_FOLDER = "web_pages/";
    public static final String EXPECTED_FOLDER = "expected_output/";

    public static void main(String[] args) {
        StringBuilder failedTests = new StringBuilder();

        File folder = new File(HTML_FOLDER);

        // for every file in the HTML Folder
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            Arrays.sort(listOfFiles);
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("===============================");
                    System.out.println("Processing " + file.getName() + "...");
                    System.out.println("===============================");

                    System.out.println("HTML: " + readFile(HTML_FOLDER+file.getName()));
                    String actualResult = check(file.getName());
                    // replace all whitespace and special characters with empty string
                    actualResult = actualResult.replaceAll("\\s+","");

                    String expectedResult = readFile(EXPECTED_FOLDER+file.getName().replace("html","txt"));
                    expectedResult = expectedResult.replaceAll("\\s+","");

                    if (actualResult.equals(expectedResult))
                        System.out.println("----> Result matches Expected Output!");
                    else {
                        System.out.println("----> Something isn't working right! \nFixed HTML should be: \n" + expectedResult);
                        failedTests.append(file.getName()).append(" ");
                    }
                    System.out.println();
                }
            }

            System.out.println("===============================");
            if (failedTests.isEmpty())
                System.out.println("        All tests passed!");
            else
                System.out.println("Failed tests: " + failedTests);
            System.out.println("===============================");
        } else {
            System.out.println("There are not files in " + HTML_FOLDER);
        }
    }

    public static String check(String file) {

        HTMLManager manager = getManager(HTML_FOLDER+file);
        //System.out.println("Loaded tags: " + manager.getTags());
        System.out.println("Checking HTML for errors...");
        manager.fixHTML();
        System.out.println("HTML after fix: " + manager);
        return manager.toString();
    }

    public static HTMLParser getParser(String path) {
        HTMLParser result = null;
        try {
            result = new HTMLParser(new File(path));
        } catch (Exception e) {
            System.out.println("Something went wrong: " + e);
        }
        return result;
    }

    public static HTMLManager getManager(String file) {
        HTMLManager m = null;
        HTMLParser parser = getParser(file);
        if (parser != null) {
            Queue < HTMLTag > tags = parser.parse();
            m = new HTMLManager(tags);
        } else {
            System.err.println("Couldn't resolve input.  Try again!");
        }
        return m;
    }

    public static String readFile(String fileName){
        String result = "";
        try(Scanner fileIn = new Scanner(new File(fileName))){
            while(fileIn.hasNextLine()){
                result += fileIn.nextLine();
            }
        } catch(FileNotFoundException e){
            System.out.println("Unable to open file: " + fileName);
        }
        return result;
    }
}

/*
Output:
===============================
Processing test1.html...
===============================
HTML: <b><i><br/></b></i>
Checking HTML for errors...
HTML after fix: <b> <i> <br /> </i> </b>
----> Result matches Expected Output!

===============================
Processing test2.html...
===============================
HTML: <a><a><a></a>
Checking HTML for errors...
HTML after fix: <a> <a> <a> </a> </a> </a>
----> Result matches Expected Output!

===============================
Processing test3.html...
===============================
HTML: <br/></p></p>
Checking HTML for errors...
HTML after fix: <br />
----> Result matches Expected Output!

===============================
Processing test4.html...
===============================
HTML: <div><div><ul><li></li><li></li><li></ul></div>
Checking HTML for errors...
HTML after fix: <div> <div> <ul> <li> </li> <li> </li> <li> </li> </ul> </div> </div>
----> Result matches Expected Output!

===============================
Processing test5.html...
===============================
HTML: <div><h1></h1><div><img/><p><br/><br/><br/></div></div></table>
Checking HTML for errors...
HTML after fix: <div> <h1> </h1> <div> <img /> <p> <br /> <br /> <br /> </p> </div> </div>
----> Result matches Expected Output!

===============================
        All tests passed!
===============================

Process finished with exit code 0
*/